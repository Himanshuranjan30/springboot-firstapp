package com.first.firstapp.dao;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.first.firstapp.entities.course;

public interface coursesdao extends JpaRepository<course, Integer>{
	
	@Procedure
	String getitout();
	
	

	List<course> findByDateIsNull();
}
