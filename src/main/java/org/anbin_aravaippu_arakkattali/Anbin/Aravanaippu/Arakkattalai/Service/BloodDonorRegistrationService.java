package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.BloodDonorRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class BloodDonorRegistrationService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(BloodDonorRegistration bloodDonorRegistration) {
		try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("charlesbellarmin05@gmail.com");
            helper.setTo("charlesbellarmin05@gmail.com");
            helper.setSubject("New Blood Donor Registration: " + bloodDonorRegistration.getBloodDonorName());

            String htmlMessage = String.format("""
            	    <div style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
            	      <h3 style="margin-bottom: 10px;">New Blood Donor Registration</h3>
            	      <table style="border-collapse: collapse;">
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Name</td>
            	          <td>: %s</td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Age</td>
            	          <td>: %s</td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Blood Group</td>
            	          <td>: %s</td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Phone</td>
            	          <td>: %s</td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Email</td>
            	          <td>: <a href="mailto:%s" style="color: #1a73e8;">%s</a></td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">District</td>
            	          <td>: %s</td>
            	        </tr>
            	        <tr>
            	          <td style="padding: 4px 8px; font-weight: bold;">Contact Permission</td>
            	          <td>: %s</td>
            	        </tr>
            	      </table>
            	    </div>
            	    """,
            	    bloodDonorRegistration.getBloodDonorName(),                // %s 1
            	    bloodDonorRegistration.getBloodDonorAge(),                 // %s 2
            	    bloodDonorRegistration.getBloodGroup(),                    // %s 3
            	    bloodDonorRegistration.getBloodDonorPhonoNo(),             // %s 4
            	    bloodDonorRegistration.getBloodDonorEmail(),               // %s 5 (for mailto link)
            	    bloodDonorRegistration.getBloodDonorEmail(),               // %s 6 (for display)
            	    bloodDonorRegistration.getBloodDonorDistrict(),            // %s 7
            	    bloodDonorRegistration.getBloodDonoteContact()
            	        ? "Yes. I agree to be contacted for blood donation when needed."
            	        : "No. I prefer not to be contacted for blood donation."  // %s 8
            	);


            // ✅ This line enables HTML rendering
            helper.setText(htmlMessage, true);

            mailSender.send(message);
            System.out.println("Mail sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
	
}
