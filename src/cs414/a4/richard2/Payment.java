package cs414.a4.richard2;

import org.joda.time.*;

public class Payment {

	protected double amountFee;
	protected DateTime datePaid;

   
    public double getAmountFee() {
        return amountFee;
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
}
