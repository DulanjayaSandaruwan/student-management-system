package com.example.studentManagementSystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseUtil {
    private String code;
    private String message;
    private Object content;
}
