package ru.gb.HW006.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.HW006.aspect.TrackUserAction;
import ru.gb.HW006.model.Note;
import ru.gb.HW006.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    @TrackUserAction
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    public Note updateNote(Note note, Long id) {
        Note noteById = getNoteById(id);

        noteById.setTitle(note.getTitle());
        noteById.setDescription(note.getDescription());
        noteById.setDate(note.getDate());

        return noteRepository.save(noteById);
    }
    @TrackUserAction
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }
    @TrackUserAction
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}
