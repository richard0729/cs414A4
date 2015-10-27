package cs414.a4.richard2;

import org.joda.time.*;

public class CreditPayment extends Payment {

	private String cardNumber;
    private DateTime expireDate;
    
    public CreditPayment(String cardNumber, DateTime datePaid, DateTime expireDate, double amountFee){
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.datePaid = datePaid;
        this.amountFee = amountFee;
        
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public DateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(DateTime expireDate) {
        this.expireDate = expireDate;
    }
}
