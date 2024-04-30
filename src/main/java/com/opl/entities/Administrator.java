package com.opl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {

	@Id
	private String adminid;
	
	private String name;
	private String gender;
	private String contact;
	private String address;
	private String city;
	private Integer pinCode;
}
