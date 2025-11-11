package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MessageService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(Message message) {

		try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom("charlesbellarmin05@gmail.com");
            helper.setTo("charlesbellarmin05@gmail.com");
            helper.setSubject("Communication Email from "+message.getSenderName());

            String htmlMessage = String.format("""
            	    <div style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
            	      <h3 style="margin-bottom: 10px;">New Communication Email</h3>
            	      <table style="border-collapse: collapse;">
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Name</td>
            	          <td>: %s</td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Email</td>
            	          <td>: <a href="mailto:%s" style="color: #1a73e8;">%s</a></td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Phone</td>
            	          <td>: %s</td>
            	        </tr>
            	      </table>

            	      <p style="margin-top: 15px; font-weight: bold;">Message:</p>
            	      <p style="background-color: #f5f5f5; padding: 10px; border-radius: 6px;">
            	        %s
            	      </p>
            	    </div>
            	    """,
            	    message.getSenderName(),   // %s 1
            	    message.getSenderEmail(),  // %s 2 (for mailto link)
            	    message.getSenderEmail(),  // %s 3 (for visible email)
            	    message.getSenderPhoneNo(),// %s 4
            	    message.getSenderMessage() // %s 5
            	);



            // ✅ This line enables HTML rendering
            helper.setText(htmlMessage, true);

            mailSender.send(mimeMessage);
            System.out.println("Mail sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
	
}
