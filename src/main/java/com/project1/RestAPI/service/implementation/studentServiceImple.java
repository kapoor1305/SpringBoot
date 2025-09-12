package com.project1.RestAPI.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project1.RestAPI.dto.addStudentRequestDto;
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

    @Override
    public studentDto createNewStudent(addStudentRequestDto addStudentRequestDto) {

        student newStudent = modelMapper.map(addStudentRequestDto, student.class);
        student student = studentRepository.save(newStudent);
        return modelMapper.map(student, studentDto.class);
    }

    @Override
    public void deleteById(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found by id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public studentDto updateStudent(Long id, addStudentRequestDto addStudentRequestDto) {
        student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found by id: " + id));

        if (addStudentRequestDto.getName() != null && !addStudentRequestDto.getName().isEmpty()) {
            student.setName(addStudentRequestDto.getName());
        }
        if (addStudentRequestDto.getEmail() != null && !addStudentRequestDto.getEmail().isEmpty()) {
            student.setEmail(addStudentRequestDto.getEmail());
        }

        student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, studentDto.class);

        // ## Another approach using ModelMapper with configuration to skip id mapping
        // modelMapper.map(addStudentRequestDto, student);
        // modelMapper.map(addStudentRequestDto.class, student.class);
        // studentRepository.save(student);
        // return modelMapper.map(student, studentDto.class);
    }

}
