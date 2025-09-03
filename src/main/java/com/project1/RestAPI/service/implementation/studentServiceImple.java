package com.project1.RestAPI.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project1.RestAPI.dto.studentDto;
import com.project1.RestAPI.entity.student;
import com.project1.RestAPI.repository.studentRepository;
import com.project1.RestAPI.service.studentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class studentServiceImple implements studentService {

    private final studentRepository studentRepository;
    private ModelMapper modelMapper;

    public List<studentDto> getAllStudents() {

        List<student> students = studentRepository.findAll();

        List<studentDto> studentDtoList = students.stream()
                .map(student -> new studentDto(student.getId(), student.getName(), student.getEmail()))
                .toList(); // type 1: modelmapping.

        return studentDtoList;
    }

    public studentDto getStudentById(Long id) {

        student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentDto studentDto = modelMapper.map(student, studentDto.class); // type 2: modelmapping.
        return studentDto;

    }

}
