package com.project1.RestAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project1.RestAPI.dto.studentDto;
import com.project1.RestAPI.service.studentService;

import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@AllArgsConstructor
public class StudentController {

    private final studentService studentService;

    @GetMapping("/students")
    public List<studentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public studentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

}
