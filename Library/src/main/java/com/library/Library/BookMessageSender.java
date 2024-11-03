package com.library.Library;

import com.library.Library.model.BookLibrary;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendBookMessage(BookLibrary book, String operation) {
        BookMessage message = new BookMessage(book, operation);
        rabbitTemplate.convertAndSend("book-queue", message);
    }
}
