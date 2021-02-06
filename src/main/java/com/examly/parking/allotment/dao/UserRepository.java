package com.examly.parking.allotment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.parking.allotment.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,String>{

}

