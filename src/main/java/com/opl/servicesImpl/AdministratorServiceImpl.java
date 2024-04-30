package com.opl.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opl.entities.Administrator;
import com.opl.proxies.AdministratorDto;
import com.opl.repositories.AdministratorRepo;
import com.opl.services.AdministratorServices;
import com.opl.utils.Helper;

@Component
public class AdministratorServiceImpl implements AdministratorServices {

	@Autowired
	private Helper helper;
	
	@Autowired
	private AdministratorRepo administratorRepo;
	
	@Override
	public String registerAdmin(AdministratorDto administratorDto) {
		try {
			Administrator administrator = helper.convertDtoToAdministrator(administratorDto);
			Optional<Administrator> byId = administratorRepo.findById(administrator.getAdminid());
			if (byId.isPresent()) {
				return "Profile is already Created";
			}
			administratorRepo.save(administrator);
			return "Profile Created Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error in Profile Creation";
		}
	}

	@Override
	public AdministratorDto getAdmin(String name) {
		Optional<Administrator> byName = administratorRepo.findByName(name);
		if (byName.isPresent()) {
			Administrator administrator = byName.get();
			AdministratorDto administratorDto = helper.convertAdministratorToDto(administrator);
			return administratorDto;
		}
		return null;
	}

	@Override
	public String updateAdmin(AdministratorDto administratorDto, String id) {
		Optional<Administrator> byId = administratorRepo.findById(id);
		if (byId.isPresent()) {
			Administrator administrator = helper.convertDtoToAdministrator(administratorDto);
			administratorRepo.save(administrator);
			return "Admin updated successfully";
		}
		return "No admin found with this id : "+id;
	}

}
