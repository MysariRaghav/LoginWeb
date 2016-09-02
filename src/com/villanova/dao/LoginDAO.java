package com.villanova.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private JdbcTemplate jdbcOriginalSql;
	public LoginDAO(){
		System.out.println("Crfeated offersDAO");
	}
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		jdbcOriginalSql=(JdbcTemplate) this.jdbc.getJdbcOperations();
	}
	
	public boolean create(LoginDetails details)
	{
		BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(details);
		return jdbc.update("insert into logindetails (Email, Password) values (:email, :password)", params)==1;
	}

	
	public List<LoginDetails> getAll()
	{
		return jdbc.query("select * from logindetails", new RowMapper<LoginDetails>(){

			@Override
			public LoginDetails mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				LoginDetails details= new LoginDetails();
				details.setEmail(rs.getString("Email"));
				details.setPassword(rs.getString("Password"));
				return details;
			}
			
		});
	}
	
	public LoginDetails getPasswordByEmail(String email)
	{
		MapSqlParameterSource params=new MapSqlParameterSource("email", email);
		return jdbc.queryForObject("select * from logindetails where Email= :email", params, new RowMapper<LoginDetails>(){

			public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				LoginDetails details= new LoginDetails();
				details.setEmail(rs.getString("Email"));
				details.setPassword(rs.getString("Password"));
				return details;
			}
			
		});
		
	}

	public List<String> getAllEmails() {
		// TODO Auto-generated method stub
		
		return jdbc.query("select Email from logindetails", new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("Email");
				
			}
			
		});
		//return null;
	}

}
