import { Component } from '@angular/core';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.scss'],
})
export class HistoryComponent {
  history: string[] = ['Prompt 1', 'Prompt 2', 'Prompt 3']; // Exemple de données
}
