package com.doctorapp.repository;

import java.sql.SQLException;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorRepository {
    
    void addDoctor(Doctor doctor);

    void updateDoctor(int doctorId,double fees);

    void deleteDoctors(int doctorId);

    Doctor findById(int doctorId);
    
    List<Doctor> findAll();

    List<Doctor> findBySpeciality(String speciality) throws SQLException;

    List<Doctor> findBySpecialityAndExp(String speciality,int experience);

    List<Doctor> findBySpecialityAndLessFees(String speciality,double fees);

    List<Doctor> findBySpecialityAndRatings(String speciality,int ratings);

    List<Doctor> findBySpecialityAndName(String speciality,String name);
}
