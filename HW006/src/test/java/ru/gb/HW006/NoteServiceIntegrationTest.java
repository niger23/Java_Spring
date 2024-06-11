package ru.gb.HW006;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.HW006.model.Note;
import ru.gb.HW006.repository.NoteRepository;
import ru.gb.HW006.service.NoteService;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class NoteServiceIntegrationTest {
    @Autowired
    private NoteService noteService;
    @MockBean
    private NoteRepository noteRepository;

    @Test
    public void createNotesTest() {
        Note note1 = new Note();
        note1.setId(1L);
        note1.setDescription("тест1");

        noteService.createNote(note1);

        verify(noteRepository).save(note1);
    }
}
