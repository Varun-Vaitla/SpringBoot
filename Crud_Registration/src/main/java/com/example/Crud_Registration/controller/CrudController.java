package com.example.Crud_Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Crud_Registration.Entity.Registration;
import com.example.Crud_Registration.Service.CrudService;
@Controller
public class CrudController {
	@Autowired
	CrudService service;
	@GetMapping("/")
	public String loadHome()
	{
		return "home.html";
	}
    @PostMapping("/insert")
    public String insert(@ModelAttribute Registration registration,Model model)
    {
	    return service.add(registration,model) ;
    }
    @GetMapping("/fetch")
	public String loadFetch(Model model)
	{
		
		return service.fetch(model);
	}
}
