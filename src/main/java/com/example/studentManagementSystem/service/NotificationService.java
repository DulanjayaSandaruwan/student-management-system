package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.NotificationDTO;
import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.util.NotificationStatus;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/
public interface NotificationService {
    String saveNotification(NotificationDTO notificationDTO);

    String updateNotification(NotificationDTO notificationDTO);
    List<NotificationDTO> getAllNotification(NotificationStatus notificationStatus);
}
