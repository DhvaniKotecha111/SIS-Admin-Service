package com.opl.proxies;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeDetailsDto {

	private Long id;
	private String studentEnrollmentNo;
	private Double feeAmount;
	private LocalDate dueDate;
	private String updatedBy;
	private LocalDate updatedDate;
}
