package com.example.GameScoreMail.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpSession;

@Controller
public class GameController {
	@Autowired
	JavaMailSender mailSender;
	@GetMapping("/")
	public String welcome(HttpSession session) {
		session.invalidate();
		return "welcome";
	}
	
	@PostMapping("/start")
	public String startGame(@RequestParam String name, @RequestParam String email, HttpSession session, Model model) {
		session.setAttribute("name", name);
		session.setAttribute("email", email);
		session.setAttribute("number", new Random().nextInt(101));
		session.setAttribute("attempts", 0);
		model.addAttribute("message", "Welcome " + name + "! Guess a number between 1 and 100.");
		return "index";
	}
	
	@PostMapping("/guess")
	public String guess(@RequestParam int guess, HttpSession session, Model model) {
		Integer number = (Integer) session.getAttribute("number");
		Integer attempts = (Integer) session.getAttribute("attempts");

		attempts++;
		session.setAttribute("attempts", attempts);

		if (guess < number) {
			model.addAttribute("message", "Too low!");
		} else if (guess > number) {
			model.addAttribute("message", "Too high!");
		} else {
			int points = Math.max(100 - (attempts - 1) * 10, 10);

			String name = (String) session.getAttribute("name");
			String email = (String) session.getAttribute("email");

			model.addAttribute("name", name);
			model.addAttribute("attempts", attempts);
			model.addAttribute("points", points);
			model.addAttribute("email", email);

			sendMail(name, attempts, points, email);

			return "result";
		}

		return "index";
	}

	void sendMail(String name, Integer attempts, int points, String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("varunvm996@gmail.com");
		message.setTo(email);
		message.setSubject("You Score in Number Game");
		message.setText(
				"Hey " + name + ", You have Taken " + attempts + " attempts, on calculation Your Score is " + points);

		mailSender.send(message);
	}


}
