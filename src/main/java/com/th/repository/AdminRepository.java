package com.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.th.model.Admin;
/**
 *  AdminRepository extends Jpa repository that allows to perform CRUD operations on admin table
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	


}
