import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Crée une interface pour définir la structure de la réponse
interface ChatResponse {
  content: string;
}

@Injectable({
  providedIn: 'root',
})
export class ChatService {
  private apiUrl = 'http://localhost:8080/api/chat'; // Backend URL

  constructor(private http: HttpClient) {}

  // Modifie le type de retour de la méthode pour refléter la structure réelle
  sendPrompt(content: string): Observable<ChatResponse> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    const body = {
      content: content,
      maxTokens: 10000, // Optional: Add extra fields if necessary
    };

    return this.http.post<ChatResponse>(this.apiUrl, body, {
      headers: headers,
      responseType: 'json', // Attendre un objet JSON
    });
  }
}
