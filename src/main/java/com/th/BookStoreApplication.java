package com.th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BookStoreApplication class helps to run the application
 * 
 * @author bharati_koliwad, rakshita_prakash, arifa_azam
 *
 */
@SpringBootApplication
public class BookStoreApplication {

	/**
	 * This main method is the starting point of the application
	 * 
	 * @param args Accepts command line input in the form of array
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}