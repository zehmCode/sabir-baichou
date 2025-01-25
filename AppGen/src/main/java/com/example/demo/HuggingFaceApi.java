package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HuggingFaceApi {

    private static final String API_URL = "https://api-inference.huggingface.co/models/mistralai/Mistral-Nemo-Instruct-2407/v1/chat/completions";
    private static final String API_TOKEN = "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";

    // Stockage en mémoire pour les réponses
    private static final Map<String, String> responseCache = new ConcurrentHashMap<>();

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> getChatResponse(@RequestBody ChatRequest chatRequest) {
        try {
            // Construire le corps de la requête JSON
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "mistralai/Mistral-Nemo-Instruct-2407");
            requestBody.put("messages", new Object[]{
                Map.of("role", "user", "content", chatRequest.getContent())
            });
            requestBody.put("max_tokens", chatRequest.getMaxTokens());
            requestBody.put("stream", false);

            // Convertir en JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            // Configurer les en-têtes de requête
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(API_TOKEN);

            // Envoyer la requête
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
            ResponseEntity<String> response = restTemplate.exchange(
                API_URL,
                HttpMethod.POST,
                entity,
                String.class
            );

            // Traiter la réponse
            JsonNode root = objectMapper.readTree(response.getBody());
            JsonNode contentNode = root.at("/choices/0/message/content");

            String responseContent = contentNode.asText();

            Map<String, String> result = new HashMap<>();
            result.put("content", responseContent);

            return ResponseEntity.status(response.getStatusCode()).body(result);
        } catch (Exception e) {
            // Gestion des erreurs
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("content", "Erreur lors de l'appel à l'API: " + e.getMessage());
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    public static class ChatRequest {
        private String content;
        private int maxTokens = 500;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getMaxTokens() {
            return maxTokens;
        }

        public void setMaxTokens(int maxTokens) {
            this.maxTokens = maxTokens;
        }
    }
}
