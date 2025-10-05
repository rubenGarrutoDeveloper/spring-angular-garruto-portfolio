/**
 * Production Environment Configuration
 * 
 * 🎓 LEARNING NOTES:
 * 
 * This file is used when running:
 * - ng build --configuration=production
 * - ng build --prod (shorthand)
 * 
 * Angular automatically REPLACES environment.ts with this file during prod builds.
 */

export const environment = {
  /**
   * Production flag
   * - true = production mode
   * - Disables debugging, Angular dev mode checks
   * - Better performance, smaller bundle size
   */
  production: true,

  /**
   * API Base URL for production
   * Points to your deployed Spring Boot backend on Render
   */
  apiBaseUrl: 'https://spring-angular-garruto-portfolio.onrender.com/api/v1',

  /**
   * Production-specific configs
   */
  enableDebugLogs: false, // No console.logs in production
  apiTimeout: 10000, // 10 seconds (stricter timeout)
};

/**
 * 🔒 SECURITY NOTE:
 * - Never commit API keys or secrets here if your repo is public!
 * - Use environment variables or secret management services
 * - This file is included in your built bundle (visible to users)
 */
