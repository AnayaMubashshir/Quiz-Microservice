package com.microservice.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.quiz_service.model.Quiz;


public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
}
