package com.spring.hibernate.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hibernate.Service.DBAService;
import com.spring.hibernate.entity.Customer;
import com.spring.hibernate.entity.CustomerValidation;


@Controller
public class HomePageController 
{
	@Autowired
	DBAService dbaService;
	
	@Autowired
	CustomerValidation customervalidation;
	
	@RequestMapping("/")
	public String homePage()
	{
		System.out.println("----------- Login Page --------");
		return "HomePage";
	}
	
	@RequestMapping("/getData")
	public String getDetails (Model model)
	{
		System.out.println("Code Started");
		List<Customer> tempData = dbaService.Data();
		System.out.println("Completed");
		model.addAttribute("VALUES", tempData);
		return "list-of -student";
	}
	
	@RequestMapping("/form")
	public String formDetails(Model model)
	{
		model.addAttribute("FORM", customervalidation);
		return "Student-Form";
	}
	
	@RequestMapping(value = "/processing", method = { RequestMethod.POST})
	public String insertDBA (@Valid @ModelAttribute("FORM") CustomerValidation tempCustom , BindingResult result) 
	{
		System.out.println("ID is " + tempCustom.getId());
		if(result.hasErrors()) {
			return "Student-Form";
		}else 
		{
			String Output;
			Output = dbaService.insertDBA(tempCustom);	
			System.out.println(Output);
			if(Output.equalsIgnoreCase("Success")) 
				return "Success-page";
			else 
				return "Student-Form";	
		}
	}
	
	@RequestMapping(value ="/updateForm")
	public String getDetailsUpdate (@RequestParam("CustomerId") int id , Model model)
	{
		System.out.println("Code Started To run this method.");
		Customer tempData = dbaService.getData(id);
		System.out.println("Completed" + tempData);
		model.addAttribute("FORM" , tempData);
		return "Student-Form";
	}
	
	@RequestMapping(value="/deleteCustomer")
	public String Delete(@RequestParam("CustomerId") int id)
	{
		System.out.println("Delete Process Started");
		String result = dbaService.delete(id);
		System.out.println("DELETED " + result);
		if(result.equalsIgnoreCase("Success"))
			return "Success-page";
		else
			return "HomePage";
	}
}
