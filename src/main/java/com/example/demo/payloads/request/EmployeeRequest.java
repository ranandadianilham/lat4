package com.example.demo.payloads.request;

import com.example.demo.models.Employee_Detail;
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
