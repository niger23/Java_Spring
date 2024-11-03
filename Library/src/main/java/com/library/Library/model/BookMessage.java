package com.library.Library.model;


import java.io.Serializable;

public class BookMessage implements Serializable {
    public BookLibrary book;
    public String operation;

    public BookMessage() {}

    public BookMessage(BookLibrary book, String operation) {
        this.book = book;
        this.operation = operation;
    }
}
