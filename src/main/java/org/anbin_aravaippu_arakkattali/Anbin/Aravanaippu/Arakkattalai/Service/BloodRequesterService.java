package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.BloodRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class BloodRequesterService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(BloodRequester bloodRequester) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setFrom("charlesbellarmin05@gmail.com");
			helper.setTo("charlesbellarmin05@gmail.com");
			helper.setSubject("New Blood Request from : " + bloodRequester.getBloodRequesterName());

			String formattedDate = bloodRequester.getBloodRequestingDate();
			try {
			    LocalDate parsedDate = LocalDate.parse(formattedDate); // 2025-11-12
			    formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			} catch (Exception e) {
			    // keep original if parsing fails
			}

			
			String htmlMessage = String.format("""
					<div style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
					  <h3 style="margin-bottom: 10px;">New Blood Request</h3>
					  <table style="border-collapse: collapse;">
					    <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">Name</td>
					      <td>: %s</td>
					    </tr>
					    <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">Phone</td>
					      <td>: %s</td>
					    </tr>
					    <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">Reason</td>
					      <td>: %s</td>
					    </tr>
					    <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">Blood Group</td>
					      <td>: %s</td>
					    </tr>
					    <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">District</td>
					      <td>: %s</td>
					    </tr>
					    <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">Requesting Place</td>
					      <td>: %s</td>
					    </tr>
					    <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">Requesting Date</td>
					      <td>: %s</td>
					    </tr>
					  </table>
					</div>
					""", bloodRequester.getBloodRequesterName(), bloodRequester.getBloodRequesterPhoneNo(),
					bloodRequester.getBloodRequestReason(), bloodRequester.getBloodGroup(),
					bloodRequester.getBloodRequesterDistrict(), bloodRequester.getBloodRequestingPlace(),
					formattedDate);

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
