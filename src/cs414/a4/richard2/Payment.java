package cs414.a4.richard2;

import org.joda.time.*;

public class Payment {

	protected double amountFee;
	protected double originalAmountFee;
	protected DateTime datePaid;
	protected PaymentType paymentType;
	
	public Payment(){}
   
	public Payment(double ad, PaymentType pt){
		datePaid = new DateTime();
		paymentType = pt;
		originalAmountFee = ad;
		amountFee = ad;
	}
	
    public double getAmountFee() {
        return amountFee;
    }
    public double getOriginalAmountFee() {
        return originalAmountFee;
    }

    
    public void setAmountFee(double amountFee) {
        this.amountFee = amountFee;
    }


    public DateTime getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(DateTime datePaid) {
        this.datePaid = datePaid;
    }
    
    public PaymentType getPaymentType(){
		return paymentType;
	}
}
