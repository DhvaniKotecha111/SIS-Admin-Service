package com.opl.proxies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorDto {

	private String adminid;
	private String name;
	private String gender;
	private String contact;
	private String address;
	private String city;
	private Integer pinCode;
}
