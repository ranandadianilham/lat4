
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Trainee;
import com.example.demo.payloads.request.TraineeRequest;
import com.example.demo.payloads.request.TrainingRequest;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {

    Trainee save(TraineeRequest bankAccountRequest);
}
