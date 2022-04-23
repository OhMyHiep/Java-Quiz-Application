package com.beaconfire.personalProject.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSubmissionResult implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date startTime;
	
	private Integer quiz_id;
	
//	private Long nbrQuizQuestion; 
	
	private String category;
	
	private Integer score; 
	
	private String firstName;
	
	private String lastName;
	
	
}
