package com.example.studentManagementSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.studentManagementSystem.config.Encoder;
import com.example.studentManagementSystem.dto.UserReqDTO;
import com.example.studentManagementSystem.dto.UserResDTO;
import com.example.studentManagementSystem.entity.UserEntity;
import com.example.studentManagementSystem.repo.UserRepo;
import com.example.studentManagementSystem.service.UserService;
import com.example.studentManagementSystem.util.JWTUtil;
import com.example.studentManagementSystem.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private JWTUtil jwtUtil;

    @Autowired
    private Encoder encoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseUtil authenticationLogin(UserReqDTO userReqDTO) {
        List<Object[]> userObject = userRepo.findUserByUsername(userReqDTO.getUserName());

        if (!userObject.isEmpty()) {
            Boolean isCorrect = encoder.matches(userReqDTO.getPassword(), (String) userObject.get(0)[2]);
            if (isCorrect) {
                String token = jwtUtil.generateJwtToken(userReqDTO.getUserName());
                UserResDTO authResDTO = new UserResDTO(((Number) userObject.get(0)[0]).intValue(), (String) userObject.get(0)[1], userReqDTO.getUserName(), token);
                return new ResponseUtil("200", "Login Successfully", authResDTO);

            } else {
                return new ResponseUtil("500", "Incorrect username or password", null);
            }
        } else {
            return new ResponseUtil("500", "Incorrect username or password", null);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findFirstByUsername(username);
        if (userEntity == null) {
            return null;
        }
        return new User(userEntity.getUsername(), "", new ArrayList<>());
    }
}
