package com.microservice.question_service.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.question_service.dao.QuestionDao;
import com.microservice.question_service.model.Question;
import com.microservice.question_service.model.QuestionWrapper;
import com.microservice.question_service.model.Response;



@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
	}
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
		return new ResponseEntity<>("Question added successfully!",HttpStatus.CREATED);
	}
	public String updateQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
		return "Question updated successfully!";
	}
	public String deleteQuestion(int id) {
		// TODO Auto-generated method stub
		questionDao.deleteById(id);
		return "Question deleted succeSssfully!";
	}
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
		// TODO Auto-generated method stub
		List<Integer> questions=questionDao.findRandomQuestionByCategory(categoryName,numQuestions);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		// TODO Auto-generated method stub
		List<QuestionWrapper> wrappers=new ArrayList<>();
		List<Question> questions=new ArrayList<>();
		for(Integer id:questionIds) {
			questions.add(questionDao.findById(id).get());
		}
		for(Question question:questions) {
			QuestionWrapper wrapper=new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}
	public ResponseEntity<Integer> getScore(List<Response> responses) {
		// TODO Auto-generated method stub
		int right=0;
		for(Response r:responses) {
			Question question =questionDao.findById(r.getId()).get();
			if(r.getResponse().equals(question.getRightAnswer())){
				right++;
			}
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
}
