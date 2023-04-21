package com.sudeepta.hibernatedemo;

import com.sudeepta.hibernatedemo.DAO.StudentDAO;
import com.sudeepta.hibernatedemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO)
			//readStudent(studentDAO);
			//findAll(studentDAO);
			//update(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void findAll(StudentDAO studentDAO) {
		List<Student> students= studentDAO.findAll();
		System.out.println(students.size());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		studentDAO.delete(3);
		System.out.println("Deleted student id 3");
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("sharmila", "nag", "sharmila@gmail.com");
		studentDAO.save(tempStudent1);
		int theId = tempStudent1.getId();
		Student student = studentDAO.findById(theId);
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		//create multiple students

		Student tempStudent1 = new Student("priya", "nag", "priya@gmail.com");
		Student tempStudent2 = new Student("emily", "sen", "emily@gmail.com");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

		//save the student objects
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("sudeepta", "das", "sudeepta@gmail.com");
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: "+tempStudent.getId());
		//save student obj
		//display id of saved student
	}

	private void update(StudentDAO studentDAO) {
		// create student object
		System.out.println("Updating student object");
		// retrieve student

		int studentId = 1;
		Student mystudent = studentDAO.findById(studentId);
		mystudent.setFirstname("Scooby Dooby");
		studentDAO.update(mystudent);


		System.out.println("Saved student. Generated id: "+mystudent.getFirstname());
		//save student obj
		//display id of saved student
	}
}
