package com.example.Boot_CRUD_OPP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Boot_CRUD_OPP.Entity.Student;
import com.example.Boot_CRUD_OPP.Service.CrudService;
@Controller
public class CrudController {
	@Autowired
	CrudService service;
	@GetMapping("/")
	public String loadHome()
	{
		return "home.html";
	}
	@GetMapping("/insert")
    public String loadInsert()
    {
    	return "insert.html";
    }
	@GetMapping("/fetch")
	public String loadFetch(Model model)
	{
		
		return service.fetch(model);
	}
	@PostMapping("/insert")
	public String insert(@ModelAttribute Student student,Model model)
	{
		return service.add(student,model) ;
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model model)
	{
		return service.delete(id,model);
	}
	@GetMapping("/fetchByName")
	public String fetchByName(Model model,@RequestParam(defaultValue="")String search)
	{
		
	return service.fetchName(model,search);	
	}
	@GetMapping("/fetchByEmail")
	public String fetchByEmail(Model model,@RequestParam(defaultValue="")String searchEmail) 
	{
		return service.fetchEmail(model,searchEmail);
	}
	@GetMapping("/fetchByAll")
	public String fetchByAll(Model model,@RequestParam(defaultValue="")String searchAll) 
	{
		return service.fetchAll(model,searchAll);
	}
}

