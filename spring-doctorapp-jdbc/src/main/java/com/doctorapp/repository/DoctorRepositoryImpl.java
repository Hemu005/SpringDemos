package com.doctorapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DoctorDb;
import com.doctorapp.util.Queries;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {
	
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  
	public DoctorRepositoryImpl(JdbcTemplate jdbcTemplate) {
	super();
	this.jdbcTemplate = jdbcTemplate;
}

	@Override
	public void addDoctor(Doctor doctor) {
		Object[] doctorArr= {doctor.getDoctorName(),doctor.getSpeciality(),doctor.getFees(),
					doctor.getRating(),doctor.getExperience()};
		jdbcTemplate.update(Queries.InsertQuery, doctorArr);
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		jdbcTemplate.update(Queries.UpdateQuery, doctorId,fees);
	}

	@Override
	public void deleteDoctors(int doctorId) {
	    jdbcTemplate.update(Queries.DeleteQuery, doctorId);
	}

	@Override
	public Doctor findById(int doctorId) {
		Doctor doctor=jdbcTemplate.queryForObject(Queries.findByIdQuery, new DoctorMapper(),doctorId);
		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
		RowMapper<Doctor> mapper=new DoctorMapper();
		List<Doctor> doctors=jdbcTemplate.query(Queries.findAllQuery, mapper);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) throws SQLException {
		RowMapper<Doctor> mapper=new DoctorMapper();
		List<Doctor> doctors=jdbcTemplate.query(Queries.findBySpeciality, mapper,speciality);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
		RowMapper<Doctor> mapper=new DoctorMapper();
		List<Doctor> doctors=jdbcTemplate.query(Queries.findBySpecialityAndExp, mapper,speciality,experience);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) {
		RowMapper<Doctor> mapper=new DoctorMapper();
		List<Doctor> doctors=jdbcTemplate.query(Queries.findBySpecialityAndLessFees, mapper,speciality,fees);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
		RowMapper<Doctor> mapper=new DoctorMapper();
		List<Doctor> doctors=jdbcTemplate.query(Queries.findBySpecialityAndRatings, mapper,speciality,ratings);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndName(String speciality, String name) {
		RowMapper<Doctor> mapper=new DoctorMapper();
		List<Doctor> doctors=jdbcTemplate.query(Queries.findBySpecialityAndName, mapper,speciality,name);
		return doctors;
	}
   
    }
