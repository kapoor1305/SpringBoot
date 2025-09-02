package com.project1.RestAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project1.RestAPI.dto.studentDto;
import com.project1.RestAPI.entity.student;
import com.project1.RestAPI.repository.studentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {

    @Autowired
    studentRepository studentRepository;

    // public StudentController(studentRepository studentRepository) {
    // this.studentRepository = studentRepository;
    // }

    @GetMapping("/student")
    public List<student> getStudent() {
        return studentRepository.findAll();
    }

}
