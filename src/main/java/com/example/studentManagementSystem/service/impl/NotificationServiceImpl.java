package com.example.studentManagementSystem.service.impl;

import com.example.studentManagementSystem.dto.NotificationDTO;
import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.entity.Notification;
import com.example.studentManagementSystem.entity.Student;
import com.example.studentManagementSystem.repo.NotificationRepo;
import com.example.studentManagementSystem.repo.StudentRepo;
import com.example.studentManagementSystem.service.NotificationService;
import com.example.studentManagementSystem.util.NotificationStatus;
import com.example.studentManagementSystem.util.StudentStatus;
import com.example.studentManagementSystem.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveNotification(NotificationDTO notificationDTO) {
        if (notificationRepo.existsById(notificationDTO.getId())) {
            return VarList.RSP_DUPLICATED;
        } else {
            notificationRepo.save(modelMapper.map(notificationDTO, Notification.class));
            return VarList.RSP_SUCCESS;
        }
    }

    @Override
    public String updateNotification(NotificationDTO notificationDTO) {
        if (notificationRepo.existsById(notificationDTO.getId())) {
            notificationRepo.save(modelMapper.map(notificationDTO, Notification.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    @Override
    public List<NotificationDTO> getAllNotification(NotificationStatus notificationStatus) {
        List<Notification> notificationList = notificationRepo.getNotificationByStatus(String.valueOf(notificationStatus));
        return modelMapper.map(notificationList, new TypeToken<ArrayList<StudentDTO>>() {
        }.getType());
    }
}
