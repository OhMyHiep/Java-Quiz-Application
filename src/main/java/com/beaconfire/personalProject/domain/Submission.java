package com.beaconfire.personalProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name="Submission")
public class Submission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer submission_id;
	
	@Column
	private Timestamp startTime;
	
	@Column
	private Timestamp endTime;
	 
	@Column
	private Integer score;
	
	@ManyToOne
	@JoinColumn(name="quiz_id")
	private Quiz quiz;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	
	

}
