package com.opl.services;

import org.springframework.stereotype.Service;

import com.opl.proxies.FeeDetailsDto;

@Service
public interface FeeDetailsServices {

	public String addFeeDetails(FeeDetailsDto feeDetailsDto);
	
	public FeeDetailsDto getFeeDetails(String enrolNo);
	
	public String updateFeeDetails(String enrolNo, FeeDetailsDto feeDetailsDto);
}
