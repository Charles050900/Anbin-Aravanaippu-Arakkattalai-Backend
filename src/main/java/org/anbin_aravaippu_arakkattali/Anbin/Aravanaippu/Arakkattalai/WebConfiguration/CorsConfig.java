package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.WebConfiguration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class CorsConfig {

    // Update with your deployed frontend URL
    private static final String LOCAL_FRONTEND = "http://localhost:5173/Anbin-Aravanaippu-Arakkattalai/";
    private static final String DEPLOYED_FRONTEND = "https://charles050900.github.io/Anbin-Aravanaippu-Arakkattalai/";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(LOCAL_FRONTEND, DEPLOYED_FRONTEND)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}



