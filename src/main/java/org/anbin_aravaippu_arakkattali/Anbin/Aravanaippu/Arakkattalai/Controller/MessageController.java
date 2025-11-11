package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Controller;


import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.Message;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping("/sendMessage")
	public String sendMail(@RequestBody Message message) {

		messageService.sendEmail(message);
		return "Email sent";
	}
}
