package com.example.demo.Controllers;

import com.example.demo.models.Bank_Account;
import com.example.demo.models.Note;
import com.example.demo.payloads.request.BankAccountRequest;
import com.example.demo.payloads.request.note.EditRequest;
import com.example.demo.payloads.response.BaseResponse;
import com.example.demo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/idstar/bank")
public class BankAccountController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getAll() {
        List<Bank_Account> notes = bankAccountRepository.findAll();
        return new ResponseEntity<>(new BaseResponse(200, "success", notes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long id) {
        Optional<Bank_Account> note = bankAccountRepository.findById(id);
        return new ResponseEntity<>(new BaseResponse(200, "success", note), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<BaseResponse> save() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> editById(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/note")
    public ResponseEntity<BaseResponse> addPost(@RequestBody BankAccountRequest bankAccountRequest) {
        Bank_Account noteObj = bankAccountRepository.save(bankAccountRequest);
        return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
    }

    @PutMapping("/note/{id}")
    public ResponseEntity<BaseResponse> editPost(@PathVariable Long id, @RequestBody EditRequest editRequest) {
        try {
            Optional<Bank_Account> oldNote = bankAccountRepository.findById(id);
            Bank_Account updatingNote = new Bank_Account();
            if (oldNote.isPresent()) {
            }
            Bank_Account noteObj = bankAccountRepository.save(updatingNote);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<BaseResponse> deletePost(@PathVariable Long id, @RequestBody EditRequest editRequest) {
        try {
            Optional<Bank_Account> oldNote = bankAccountRepository.findById(id);
            Bank_Account updatingNote = new Bank_Account();
            if (oldNote.isPresent()) {
            }
            Bank_Account noteObj = bankAccountRepository.save(updatingNote);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }

}
