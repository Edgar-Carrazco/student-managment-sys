package com.example.sms;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentManagmentSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagmentSystemApplication.class, args);
	}

	@Autowired // Inject Student Repository
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student student1  = new Student("Leon" , "David" , "LeonDavid@Email.com");
		studentRepository.save(student1);

		Student student2 = new Student ("Alain" , "Picard" , "Alain@generation.com");
		studentRepository.save(student2);

		Student student3 = new Student ("Tony" , "Ross" , "TRoss@generation.com");
		studentRepository.save(student3);
	}
}
