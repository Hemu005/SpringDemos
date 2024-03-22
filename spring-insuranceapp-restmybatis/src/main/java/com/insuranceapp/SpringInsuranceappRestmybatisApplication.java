package com.insuranceapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.insuranceapp.service.IInsuranceService;

@SpringBootApplication
public class SpringInsuranceappRestmybatisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringInsuranceappRestmybatisApplication.class, args);
	}
    @Autowired
    IInsuranceService service;
	@Override
	public void run(String... args) throws Exception {
//       Scanner sc=new Scanner(System.in);
//       System.out.println("Add Insurance details:");
//       System.out.println("Enter insurance id:");
//       int id=sc.nextInt();
//       System.out.println("Enter insurance name:");
//       String name=sc.next();
//       System.out.println("Enter insurance brand:");
//       String brand=sc.next();
//       System.out.println("Enter insurance type:");
//       String type=sc.next();
//       System.out.println("Enter insurance duration");
//       int due=sc.nextInt();
//       System.out.println("Enter insurance premium");
//       double pre=sc.nextDouble();
	}

}
