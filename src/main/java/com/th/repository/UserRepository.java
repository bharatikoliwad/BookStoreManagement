package com.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.th.model.User;

/**
 * UserRepository exdends the JpaRepository that allows you to perform the CRUD
 * operations on user table
 * 
 * @author bharati_koliwad,rakshita_prakash
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
