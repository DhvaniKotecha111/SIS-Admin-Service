package com.opl.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opl.entities.Administrator;

@Repository
public interface AdministratorRepo extends CrudRepository<Administrator, String> {

	Optional<Administrator> findByName(String name);
}
