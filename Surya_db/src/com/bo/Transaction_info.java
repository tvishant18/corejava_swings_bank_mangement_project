package com.bo;

public class Transaction_info {
private int Customer_id;
private int Account_no;
private int Credit_amount;
private int Debit_amount;
private int Transfer_amount;
private String Transaction_date;
private int Receiver_Customer_id;
public int getReceiver_Customer_id() {
	return Receiver_Customer_id;
}
public void setReceiver_Customer_id(int receiver_Customer_id) {
	Receiver_Customer_id = receiver_Customer_id;
}
public int getReceiver_Account_no() {
	return Receiver_Account_no;
}
public void setReceiver_Account_no(int receiver_Account_no) {
	Receiver_Account_no = receiver_Account_no;
}
private int Receiver_Account_no;
public String getTransaction_date() {
	return Transaction_date;
}
public void setTransaction_date(String transaction_date) {
	Transaction_date = transaction_date;
}
public int getCredit_amount() {
	return Credit_amount;
}
public void setCredit_amount(int credit_amount) {
	Credit_amount = credit_amount;
}
public int getDebit_amount() {
	return Debit_amount;
}
public void setDebit_amount(int debit_amount) {
	Debit_amount = debit_amount;
}
public int getTransfer_amount() {
	return Transfer_amount;
}
public void setTransfer_amount(int transfer_amount) {
	Transfer_amount = transfer_amount;
}
public int getCustomer_id() {
	return Customer_id;
}
public void setCustomer_id(int customer_id) {
	Customer_id = customer_id;
}
public int getAccount_no() {
	return Account_no;
}
public void setAccount_no(int account_no) {
	Account_no = account_no;
}

}
