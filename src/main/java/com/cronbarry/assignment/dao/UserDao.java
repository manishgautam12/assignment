package com.cronbarry.assignment.dao;





import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.cronbarry.assignment.entity.UserLead;

@Repository
public interface UserDao extends JpaRepository<UserLead,Integer> {

    

    

}
