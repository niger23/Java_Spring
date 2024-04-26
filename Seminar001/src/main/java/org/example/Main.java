package org.example;

import com.google.gson.Gson;
import org.example.domain.Person;

public class Main {
    public static void main(String[] args) {
        Person newUser = new Person("John","Snow", 15);
        System.out.println(newUser);

        Gson gson = new Gson();
        String json = gson.toJson(newUser);
        System.out.println(json);

        Person deSerializePerson = gson.fromJson(json, Person.class);
        System.out.println(deSerializePerson);

        System.out.println(newUser.equals(deSerializePerson));



    }
}