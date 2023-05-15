package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.UserReqDTO;
import com.example.studentManagementSystem.util.ResponseUtil;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/
public interface UserService extends UserDetailsService {
    ResponseUtil authenticationLogin(UserReqDTO userReqDTO);
}
