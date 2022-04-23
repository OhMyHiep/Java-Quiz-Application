package com.beaconfire.personalProject.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Category")
@Builder
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer category_id;
	
	
	@Column
	private String categoryName;
	
	
	@OneToMany(mappedBy = "questionCategory")
	private List<Question> questions;
	
	
	@OneToMany(mappedBy = "quizCategory")
	private List<Quiz> quizs;
	
} 




