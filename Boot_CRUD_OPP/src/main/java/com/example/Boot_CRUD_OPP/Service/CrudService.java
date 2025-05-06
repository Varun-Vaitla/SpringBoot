package com.example.Boot_CRUD_OPP.Service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.Boot_CRUD_OPP.Entity.Student;
import com.example.Boot_CRUD_OPP.Repository.StudentRepository;
@Service
public class CrudService {
	@Autowired
	StudentRepository repository;

	public String add(Student student, Model model) {
		
		repository.save(student);
		model.addAttribute("message","inserted success");
		return "home.html";
	}

	public String fetch(Model model) {
		List<Student> students=repository.findAll();
		if(students.isEmpty())
		{
			model.addAttribute("message","no records found");
			return "home.html";
		}
		else
		{
			model.addAttribute("students",students);
			return "fetch.html";
		}
	
	}
	
	

	public String delete(int id, Model model) {
		repository.deleteById(id);
		model.addAttribute("message","record deleted success");
		return "home.html";
	}

	public String fetchName(Model model, String search) {
		List<Student> students=repository.findByNameLike("%"+search+"%");
		if(students.isEmpty())
		{
			model.addAttribute("message","no records found");
			return "home.html";
		}
		else
		{
			model.addAttribute("students",students);
			return "fetch.html";
		}
	}

	public String fetchEmail(Model model, String searchEmail) {
		List<Student> students=repository.findByEmailLike("%"+searchEmail+"%");
		if(students.isEmpty())
		{
			model.addAttribute("message","records not found");
			return "home.html";
		}
		else
		{
			model.addAttribute("students",students);
			return "fetch.html";
		}
	}

	public String fetchAll(Model model, String searchAll) {
		
		HashSet<Student> students=new HashSet<Student>();
		try {
			long num=Long.parseLong(searchAll);
			students.addAll(repository.findByMobile(num));
		}catch (NumberFormatException e)
		{
			students.addAll(repository.findByNameLike("%"+searchAll+"%"));
			students.addAll(repository.findByEmailLike("%"+searchAll+"%"));
		}
		if(students.isEmpty())
		{
			model.addAttribute("message","No records found");
			return "home.html";
		}
		else
		{
			model.addAttribute("students", students);
			return "fetch.html";
		}

	}

	

}
