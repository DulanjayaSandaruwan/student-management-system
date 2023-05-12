package com.example.studentManagementSystem.repo;

import com.example.studentManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/
public interface UserRepo extends JpaRepository<User, Integer> {

}
