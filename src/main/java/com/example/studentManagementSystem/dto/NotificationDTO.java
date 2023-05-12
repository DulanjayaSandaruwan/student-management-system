package com.example.studentManagementSystem.dto;

import com.example.studentManagementSystem.util.NotificationStatus;
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
public class NotificationDTO {
    private int id;
    private String sender;
    private String receiver;
    private String message;
    private String sendDate;
    private NotificationStatus status;
}
