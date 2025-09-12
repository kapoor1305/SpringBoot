package com.project1.RestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class addStudentRequestDto {
    private String name;
    private String email;
}
