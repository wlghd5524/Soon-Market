package org.nobase.nobase_backend.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOrigins("http://localhost:3000") // 허용할 오리진들
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // 허용할 HTTP 메소드
                .allowCredentials(true) // 쿠키를 포함할 것인지
                .maxAge(3600); // pre-flight 요청의 결과를 캐시하는 시간(초 단위)
    }
}
