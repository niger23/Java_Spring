package ru.gb.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.gb.interfaces.iEngine;

@Component
@Primary
public class GasEngine implements iEngine {

    public GasEngine() {
        System.out.println("Газовый двигатель создан");
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатель на газу запущен");
    }
}
