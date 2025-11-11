package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.VolunteerRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class VolunteerService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(VolunteerRegistration volunteerRegistration) {
//		SimpleMailMessage finalMessage = new SimpleMailMessage();
//		finalMessage.setFrom("charlesbellarmin05@gmail.com");
//		finalMessage.setTo("charlesbellarmin05@gmail.com");
//		finalMessage.setSubject("New Volunteer " + volunteerRegistration.getVolunteerName());
//		String formattedMessage = String.format("""
//				New Volunteer Registration
//
//				Name          : %s
//				Age           : %s
//				Email         : %s
//				Phone         : %s
//				District      : %s
//				Blood Group   : %s
//				Work Together : %s
//				Blood Donate  : %s
//				""", volunteerRegistration.getVolunteerName(), volunteerRegistration.getVolunteerAge(),
//				volunteerRegistration.getVolunteerEmail(), volunteerRegistration.getVolunteerPhone(),
//				volunteerRegistration.getVolunteerDistrict(), volunteerRegistration.getVolunteerBloodGroup(),
//				volunteerRegistration.getWorkTogether() ? "Yes. I am ready to join and work together with trust."
//						: "No. I am not ready to join at the moment.",
//				volunteerRegistration.getBloodDonate() ? "Yes. I agree to donate blood when needed."
//						: "No. I didn’t agree to donate blood when needed.");
		try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("charlesbellarmin05@gmail.com");
            helper.setTo("charlesbellarmin05@gmail.com");
            helper.setSubject("New Volunteer Registration: " + volunteerRegistration.getVolunteerName());

            String htmlMessage = String.format("""
                <div style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
                  <h3 style="margin-bottom: 10px;">New Volunteer Registration</h3>
                  <table style="border-collapse: collapse;">
                    <tr><td style="padding: 4px 8px; font-weight: bold;">Name</td><td>: %s</td></tr>
                    <tr><td style="padding: 4px 8px; font-weight: bold;">Age</td><td>: %s</td></tr>
                    <tr><td style="padding: 4px 8px; font-weight: bold;">Email</td>
                        <td>: <a href="mailto:%s" style="color: #1a73e8;">%s</a></td></tr>
                    <tr><td style="padding: 4px 8px; font-weight: bold;">Phone</td><td>: %s</td></tr>
                    <tr><td style="padding: 4px 8px; font-weight: bold;">District</td><td>: %s</td></tr>
                    <tr><td style="padding: 4px 8px; font-weight: bold;">Blood Group</td><td>: %s</td></tr>
                    <tr><td style="padding: 4px 8px; font-weight: bold;">Work Together</td>
                        <td>: %s</td></tr>
                    <tr><td style="padding: 4px 8px; font-weight: bold;">Blood Donate</td>
                        <td>: %s</td></tr>
                  </table>
                </div>
                """,
                volunteerRegistration.getVolunteerName(),
                volunteerRegistration.getVolunteerAge(),
                volunteerRegistration.getVolunteerEmail(),
                volunteerRegistration.getVolunteerEmail(),
                volunteerRegistration.getVolunteerPhone(),
                volunteerRegistration.getVolunteerDistrict(),
                volunteerRegistration.getVolunteerBloodGroup(),
                volunteerRegistration.getWorkTogether()
                    ? "Yes. I am ready to join and work together with trust."
                    : "No. I am not ready to join at the moment.",
                volunteerRegistration.getBloodDonate()
                    ? "Yes. I agree to donate blood when needed."
                    : "No. I didn’t agree to donate blood when needed."
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

		
		
//		finalMessage.setText(htmlMessage);

//		mailSender.send(finalMessage);
//		System.out.println("Mail sent successfully");
//	}

}
