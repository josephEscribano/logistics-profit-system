package com.dasher.logisticsProfitSystem.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for Cross-Origin Resource Sharing (CORS). This configuration is conditionally
 * enabled based on the 'profit-system.cors.enabled' property being set to 'true'. It defines CORS
 * rules for allowing requests from specific origins and methods.
 */
@Configuration
@ConditionalOnProperty(prefix = "profit-system.cors", value = "enabled", havingValue = "true")
public class CorsConfiguration {

  /**
   * Configures global CORS (Cross-Origin Resource Sharing) mappings. This bean provides a {@link
   * WebMvcConfigurer} implementation to customize CORS settings.
   *
   * @return A {@link WebMvcConfigurer} instance with defined CORS rules.
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {

      /**
       * Adds CORS mappings to the registry. This method specifies which origins, HTTP methods, and
       * headers are allowed for cross-origin requests to the application's endpoints.
       *
       * @param registry The {@link CorsRegistry} to which CORS mappings are added.
       */
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PATCH", "DELETE")
            .maxAge(3600);
      }
    };
  }
}
