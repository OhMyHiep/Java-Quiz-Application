package com.beaconfire.personalProject.daoImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.beaconfire.personalProject.dao.AbstractHibernateDAO;
import com.beaconfire.personalProject.domain.Quiz;
import com.beaconfire.personalProject.domain.QuizQuestion;
import com.beaconfire.personalProject.domain.Submission;
import com.beaconfire.personalProject.domain.UserSubmissionResult;

@Repository
public class SubmissionDaoImpl extends AbstractHibernateDAO<UserSubmissionResult>{

	@Transactional
	public List<UserSubmissionResult> getUserSubmissions(Integer user_id){
		Session session =getCurrentSession();
		List<UserSubmissionResult> results = null;
//		System.out.println("in");
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<UserSubmissionResult> criteriaQuery = criteriaBuilder.createQuery(UserSubmissionResult.class);

			Root<Submission> pRoot = criteriaQuery.from(Submission.class);
			pRoot.join("user", JoinType.INNER);
			Join <Submission,Quiz> quizJoin =pRoot.join("quiz",JoinType.INNER);
//			Join<Quiz,QuizQuestion> qqJoin=quizJoin.join("quizQuestions",JoinType.INNER);
//			pRoot.join("QuizQuestion",JoinType.INNER);
			criteriaQuery.multiselect(
					pRoot.get("startTime"),
					pRoot.get("quiz").get("quiz_id"),
//					criteriaBuilder.count(qqJoin),
//					pRoot.get("quiz").get("quizQuestions"), 
//					quizJoin.get("quizQuestions"),
					pRoot.get("quiz").get("quizCategory").get("categoryName"),
					pRoot.get("score"),
					pRoot.get("user").get("firstName"),
					pRoot.get("user").get("lastName"));
			Predicate predicate = pRoot.get("user").get("user_id").in(Arrays.asList(user_id));
			criteriaQuery.where(predicate);
			results = session.createQuery(criteriaQuery).getResultList();
			results.sort((UserSubmissionResult u1, UserSubmissionResult u2)-> 
			u1.getStartTime().compareTo(u2.getStartTime()));
//			System.out.println(results.size()); 
			printResult(results);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}
	
	private static void printResult(List<UserSubmissionResult> results) {
		results.forEach(result -> {
			System.out.println("Date: " + result.getStartTime());
			System.out.println("Quiz Id: " + result.getQuiz_id());
//			System.out.println("Nbr questions:" +result.getNbrQuizQuestion());
			System.out.println("Score: " + result.getScore());
			System.out.println("Name: " + result.getFirstName());
			System.out.println("Last Name: " + result.getLastName());
			System.out.println("=======================");
		});
	}
	
	
	
	
	
	
}
