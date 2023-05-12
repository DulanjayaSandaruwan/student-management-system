package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.NotificationDTO;
import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.service.NotificationService;
import com.example.studentManagementSystem.util.NotificationStatus;
import com.example.studentManagementSystem.util.ResponseUtil;
import com.example.studentManagementSystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ResponseUtil responseUtil;

    @GetMapping("/getAllNotifications")
    public ResponseEntity getAllNotifications(@PathVariable String status) {
        try {
            List<NotificationDTO> notificationDTOList = notificationService.getAllNotification(NotificationStatus.valueOf(status));
            responseUtil.setCode(VarList.RSP_SUCCESS);
            responseUtil.setMessage("Success");
            responseUtil.setContent(notificationDTOList);
            return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
