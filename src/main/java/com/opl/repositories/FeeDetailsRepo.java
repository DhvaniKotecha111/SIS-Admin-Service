package com.opl.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opl.entities.FeeDetails;

@Repository
public interface FeeDetailsRepo extends CrudRepository<FeeDetails, Long> {

	Optional<FeeDetails> findByStudentEnrollmentNo(String enrolNo);
}
