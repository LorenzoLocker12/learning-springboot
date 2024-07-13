package com.lorenzo.cruddemo;

import com.lorenzo.cruddemo.dao.StudentDAO;
import com.lorenzo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

		//	createMultipleStudents(studentDAO);

		//	createStudent(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		Student student = new Student("Daphy", "Dew", "DephyDew@gmail.com");
		// save the student
		studentDAO.save(student);
		// display id off the students
		int id = student.getId();
		System.out.println("The id of the student is: " + id);
		// retrieve student based on the id: primary key
		Student query = studentDAO.findById(id);
		// display student
		System.out.println(query);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students...");
		Student student1 = new Student("Kin", "Koe", "KinKoe@gmail.com");
		Student student2 = new Student("Mary", "Min", "MaryMin@gmail.com");
		Student student3 = new Student("Hui", "Pou", "HuiPou@gmail.com");


		System.out.println("Saving students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	public void createStudent(StudentDAO studentDAO){
		// create the student
		System.out.println("Creating student...");
		Student student = new Student("Paul", "Locker", "Idk@gmail.com");

		// save the student object
		System.out.println("Saving student...");
		studentDAO.save(student);

		// display the saved student
		System.out.println("Saved Student. Generated id: " + student.getId());
	}
}
