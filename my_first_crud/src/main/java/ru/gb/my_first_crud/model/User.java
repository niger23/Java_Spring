package ru.gb.my_first_crud.model;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;

}
