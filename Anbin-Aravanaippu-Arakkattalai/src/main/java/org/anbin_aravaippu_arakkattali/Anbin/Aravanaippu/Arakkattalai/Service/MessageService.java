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
}
