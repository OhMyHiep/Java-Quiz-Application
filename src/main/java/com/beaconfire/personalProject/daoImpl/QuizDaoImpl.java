package com.beaconfire.personalProject.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;
import com.beaconfire.personalProject.domain.Question;
import com.beaconfire.personalProject.domain.Quiz;
import com.beaconfire.personalProject.domain.QuizQuestion;
import com.beaconfire.personalProject.domain.User;



import com.beaconfire.personalProject.domain.Choice;
import com.beaconfire.personalProject.dao.AbstractHibernateDAO;
import com.beaconfire.personalProject.domain.Category;

@Repository
public class QuizDaoImpl extends AbstractHibernateDAO<Quiz>{
	
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
	    
	
	public QuizDaoImpl() {
		setClazz(Quiz.class);
	}
	
	
	public Quiz getQuizId(Integer id) {
        return findById(id);
    }
	
	 
	private RowMapper<Category> categoryMap= (ResultSet rs, int i) -> {
		Category c=new Category();
		c.setCategory_id(rs.getInt("category_id"));
		c.setCategoryName(rs.getString("categoryName"));
		return c;
	};
	   
	
	private RowMapper<Question> questionMap= (ResultSet resultSet, int i) -> {
		
	    Question q= new Question();
	    q.setQuestion_id(resultSet.getInt("question_id"));
	    q.setQuestionContent(resultSet.getString("questionContent"));
	    Category category= new Category();
	    category.setCategory_id(resultSet.getInt("category_id"));
	    q.setQuestionCategory(category);
	    return q;
	    
	    }; 
	    
	
	 private RowMapper<Choice> choiceMapper=(ResultSet rs, int i) -> {
		 Choice c=new Choice();
		 c.setChoice_id(rs.getInt("choice_id"));
		 c.setChoiceContent(rs.getString("choiceContent"));
		 c.setIsCorrect(rs.getString("isCorrect"));
		 Question question= new Question();
		 question.setQuestion_id(rs.getInt("question_id"));
		 c.setQuestion(question);
		 return c;
 	 };
	     
	
	public  List<Category> getCategory() {
		System.out.println("in get category");
		String sql="SELECT * FROM Category";
		List<Category> list= namedParameterJdbcTemplate.query(sql,categoryMap);
		return list;
	}
	    
	
	public List<Question> getQuestionsBycategoryName(String categoryName) {
		
		String sql= "SELECT q.question_id, q.questionContent, q.category_id FROM Question q JOIN Category c ON q.category_id = c.category_id WHERE c.categoryName=:name ORDER BY RAND() LIMIT 10";
		MapSqlParameterSource p = new MapSqlParameterSource();
		p.addValue("name", categoryName);
		List<Question> qList = namedParameterJdbcTemplate.query(sql,p,questionMap);
		mapChoiceToQuestion(qList);
		return qList;
		
		}
	    
	private void mapChoiceToQuestion(List<Question> qList) {
		String sql="SELECT * \n"
				+ "FROM Choice\n"
				+ "WHERE question_id=:id";
		for(Question q:qList) {
			MapSqlParameterSource p= new MapSqlParameterSource();
			p.addValue("id",q.getQuestion_id());
			List<Choice> cList= namedParameterJdbcTemplate.query(sql,p,choiceMapper);
			q.setChoices(cList);
		}
		
	}
	
	
	
	 
	
	public void submitQuiz(Category cat,HashMap<String, Integer> map, List<Question> qList, Timestamp begin, Timestamp end,int score, User user, String quizName) {
		
		String sqlString="INSERT INTO Quiz (quizName,category_id) VALUES(?,?)";
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn= jdbcTemplate.getDataSource().getConnection();
			conn.setAutoCommit(false);
			preparedStatement= conn.prepareStatement(sqlString);
			
			System.out.print("quizName: ");
			System.out.println(quizName);
			preparedStatement.setString(1, quizName);
			
			System.out.print("Category name: ");
			System.out.println(cat.getCategoryName());
			preparedStatement.setInt(2, qList.get(0).getQuestionCategory().getCategory_id());
			preparedStatement.executeUpdate();
			
			String sqlQuizId= "select LAST_INSERT_ID() As id";
			
			preparedStatement=conn.prepareStatement(sqlQuizId);
			ResultSet rSet= preparedStatement.executeQuery();
			Integer quizId=null;
			while (rSet.next()) {
				quizId =rSet.getInt("id");
			}
			
			String insertQuestion="Insert into QuizQuestion (question_id,quiz_id,selected_choice_id) Values(?,?,?)"; 
			for(Question q:qList) {
				int selected_choice_id = map.get(q.getQuestionContent());
				preparedStatement=conn.prepareStatement(insertQuestion);
				preparedStatement.setInt(1,q.getQuestion_id());
				preparedStatement.setInt(2, quizId);
				preparedStatement.setInt(3, selected_choice_id);
				preparedStatement.executeUpdate();
			}
			
			String insertSubmission="insert into Submission (startTime,endTime,score,quiz_id,user_id) Values(?,?,?,?,?)";
			preparedStatement=conn.prepareStatement(insertSubmission);
			preparedStatement.setObject(1, begin);
			preparedStatement.setObject(2, end);
			preparedStatement.setInt(3, score);
			preparedStatement.setInt(4, quizId);
			preparedStatement.setInt(5, user.getUser_id());
			preparedStatement.executeUpdate();
			
			conn.commit();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			if(conn!=null) {
				
				try {
					conn.rollback();
				}
				catch(SQLException ex) {
					
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				
				try {
					conn.rollback();
				}
				catch(SQLException ex) {
					
				}
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public List<Quiz> getAllQuiz() {
		List<Quiz> qzList= getCurrentSession().createQuery("select distinct qz from Quiz qz join fetch qz.quizQuestions qq join fetch qq.question").list();//qz join fetch qz.quizQuestions qq join fetch qq.question qq join fetch qq.question
//		for(Quiz qz:qzList) {
//			for(QuizQuestion qq: qz.getQuizQuestions()){
//				for(Choice c: qq.getQuestion().getChoices()) {
//				}
//			}
//		}
		return qzList;
		
	} 
	
	
	@Override
	public Quiz findById(Integer id){
		List<Quiz> qzList= getCurrentSession().createQuery("select distinct qz from Quiz qz join fetch qz.quizQuestions qq "
				+ "join fetch qq.question "
				+ "where qz.quiz_id=:id").setParameter("id", id).list();//qz join fetch qz.quizQuestions qq join fetch qq.question qq join fetch qq.question
		for(Quiz qz:qzList) {
			for(QuizQuestion qq: qz.getQuizQuestions()){
				for(Choice c: qq.getQuestion().getChoices()) {
				}
			}
		}
		return qzList.size()==0? null:qzList.get(0);
	}
	
	
	
	
	    
	    
}
