package com.project1.RestAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project1.RestAPI.dto.addStudentRequestDto;
import com.project1.RestAPI.dto.studentDto;
import com.project1.RestAPI.service.studentService;

import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
public class StudentController {

    private final studentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<studentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<studentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id)); // same as above.
    }

    @PostMapping("/students")
    public ResponseEntity<studentDto> createNewStudent(@RequestBody addStudentRequestDto addStudentRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<studentDto> updateStudent(@PathVariable Long id,
            @RequestBody addStudentRequestDto addStudentRequestDto) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<studentDto> partialUpdateStudent(@PathVariable Long id,
            @RequestBody addStudentRequestDto addStudentRequestDto) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentService.partialUpdateStudent(id, addStudentRequestDto));
    }

}
