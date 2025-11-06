package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Controller;


import java.util.Date;
import java.util.List;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service.MessageService;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/contact")
@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;

	@PostMapping("/submit")
	public String submitMessage(@RequestBody Message message) {

		messageService.saveMessage(message);
		return "Message saved successfully";

	}

	@GetMapping("/all")
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}

	@GetMapping("/last")
	public List<Message> getLastMessages() {
		return messageService.getLastMessages();

	}

	@SuppressWarnings("deprecation")
	@GetMapping("/today")
	public List<Message> getTodayMessages() {
		Date todayDate = new Date();

		StringBuilder sb = new StringBuilder();
		sb.append( todayDate.getDate()).append("-");
		sb.append( (todayDate.getMonth()+1)).append("-");
		sb.append( (todayDate.getYear()-100+2000));

		return messageService.getTodayMessages(sb.toString());
	}

}
