package ru.gb.Seminar0062.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.Seminar0062.model.Reader;
import ru.gb.Seminar0062.repository.ReaderRepository;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository readerRepository;

    @GetMapping
    public List<Reader> detAllReaders() {
        return readerRepository.findAll();
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }
}
