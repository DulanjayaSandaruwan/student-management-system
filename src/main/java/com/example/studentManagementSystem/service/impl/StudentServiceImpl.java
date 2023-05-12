package com.example.studentManagementSystem.service.impl;

import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.entity.Student;
import com.example.studentManagementSystem.repo.StudentRepo;
import com.example.studentManagementSystem.service.StudentService;
import com.example.studentManagementSystem.util.StudentStatus;
import com.example.studentManagementSystem.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String saveStudent(StudentDTO studentDTO) {

        if (studentRepo.existsById(studentDTO.getId())) {
            return VarList.RSP_DUPLICATED;
        } else {
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;
        }
    }

    @Override
    public String updateStudent(StudentDTO studentDTO) {
        if (studentRepo.existsById(studentDTO.getId())) {
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> employeeList = studentRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<StudentDTO>>() {
        }.getType());
    }

    @Override
    public List<StudentDTO> getAllPendingRegistration() {
        List<Student> employees = studentRepo.getStudentByStatus(StudentStatus.PENDING_REGISTRATION);
        return modelMapper.map(employees, new TypeToken<ArrayList<StudentDTO>>() {
        }.getType());
    }

}
