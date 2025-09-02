package com.project1.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project1.RestAPI.entity.student;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {

}
