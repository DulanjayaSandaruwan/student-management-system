package com.example.studentManagementSystem.repo;

import com.example.studentManagementSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 06/05/2023
 **/
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    String FIND_USER_BY_USERNAME = "select id,userName,password from user where userName=?1";

    @Query(value = FIND_USER_BY_USERNAME, nativeQuery = true)
    List<Object[]> findUserByUsername(String username);

    String FIND_USER_BY_NAME="select id from user where username=?1";
    @Query(value = FIND_USER_BY_NAME,nativeQuery = true)
    Integer findByIdAndStatus(String userName);
    UserEntity findFirstByUsername(String username);
}
