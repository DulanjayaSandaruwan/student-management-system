package com.example.studentManagementSystem.repo;

import com.example.studentManagementSystem.entity.Notification;
import com.example.studentManagementSystem.entity.Student;
import com.example.studentManagementSystem.util.NotificationStatus;
import com.example.studentManagementSystem.util.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/
public interface NotificationRepo extends JpaRepository<Notification, Integer> {
    public List<Notification> getNotificationByStatus(String status);
}
