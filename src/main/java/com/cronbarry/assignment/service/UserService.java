package com.cronbarry.assignment.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cronbarry.assignment.dao.MainUserDao;
import com.cronbarry.assignment.dao.UserDao;
import com.cronbarry.assignment.entity.User;
import com.cronbarry.assignment.entity.UserLead;

@Component
public class UserService {
    
    @Autowired
    private UserDao userDao;
    @Autowired
    private MainUserDao mainUserDao;

    public ResponseEntity<List<UserLead>> updateAllData() {

        return new ResponseEntity<>(userDao.findAll(),HttpStatus.OK); 
    }

    public ResponseEntity<String> updateAllRecord() {
        List<User> users=mainUserDao.findAll();
        List<UserLead> userLeads=userDao.findAll();
        Map<String, Integer> map = new HashMap<>();

        int i=0;
        for(UserLead lead:userLeads){
           int index=i%users.size()+1;
           lead.setUser_assign_id(index);
           if(map.containsKey(lead.getEmail())){
            lead.setRepeat_flag("R");
            lead.setUser_assign_id(map.get(lead.getEmail()));
           }else{
            lead.setRepeat_flag(" ");
            i++;
           }
           map.put(lead.getEmail(),i);
           
        }
        userDao.saveAll(userLeads);
        return new ResponseEntity<>("update data success",HttpStatus.OK);
        
    }

  
}
