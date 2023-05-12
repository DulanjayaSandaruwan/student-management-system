package com.example.studentManagementSystem.dto;

import com.example.studentManagementSystem.util.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String status;
}
