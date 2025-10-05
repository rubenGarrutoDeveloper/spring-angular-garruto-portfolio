/**
 * Development Environment Configuration
 * 
 * 🎓 LEARNING NOTES:
 * 
 * This file is used when running:
 * - ng serve (local development)
 * - ng build (without --configuration=production)
 * 
 * HOW IT WORKS:
 * - Angular replaces this file at BUILD TIME
 * - Not a runtime switch (happens during compilation)
 * - The 'environment.production.ts' file replaces this when building for prod
 */

export const environment = {
  /**
   * Production flag
   * - false = development mode
   * - Enables extra debugging, verbose logging, etc.
   */
  production: false,

  /**
   * API Base URL for local development
   * 
   * Options:
   * 1. Local Spring Boot: 'http://localhost:8080/api/v1'
   * 2. Your deployed backend (for testing): 'https://spring-angular-garruto-portfolio.onrender.com/api/v1'
   */
  apiBaseUrl: 'http://localhost:8080/api/v1',

  /**
   * Optional: Different config for local vs deployed backend
   * Uncomment the one you want to use during development
   */
  // apiBaseUrl: 'https://spring-angular-garruto-portfolio.onrender.com/api/v1',

  /**
   * Other environment-specific configs you might need
   */
  enableDebugLogs: true,
  apiTimeout: 30000, // 30 seconds for local debugging
};

/**
 * 💡 TIP: You can add any configuration here:
 * - Feature flags: enableNewFeature: false
 * - API keys: googleMapsApiKey: 'dev-key-123'
 * - Analytics: enableAnalytics: false
 * - Mock data: useMockData: true
 */