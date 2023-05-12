package com.example.studentManagementSystem.service.impl;

import com.example.studentManagementSystem.dto.UserDTO;
import com.example.studentManagementSystem.repo.UserRepo;
import com.example.studentManagementSystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
        if (userDTO.getUserName().equals("admin@treinetic.com") && userDTO.getPassword().equals("IAmAdmin")) {
            return userDTO;
        } else {
            userRepo.existsById(userDTO.getId());
            return userDTO;
        }

    }
}
