package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer messageId;
	private String senderName;
	private String senderEmail;
	private String senderPhoneNo;
	private String senderMessage;
	private String createdAt;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderPhoneNo() {
		return senderPhoneNo;
	}

	public void setSenderPhoneNo(String senderPhoneNo) {
		this.senderPhoneNo = senderPhoneNo;
	}

	public String getSenderMessage() {
		return senderMessage;
	}

	public void setSenderMessage(String senderMessage) {
		this.senderMessage = senderMessage;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
