package com.beaconfire.personalProject.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beaconfire.personalProject.daoImpl.FeedbackDaoImpl;




@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	FeedbackDaoImpl feedbackDaoImpl;
	
	@Autowired
	public void setFeedbackDaoImpl(FeedbackDaoImpl feedbackDaoImpl) {
		this.feedbackDaoImpl=feedbackDaoImpl;
	}
	
	
	@GetMapping
	public String toFeedback() {
		
		return "feedback";
	}
	
	
	@PostMapping
	public String submitFeedback(HttpServletRequest request) {
		if(request.getParameter("stars")!=null) {
		String feedback= request.getParameter("feedback");
		int star= Integer.parseInt(request.getParameter("stars"));
		feedbackDaoImpl.insertFeedback(feedback, star);
		}
		return "home";
		
	}
	
	
}