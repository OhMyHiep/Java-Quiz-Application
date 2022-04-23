package com.beaconfire.personalProject.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beaconfire.personalProject.domain.User;
import com.beaconfire.personalProject.domain.UserSubmissionResult;
import com.beaconfire.personalProject.service.SubmissionService;




@Controller
@RequestMapping("/user/submission")
public class SubmissionController {
	
	private SubmissionService submissionService;

	@Autowired
	public void setSubmissionService(SubmissionService submissionService) {
		this.submissionService = submissionService;
	}
	
	@GetMapping
	public String adminView(HttpSession session) {
		
		return "adminQuizView";
	}
	
	@GetMapping("/id/{user_id}")
	public String getUserSubmission( @PathVariable Optional<Integer> user_id,HttpSession session) {
		System.out.println("in get user submission,ID:"+user_id);
		if(user_id.isPresent()) {
			System.out.println("id not null");
			List<UserSubmissionResult> subList= submissionService.getUserSubmissions(user_id.get());	
			session.setAttribute("subList", subList);
		}
		return "adminQuizView";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
