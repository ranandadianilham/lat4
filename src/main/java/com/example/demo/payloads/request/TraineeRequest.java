package com.example.demo.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraineeRequest {

    private String tanggal;

    private Long idKaryawan;

    private Long idTraining;
}
