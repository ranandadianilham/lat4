package com.example.demo.payloads.response;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Long id;
    private Date createdDate;
    private Date deletedDate;
    private Date updatedDate;

    private String alamat;
    private String dob;
    private String nama;
    private String status;

    private EmployeeDetailResponse detail_karyawan;
}
