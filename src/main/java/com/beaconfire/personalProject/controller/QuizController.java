package com.beaconfire.personalProject.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beaconfire.personalProject.domain.Category;
import com.beaconfire.personalProject.domain.Choice;
import com.beaconfire.personalProject.domain.Question;
import com.beaconfire.personalProject.domain.Quiz;
import com.beaconfire.personalProject.domain.User;
import com.beaconfire.personalProject.service.QuizService;

@Controller
@RequestMapping("/user/quiz")
public class QuizController {
	
	QuizService quizService;
	
	
	@GetMapping 
	public String displayCategory(Model model, HttpServletRequest request) {
		System.out.println("in quiz deafault");
		List<Category> category=quizService.getCategory();
		HttpSession session= request.getSession(false);

		if(session==null) {
			return "login";
		}
		session.setAttribute("cat",category);
		Category cat=new Category();
		model.addAttribute(cat);
		return "home";

	}
	 
	
	@GetMapping("/category")
	public String submitCategory(@ModelAttribute Category cat , Model model,HttpSession session){
		System.out.print("name: ");
		System.out.println(cat.getCategoryName());
//		System.out.print("category id: ");
//		System.out.println(cat.getCategory_id());
		List<Question> qList= quizService.getQuestionsBycategoryName(cat.getCategoryName());
		session.setAttribute("qList",qList);
		session.setAttribute("current", 1);
		HashMap<String, Integer> map= new HashMap<>();
		session.setAttribute("map",map);
		Timestamp begin=new Timestamp(new Date().getTime());
		session.setAttribute("begin", begin);
		session.setAttribute("catName", cat.getCategoryName());
		
		return "question1";
	}
	

	
	private void prevNext(Model model, HttpServletRequest request) {
		HttpSession session =request.getSession();
		Integer current=(Integer)session.getAttribute("current");
		current= current==null? 1:current;
		current=request.getParameter("submit").equals("prev")? current-1:current+1;
		session.setAttribute("current",current);
	}
	 
	
	private void storechoiceHelper(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String choice_id= request.getParameter("choice_id");
		String quesContent=request.getParameter(choice_id);
		HashMap<String, Integer> map= (HashMap<String, Integer>)session.getAttribute("map");
		
		
		if(choice_id!=null) {
			System.out.println(choice_id);
			Integer id= Integer.parseInt(choice_id);
			map.put(quesContent,id);
			
			System.out.print("choice id: ");
			System.out.println(id);
			session.setAttribute("map", map);
		}
		System.out.println(map);
	}
	
	
	@PostMapping("/nav")
	private String storeChoice(@ModelAttribute Category cat,Model model, HttpServletRequest request) {
		storechoiceHelper(model, request);
		if(!request.getParameter("submit").equals("Submit")) {
			prevNext(model, request);
		}
		else {
			return submitQuiz(cat, model, request.getSession());
		}
		return "question1";
	}
	
	
	private String submitQuiz(@ModelAttribute Category cat , Model model,HttpSession session) {
		
		System.out.println("in submit");
		
		HashMap<String, Integer> map= (HashMap<String, Integer>)session.getAttribute("map");
		
		if(map.size()==10) {
			List<Question> qList= (List<Question>)session.getAttribute("qList");
			
			System.out.print("qlist size: ");
			System.out.println(qList.size()==10);
			
			Timestamp begin= (Timestamp) session.getAttribute("begin");
			Timestamp end= new Timestamp(new Date().getTime());
			
			session.setAttribute("end", end);
			
			
			calculateScore(qList, map, session);
			int score=(int) session.getAttribute("score");
			User user= (User)session.getAttribute("user");
			String quizName= ((String) session.getAttribute("catName")+" quiz");
			session.setAttribute("quizName", quizName);
			quizService.submitQuiz(cat, map, qList, begin, end, score, user,quizName);
		}
		else {
			session.setAttribute("submitError", "answer all questions");
			return "question1";
		}
		return "results";
		
	}
	
	
	
	private void calculateScore(List<Question> qList,HashMap<String, Integer> map,HttpSession session) {
		int score=0;
		for(Question q: qList) {
			for(Choice c:q.getChoices()) {
				if (c.getChoice_id()==map.get(q.getQuestionContent()) && c.getIsCorrect().equals("yes")) score++;
			}
			
		}
		session.setAttribute("score",score);
		
	}
	
	@GetMapping("/id/{quiz_id}")
	public String findById( @PathVariable Optional<Integer> quiz_id,HttpSession session) {
		if(quiz_id.isPresent()) {
			System.out.println("quiz_id not null");
			Quiz qz= quizService.findById(quiz_id.get());
			session.setAttribute("quiz", qz);
		}
		return "detailedQuiz";
	}
	
	
	@GetMapping("/id/")
	public String findById(HttpSession session) {
		session.removeAttribute("quiz");
		return "detailedQuiz";
	}
	
	
	@Autowired
	public void setRegister(QuizService quizService) {
		this.quizService = quizService;
	}
	
	
}
