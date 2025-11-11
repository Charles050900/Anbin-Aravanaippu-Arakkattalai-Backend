package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Entity;

public class FundTransferDetails {

	private String transactionNo;
	private String transactionAmount;
	private String payerName;
	private String payerPhoneNo;
	private String payerMessage;

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerPhoneNo() {
		return payerPhoneNo;
	}

	public void setPayerPhoneNo(String payerPhoneNo) {
		this.payerPhoneNo = payerPhoneNo;
	}

	public String getPayerMessage() {
		return payerMessage;
	}

	public void setPayerMessage(String payerMessage) {
		this.payerMessage = payerMessage;
	}

}
