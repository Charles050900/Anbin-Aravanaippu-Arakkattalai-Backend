package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Controller;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.BloodDonorRegistration;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service.BloodDonorRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloodDonorRegistraionController {
	@Autowired
	private BloodDonorRegistrationService bloodDonorRegistrationService;

	@PostMapping("/bloodDonorRegistration")
	public String sendMail(@RequestBody BloodDonorRegistration bloodDonorRegistration) {

		bloodDonorRegistrationService.sendEmail(bloodDonorRegistration);
		return "Email sent";
	}
}
