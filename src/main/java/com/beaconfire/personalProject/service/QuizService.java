package com.beaconfire.personalProject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beaconfire.personalProject.daoImpl.QuizDaoImpl;
import com.beaconfire.personalProject.domain.Category;
import com.beaconfire.personalProject.domain.Choice;
import com.beaconfire.personalProject.domain.Question;
import com.beaconfire.personalProject.domain.Quiz;
import com.beaconfire.personalProject.domain.QuizQuestion;
import com.beaconfire.personalProject.domain.User;


@Component 
public class QuizService {

	private QuizDaoImpl quizDaoImpl;

	
	@Autowired
	public void setQuizDaoImpl(QuizDaoImpl quizDaoImpl) {
		this.quizDaoImpl = quizDaoImpl;
	}
	
	
	public Quiz getQuizId(Integer id) {
        return quizDaoImpl.findById(id);
    }
	
	
	public  List<Category> getCategory() {
		
		return quizDaoImpl.getCategory();
	}
	    
	
	
	public List<Question> getQuestionsBycategoryName(String categoryName) {
		
		return quizDaoImpl.getQuestionsBycategoryName(categoryName);
		
		}
	    
	
	
	public void submitQuiz(Category cat,HashMap<String, Integer> map, List<Question> qList, Timestamp begin, Timestamp end,int score, User user, String quizName) {
		quizDaoImpl.submitQuiz(cat, map, qList, begin, end, score, user, quizName);
		
	}
	
	
	@Transactional
	public List<Quiz> getAllQuiz() {
		return quizDaoImpl.getAllQuiz();
	} 
	 
	@Transactional
	public Quiz findById(Integer id) {
		return quizDaoImpl.findById(id);
	}
	
}
