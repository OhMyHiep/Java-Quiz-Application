package com.beaconfire.personalProject.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name="QuizQuestion")
public class QuizQuestion { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quizQuestion_id;
	
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@ManyToOne
	@JoinColumn(name="selected_choice_id")
	private Choice choice;
	
	
	 
}
