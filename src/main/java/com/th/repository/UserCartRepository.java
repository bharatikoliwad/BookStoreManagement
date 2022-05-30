package com.th.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.th.model.UsersCart;

/**
 * UserCartRepository extends Jpa repository that allows to perform CRUD operations on user cart table
 *
 *  @author  bharati_koliwad,rakshita_prakash
 */
@Repository
public interface UserCartRepository extends JpaRepository<UsersCart,Integer> {
	
	/**
	 * finds all books ordered by a particular user
	 * @param useremail 
	 * @return List<UserCart> (list of books ordered by a user)
	 */
	List<UsersCart> findByUseremail(String useremail);
	
	/**
	 * finds a book using useremail and bookid 
	 * @param useremail
	 * @param bookid
	 * @return UserCart 
	 */
	UsersCart findByUseremailAndBookid(String useremail, int bookid);
	

}
