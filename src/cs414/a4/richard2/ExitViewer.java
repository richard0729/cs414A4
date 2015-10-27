package cs414.a4.richard2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ExitViewer extends Viewer{
	  
	  private Garage garage;
	  private GarageViewer garage_view;
	  private ExitKiosk kiosk;
	  private DecimalFormat df = new DecimalFormat("0.00");
	  
	  private Scanner input = new Scanner(System.in);
	  private Receipt receipt;

	  public ExitViewer(Garage garage) {
	    this.garage = garage;
	    garage_view = new GarageViewer(garage);
	    kiosk = garage.getExit();
	  }
	  
	  public void paymentMenu(double amountDue, Ticket ticket, boolean isFlatRate){
					
			int choice =printMenu("Please Select an option Payment", new String[]{
			        "Cash Payment",
			        "Credit Payment",
			        "[Test System - Return to Main Menu]"
			      });
			switch(choice){
			case 1: 
				//System.out.println("Please insert cash. Enter amount in USD: ");
				String ticket_printed = printString("Please enter cash amount: ", "0");
				double paymentAmount = input.nextInt();
				//CashPayment cp = new CashPayment(amountDue, paymentAmount);
				CashPayment cp = new CashPayment(amountDue, paymentAmount);
				while(cp.getAmountFee()>0){
					System.out.println("Remaining balance: $"+ df.format(cp.getAmountFee())); 
					System.out.println("Please insert cash. Enter amount in USD: ");
					paymentAmount = input.nextInt();
					cp.makePostCashPayment(paymentAmount);
					}
				System.out.println("Please take change: $" + df.format(cp.getBalanceCash())); 
				 receipt = new Receipt(cp);
				receipt.printReceipt();
				garage.addReceipt(receipt);
				//pause();
				//if(isFlatRate==true)garage.exitGarage(); 
				//if(isFlatRate==false)garage.exitGarage(ticket); 
				kiosk.exit_success(ticket);
		        System.out.println("[Gate auto open/close. You have exited garage.]");
				break;	
			case 2: 
				System.out.println("Please enter account number (16 digits no dashes): ");
				String accountNum = input.next();
				System.out.println("Please enter expiration date (format MM/yyyy): ");
				String expDate = input.next();
				//CreditPayment ep = new CreditPayment(amountDue, accountNum, expDate);
				CreditPayment ep = new CreditPayment( accountNum, expDate,amountDue);
				if(ep.isAccountValid()){
					receipt = new Receipt(ep);
					receipt.printReceipt();
					garage.addReceipt(receipt);
					//garage.addReceiptToCollection(r);
					//pause();
					//if(isFlatRate==true)garage.exitGarage(); 
					//else garage.exitGarage(ticket); 
					kiosk.exit_success(ticket);
			        System.out.println("[Gate auto open/close. You have exited garage.]");
				}
				else paymentMenu(amountDue, ticket, isFlatRate);
				break;
			case 3: break;
			default:
				System.out.println("Invalid selection.\n");
				paymentMenu(amountDue, ticket, isFlatRate); break;
			}
		}
}
