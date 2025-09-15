package com.project1.RestAPI.service;

import java.util.List;

import com.project1.RestAPI.dto.addStudentRequestDto;
import com.project1.RestAPI.dto.studentDto;

public interface studentService {

    List<studentDto> getAllStudents();

    studentDto getStudentById(Long id);

    studentDto createNewStudent(addStudentRequestDto addStudentRequestDto);

    void deleteById(Long id);

    studentDto updateStudent(Long id, addStudentRequestDto addStudentRequestDto);

    studentDto partialUpdateStudent(Long id, addStudentRequestDto addStudentRequestDto);
}
