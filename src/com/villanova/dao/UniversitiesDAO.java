package com.villanova.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class UniversitiesDAO {

	private NamedParameterJdbcTemplate jdbc;
	private JdbcTemplate jdbcOriginalSql;
	
	public UniversitiesDAO() {
		System.out.println("Crfeated universitiesDAO");
	}
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		jdbcOriginalSql=(JdbcTemplate) this.jdbc.getJdbcOperations();
	}
	
	public List<Universities> queryUniversitiesOnUserProfile(float gpa, float workExperience, boolean researchWork, boolean otherCertifications){
		
		
		MapSqlParameterSource params=new MapSqlParameterSource("gpa", gpa);
		params.addValue("workExperience", workExperience);
		params.addValue("researchWork", researchWork);
		params.addValue("otherCertifications", otherCertifications);
		//return jdbc.query("select Code, Department, Degree from universities where GPA >= :gpa and WorkExperence >= :workExperience and BIN(ResearchWork+0) >= :researchWork and BIN(OtherCertification+0) >= :otherCertifications", params, new RowMapper<Universities>(){

		return jdbc.query("select * from universities where GPA <= :gpa and WorkExperence <= :workExperience and ResearchWork <= :researchWork and OtherCertification <= :otherCertifications", params, new RowMapper<Universities>(){

			@Override
			public Universities mapRow(ResultSet rs, int rownum)
					throws SQLException {
				// TODO Auto-generated method stub
				
				Universities univ = new Universities();
				
				univ.setCode(rs.getString("Code"));
				univ.setDepartment(rs.getString("Department"));
				univ.setDegree(rs.getString("Degree"));
				univ.setGpa(rs.getFloat("GPA"));
				univ.setWorkExperience(rs.getFloat("WorkExperence"));
				univ.setResearchWork(rs.getBoolean("ResearchWork"));
				univ.setOtherCertifications(rs.getBoolean("OtherCertification"));
				return univ;
			}			
			});
		
		//return null;
		
	}
	
}
