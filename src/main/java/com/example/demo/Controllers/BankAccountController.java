package com.example.demo.Controllers;

import com.example.demo.models.Bank_Account;
import com.example.demo.models.Note;
import com.example.demo.payloads.response.BaseResponse;
import com.example.demo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/idstar")
public class BankAccountController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @GetMapping("/accounts")
    public ResponseEntity<BaseResponse> getAll() {
        List<Bank_Account> notes = bankAccountRepository.findAll();
        return new ResponseEntity<>(new BaseResponse(200, "success", notes), HttpStatus.OK);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long id) {
        Optional<Bank_Account> note = bankAccountRepository.findById(id);
        return new ResponseEntity<>(new BaseResponse(200, "success", note), HttpStatus.OK);
    }


}
