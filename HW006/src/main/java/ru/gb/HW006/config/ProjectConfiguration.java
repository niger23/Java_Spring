package ru.gb.HW006.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.HW006.aspect.ActionAspect;

@Configuration
@ComponentScan(basePackages = "ru.gb.HW006")
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public ActionAspect aspect() {
        return new ActionAspect();
    }
}
