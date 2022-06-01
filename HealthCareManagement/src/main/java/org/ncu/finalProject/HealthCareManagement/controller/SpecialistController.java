package org.ncu.finalProject.HealthCareManagement.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ncu.finalProject.HealthCareManagement.entity.Meeting;
import org.ncu.finalProject.HealthCareManagement.entity.Specialist;
import org.ncu.finalProject.HealthCareManagement.service.MeetingService;
import org.ncu.finalProject.HealthCareManagement.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpecialistController {

	@Autowired
	private SpecialistService specialistService;

	@Autowired
	private MeetingService meetingService;

	/* Creating domain object/bean for data binding */
	@ModelAttribute("specialist")
	public Specialist getSpecialist() {

		return new Specialist();
	}

	/* Controller mapping for showing the specialist input form */
	@GetMapping("/showSpecialistForm")
	public String showCustomerForm(@ModelAttribute("specialist") Specialist specialist, HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {

		return "specialistRegistration";
	}

	/* Controller mapping for processing the create/insert operation */
	@PostMapping("/processSpecialistForm")
	public String processForm(@Validated @ModelAttribute("specialist") Specialist specialist,
			BindingResult bindingResult, Model model, HttpServletResponse response, HttpSession session,
			HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return "showSpecialistForm";
		} else {
			specialist.toString();

			/* Creating cookies */
			Cookie cookie1 = new Cookie("specialist_username", specialist.getSpecialist_username());

			Cookie cookie2 = new Cookie("specialist_password", specialist.getSpecialist_password());

			cookie1.setMaxAge(60 * 60);
			cookie2.setMaxAge(60 * 60);

			response.addCookie(cookie1);
			response.addCookie(cookie2);

			session = request.getSession();
			session.setAttribute("specialist_username", specialist.getSpecialist_username());
			session.setAttribute("specialist_password", specialist.getSpecialist_password());
			session.setMaxInactiveInterval(60 * 60);

			specialistService.saveSpecialist(specialist);

			List<Meeting> meetingList = meetingService.fetchMeeting();
			model.addAttribute("meeting", meetingList);
			return "specialistHomepage";
		}
	}

	@RequestMapping(value = "/loginSpecialistForm")
	public String getCustomerLogin() {
		return "loginSpecialist";
	}

//	@RequestMapping(value = "/validateSpecialist")
//	public RedirectView validatespecialist(HttpServletRequest request, @RequestParam("pass") String pass,
//			@RequestParam("username") String username) {
//		HttpSession session = request.getSession();
//
//		System.out.println(username);
//		System.out.println(pass);
//		boolean is = specialistService.validateSpecialist(username, pass);
//		if (is) {
//			session.removeAttribute("iscustomerlogin");
//			session.removeAttribute("isspecialistlogin");
//			session.setAttribute("iscustomerlogin", username);
//			return new RedirectView("/HealthCareManagement/");
//		}
//		return new RedirectView("/HealthCareManagement/loginSpecialist.jsp");
//	}

	@RequestMapping(value = "/validateSpecialist")
	public String validateSpecialist(HttpServletRequest request, @RequestParam("pass") String pass,
			@RequestParam("username") String username) {
		HttpSession session = request.getSession();

		System.out.println(username);
		System.out.println(pass);
		boolean is = specialistService.validateSpecialist(username, pass);
		if (is) {
			session.removeAttribute("iscustomerlogin");
			session.removeAttribute("isspecialistlogin");
			session.setAttribute("isspecialistlogin", username);
			return "redirect:/goSpecialistPage";
		}
		return "loginSpecialist";
	}
	
	@RequestMapping(value = "/goSpecialistPage")
	public String getSpecialistHomePage(Model model, @ModelAttribute("specialist") Specialist specialist,
			@ModelAttribute("meeting") Meeting meeting) {

		List<Meeting> meetingList = meetingService.fetchMeeting();
		System.out.println(meetingList.toString());
		model.addAttribute("meeting", meetingList);
		
		return "specialistHomepage";
	}
	
	@RequestMapping(value= "/logoutSpecialist")
	public String logoutSpecialist(HttpServletRequest request)
	{
		
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/";
	}

}
