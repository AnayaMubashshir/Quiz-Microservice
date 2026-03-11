package com.microservice.quiz_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.quiz_service.dao.QuizDao;
import com.microservice.quiz_service.feign.QuizInterface;
import com.microservice.quiz_service.model.QuestionWrapper;
import com.microservice.quiz_service.model.Quiz;
import com.microservice.quiz_service.model.Response;


@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuizInterface quizInterface;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		 List<Integer> questions=quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		 Quiz quiz=new Quiz(); 
		 quiz.setTitle(title); 
		 quiz.setQuestionIds(questions);
		 quizDao.save(quiz); 
		 return new ResponseEntity<>("Success",HttpStatus.CREATED); 
	}
		 
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		 Quiz quiz=quizDao.findById(id).get(); 
		 List<Integer> questionIds=quiz.getQuestionIds();
		 ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionFromId(questionIds);
		
		 return questions;
	}
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		ResponseEntity<Integer> score=quizInterface.getScore(responses);
		return score;
	}
	
}
