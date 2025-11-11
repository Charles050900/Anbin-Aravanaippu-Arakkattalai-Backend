package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Controller;


import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.FundTransferDetails;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundTransferController {

	@Autowired
	private FundTransferService fundTransferService;

	@PostMapping("/fundTransfer")
	public String sendMail(@RequestBody FundTransferDetails fundTransferDetails) {

		fundTransferService.sendEmail(fundTransferDetails);
		return "Email sent";
	}
}
