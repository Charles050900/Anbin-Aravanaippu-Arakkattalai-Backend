package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service;

import java.util.List;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Repository.MessageRepository;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public void saveMessage(Message message) {

		messageRepository.save(message);
	}

	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public List<Message> getLastMessages() {
		return messageRepository.findLastMessages();
	}

	public List<Message> getTodayMessages(String date) {
		return messageRepository.findTodayMessages("%" + date + "%");
	}

}
