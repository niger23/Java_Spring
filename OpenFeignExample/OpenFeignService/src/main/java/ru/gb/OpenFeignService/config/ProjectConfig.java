package ru.gb.OpenFeignService.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "ru.gb.OpenFeignService.proxy")
public class ProjectConfig {
}
