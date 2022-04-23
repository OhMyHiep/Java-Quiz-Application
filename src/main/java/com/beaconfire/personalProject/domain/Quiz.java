package com.beaconfire.personalProject.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="Quiz") 
public class Quiz implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quiz_id;
	
	@Column
	private String quizName;
	
	
	@OneToMany(mappedBy = "quiz")
	private List<QuizQuestion> quizQuestions;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category quizCategory;
	
	
	@OneToMany(mappedBy = "quiz")
	private List<Submission> submissions;
	

}




