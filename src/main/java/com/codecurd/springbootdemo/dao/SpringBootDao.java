package com.codecurd.springbootdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codecurd.springbootdemo.pojo.SpringBootPojo;

public interface SpringBootDao extends JpaRepository<SpringBootPojo, Integer> {

	public List<SpringBootPojo> findByVersion(String version);
	
}
