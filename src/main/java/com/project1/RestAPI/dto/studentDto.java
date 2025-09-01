package com.project1.RestAPI.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class studentDto {
    private long id;
    private String name;
    private String email;

    // public String getName() {
    // return name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public int getEmail() {
    // return age;
    // }

    // public void setAge(int age) {
    // this.age = age;
    // }
}