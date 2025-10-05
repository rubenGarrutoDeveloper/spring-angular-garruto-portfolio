import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BaseApiService } from './base-api.service';
import { PersonalInfo } from '../models/personal-info.model';

/**
 * PersonalInfoService
 * 
 * Handles all HTTP operations for personal information
 * Extends BaseApiService to inherit common CRUD operations
 * 
 * 🎓 LEARNING NOTES:
 * 
 * 1. @Injectable({ providedIn: 'root' }):
 *    - Marks this as an Angular service
 *    - 'root' = singleton instance shared across entire app
 *    - Automatically added to dependency injection system
 *    - No need to add to providers array in modules!
 * 
 * 2. EXTENDS BaseApiService<PersonalInfo>:
 *    - Inherits getAll() and getById() methods
 *    - <PersonalInfo> tells TypeScript what type T is
 *    - No need to rewrite common HTTP logic!
 * 
 * 3. CONSTRUCTOR with super():
 *    - Calls parent class constructor
 *    - Passes HttpClient and endpoint path to BaseApiService
 *    - Angular automatically injects HttpClient (Dependency Injection)
 */

@Injectable({
  providedIn: 'root'
})
export class PersonalInfoService extends BaseApiService<PersonalInfo> {
  
  /**
   * Constructor
   * 
   * 🎓 DEPENDENCY INJECTION:
   * - Angular sees 'private http: HttpClient' in constructor
   * - Automatically creates/provides HttpClient instance
   * - No need to manually create: new HttpClient()
   * - Promotes testability and loose coupling
   * 
   * @param http - Injected by Angular's DI system
   */
  constructor(http: HttpClient) {
    // Call parent constructor with endpoint name
    // This sets up the full URL: baseUrl + '/personal-info'
    super(http, 'personal-info');
  }

  /**
   * Custom method: Get current user's personal info
   * 
   * In a real app with authentication, this would fetch the
   * logged-in user's info. For now, we assume ID = 1.
   * 
   * 🎓 This demonstrates how to add custom methods beyond getAll/getById
   * 
   * @returns Observable<PersonalInfo> - the current user's info
   */
  getCurrentUserInfo(): Observable<PersonalInfo> {
    // Assuming your personal info has ID = 1 in the database
    return this.getById(1);
  }

  // ✅ Already available from BaseApiService (no need to implement):
  // - getAll(): Observable<PersonalInfo[]>
  // - getById(id: number): Observable<PersonalInfo>
}

/**
 * 📌 HOW TO USE THIS SERVICE IN A COMPONENT:
 * 
 * import { Component, OnInit, signal } from '@angular/core';
 * import { PersonalInfoService } from './core/services/personal-info.service';
 * import { PersonalInfo } from './core/models/personal-info.model';
 * 
 * @Component({
 *   selector: 'app-profile',
 *   template: `
 *     <div>
 *       <h1>{{ personalInfo().firstName }} {{ personalInfo().lastName }}</h1>
 *       <p>{{ personalInfo().professionalTitle }}</p>
 *     </div>
 *   `
 * })
 * export class ProfileComponent implements OnInit {
 *   personalInfo = signal<PersonalInfo>({});
 * 
 *   constructor(private personalInfoService: PersonalInfoService) {}
 * 
 *   ngOnInit() {
 *     this.personalInfoService.getCurrentUserInfo().subscribe({
 *       next: (data) => this.personalInfo.set(data),
 *       error: (err) => console.error('Error loading profile:', err)
 *     });
 *   }
 * }
 * 
 * 
 * 🎓 KEY CONCEPTS RECAP:
 * 
 * 1. SERVICE LAYER PATTERN:
 *    Components ← Services ← HTTP ← Backend API
 *    - Components focus on UI logic
 *    - Services handle data fetching/business logic
 *    - Separation of concerns = cleaner code
 * 
 * 2. OBSERVABLE PATTERN:
 *    - Subscribe to get data: .subscribe({ next, error, complete })
 *    - Lazy execution: only runs when subscribed
 *    - Unsubscribe to prevent memory leaks (Angular handles this for HttpClient)
 * 
 * 3. TYPE SAFETY:
 *    - PersonalInfo interface ensures correct property names
 *    - TypeScript catches typos at compile time
 *    - Better IDE autocomplete and refactoring
 */