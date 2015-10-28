package cs414.a4.richard2;

import java.text.DecimalFormat;
//import java.util.Date;
//import org.joda.time.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Receipt {
	//private Date paymentDate;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	private Date paymentDate;
	private PaymentType paymentType;
	private double amount;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	public Receipt(Payment pay){
		paymentDate = pay.getDatePaid();
		//amount = pay.getOriginalAmountFee();
		amount = pay.getAmountFee();
		paymentType = pay.getPaymentType();
	}
	
	public void printReceipt(){
		System.out.println("\nReceipt: \nThank you for paid Ticket.\nDate: "
				+dateFormat.format(paymentDate)+
				"\nTotal: $" + df.format(amount) + "\nPayment Type: " + paymentType + "\n");
	}
}
