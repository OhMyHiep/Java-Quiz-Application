package com.beaconfire.personalProject.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackDaoImpl {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	   this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	   this.jdbcTemplate = jdbcTemplate;
	}
	    
	
	public void insertFeedback(String feedback, int stars) {
		String sql="INSERT INTO Feedback (comment,stars) VALUES(?,?)";
		jdbcTemplate.update(sql,feedback,stars);
	}
	
	
}