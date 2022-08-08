package dev.be.handler.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dev.be.handler.resolver.DemoResolver;

@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(demoDtoResolver());
    }

    @Bean
    public DemoResolver demoDtoResolver() {
        return new DemoResolver();
    }
}
