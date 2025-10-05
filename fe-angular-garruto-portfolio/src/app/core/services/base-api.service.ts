import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../../../environments/environment';

/**
 * BaseApiService - Abstract base class for all API services
 * 
 * 🎓 LEARNING NOTES:
 * 
 * 1. ABSTRACT CLASS:
 *    - Cannot be instantiated directly (no 'new BaseApiService()')
 *    - Serves as a blueprint for child classes
 *    - Provides common functionality to all entity services
 * 
 * 2. GENERICS <T>:
 *    - T is a type parameter (placeholder for any type)
 *    - Makes the class reusable for different entity types
 *    - Example: BaseApiService<PersonalInfo> means T = PersonalInfo
 * 
 * 3. DRY PRINCIPLE:
 *    - Don't Repeat Yourself
 *    - Common HTTP logic written once, reused by all services
 *    - Easier to maintain (change error handling in one place)
 */

export abstract class BaseApiService<T> {
  /**
   * Base API URL - all endpoints start with this
   * Protected = accessible by child classes, not from outside
   */
  protected readonly baseUrl = environment.apiBaseUrl;

  /**
   * Constructor - called by child classes
   * @param http - Angular's HttpClient for making HTTP requests
   * @param endpoint - specific endpoint path (e.g., 'personal-info')
   */
  constructor(
    protected http: HttpClient,
    protected endpoint: string
  ) {}

  /**
   * Get all entities
   * 
   * 🎓 OBSERVABLE:
   * - Like a Promise, but can emit multiple values over time
   * - Used by Angular's HttpClient
   * - Must be subscribed to (lazy - doesn't execute until subscribed)
   * 
   * @returns Observable<T[]> - array of entities of type T
   */
  getAll(): Observable<T[]> {
    const url = `${this.baseUrl}/${this.endpoint}`;
    
    return this.http.get<T[]>(url).pipe(
      tap(data => console.log(`[${this.endpoint}] Fetched ${data.length} records`)),
      catchError(this.handleError)
    );
  }

  /**
   * Get single entity by ID
   * 
   * @param id - entity ID
   * @returns Observable<T> - single entity of type T
   */
  getById(id: number): Observable<T> {
    const url = `${this.baseUrl}/${this.endpoint}/${id}`;
    
    return this.http.get<T>(url).pipe(
      tap(data => console.log(`[${this.endpoint}] Fetched record with id ${id}`, data)),
      catchError(this.handleError)
    );
  }

  /**
   * Centralized error handling
   * 
   * 🎓 RxJS OPERATORS:
   * - pipe() - chains operators together
   * - tap() - performs side effects (like logging) without changing the data
   * - catchError() - handles errors in the observable stream
   * - throwError() - creates an observable that emits an error
   * 
   * @param error - HTTP error response from Angular
   * @returns Observable that emits an error
   */
  protected handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = 'An unknown error occurred';

    if (error.error instanceof ErrorEvent) {
      // Client-side error (network issue, etc.)
      errorMessage = `Client Error: ${error.error.message}`;
    } else {
      // Backend error (404, 500, etc.)
      errorMessage = `Server Error: ${error.status} - ${error.message}`;
    }

    console.error('❌ API Error:', errorMessage);
    console.error('Full error object:', error);

    // Return observable with error message
    return throwError(() => new Error(errorMessage));
  }
}

/**
 * 🤔 WHY ABSTRACT CLASS instead of regular class?
 * 
 * ✅ Abstract Class benefits:
 * - Forces a contract (child classes must follow the pattern)
 * - Prevents direct instantiation (you shouldn't use BaseApiService directly)
 * - Provides shared implementation while allowing customization
 * - Documents intent: "This is a base class, extend it!"
 * 
 * 📌 Usage Pattern:
 * 
 * export class PersonalInfoService extends BaseApiService<PersonalInfo> {
 *   constructor(http: HttpClient) {
 *     super(http, 'personal-info'); // Pass endpoint to parent
 *   }
 *   
 *   // Inherits getAll() and getById() automatically!
 *   // Can add custom methods specific to PersonalInfo here
 * }
 */