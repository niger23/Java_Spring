package ru.gb.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.interfaces.iEngine;

@Component
public class Car {
    private String model = "X1";
    private String made = "BMW";
    private iEngine engine;

    public Car(iEngine engine) {
        this.engine = engine;
        System.out.println("Автомобиль создан");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", made='" + made + '\'' +
                ", engine=" + engine +
                '}';
    }
    public void go() {
        engine.startEngine();
    }
}
