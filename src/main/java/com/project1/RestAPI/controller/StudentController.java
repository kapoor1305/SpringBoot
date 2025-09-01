package com.project1.RestAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project1.RestAPI.dto.studentDto;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {

    @GetMapping("/student")
    public studentDto getStudent() {
        return new studentDto(1, "John Doe", "jhon@abc.com");
    }

}
