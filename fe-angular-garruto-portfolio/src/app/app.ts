import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Hello, HelloService } from './core/services/hello.service';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('fe-angular-garruto-portfolio');
  protected helloData = signal<Hello[]>([]);
  protected loading = signal(false);
  protected error = signal<string | null>(null);

  constructor(private helloService: HelloService) {}

  testBackendCall() {
    this.loading.set(true);
    this.error.set(null);

    this.helloService.getHello().subscribe({
      next: (data) => {
        this.helloData.set(data);
        this.loading.set(false);
        console.log('Backend response:', data);
      },
      error: (err) => {
        this.error.set('Error calling backend: ' + err.message);
        this.loading.set(false);
        console.error('Backend error:', err);
      }
    });
  }
}
