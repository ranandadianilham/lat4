package com.example.demo.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequest {
    private String jenis;
    private String nama;
    private String rekening;
}
