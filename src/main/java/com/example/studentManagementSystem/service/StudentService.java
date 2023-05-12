package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.StudentDTO;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/
public interface StudentService {
    String saveStudent(StudentDTO studentDTO);
    String updateStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudent();
    List<StudentDTO> getAllPendingRegistration();



}
