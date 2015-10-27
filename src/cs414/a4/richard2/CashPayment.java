package cs414.a4.richard2;

import org.joda.time.*;

public class CashPayment extends Payment {
	
	private double TotalPaid;
	private double balanceCash;
	
	 public CashPayment(double amountFee,double totalPaid,  DateTime datePaid){        
	        this.amountFee = amountFee;   
	        this.TotalPaid = totalPaid;
	        this.balanceCash = totalPaid - amountFee;
	        this.datePaid = datePaid;        
	    }
	 
}
