package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
import com.insuranceapp.repository.IInusuranceRepository;
@Service
public class InsuranceServiceImpl implements IInsuranceService{
@Autowired
IInusuranceRepository inusuranceRepository;
	@Override
	public void addInsurance(Insurance insurance) {
      	inusuranceRepository.addInsurance(insurance);	
	}

	@Override
	public void updateInsurance(int insuranceId, double premium) {
       inusuranceRepository.updateInsurance(insuranceId, premium);		
	}

	@Override
	public void deleteInsurance(int insuranceId) {
       inusuranceRepository.deleteInsurance(insuranceId);		
	}

	@Override
	public List<Insurance> getAll() {
		List<Insurance> insurances=inusuranceRepository.findAll();
		return insurances;
	}

	@Override
	public List<Insurance> getByBrand(String brand) throws InsuranceNotFoundException {
		List<Insurance> insurances=inusuranceRepository.findByBrand(brand);
		if(insurances.isEmpty())
			throw new InsuranceNotFoundException("Insurance not found");
		return insurances;
	}

	@Override
	public List<Insurance> getByBrandAndPType(String brand, String type) throws InsuranceNotFoundException {
        List<Insurance> insurances=inusuranceRepository.findByBrandAndPType(brand, type);
        if(insurances.isEmpty())
			throw new InsuranceNotFoundException("Insurance not found");
		return insurances;
	}

	@Override
	public List<Insurance> getByTypeAndLesserPremium(String type, double premium) throws InsuranceNotFoundException {
		List<Insurance> insurances=inusuranceRepository.findByTypeAndLesserPremium(type, premium);
		if(insurances.isEmpty())
			throw new InsuranceNotFoundException("Insurance not found");
		return insurances;
	}

	@Override
	public Insurance getById(int insuranceId) throws InsuranceNotFoundException {
	  Insurance insurance= inusuranceRepository.findById(insuranceId);
		return insurance;
	}


  
}
