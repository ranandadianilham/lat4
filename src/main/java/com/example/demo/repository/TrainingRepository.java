package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Training;
import com.example.demo.payloads.request.TrainingRequest;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    Training save(TrainingRequest employee);
}
