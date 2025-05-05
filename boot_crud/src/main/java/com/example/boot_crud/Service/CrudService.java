package com.example.boot_crud.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.boot_crud.Entity.Student;
import com.example.boot_crud.Repository.StudentRepository;
@Service
public class CrudService {
	@Autowired
	StudentRepository repository;
	
	public String add(Student student,Model model)
	{
		repository.save(student);
		model.addAttribute("message","Record Added Success");
		return "home.html";
	}

	public String fetch(Model model,String search) {
		List<Student> students=null;
		students = repository.findByNameLike("%"+ search +"%");
		if(students.isEmpty())
		{
			model.addAttribute("message","No records found"); 
			return "home.html";
		}
		else
		{
			model.addAttribute("students",students); 
			return "fetch.html";
		}
	}


}
