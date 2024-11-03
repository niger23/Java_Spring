package com.library.Library;

import com.library.Library.repository.BookRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMessageReceiver {

    @Autowired
    private BookRepository bookRepository;

    @RabbitListener(queues = "book-queue")
    public void receiveBookMessage(BookMessage message) {
        switch (message.operation) {
            case "CREATE":
                bookRepository.save(message.book);
                break;
            case "UPDATE":
                bookRepository.save(message.book);
                break;
            case "DELETE":
                bookRepository.deleteById(message.book.getId());
                break;
            default:

        }
    }
}
