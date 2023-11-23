package com.example.demo.Controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.Employee_Detail;
import com.example.demo.payloads.request.EmployeeRequest;
import com.example.demo.payloads.response.BaseResponse;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/idstar/karyawan")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getAll() {
        List<Employee> notes = employeeRepository.findAll();
        return new ResponseEntity<>(new BaseResponse(200, "success", notes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long id) {
        Optional<Employee> note = employeeRepository.findById(id);
        System.out.println(id);
        return new ResponseEntity<>(new BaseResponse(200, "success", note), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> addPost(@RequestBody EmployeeRequest employeeRequest) {
        Employee temp = new Employee();
        temp.setNama(employeeRequest.getNama());
        temp.setDob(employeeRequest.getDob());
        temp.setAlamat(employeeRequest.getAlamat());
        temp.setStatus(employeeRequest.getStatus());

        Employee_Detail temp1 = new Employee_Detail();
        temp1.setNpwp(employeeRequest.getDetailKaryawan().getNpwp());
        temp1.setNik(employeeRequest.getDetailKaryawan().getNpwp());

        temp.setEmployee_Detail(temp1);

        Employee noteObj = employeeRepository.save(temp);

        System.out.println(noteObj);
        return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> editPost(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        try {
            Optional<Employee> oldNote = employeeRepository.findById(id);
            Employee temp = new Employee();
            if (oldNote.isPresent()) {
                temp.setId(id);
                temp.setNama(employeeRequest.getNama());
                temp.setDob(employeeRequest.getDob());
                temp.setAlamat(employeeRequest.getAlamat());
                temp.setStatus(employeeRequest.getStatus());
                temp.setEmployee_Detail(oldNote.get().getEmployee_Detail());

            }
            System.out.println(temp);
            Employee noteObj = employeeRepository.save(temp);
            return new ResponseEntity<>(new BaseResponse(200, "success", noteObj), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "failed", e.getMessage()), HttpStatus.OK);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deletePost(@PathVariable Long id) {
        try {
            Optional<Employee> oldNote = employeeRepository.findById(id);
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(new BaseResponse(200, "delete success", oldNote), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(200, "success", e.getMessage()), HttpStatus.OK);
        }
    }
}
