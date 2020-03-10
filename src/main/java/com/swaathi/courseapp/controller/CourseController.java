package com.swaathi.courseapp.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.swaathi.courseapp.dao.StudentDAO;
import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.dao.PaymentDAO;
import com.swaathi.courseapp.domain.BatchClass;
import com.swaathi.courseapp.domain.CourseClass;
import com.swaathi.courseapp.domain.PaymentClass;
import com.swaathi.courseapp.domain.StudentClass;
import com.swaathi.courseapp.dto.MessageDTO;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.service.UserService;

@RestController
@RequestMapping("api")

public class CourseController {
	@Autowired
	StudentDAO dao;
	@Autowired
	CourseDAO dao1;
	@Autowired
	BatchDAO dao2;
	@Autowired
	StudentDAO dao3;
	@Autowired
	PaymentDAO dao4;
	@GetMapping("/Register")
	public MessageDTO Register(@RequestParam("name") String name,@RequestParam("fname")String fatherName,@RequestParam("mail")String emailId,@RequestParam("doj")String doj,@RequestParam("user")String userName,@RequestParam("pass")String password,@RequestParam("phNo")String phNo) throws DBException {
StudentClass s1 = new StudentClass();
		MessageDTO msg = new MessageDTO();
		
		s1.setFullName(name);
		s1.setFatherNameOrGuardianName(fatherName);
		s1.setEmailId(emailId);
		s1.setDateOfJoining(LocalDate.parse(doj));
		s1.setUserName(userName);
		s1.setPassWord(password);
		s1.setPhoneNo(phNo);
		int a = dao.save(s1);
		if(a==1) {
			msg.setInfoMessage("Registered Successfully!!!");
		}
		else {
			msg.setErrroMessage("Registration Failed!!!");
		}
		return msg;
		
	}
	@GetMapping("/viewCourse")
	public List<CourseClass> viewCourse() throws DBException
	{
List<CourseClass>  s = dao1.findAll();
		return s;	
	}
	
@GetMapping("/Login")
	public MessageDTO Login(@RequestParam("username")String name,@RequestParam("password")String pass) {
		MessageDTO msg = new MessageDTO();
		boolean status = false;
		StudentClass user = new StudentClass();
		user.setUserName(name);
		user.setPassWord(pass);
		
		try {
			status = UserService.login(user);
			System.out.println(status);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(status) {
			msg.setInfoMessage("Login Successful");
		}
		else {
			msg.setErrroMessage("Login not successful Try Again!!!");
		}
		return msg;
	}
@GetMapping("/viewBatch")
public List<BatchClass> viewBatch() throws DBException
{
List <BatchClass>  a = dao2.findAll();
return a;
		
}

@GetMapping("/viewStudents")
public List<StudentClass> viewStudents() throws DBException
{
List <StudentClass>  a = dao3.findAll();
return a;
		
}	
@GetMapping("/viewEnrolledStudents")
public List<PaymentClass> viewEnrolledStudents() throws DBException
{
List <PaymentClass>  a = dao4.findAll();
return a;
		
}	
	
}

