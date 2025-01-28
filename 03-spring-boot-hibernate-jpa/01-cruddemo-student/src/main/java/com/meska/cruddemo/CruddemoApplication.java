package com.meska.cruddemo;

import com.meska.cruddemo.dao.StudentDAO;
import com.meska.cruddemo.dao.StudentDAOImp;
import com.meska.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDao){
		return runner -> { // java lambda expression
//			System.out.println("Hello I run after all beans are loaded!"); // will other custom code!
//			createStudent(studentDao);
			createMultipleStudents(studentDao);
//			readStudent(studentDao);
//			queryStudents(studentDao);
//			findByName(studentDao);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
//			deleteAll(studentDao);
		};


	}

	private void createMultipleStudents(StudentDAO studentDao) {
		Student student1 = new Student("Yousf", "Meska", "yousefmeska123@gmail.com");
		studentDao.save(student1);
		System.out.println("Saved student, Generated It "+  student1.getId());

		Student student2 = new Student("Omar", "Meska", "omarmeska123@gmail.com");
		studentDao.save(student2);
		System.out.println("Saved student, Generated It "+  student2.getId());

		Student student3 = new Student("Ali", "Meska", "alimeska123@gmail.com");
		studentDao.save(student3);
		System.out.println("Saved student, Generated It "+  student3.getId());
	}

	public void createStudent(StudentDAO studentDao){
		System.out.println("creating new student...");

		Student student = new Student("Yousf", "Meska", "yousefmeska123@gmail.com");

		studentDao.save(student);

		System.out.println("Saved student, Generated It "+  student.getId());
	}



	public void readStudent(StudentDAO studentDao){
		// create the studen object
		Student newStudent = new Student("Ali", "Meska", "Alimeska123@gmail.com");

		// save it to the database
		studentDao.save(newStudent);

		// retrieve the student
		Student retrievedStudent = studentDao.findById(newStudent.getId());

		System.out.println("Found" + retrievedStudent.toString()	);
	}

	public void queryStudents(StudentDAO studentDao){
		List<Student> students = studentDao.findAll();

		for(Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}

	public void findByName(StudentDAO studentDao){
		List<Student> students = studentDao.findByLastName("meska");

		for(Student tempStudent: students){
			System.out.println(tempStudent.toString());
		}
	}

	private void updateStudent(StudentDAO studentDao){
		// retrieve student of id = 1;
		Student myStudent = studentDao.findById(1);

		//set first name = 'Mahmoud';
		myStudent.setFirstName("Mahmoud"); // now we've an instance that's Student object with new name, need to be updated

		//persiste the update
		studentDao.update(myStudent);

		//retrieve the updated one
		System.out.println("updated student" + myStudent.getFirstName());
	}

	private void deleteStudent(StudentDAO studentDao){
		int studentId = 1;
		System.out.println("Deleting student of id = " + studentId);
		studentDao.deleteById(studentId);
	}


	private int deleteAll(StudentDAO studentDao){
		System.out.println("Deleting all students");
		int rowsAffected = studentDao.deleteAll();
		System.out.println("Rows affected" + rowsAffected);
		return rowsAffected;
	}

}
