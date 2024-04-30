package com.opl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opl.entities.Administrator;
import com.opl.entities.FeeDetails;
import com.opl.proxies.AdministratorDto;
import com.opl.proxies.FeeDetailsDto;

@Component
public class Helper {

	@Autowired
	private ObjectMapper mapper;
	
	public Administrator convertDtoToAdministrator(AdministratorDto administratorDto)
	{
		return mapper.convertValue(administratorDto, Administrator.class);
	}
	
	public FeeDetails convertDtoToFeeDetails(FeeDetailsDto feeDetailsDto)
	{
		return mapper.convertValue(feeDetailsDto, FeeDetails.class);
	}
	
	public AdministratorDto convertAdministratorToDto(Administrator administrator)
	{
		return mapper.convertValue(administrator, AdministratorDto.class);
	}
	
	public FeeDetailsDto convertFeeDetailsToDto(FeeDetails feeDetails)
	{
		return mapper.convertValue(feeDetails, FeeDetailsDto.class);
	}
}
