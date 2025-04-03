package org.example.zombie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//CORS - Cross Origin Configuration
@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  //api/users/list
                        .allowedOrigins("*")
                        .allowedMethods("Get", "Post", "Put", "Delete")
                        .allowedHeaders("*");
            }
        };
    }
}
