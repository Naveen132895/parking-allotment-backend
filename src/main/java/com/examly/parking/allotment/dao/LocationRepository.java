package com.examly.parking.allotment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.parking.allotment.model.Location;

public interface LocationRepository extends JpaRepository<Location,String>{

}
