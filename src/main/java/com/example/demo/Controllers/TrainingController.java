package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

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
import com.example.demo.models.Training;
import com.example.demo.payloads.request.TrainingRequest;
import com.example.demo.payloads.response.BaseResponse;
import com.example.demo.repository.TrainingRepository;

@RestController
@RequestMapping("/v1/idstar/training")
public class TrainingController {

    @Autowired
    private TrainingRepository trainingRepository;

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getAll() {
        List<Training> notes = trainingRepository.findAll();
        return new ResponseEntity<>(new BaseResponse(200, "success", notes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long id) {
        Optional<Training> note = trainingRepository.findById(id);
        return new ResponseEntity<>(new BaseResponse(200, "success", note), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> addPost(@RequestBody TrainingRequest TrainingRequest) {
        Training temp = new Training();

        temp.setPengajar(TrainingRequest.getPengajar());
        temp.setTema(TrainingRequest.getTema());

        Training noteObj = trainingRepository.save(temp);

        return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> editPost(@PathVariable Long id, @RequestBody TrainingRequest TrainingRequest) {
        try {
            Optional<Training> oldNote = trainingRepository.findById(id);
            Training temp = getTraining(TrainingRequest, oldNote);
            Training noteObj = trainingRepository.save(temp);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }

    private static Training getTraining(TrainingRequest TrainingRequest, Optional<Training> oldNote) {
        Training temp = new Training();
        if (oldNote.isPresent()) {
            temp.setPengajar(TrainingRequest.getPengajar());
            temp.setTema(TrainingRequest.getTema());
        }
        return temp;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deletePost(@PathVariable Long id) {
        try {
            Optional<Training> oldNote = trainingRepository.findById(id);
            trainingRepository.deleteById(id);
            return new ResponseEntity<>(new BaseResponse(200, "delete success", oldNote), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", null), HttpStatus.OK);
        }
    }
}
