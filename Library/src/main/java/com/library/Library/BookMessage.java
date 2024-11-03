package com.library.Library;

import com.library.Library.model.BookLibrary;


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
