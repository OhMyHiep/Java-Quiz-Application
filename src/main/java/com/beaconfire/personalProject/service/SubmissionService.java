package com.beaconfire.personalProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beaconfire.personalProject.daoImpl.SubmissionDaoImpl;
import com.beaconfire.personalProject.domain.UserSubmissionResult;

@Component 
public class SubmissionService {

	private SubmissionDaoImpl submissionDaoImpl;

	@Autowired
	public void setSubmissionDaoImpl(SubmissionDaoImpl submissionDaoImpl) {
		this.submissionDaoImpl = submissionDaoImpl;
	}
	
	@Transactional
	public List<UserSubmissionResult> getUserSubmissions(Integer user_id){
		return submissionDaoImpl.getUserSubmissions(user_id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
