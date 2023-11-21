package com.example.demo.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String nama;
    private String dob;
    private String status;
    private String alamat;
    private EmployeeDetailRequest detailKaryawan;
}
