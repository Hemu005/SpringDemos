package com.doctorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.Exception.DoctorNotFoundException;
import com.doctorapp.Exception.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.DoctorRepositoryImpl;
import com.doctorapp.repository.IDoctorRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
@Service
public class DoctorServiceImpl implements IDoctorService{
	@Autowired
    IDoctorRepository doctorRepository;
	@Override
	public void addDoctor(Doctor doctor) {
	  doctorRepository.addDoctor(doctor);
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
	   doctorRepository.updateDoctor(doctorId, fees);
	}

	@Override
	public void deleteDoctors(int doctorId) {
		doctorRepository.deleteDoctors(doctorId);
	}

	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException {
		if(doctorRepository.findById(doctorId)==null) {
			throw new IdNotFoundException("Doesn't have any doctor from this Id");
		}
		return doctorRepository.findById(doctorId);
	}

	@Override
	public List<Doctor> getAll() {
		List<Doctor> doctors=doctorRepository.findAll();
		return doctors;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException, SQLException {
		List<Doctor> doctors=doctorRepository.findBySpeciality(speciality);
		if(doctors.isEmpty()) {
			throw  new DoctorNotFoundException("Doesn't have any doctor from this speciality");
		}
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		List<Doctor> doctors=doctorRepository.findBySpecialityAndExp(speciality,experience);
		if(doctors.isEmpty()) {
			throw  new DoctorNotFoundException("Doesn't have any doctor from this speciality and experience");
		}
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
		List<Doctor> doctors=doctorRepository.findBySpecialityAndLessFees(speciality,fees);
		if(doctors.isEmpty()) {
			throw  new DoctorNotFoundException("Doesn't have any doctor from this speciality and fess");
		}
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
		List<Doctor> doctors=doctorRepository.findBySpecialityAndRatings(speciality,ratings);
		if(doctors.isEmpty()) {
			throw  new DoctorNotFoundException("Doesn't have any doctor from this speciality and ratings");
		}
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndName(String speciality, String name) throws DoctorNotFoundException {
		List<Doctor> doctors=doctorRepository.findBySpecialityAndName(speciality,name);
		if(doctors.isEmpty()) {
			throw  new DoctorNotFoundException("Doesn't have any doctor from this speciality and name");
		}
		return doctors;
	}

   
}
