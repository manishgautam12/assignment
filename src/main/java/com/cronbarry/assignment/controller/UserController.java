package com.cronbarry.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cronbarry.assignment.entity.UserLead;
import com.cronbarry.assignment.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("findall")
    public ResponseEntity<List<UserLead>> userApi()
    {
        return userService.updateAllData();
    }
    @PutMapping("update")
     public ResponseEntity<String> updateAllRecord()
     {
        return userService.updateAllRecord();
     }
}
