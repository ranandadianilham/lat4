package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Note;
import com.example.demo.payloads.request.note.EditRequest;
import com.example.demo.payloads.response.BaseResponse;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CrudController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/note")
    public ResponseEntity<BaseResponse> getAll() {
        List<Note> notes = noteRepository.findAll();
        return new ResponseEntity<>(new BaseResponse(200, "success", notes), HttpStatus.OK);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return new ResponseEntity<>(new BaseResponse(200, "success", note), HttpStatus.OK);
    }

    @PostMapping("/note")
    public ResponseEntity<BaseResponse> addPost(@RequestBody EditRequest editRequest) {
        Note noteObj = noteRepository.save(editRequest);
        return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
    }

    @PutMapping("/note/{id}")
    public ResponseEntity<BaseResponse> editPost(@PathVariable Long id, @RequestBody EditRequest editRequest) {
        try {
            Optional<Note> oldNote = noteRepository.findById(id);
            Note updatingNote = new Note();
            if (oldNote.isPresent()) {
                updatingNote.setTitle(editRequest.getTitle());
                updatingNote.setBody(editRequest.getBody());
            }
            Note noteObj = noteRepository.save(updatingNote);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<BaseResponse> deletePost(@PathVariable Long id, @RequestBody EditRequest editRequest) {
        try {
            Optional<Note> oldNote = noteRepository.findById(id);
            Note updatingNote = new Note();
            if (oldNote.isPresent()) {
                updatingNote.setTitle(editRequest.getTitle());
                updatingNote.setBody(editRequest.getBody());
            }
            Note noteObj = noteRepository.save(updatingNote);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }
}
