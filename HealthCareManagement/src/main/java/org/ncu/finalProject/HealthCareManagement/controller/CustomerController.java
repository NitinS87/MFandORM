package org.ncu.finalProject.HealthCareManagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ncu.finalProject.HealthCareManagement.entity.Customer;
import org.ncu.finalProject.HealthCareManagement.entity.Meeting;
import org.ncu.finalProject.HealthCareManagement.entity.Specialist;
import org.ncu.finalProject.HealthCareManagement.service.CustomerService;
import org.ncu.finalProject.HealthCareManagement.service.MeetingService;
import org.ncu.finalProject.HealthCareManagement.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private SpecialistService specialistService;

	@Autowired
	private MeetingService meetingService;

	/* Creating domain object/bean for data binding */
	@ModelAttribute("customer")
	public Customer getCustomer() {

		return new Customer();
	}

	/* Controller mapping for showing the customer input form */
	@GetMapping("/showCustomerForm")
	public String showCustomerForm(@ModelAttribute("customer") Customer customer, HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {

		return "customerRegistration";

	}

	/* Controller mapping for processing the create/insert operation */
	@RequestMapping(value = "/processCustomerForm")
	public String processForm(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			Model model, HttpServletResponse response, HttpSession session, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return "showCustomerForm";
		} else {
			System.out.println(customer.toString());

			customerService.saveCustomer(customer);

			return "customerHomepage";
		}
	}

	@RequestMapping(value = "/loginCustomerForm")
	public String getCustomerLogin() {
		return "loginCustomer";
	}

//	@RequestMapping(value="/validateCustomer")
//	public RedirectView validatebuyer(HttpServletRequest request,@RequestParam("pass")String pass,@RequestParam("username")String username)
//	{
//		HttpSession session=request.getSession();
//		
//		System.out.println(username);
//		System.out.println(pass);
//		boolean is = customerService.validateCustomer(username, pass);
//		if(is) 
//		{
//			session.removeAttribute("iscustomerlogin");
//			session.removeAttribute("isspecialistlogin");
//			session.setAttribute("iscustomerlogin", username);
//			return new RedirectView("/HealthCareManagement/customerHomepage");
//		}
//		return new RedirectView("/HealthCareManagement/loginCustomer.jsp");
//	}

	@RequestMapping(value = "/validateCustomer")
	public String validateCustomer(HttpServletRequest request, @RequestParam("pass") String pass,
			@RequestParam("username") String username) {
		HttpSession session = request.getSession();

		System.out.println(username);
		System.out.println(pass);
		boolean is = customerService.validateCustomer(username, pass);
		if (is) {
			session.removeAttribute("iscustomerlogin");
			session.removeAttribute("isspecialistlogin");
			session.setAttribute("iscustomerlogin", username);
			return "redirect:/goCustomerPage";
		}
		return "loginCustomer";
	}

	@RequestMapping(value = "/goCustomerPage")
	public String getCustomerHomePage(Model model, @ModelAttribute("specialist") Specialist specialist,
			@ModelAttribute("meeting") Meeting meeting,HttpServletRequest request, @ModelAttribute("customer") Customer customer ) {
		
		List<Meeting> meetingList = meetingService.fetchMeeting();
		System.out.println(meetingList.toString());
		model.addAttribute("meeting", meetingList);

		List<Specialist> specialistList = specialistService.fetchSpecialist();
		System.out.println(meetingList.toString());
		model.addAttribute("specialist", specialistList);
		
		model.addAttribute("customer", customer);

		return "customerHomepage";
	}
	
	@RequestMapping(value= "/logoutCustomer")
	public String logoutCustomer(HttpServletRequest request)
	{
		
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	

}