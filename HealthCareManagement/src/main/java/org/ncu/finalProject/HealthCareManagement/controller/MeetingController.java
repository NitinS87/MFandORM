package org.ncu.finalProject.HealthCareManagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ncu.finalProject.HealthCareManagement.entity.Meeting;
import org.ncu.finalProject.HealthCareManagement.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	/* Creating domain object/bean for data binding */
	@ModelAttribute("meeting")
	public Meeting getMeeting() {

		return new Meeting();
	}

	@GetMapping("/showCustomerMeetingForm")
	public String showCustomerForm(@RequestParam("specialist_id") int specialist_id,
			@RequestParam("customer_id") int customer_id, @ModelAttribute("meeting") Meeting meeting, Model model) {
		
		System.out.println("Getting the meeting data for these ids: " + customer_id + " ," + specialist_id);
//		meeting = meetingService.chosenOneMeeting(customer_id, specialist_id);
		/* send the meeting object to view */
		model.addAttribute("customer_id", customer_id);
		model.addAttribute("specialist_id", specialist_id);
		model.addAttribute(meeting);

		return "meetingCustomerForm";
	}

	/* Controller mapping for processing the create/insert operation */
	@PostMapping("/processCustomerMeetingForm")
	public String processForm(@Validated @ModelAttribute("Meeting") Meeting meeting, Model model,
			HttpServletResponse response, HttpSession session, HttpServletRequest request) {

		System.out.println(meeting.toString());

		meetingService.saveMeeting(meeting);
		model.addAttribute("meeting", meeting);

		return "confirmMeeting";
	}

	/* Controller mapping for update form */
	@GetMapping("/updateSpecialistMeetingForm")
	public String showMeetingUpdateForm(@RequestParam("id") int id, @ModelAttribute("meeting") Meeting meeting,
			Model model) {

		System.out.println("Getting the meeting data for id: " + id);
		meeting = meetingService.getOneMeeting(id);
		/* send the meeting object to view */
		model.addAttribute(meeting);
		return "meetingSpecialistForm";
	}

	/* Controller mapping for processing the create/insert operation */
	@PostMapping("/processSpecialistMeetingForm")
	public String processUpdateForm(@Validated @ModelAttribute("Meeting") Meeting meeting, Model model,
			HttpServletResponse response, HttpSession session, HttpServletRequest request) {

		System.out.println(meeting.toString());
		
		String[] list = meeting.getLogistics();
		String others = "";
		for(String l : list) {
			others = others+" "+l+", "; 
			System.out.println(l);
		}
		
		if (others.endsWith(", ")) {
		    others = others.substring(0, others.length() - 2) + ". ";
		}

		/* send the updated data using model attribute */
		System.out.println(others);
		model.addAttribute("meeting.logistics", others);
		model.addAttribute("meeting", meeting);
		
		return "confirmSpecialistMeeting";	
	}

	/* Controller mapping for update form */
	@GetMapping("/confirmDetails")
	public String showSpecialistUpdateForm(@RequestParam("id") int id, @ModelAttribute("meeting") Meeting meeting, Model model) {

		System.out.println("Getting the meeting data for id: " + id);
		meeting = meetingService.getOneMeeting(id);
		/* send the student object to view */
		model.addAttribute(meeting);
		meetingService.editMeeting(meeting);
		
		return "confirmUpdateMeeting";
	}
	
	/* Controller mapping for update form */
	@GetMapping("/updateCustomerMeetingForm")
	public String showUpdateForm(@RequestParam("id") int id, @ModelAttribute("meeting") Meeting meeting, Model model) {

		System.out.println("Getting the meeting data for id: " + id);
		meeting = meetingService.getOneMeeting(id);
		/* send the student object to view */
		model.addAttribute(meeting);
		return "confirmUpdateMeeting";
	}

	/* Controller mapping for processing the delete operation */
	@GetMapping("/deleteMeeting")
	public String deleteMeeting(@RequestParam("id") int id) {
		meetingService.deleteOneMeeting(id);
		System.out.println("Records deleted successfully");
		return "redirect:/goCustomerPage";
	}

}
