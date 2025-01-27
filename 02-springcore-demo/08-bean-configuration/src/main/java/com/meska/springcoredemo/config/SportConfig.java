package com.meska.springcoredemo.config;

import com.meska.springcoredemo.common.Coach;
import com.meska.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
//    @Bean
    @Bean("custom_bean_id")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
