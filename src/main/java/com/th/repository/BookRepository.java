package com.th.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.th.model.Book;

/**
 * BookRepository extends Jpa repository that allows to perform CRUD operations
 * on book table
 * 
 * @author bharati_koliwad, arifa_azam
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	/**
	 * search a book by bookname
	 * 
	 * @param bookname
	 * @return Optional<Book>
	 */
	@Query(value = "select * from Book b where b.bookname like %:bookname%", nativeQuery = true)
	public abstract Optional<Book> FindByBookName(String bookname);
}
