package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee_Detail;
import com.example.demo.models.Trainee;
import com.example.demo.payloads.request.TraineeRequest;
import com.example.demo.payloads.response.BaseResponse;
import com.example.demo.repository.TraineeRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/idstar/trainee")
public class TraineeController {

    @Autowired
    private TraineeRepository traineeRepository;

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getAll() {
        List<Trainee> notes = traineeRepository.findAll();
        return new ResponseEntity<>(new BaseResponse(200, "success", notes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long id) {
        Optional<Trainee> note = traineeRepository.findById(id);
        return new ResponseEntity<>(new BaseResponse(200, "success", note), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> addPost(@RequestBody TraineeRequest bankAccountRequest) {
        Trainee noteObj = traineeRepository.save(bankAccountRequest);
        return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> editPost(@PathVariable Long id, @RequestBody TraineeRequest TraineeRequest) {
        try {
            Optional<Trainee> oldNote = traineeRepository.findById(id);
            Trainee updatingNote = new Trainee();
            if (oldNote.isPresent()) {
                updatingNote.setIdKaryawan(TraineeRequest.getIdKaryawan());
                updatingNote.setIdTraining(TraineeRequest.getIdTraining());
                updatingNote.setTanggal(TraineeRequest.getTanggal());
            }
            Trainee noteObj = traineeRepository.save(updatingNote);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deletePost(@PathVariable Long id, @RequestBody TraineeRequest TraineeRequest) {
        try {
            Optional<Trainee> oldNote = traineeRepository.findById(id);
            Trainee updatingNote = new Trainee();
            if (oldNote.isPresent()) {
            }
            Trainee noteObj = traineeRepository.save(updatingNote);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }
}
