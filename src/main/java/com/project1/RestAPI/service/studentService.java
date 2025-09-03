package com.project1.RestAPI.service;

import java.util.List;

import com.project1.RestAPI.dto.studentDto;

public interface studentService {

    List<studentDto> getAllStudents();

    studentDto getStudentById(Long id);
}
