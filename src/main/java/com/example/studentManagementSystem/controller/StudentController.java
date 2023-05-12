package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.NotificationDTO;
import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.service.NotificationService;
import com.example.studentManagementSystem.service.StudentService;
import com.example.studentManagementSystem.util.NotificationStatus;
import com.example.studentManagementSystem.util.ResponseUtil;
import com.example.studentManagementSystem.util.StudentStatus;
import com.example.studentManagementSystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ResponseUtil responseUtil;

    @PostMapping(value = "/saveStudent")
    public ResponseEntity saveStudent(@RequestBody StudentDTO studentDTO) {
        try {
            String res = studentService.saveStudent(studentDTO);
            if (res.equals("00")) {
                responseUtil.setCode(VarList.RSP_SUCCESS);
                responseUtil.setMessage("Success");
                responseUtil.setContent(studentDTO);
                return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseUtil.setCode(VarList.RSP_DUPLICATED);
                responseUtil.setMessage("Already Registered");
                responseUtil.setContent(studentDTO);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            } else {
                responseUtil.setCode(VarList.RSP_FAIL);
                responseUtil.setMessage("Error");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/updateStudent")
    public ResponseEntity updateStudent(@RequestBody StudentDTO studentDTO) {
        NotificationDTO notificationDTO = new NotificationDTO();
        try {

            notificationDTO.setMessage("Your registration request has been accept");
            notificationDTO.setReceiver(studentDTO.getEmail());
            notificationDTO.setSender("test@gmail.com");
            notificationDTO.setSendDate(new Date().toString());
            notificationDTO.setStatus(NotificationStatus.UNREAD);

            String res = studentService.updateStudent(studentDTO);
            if(studentDTO.getStatus().equals(StudentStatus.PENDING_REGISTRATION.toString())){
                notificationService.saveNotification(notificationDTO);
            }
            if (res.equals("00")) {
                responseUtil.setCode(VarList.RSP_SUCCESS);
                responseUtil.setMessage("Success");
                responseUtil.setContent(studentDTO);
                return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseUtil.setCode(VarList.RSP_NO_DATA_FOUND);
                responseUtil.setMessage("Not a registered employee");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            } else {
                responseUtil.setCode(VarList.RSP_FAIL);
                responseUtil.setMessage("Error");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity getAllStudents() {
        try {
            List<StudentDTO> studentDTOList = studentService.getAllStudent();
            responseUtil.setCode(VarList.RSP_SUCCESS);
            responseUtil.setMessage("Success");
            responseUtil.setContent(studentDTOList);
            return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllPendingStudents")
    public ResponseEntity getAllEmployees() {
        try {
            List<StudentDTO> studentDTOList = studentService.getAllPendingRegistration();
            responseUtil.setCode(VarList.RSP_SUCCESS);
            responseUtil.setMessage("Success");
            responseUtil.setContent(studentDTOList);
            return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
