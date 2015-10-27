package cs414.a4.richard2;

import java.text.DecimalFormat;
//import java.util.Date;
import org.joda.time.*;

public class Receipt {
	//private Date paymentDate;
	private DateTime paymentDate;
	private PaymentType paymentType;
	private double amount;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	public Receipt(Payment pay){
		paymentDate = pay.getDatePaid();
		amount = pay.getOriginalAmountFee();
		paymentType = pay.getPaymentType();
	}
	
	public void printReceipt(){
		System.out.println("\nReceipt: \nThank you for paid Ticket.\nDate: "+paymentDate+
				"\nTotal: $" + df.format(amount) + "\nPayment Type: " + paymentType + "\n");
	}
}
