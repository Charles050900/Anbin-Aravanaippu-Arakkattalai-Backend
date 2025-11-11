package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Controller;


import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.VolunteerRegistration;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolunteerController {

	@Autowired
	private VolunteerService volunteerService;

	@PostMapping("/volunteerRegistration")
	public String sendMail(@RequestBody VolunteerRegistration volunteerRegistration) {

		volunteerService.sendEmail(volunteerRegistration);
		return "Email sent";
	}
}
