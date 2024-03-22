package com.doctorapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
import com.doctorapp.repository.IDoctorRepository;
import com.doctorapp.service.IDoctorService;

@SpringBootApplication
public class SpringDoctorappJdbcApplication implements CommandLineRunner{
    @Autowired
    IDoctorService doctorService;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Add Doctor \n"+
		                   "2.Update Doctor \n"+
				           "3.Delete Doctor \n"+
		                   "4.To Get all doctors \n"+
				           "5.Get doctor by speciality \n"+
		                   "6.Get doctor by speciality and Exp \n"+
				           "7.Get doctor by speciality and Fess less than \n"+
		                   "8.Get doctor by speciality and ratings \n"+
				           "9.Get doctor by id");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter doctor name:");
			String name=sc.next();
			System.out.println("Enter speciality:");
			String speciality=sc.next();
			System.out.println("Enter fees:");
			double fees=sc.nextDouble();
			System.out.println("Enter ratings:");
			int rating=sc.nextInt();
			System.out.println("Enter experience:");
			int exp=sc.nextInt();
			doctorService.addDoctor(new Doctor(name,speciality,fees,rating,exp));
			break;
		case 2:
			System.out.println("Enter doctor id:");
			int id=sc.nextInt();
			System.out.println("Enter updated fees:");
			double fees1=sc.nextDouble();
			doctorService.updateDoctor(id, fees1);
			break;
		case 3:
			System.out.println("Enter doctor id:");
			int id1=sc.nextInt();
			doctorService.deleteDoctors(id1);
			break;
		case 4:
			System.out.println("List of Doctors:");
			List<Doctor> doctors=doctorService.getAll();
			for (Doctor doctor : doctors) {
				System.out.println(doctor);
			}
			break;
		case 5:
			System.out.println("Enter doctor speciality:");
			String speciality1=sc.next();
			List<Doctor> doctors1=doctorService.getBySpeciality(speciality1);
			for (Doctor doctor : doctors1) {
				System.out.println(doctor);
			}
			break;
		case 6:
			System.out.println("Enter doctor speciality:");
			String speciality2=sc.next();
			System.out.println("Enter experience");
			int exp1=sc.nextInt();
			List<Doctor> doctors2=doctorService.getBySpecialityAndExp(speciality2,exp1);
			for (Doctor doctor : doctors2) {
				System.out.println(doctor);
			}
			break;
		case 7:
			System.out.println("Enter doctor speciality:");
			String speciality3=sc.next();
			System.out.println("Enter Fees less than");
			int fees2=sc.nextInt();
			List<Doctor> doctors3=doctorService.getBySpecialityAndLessFees(speciality3,fees2);
			for (Doctor doctor : doctors3) {
				System.out.println(doctor);
			}
			break;
		case 8:
			System.out.println("Enter doctor speciality:");
			String speciality4=sc.next();
			System.out.println("Enter experience");
			int ratings=sc.nextInt();
			List<Doctor> doctors4=doctorService.getBySpecialityAndRatings(speciality4,ratings);
			for (Doctor doctor : doctors4) {
				System.out.println(doctor);
			}
			break;
		case 9:
			System.out.println("Enter doctor id");
			int id2=sc.nextInt();
			Doctor doctor=doctorService.getById(id2);
			System.out.println(doctor);
			break;
		}
		System.out.println("Thank you");
	}

}
