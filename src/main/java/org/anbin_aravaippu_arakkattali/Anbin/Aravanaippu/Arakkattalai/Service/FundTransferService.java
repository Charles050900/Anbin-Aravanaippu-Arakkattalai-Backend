package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Service;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity.FundTransferDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class FundTransferService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(FundTransferDetails fundTransferDetails) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setFrom("charlesbellarmin05@gmail.com");
			helper.setTo("charlesbellarmin05@gmail.com");
			helper.setSubject("Fund Transfer Details from: " + fundTransferDetails.getPayerName());

			String htmlMessage = String.format("""
					<div style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
					    <h3  style="margin-bottom: 10px;">Fund Transfer Details</h3>
					    <table style="border-collapse: collapse;">

					        <tr>
					      <td style="padding: 4px 8px; font-weight: bold;">Transaction No</td>
					      <td>: %s</td>
					    </tr>
					        <tr>
					            <td style="padding: 4px 8px; font-weight: bold;">Amount</td>
					            <td>: %s</td>
					        </tr>
					        <tr>
					            <td style="padding: 4px 8px; font-weight: bold;">Payer Name</td>
					            <td>: %s</td>
					        </tr>
					        <tr>
					            <td style="padding: 4px 8px; font-weight: bold;">Payer Phone No</td>
					            <td>: %s</td>
					        </tr>
					        <tr>
					            <td style="padding: 4px 8px; font-weight: bold;"">Message</td>
					            <td>: %s</td>
					        </tr>
					    </table>
					</div>
					""", fundTransferDetails.getTransactionNo(), fundTransferDetails.getTransactionAmount(),
					fundTransferDetails.getPayerName(), fundTransferDetails.getPayerPhoneNo(),
					fundTransferDetails.getPayerMessage());

			helper.setText(htmlMessage, true); // HTML enabled
			mailSender.send(message);
			System.out.println("Fund Transfer email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Failed to send Fund Transfer email: " + e.getMessage());
		}

	}
}
