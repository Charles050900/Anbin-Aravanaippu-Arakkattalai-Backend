package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Controller;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.BloodRequester;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service.BloodRequesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloodRequesterController {

	@Autowired
	private BloodRequesterService bloodRequesterService;

	@PostMapping("/bloodRequester")
	public String sendMail(@RequestBody BloodRequester bloodRequester) {

		bloodRequesterService.sendEmail(bloodRequester);
		return "Email sent";
	}

}
