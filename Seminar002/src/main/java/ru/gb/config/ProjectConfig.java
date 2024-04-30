package ru.gb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ru.gb.domain")
public class ProjectConfig {
//    @Bean
//    Engine engin1() {
//        Engine engine = new Engine();
//        engine.setTypeEngine("Бензин");
//        return engine;
//    }
//
//    @Bean("BMW")
//    @Scope("singleton")
//    Car car1() {
//        Car obCar = new Car(engin1());
//        obCar.setModel("X1");
//        obCar.setMade("BMW");
//        return obCar;
//    }
//    @Bean
//    @Primary
//    Car car2() {
//        Car obCar = new Car();
//        obCar.setModel("H7");
//        obCar.setMade("HAVAL");
//        return obCar;
//    }
//    @Bean(name="Audi")
//    @Scope("prototype")
//    Car car3() {
//        Car obCar = new Car();
//        obCar.setModel("S8");
//        obCar.setMade("Audi");
//        return obCar;
//    }
//    @Bean
//    String hello() {
//        return "Hello";
//    }
//
//    @Bean Integer ten() {
//        return 10;
//    }
}
