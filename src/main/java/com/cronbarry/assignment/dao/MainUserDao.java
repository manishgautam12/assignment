package com.cronbarry.assignment.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cronbarry.assignment.entity.User;

public interface MainUserDao extends JpaRepository<User,Integer> {
    List<User> findAll();

    
    
}
