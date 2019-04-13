package com.Heroku.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Heroku.entity.Banks;

public interface BankRepo extends JpaRepository<Banks, Integer> {

	@Query("from Banks where name=:name")
	Banks findId(@Param("name")String bankName);

}
