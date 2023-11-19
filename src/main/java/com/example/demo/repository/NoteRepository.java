package com.example.demo.repository;

import com.example.demo.models.Note;
import com.example.demo.payloads.request.note.EditRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Note save(EditRequest editRequest);

}
