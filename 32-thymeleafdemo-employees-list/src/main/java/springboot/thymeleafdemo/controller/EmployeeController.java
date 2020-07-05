package springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		Employee empl1 = new Employee(1, "Hebe", "Tien", "hebe.tien@gmail.com");
		Employee empl2 = new Employee(1, "Esther", "Yu", "esther.yu@gmail.com");
		Employee empl3 = new Employee(1, "Xiaotang", "Zhao", "xiaotang.zhao@gmail.com");
		
		theEmployees = new ArrayList<>();
		
		theEmployees.add(empl1);
		theEmployees.add(empl2);
		theEmployees.add(empl3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
