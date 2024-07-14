package com.lorenzo.cruddemo;

import com.lorenzo.cruddemo.dao.StudentDAO;
import com.lorenzo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

			createMultipleStudents(studentDAO);

		//	createStudent(studentDAO);

		//	readStudent(studentDAO);

		//	queryForStudents(studentDAO);
			
		//	queryForStudentsByLastName(studentDAO, "Dew");

		//	updateStudentFirstNameById(studentDAO, 55, "Britney");

		//	deleteStudentById(studentDAO, 2);

		//	deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rows = studentDAO.deleteAll();
		System.out.println("Deleted " + rows + " students");
	}

	private void deleteStudentById(StudentDAO studentDAO, int id) {
		System.out.println("Searching for student with id: " + id);
		Student student = studentDAO.findById(id);
		if (student != null) {
			System.out.println("Found student");
			System.out.println("deleting student with id: " + id);
			studentDAO.delete(id);
		}else {
			System.out.println("Student with id: " + id + " not found");
		}
	}

	private void updateStudentFirstNameById(StudentDAO studentDAO, int id, String newName) {
		System.out.println("Searching for student with id: " + id);
		Student student = studentDAO.findById(id);
		if (student != null) {
			student.setFirstName(newName);
			System.out.println("Found student");

			System.out.println("Updating first name...");
			String lastName = student.getLastName();
			String firstName = student.getFirstName();

			student.setEmail(String.format("%s%s@gmail.com",firstName, lastName));
			studentDAO.update(student);
			System.out.println("Updated student: " + student);
		} else {
			System.out.println("Student with id: " + id + " not found");
		}

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO, String lastName) {
		// get a list of students
		List<Student> students = studentDAO.findByLastName(lastName);

		// display a list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display the list of students
		for(Student student : students){
			System.out.println(student);
		}
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
