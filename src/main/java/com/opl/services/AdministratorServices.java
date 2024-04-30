package com.opl.services;

import org.springframework.stereotype.Service;

import com.opl.proxies.AdministratorDto;

@Service
public interface AdministratorServices {

	public String registerAdmin(AdministratorDto administratorDto);
	
	public AdministratorDto getAdmin(String name);
	
	public String updateAdmin(AdministratorDto administratorDto, String id);
}
