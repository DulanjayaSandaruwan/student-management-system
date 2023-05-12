package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.dto.UserDTO;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/
public interface UserService {
    UserDTO loginUser(UserDTO userDTO);
}
