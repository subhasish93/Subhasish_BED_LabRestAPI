package com.greatlearning.studentmgmtsys.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.studentmgmtsys.model.Role;
import com.greatlearning.studentmgmtsys.model.Student;
import com.greatlearning.studentmgmtsys.model.User;
import com.greatlearning.studentmgmtsys.repository.StudentRepository;
import com.greatlearning.studentmgmtsys.repository.UserRepository;

@Configuration
public class BootStrapDataApp {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUser(ApplicationReadyEvent event) {
		
		Role user = new Role("ROLE_USER");
		Role admin = new Role("ROLE_ADMIN");
		
		User student = new User("user",this.passwordEncoder.encode("r@j1234"));
		User teacher = new User("admin",this.passwordEncoder.encode("r@j1234"));
		
		student.addrole(user);
		teacher.addrole(admin);
		
		this.userRepo.save(student);
		this.userRepo.save(teacher);
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadStudents(ApplicationReadyEvent event) {
		
		Student s1 = new Student("Raj","Roy","B.Ttech","India");
		Student s2 = new Student("Joseph", "Patrick","M.Sc","Belgium");
		Student s3 = new Student("Priya","Agarwal","MBA","Russia");
		Student s4 = new Student("Michael","Edwards","B.Tech","Australia");
		Student s5 = new Student("Servan","Kumar","M.Sc","Ireland");
		Student s6 = new Student("Mansi","Rathore","MBA","USA");
		Student s7 = new Student("Rajveer","Singh","M.Tech","Germany");
		
		this.repository.save(s1);
		this.repository.save(s2);
		this.repository.save(s3);
		this.repository.save(s4);
		this.repository.save(s5);
		this.repository.save(s6);
		this.repository.save(s7);
		
	}

}