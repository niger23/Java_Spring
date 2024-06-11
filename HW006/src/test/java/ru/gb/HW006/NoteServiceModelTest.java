package ru.gb.HW006;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.HW006.model.Note;
import ru.gb.HW006.repository.NoteRepository;
import ru.gb.HW006.service.NoteService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NoteServiceModelTest {
    @InjectMocks
    private NoteService noteService;
    @Mock
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
