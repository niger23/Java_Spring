package ru.gb.domain;

import org.springframework.stereotype.Component;
import ru.gb.interfaces.iEngine;

@Component
public class OilEngine implements iEngine {
    public OilEngine() {
        System.out.println("Бензиновый двигатель создан");
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатель на бензине запущен");
    }
}
