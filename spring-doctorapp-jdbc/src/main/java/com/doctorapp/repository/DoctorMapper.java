package com.doctorapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doctorapp.model.Doctor;

public class DoctorMapper implements RowMapper<Doctor>{

	@Override
	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(rs.getInt("doctorId"));
		doctor.setDoctorName(rs.getString("doctorName"));
		doctor.setSpeciality(rs.getString("speciality"));
		doctor.setExperience(rs.getInt("experience"));
		doctor.setRating(rs.getInt("ratings"));
		doctor.setFees(rs.getDouble("fees"));
		return doctor;
	}

}
