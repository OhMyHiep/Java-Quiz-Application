package com.beaconfire.personalProject.daoImpl;



import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.beaconfire.personalProject.dao.AbstractHibernateDAO;
import com.beaconfire.personalProject.domain.User;

@Repository
public class UserDaoImpl extends AbstractHibernateDAO<User> {
	
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private RowMapper<User> mapRow= (ResultSet resultSet, int i) -> {
	        User user = new User();
	        user.setUser_id(resultSet.getInt("user_id"));
	        user.setFirstName(resultSet.getString("firstName"));
	        user.setLastName(resultSet.getString("lastName"));
	        user.setEmail(resultSet.getString("email"));
	        return user;
	    }; 

	    
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertRegstration(User user) {
		String sql="INSERT INTO User (username,password,firstName,lastName,role,email) \n"
				+ "	VALUES(?,?,?,?,?,?);";
		return jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getRole(),user.getEmail());
	}

	public User getUser(User user) {
		String sql="SELECT * FROM User WHERE username=:username AND password=:password";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("username",user.getUsername());
        parameterSource.addValue("password", user.getPassword());
        List<User> users= namedParameterJdbcTemplate.query(sql,parameterSource,mapRow);
        return users.size()==0? null: users.get(0);
	}
	
	public List<User> getAllusers(){
		List<User> users= getCurrentSession().createQuery("from User").list();
		for(User u: users) {
			System.out.println("Last Name:"+u.getLastName());	
		}
		
		return users;
 	}
	
	
	public void updateUser(User user) {
		getCurrentSession().update(user);
	}
	
}
