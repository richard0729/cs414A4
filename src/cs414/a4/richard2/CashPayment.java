package cs414.a4.richard2;

//import org.joda.time.*;
import java.util.Date;

public class CashPayment extends Payment {
	
	private double TotalPaid;
	private double balanceCash;
	
	 //public CashPayment(double amountFee,double totalPaid,  DateTime datePaid){        
	
	//public CashPayment(double amountFee,double totalPaid){
	public CashPayment(double amountFee,double totalPaid){
	        this.amountFee = amountFee;   
	        this.TotalPaid = totalPaid;
	        this.balanceCash = totalPaid - amountFee;
	        this.datePaid = new Date();   
	        this.paymentType = PaymentType.Cash;
	    }
	/*
	 public void makeInitialCashPayment(){
			amountFee = amountFee - TotalPaid;
			if(amountFee<0) balanceCash = amountFee *-1;
		}
		public void makePostCashPayment(double TotalPaid){
			amountFee = amountFee - TotalPaid;
			if(amountFee<0) balanceCash = amountFee *-1;
		}
	*/
		public double getBalanceCash(){
			return balanceCash;
		}
}
