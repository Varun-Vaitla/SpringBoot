package com.example.Crud_Registration.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import com.example.Crud_Registration.Entity.Registration;
import com.example.Crud_Registration.Repository.CrudRepository;
@Service
public class CrudService {
	@Autowired
	CrudRepository repository;
	public String add(Registration registration, Model model) {
		repository.save(registration);
		model.addAttribute("message","inserted success");
		return "home.html";
	}
	

	
}
