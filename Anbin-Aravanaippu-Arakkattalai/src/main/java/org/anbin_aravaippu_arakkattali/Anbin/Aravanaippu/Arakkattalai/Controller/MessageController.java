package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Controller;

import java.io.IOException;
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
        try {
            messageService.saveMessage(message);
            return "Message saved successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error saving message: " + e.getMessage();
        }
    }

    @GetMapping("/all")
    public List<Message> getAllMessages() throws IOException {
        return messageService.getAllMessages();
    }

    @GetMapping("/last")
    public List<Message> getLastMessages() {
        try {
            return messageService.getLastMessages();
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
    @GetMapping("/today")
public List<Message> getTodayMessages() {
    try {
        return messageService.getTodayMessages();
    } catch (IOException e) {
        e.printStackTrace();
        return List.of();
    }
}

}
