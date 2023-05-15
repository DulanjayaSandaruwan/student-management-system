package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.config.Encoder;
import com.example.studentManagementSystem.dto.UserReqDTO;
import com.example.studentManagementSystem.service.UserService;
import com.example.studentManagementSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/login")
    public ResponseUtil validateAuthentication(@RequestBody UserReqDTO userReqDTO) {
        System.out.println(new Encoder().encode(userReqDTO.getPassword()));

        try {
            return userService.authenticationLogin(userReqDTO);
        } catch (Exception e) {
            return new ResponseUtil("500", e.getMessage(), null);
        }
    }
}
