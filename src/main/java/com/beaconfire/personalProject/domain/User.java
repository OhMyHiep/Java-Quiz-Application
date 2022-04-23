package com.beaconfire.personalProject.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name="User")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String role;
	
	@Column
	private String address; 
	
	@Column
	private String email;
	
	private String phoneNum;
	
	@Column
	private String status;
	
	@OneToMany(mappedBy = "user")
	private List<Submission> submissions;
	 
	
	public String changeStatus() {
		if(status.equals("active")) {
			status="suspended";
		}
		else {
			status ="active";
		}
		return status;
	}
	
	
	
	
	
}

