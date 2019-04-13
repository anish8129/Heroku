package com.Heroku.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Heroku.entity.Banks;
import com.Heroku.entity.Branches;

public interface BranchRepo extends JpaRepository<Branches,String> {

	@Query("from Branches where ifsc=:ifsc")
	Branches getBranchById(@Param("ifsc")String ifsc);

	@Query("from Branches where bank_id=:bank and city=:city")
	List<Branches> findBranchesByCity(@Param("bank")Banks bank, @Param("city")String city);

}
