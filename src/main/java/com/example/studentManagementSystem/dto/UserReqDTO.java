package com.example.studentManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 15/05/2023
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDTO {
    private String userName;
    private String password;
}
