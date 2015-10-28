package cs414.a4.richard2;

//import org.joda.time.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditPayment extends Payment {

	private String cardNumber;
    private String expireDate;

    
    //public CreditPayment(String cardNumber, DateTime datePaid, String expireDate, double amountFee)
    //public CreditPayment(String cardNumber, DateTime expireDate)
    public CreditPayment(String cardNumber, String expireDate, double amountFee)
    {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.datePaid = new Date(); 
        this.amountFee = amountFee;
        this.paymentType = PaymentType.Credit;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    
    public boolean isAccountValid(){
		if(isDateValid()&&isActNumValid()){
			return true;
		}
		else return false;
	}
	
	public boolean isDateValid(){  //check date format
		String ed = expireDate;
		SimpleDateFormat dtfmt = new SimpleDateFormat("MM/yyyy");
		Date date = null;
		try{
			date = dtfmt.parse(ed); 
		}
		catch (ParseException e)
        {
            System.out.println("Date format is invalid");
            return false;
        }
		return true;
	}
	public boolean isActNumValid(){
		String actNum= cardNumber;
	    for(char c : actNum.toCharArray()) //check that actNum is all digits
	    {
	        if(!Character.isDigit(c)){
	        	System.out.println("\nAccount number format is invalid.\n");
	        	return false;
	        }
	    }
		if(actNum.length()!=16){  //check that actNum is correct length
			System.out.println("Account number length is invalid.");
			return false;
		}
		return true;
	}
}
