package com.opl.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.opl.proxies.AdministratorDto;
import com.opl.proxies.FeeDetailsDto;
import com.opl.services.AdministratorServices;
import com.opl.services.FeeDetailsServices;

@RestController
@CrossOrigin("*")
public class AdministrativeController {

	@Autowired
	private AdministratorServices administratorServices;
	
	@Autowired
	private FeeDetailsServices feeDetailsServices;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//admin related apis
	@PostMapping("/register")
	public String registerWithDetails(@RequestBody AdministratorDto administratorDto)
	{ 
		return administratorServices.registerAdmin(administratorDto);
	}
	
	@PostMapping("/updateAdmin/{id}")
	public String updateAdminDetails(@RequestBody AdministratorDto administratorDto, @PathVariable String id)
	{
		return administratorServices.updateAdmin(administratorDto, id);
	}
	
	@GetMapping("/getAdmin/{name}")
	public AdministratorDto getAdmin(@PathVariable String name)
	{
		return administratorServices.getAdmin(name);
	}
	
	//user related apis
	@PostMapping("/updateUser/{enrolNo}")
	public ResponseEntity<String> updateUserDetails(@RequestBody Object obj, @PathVariable String enrolNo)
	{
		String url = "http://SIS-SERVICE-STUDENT/user/updateUser/{enrolNo}";
	    
	    // Build the URL with the provided id
	    String expandedUrl = UriComponentsBuilder.fromUriString(url)
	                            .buildAndExpand(enrolNo)
	                            .toUriString();
	    
	    // Send the HTTP POST request with the URL and request body
	    String string = restTemplate.postForObject(expandedUrl, obj, String.class);
	    return new ResponseEntity<>(string, HttpStatus.OK);
	}
	
	@GetMapping("/deleteUser/{enrolNo}")
	public ResponseEntity<String> deleteUser(@PathVariable String enrolNo)
	{
		String url = "http://SIS-SERVICE-STUDENT/user/deleteUser/{enrolNo}";
        String string = restTemplate.getForObject(url, String.class, enrolNo);
        return new ResponseEntity<>(string, HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{enrolNo}")
	public ResponseEntity<Object> getUser(@PathVariable String enrolNo)
	{
		String url = "http://SIS-SERVICE-STUDENT/user/getUser/{enrolNo}";
        Object object = restTemplate.getForObject(url, Object.class, enrolNo);
        return new ResponseEntity<>(object, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Object>> getAllUsers()
	{
		String url = "http://SIS-SERVICE-STUDENT/user/getAllUsers";
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		List<Object> userList = null;
		if (objects != null) {
			userList = Arrays.asList(objects);
		}
        return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	//feeDetails related apis
	@PostMapping("/addFeeDetails")
	public String addFeeDetails(@RequestBody FeeDetailsDto feeDetailsDto)
	{
		return feeDetailsServices.addFeeDetails(feeDetailsDto);
	}

	@GetMapping("/getFeeDetails/{enrolNo}")
	public FeeDetailsDto getFeeDetails(@PathVariable String enrolNo)
	{
		return feeDetailsServices.getFeeDetails(enrolNo);
	}
	
	@PostMapping("/updateFeeDetails/{enrolNo}")
	public String updateFeeDetails(@PathVariable String enrolNo, @RequestBody FeeDetailsDto feeDetailsDto) 
	{
		return feeDetailsServices.updateFeeDetails(enrolNo, feeDetailsDto);
	}
	
	//educationDetails related apis
	@GetMapping("/getEducationDetails/{enrolNo}")
	public ResponseEntity<Object> getEducationDetails(@PathVariable String enrolNo)
	{
		String url = "http://SIS-SERVICE-STUDENT/usert/getEducationDetails/{enrolNo}";
		Object object = restTemplate.getForObject(url, Object.class, enrolNo);
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}
}
