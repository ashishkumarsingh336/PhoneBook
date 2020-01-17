package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.ContactDetailEntity;

/**
 * Spring Data is providing jpaRepository
 * and jpaRepository providing cgLib library 
 * which gives proxy class object
 * 
 * @author Ashish
 * @version 1.0
 * @since 22.12.2019
 * jpaRepository provide multiple pre-defined method to perform CURD operation
 */
@Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetailEntity, Integer> {
    @Transactional
    @Modifying
	@Query("update ContactDetailEntity set activeSw=:activeSw WHERE contactId=:cid")
	public void update(String activeSw,Integer cid);	
}
