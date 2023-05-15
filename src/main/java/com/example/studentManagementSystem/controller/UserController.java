package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.UserDTO;
import com.example.studentManagementSystem.service.UserService;
import com.example.studentManagementSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseUtil responseUtil;

    @PostMapping(value = "/loginUser")
    public ResponseEntity loginUser(@RequestBody UserDTO userDTO) {
        userService.loginUser(userDTO);
        return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
    }
}
