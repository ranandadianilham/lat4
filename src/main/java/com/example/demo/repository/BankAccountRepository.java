package com.example.demo.repository;

import com.example.demo.models.Bank_Account;
import com.example.demo.models.Note;
import com.example.demo.payloads.request.note.EditRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<Bank_Account, Long> {

    Bank_Account save(EditRequest editRequest);
}
