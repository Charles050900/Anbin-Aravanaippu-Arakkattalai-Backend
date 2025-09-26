package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service;

import java.io.IOException;
import java.util.List;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Repository.MessageRepository;
import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
    private MessageRepository repository;

    public void saveMessage(Message message) throws IOException {
        repository.save(message);
    }

    public List<Message> getAllMessages() throws IOException {
        return repository.findAll();
    }

     // Get last 5 messages (or all if less than 5)
     public List<Message> getLastMessages() throws IOException {
         return repository.findLastMessages();
     }
    public List<Message> getTodayMessages() throws IOException {
    return repository.findTodayMessages();
}

}
