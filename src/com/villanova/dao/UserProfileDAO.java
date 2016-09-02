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

import com.villanova.server.Server;

@Component
public class UserProfileDAO {
	
	@Autowired
	private Server server;
	private NamedParameterJdbcTemplate jdbc;
	private JdbcTemplate jdbcOriginalSql;
	public UserProfileDAO(){
		System.out.println("Crfeated userProfileDAO");
	}
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		jdbcOriginalSql=(JdbcTemplate) this.jdbc.getJdbcOperations();
	}
	
	public boolean create(UserProfile details)
	{
		BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(details);
		System.out.println(details);
		if(server.getAllEmails().contains(details.getEmail()))
			return jdbc.update("insert into generaluserprofile (FirstName, LastName, PhoneNumber, Email, "
				+ "Country, HighestMajor, AreaOfInterest, CurrentUniversity, GPA, NumberOfBacklogs, "
				+ "WorkExperience, ResearchWork, OtherCertifications)"
				+ " values "
				+ "(:firstName, :lastName, :phone, :email, :country, :highestMajor, :areaOfInterest, :currentUniversity,"
				+ " :gpa, :numberOfBacklogs, :workExperience, :researchWork, :otherCertifications)", params)==1;
		
		return false;
	}

	public boolean update(UserProfile details)
	{
		BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(details);
		System.out.println(details);
		if(server.getAllEmails().contains(details.getEmail()))
			return jdbc.update("update generaluserprofile SET FirstName = :firstName, LastName = :lastName, PhoneNumber = :phone, "
				+ "Country = :country, HighestMajor = :highestMajor, AreaOfInterest = :areaOfInterest, CurrentUniversity = :currentUniversity, GPA = :gpa, NumberOfBacklogs = :numberOfBacklogs, "
				+ "WorkExperience = :workExperience, ResearchWork = :researchWork, OtherCertifications = :otherCertifications "
				+ "where Email= :email"
				, params)==1;
		
		return false;
	}
	
	public List<UserProfile> getAll()
	{
		return jdbc.query("select * from generaluserprofile", new RowMapper<UserProfile>(){

			@Override
			public UserProfile mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				UserProfile details= new UserProfile();
				details.setFirstName(rs.getString("FirstName"));
				details.setLastName(rs.getString("LastName"));
				details.setPhone(rs.getString("PhoneNumber"));
				details.setEmail(rs.getString("Email"));
				details.setCountry(rs.getString("Country"));
				details.setHighestMajor(rs.getString("HighestMajor"));
				details.setAreaOfInterest(rs.getString("AreaOfInterest"));
				details.setCurrentUniversity(rs.getString("CurrentUniversity"));
				details.setGpa(rs.getFloat("GPA"));
				details.setNumberOfBacklogs(rs.getInt("NumberOfBacklogs"));
				details.setWorkExperience(rs.getFloat("WorkExperience"));
				details.setResearchWork(rs.getString("ResearchWork"));
				details.setOtherCertifications(rs.getString("OtherCertifications"));
				return details;
			}			
		});
	}
	
	public UserProfile getUserProfileByEmail(String email)
	{
		MapSqlParameterSource params=new MapSqlParameterSource("email", email);
		return jdbc.queryForObject("select * from generaluserprofile where Email= :email", params, new RowMapper<UserProfile>(){

			@Override
			public UserProfile mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				UserProfile details= new UserProfile();
				details.setFirstName(rs.getString("FirstName"));
				details.setLastName(rs.getString("LastName"));
				details.setPhone(rs.getString("PhoneNumber"));
				details.setEmail(rs.getString("Email"));
				details.setCountry(rs.getString("Country"));
				details.setHighestMajor(rs.getString("HighestMajor"));
				details.setAreaOfInterest(rs.getString("AreaOfInterest"));
				details.setCurrentUniversity(rs.getString("CurrentUniversity"));
				details.setGpa(rs.getFloat("GPA"));
				details.setNumberOfBacklogs(rs.getInt("NumberOfBacklogs"));
				details.setWorkExperience(rs.getFloat("WorkExperience"));
				details.setResearchWork(rs.getString("ResearchWork"));
				details.setOtherCertifications(rs.getString("OtherCertifications"));
				return details;
			}			
		});
	}
	

}
