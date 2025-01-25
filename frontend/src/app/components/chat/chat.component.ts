import { Component } from '@angular/core';
import { ChatService } from '../../services/chatgpt.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent {
  userInput: string = '';
  messages: { sender: string; content: string }[] = [];

  constructor(private chatService: ChatService) {}

  sendMessage() {
    if (this.userInput.trim()) {
      const userMessage = this.userInput;
      const finalUserMessage = `Je veux que tu génères un cas d'utilisation pour ${userMessage}. Génère uniquement un JSON au format suivant : { \"title\": \"Titre du cas d'utilisation\", \"description\": \"Description détaillée\", \"microservices\": [ { \"name\": \"Nom du microservice\", \"description\": \"Description du microservice\", \"classes\": [ { \"name\": \"Nom de la classe\", \"attributes\": {\"attribut1\": \"type1\", \"attribut2\": \"type2\"}, \"methods\": {\"methode1\": \"typeRetour1\", \"methode2\": \"typeRetour2\"} } ] } ] }. Ne retourne que la réponse JSON, sans ajout de texte ou commentaire. Voici les informations pour le cas d'utilisation : Description : \"Une application pour gérer les stocks d'une entreprise.\" Assure-toi de suivre exactement cette structure et de ne rien ajouter d'autre.`;

      this.messages.push({ sender: 'Moi', content: userMessage });
      this.userInput = '';

      this.chatService.sendPrompt(finalUserMessage).subscribe(
        (response) => {
          try {
            // La réponse est un objet qui contient une clé `content`
            const rawContent = response.content;

            // Nettoyer les caractères d'échappement
            const cleanedResponse = rawContent.replace(/\\n/g, '\n').replace(/\\r/g, ''); // Remplacer les \n et \r

            // Optionnel : Vérifier si la chaîne nettoyée contient des caractères non valides
            console.log('Réponse nettoyée:', cleanedResponse);

            // Parser le contenu nettoyé en JSON
            const parsedResponse = JSON.parse(cleanedResponse);

            // Vérifier si la structure du JSON est correcte
            if (parsedResponse && parsedResponse.title && parsedResponse.microservices) {
              const usecase = `<strong>Titre du use case:</strong> ${parsedResponse.title}` + "<br />" + `<strong>Description:</strong> ${parsedResponse.description}`
              this.messages.push({ sender: 'AppGenerator', content: usecase });
              let counter = 0;
              parsedResponse.microservices.forEach((microservice: any) => {
                counter++;
                this.messages.push({
                  sender: 'AppGenerator',
                  content: `<strong>Microservice ${counter}:</strong> ${microservice.name} - ${microservice.description}`,
                });

                microservice.classes.forEach((classItem: any) => {
                  this.messages.push({
                    sender: '',
                    content: `<strong>Class:</strong> ${classItem.name}`,
                  });

                  // Liste des attributs
                  for (const [key, value] of Object.entries(classItem.attributes)) {
                    this.messages.push({
                      sender: '',
                      content: `<strong>Attribute:</strong> ${key} - <strong>Type:</strong> ${value}`,
                    });
                  }

                  // Liste des méthodes
                  for (const [method, returnType] of Object.entries(classItem.methods)) {
                    this.messages.push({
                      sender: '',
                      content: `<strong>Method:</strong> ${method} - <strong>Return Type:</strong> ${returnType}`,
                    });
                  }
                });
              });
            } else {
              throw new Error('Structure de données invalide');
            }
          } catch (error) {
            console.error('Erreur de traitement des données :', error);
            this.messages.push({ sender: 'AppGenerator', content: 'Structure de données invalide.' });
          }
        },
        (error) => {
          console.error('Erreur lors de l\'appel à l\'API :', error);
          this.messages.push({ sender: 'AppGenerator', content: 'Erreur lors de l\'appel à l\'API.' });
        }
      );
    }
  }

  handleFileUpload(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.messages.push({
        sender: 'You',
        content: `File uploaded: ${file.name}`,
      });

      console.log('Uploaded file:', file);
    }
  }
}
