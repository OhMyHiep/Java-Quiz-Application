package com.beaconfire.personalProject;
 
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.beaconfire.personalProject.domain.*;
import com.beaconfire.personalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beaconfire.personalProject.daoImpl.SubmissionDaoImpl;
import com.beaconfire.personalProject.service.QuizService;



@SpringBootApplication
public class PersonalProjectApplication {
	
	private static QuizService quizService;
	private static SubmissionDaoImpl submissionDaoImpl;
	private static UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(PersonalProjectApplication.class, args);
		
//		quizService.getCategory();
//		System.out.println(new Timestamp(new Date().getTime()));
		
//		List<Quiz> testList= quizService.getAllQuiz();
//		 List<UserSubmissionResult> ures=submissionDaoImpl.getUserSubmissions(2);
//		System.out.println(testList.size());
//		System.out.println(testList);
//		for(QuizQuestion qq:testList.get(0).getQuizQuestions()) {
//			System.out.print(qq.getQuestion().getQuestion_id()+") ");
//			System.out.println(qq.getQuestion().getQuestionContent());
//			for(Choice c: qq.getQuestion().getChoices()) {
//				System.out.print(c.getChoice_id());
//				System.out.println("    "+c.getChoiceContent());
//			}
//			
//		}
		
//		for(Quiz q: testList) System.out.println(q.getQuizName());
		List<User> users= userService.getAllusers();
		users.stream()
				.filter(x->x.getFirstName().toLowerCase(Locale.ROOT).startsWith("u"))
				.collect(Collectors.toMap(x->x.getUser_id(), x->x))
				.forEach((x,y)->System.out.println(y.getFirstName() +" "+y.getLastName()));
	}
	
	public PersonalProjectApplication(QuizService quizService,SubmissionDaoImpl submissionDaoImpl) {
		this.quizService=quizService;
		this.submissionDaoImpl=submissionDaoImpl;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
