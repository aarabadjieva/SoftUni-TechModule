package com.softuni.controller;

import com.softuni.controller.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view","views/calculatorForm");
		return "base-layout";
	}
	@PostMapping("/")
	public String calculate(@RequestParam String leftOperand, @RequestParam String rightOperand,
							@RequestParam String operator, Model model){
		double left;
		double right;
		try{
			left = Double.parseDouble(leftOperand);
		}catch (NumberFormatException str){
			left = 0d;
		}
		try{
			right = Double.parseDouble(rightOperand);
		}catch (NumberFormatException str){
			right = 0d;
		}
		Calculator calculator = new Calculator(left,right,operator);
		double result = calculator.calculateResult();
		model.addAttribute("leftOperand", calculator.getLeftOperand());
		model.addAttribute("rightOperand", calculator.getRightOperand());
		model.addAttribute("operator", calculator.getOperator());
		model.addAttribute("result", result);
		model.addAttribute("view","views/calculatorForm");

		return "base-layout";
	}

}
