import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  modalTitle: string;
  onSetTitle(title: string) {
    console.log(title);
    this.modalTitle = title;
  }
}
