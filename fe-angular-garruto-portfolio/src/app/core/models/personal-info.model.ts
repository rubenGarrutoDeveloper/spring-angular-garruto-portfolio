/**
 * PersonalInfo Model
 * 
 * Represents the core personal and professional information.
 * This is the central entity that connects to education, work experience, etc.
 * 
 * 🎓 LEARNING NOTES:
 * - We use an INTERFACE (not a class) because this is just a data shape/contract
 * - Interfaces are compile-time only (disappear after TypeScript compilation)
 * - Properties use camelCase (TypeScript convention) even though backend uses snake_case
 * - All properties are optional (?) because API might return partial data
 * - Date strings remain as 'string' type - we'll parse them to Date objects in services if needed
 */

export interface PersonalInfo {
  id?: number;
  firstName?: string;
  lastName?: string;
  birthDate?: string; // ISO date string from backend (e.g., "1992-11-06")
  professionalTitle?: string;
  bioSummaryIt?: string;
  bioSummaryEn?: string;
  profileImageUrl?: string;
  email?: string;
  phone?: string;
  linkedinUrl?: string;
  githubUrl?: string;
  locationCity?: string;
  locationRegion?: string;
  locationCountry?: string;
  createdAt?: string; // ISO datetime string
  updatedAt?: string; // ISO datetime string
}

/**
 * 🤔 WHY INTERFACE vs CLASS?
 * 
 * ✅ Use INTERFACE when:
 * - You only need to describe data shape (type checking)
 * - No behavior/methods needed
 * - Working with API responses (our case!)
 * - You want zero runtime overhead
 * 
 * ✅ Use CLASS when:
 * - You need methods/behavior
 * - You need instances with 'new'
 * - You need inheritance with actual implementation
 * - You need runtime type checking
 * 
 * Example: If we needed a method like `getFullName()`, we'd use a class:
 * 
 * class PersonalInfo {
 *   firstName?: string;
 *   lastName?: string;
 *   
 *   getFullName(): string {
 *     return `${this.firstName} ${this.lastName}`;
 *   }
 * }
 */