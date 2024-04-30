package com.opl.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opl.entities.FeeDetails;
import com.opl.proxies.FeeDetailsDto;
import com.opl.repositories.FeeDetailsRepo;
import com.opl.services.FeeDetailsServices;
import com.opl.utils.Helper;

@Component
public class FeeDetailsServiceImpl implements FeeDetailsServices {

	@Autowired
	private Helper helper;
	
	@Autowired
	private FeeDetailsRepo feeDetailsRepo;
	
	@Override
	public String addFeeDetails(FeeDetailsDto feeDetailsDto) {
		FeeDetails feeDetails = helper.convertDtoToFeeDetails(feeDetailsDto);
		feeDetailsRepo.save(feeDetails);
		return "Fee Details added successfully";
	}

	@Override
	public FeeDetailsDto getFeeDetails(String enrolNo) {
		Optional<FeeDetails> byStudentEnrollmentNo = feeDetailsRepo.findByStudentEnrollmentNo(enrolNo);
		if (byStudentEnrollmentNo.isPresent()) {
			FeeDetails feeDetails = byStudentEnrollmentNo.get();
			FeeDetailsDto feeDetailsDto = helper.convertFeeDetailsToDto(feeDetails);
			return feeDetailsDto;
		}
		return null;
	}

	@Override
	public String updateFeeDetails(String enrolNo, FeeDetailsDto feeDetailsDto) {
		Optional<FeeDetails> byStudentEnrollmentNo = feeDetailsRepo.findByStudentEnrollmentNo(enrolNo);
		if (byStudentEnrollmentNo.isPresent()) {
			FeeDetails feeDetails = helper.convertDtoToFeeDetails(feeDetailsDto);
			feeDetailsRepo.save(feeDetails);
			return "Fee Details Updated Successfully";
		}
		return "No Fee Details Found for this Student";
	}

}
