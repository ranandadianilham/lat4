package com.example.demo.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailResponse {
    private Long id;
    private Date createdDate;
    private Date deletedDate;
    private Date updatedDate;

    private String nik;
    private String npwp;

}
