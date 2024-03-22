package com.insuranceapp.service;

import java.util.List;

import com.insuranceapp.model.Insurance;

public interface IInsuranceService {
  
	List<Insurance> getAll();
	
	Insurance getById(int insuranceId);
}
