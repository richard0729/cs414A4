package cs414.a4.richard2;

import java.text.DecimalFormat;
//import org.joda.time.DateTime;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

public class Controller extends Viewer  {

	private DecimalFormat df = new DecimalFormat("0.00");
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	  
	  private Scanner input = new Scanner(System.in);
	  private Receipt receipt;
	  private int ticketID;
	  private Ticket ticket;
	  private double amountDue;
	  private UsageReport report;
	  private Date dateReport;
	  private long n;
	  
	private Garage garage;
	  //private GarageView garage_view;

	  public Controller(Garage garage) {
	    this.garage = garage;
	    report = new UsageReport(garage);
	    //garage_view = new GarageView(garage);
	  }

	  public void print_status() {
	    //clearscreen();
	    //garage_view.print_garage_status();
		  this.print_garage_status();
	  }
	  
	  public void print_garage_status() {
		    //DateTime now = new DateTime();
		  	Date now = new Date();
		    int capacity = garage.getMaxSpaces() - garage.getUsedSpaces();
		    System.out.print("Entry Gate: " + garage.entryGate.state_as_string());
		    //System.out.print("\tExit Gate: " + garage.exit_gate.state_as_string());
		    //System.out.print("\tSign: " + garage.sign.status_as_string());
		    System.out.print("\tSign Garage: " + garage.sign.getStatus());
		    System.out.println("");
		    // System.out.println("Capacity: " + garage.capacity_sign.status_as_string());
		    //System.out.print("Current time: " + now.toString("KK:mm aa"));
		    System.out.println("Current time: " + dateFormat.format(now));
		    // System.out.print("\t     Rate: " + String.format("$%0.02f/hr", garage.hourly_rate()));
		    DecimalFormat money = new DecimalFormat("$0.00");
		    double rate = garage.getFeeRate();
		    System.out.print("\t     Rate: " + money.format(rate) + "/hr");
		    //System.out.print("\tCapacity: " + garage.ticketTrans.getActiveTickets().size() + "/" + garage.getMaxSpaces());
		    System.out.print("\t	Max Spaces: " + garage.getMaxSpaces());
		    System.out.print("\t	Capacity: " + capacity );
		    System.out.println("");
		    System.out.println("");
		  }


	  public void setRate() {
	    String input = printString("New rate ($/hr): ", "");
	    double newRate;
	    try {
	    	newRate = Double.parseDouble(input);
	    }
	    catch (NumberFormatException e) {
	      System.out.println("Invalid rate!");
	      return;
	    }
	    if(newRate <= 0.0) {
	      System.out.println("Invalid rate!");
	      return;
	    }
	    garage.setFeeRate(newRate);
	  }

	  public void SetMaxSpaces() {
	    String input = printString("New max Spaces: ", "");
	    int newMax;
	    try {
	    	newMax = Integer.parseInt(input);
	    }
	    catch (NumberFormatException e) {
	      System.out.println("Invalid max Spaces!");
	      return;
	    }
	    if(newMax <= 0) {
	      System.out.println("Invalid max Spaces!");
	      return;
	    }
	    garage.setMaxSpaces(newMax);
	  }
	  
	  public void UsageMenu() {
		    while(true) {
		    	//this.print_status();
		      int choice =printMenu("Garage Usage Report ", new String[]{
		        "Hourly",
		        "Daily",
		        //"Weekly",
		        "Monthly",
		        "Return to Main Menu"
		      });
		      switch (choice) {
		        case 1:
		        	String expected2 = "MM/dd/yyyy";
		            SimpleDateFormat formatter2 = new SimpleDateFormat(expected2);
		        	String dateInput2 = printString("Enter hourly (MM/dd/yyyy): ", "");		        	
		        	try{
		        		dateReport = formatter2.parse(dateInput2);
		        	}
		        	catch(ParseException e)
		        	{
		        		System.out.println("Input wrong hourly (MM/dd/yyyy)");
		        		printContinue();
		        	}
		        	System.out.println("Garage usage in hourly of "+formatter2.format(dateReport) );
		        	n=report.reportDaily(dateReport);
		        	//System.out.println("Garage usage in hourly "+formatter2.format(dateReport) +" is: " +n);
		        	printContinue();
			        break;
		        case 2:
		        	String expectedPattern = "MM/yyyy";
		            SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		        	String dateInput = printString("Enter month (MM/yyyy) for daily report: ", "");
		        	
		        	try{
		        		dateReport = formatter.parse(dateInput);
		        	}
		        	catch(ParseException e)
		        	{
		        		System.out.println("Input wrong month (MM/yyyy)");
		        		printContinue();
		        	}
		        	System.out.println("Garage usage daily in month "+formatter.format(dateReport));
		        	n=report.reportDaily(dateReport);
		        	
		        	printContinue();
			        break;
		        case 3:
		        	String expected1 = "yyyy";
		            SimpleDateFormat formatter1 = new SimpleDateFormat(expected1);
		        	String dateInput1 = printString("Enter year (yyyy) for monthly report: ", "");		        	
		        	try{
		        		dateReport = formatter1.parse(dateInput1);
		        	}
		        	catch(ParseException e)
		        	{
		        		System.out.println("Input wrong year (yyyy)");
		        		printContinue();
		        	}
		        	System.out.println("Garage usage monthly report in year "+formatter1.format(dateReport));
		        	n=report.reportMonthly(dateReport);
		        	
		        	printContinue();
			        break;
		        case 5:
		          return;
		        default:
		          System.out.println("Unknown option.");
		          break;
		      }
		    }
		  }

	  public void garage_management() {
	    while(true) {
	      print_status();
	      int choice = printMenu("Garage Management", new String[]{
	        "Modify rate",
	        "Modify maximum capacity",
	        "Usage reports",
	        "[Return to Main Menu]"
	      });

	      switch (choice) {
	        case 1:
	          setRate();
	          break;
	        case 2:
	          SetMaxSpaces();
	          break;
	        case 3:
	        	UsageMenu();
	          break;
	          
	        case 4:
	          // occupapation_report_menu();
	          return;
	        case 5:
	          return;
	        default:
	          System.out.println("Unknown option.");
	          break;
	      }
	    }
	  }

	  public void main_menu() {
	    while(true) {
	      print_status();
	      int choice = printMenu("Main", new String[]{
	        "Garage Entry ",
	        "Garage Exit ",
	        "Garage Management",
	        "Exit Program"
	      });

	      switch (choice) {
	        case 1: // stuff
	          //EntryViewer entryViewer = new EntryViewer(garage);
	          //entryViewer.run();
	          // this.garage_entryViewer_menu();
	        	entryMenu();
	          break;
	        case 2:
	          //ExitgarageController exit_garage = new ExitgarageController(garage);
	          //exit_garage.run();
	        	exitMenu();
	          break;
	        case 3:
	          garage_management();
	          break;
	        case 4:
	          return;
	        case 5:
	          return;
	        default:
	          System.out.println("Unknown option.");
	          break;
	      }
	    }
	  }
	  
	  public void entryMenu() {
		    while(true) {
		    	this.print_status();
		      int choice =printMenu("Garage Entry ", new String[]{
		        "Purchase Ticket",
		        "Return to Main Menu"
		      });
		      switch (choice) {
		        case 1:
		          purchaseMenu();
		          break;
		        case 2:
		          return;
		        default:
		          System.out.println("Unknown option.");
		          break;
		      }
		    }
		  }


	  public void purchaseMenu() {
		  	if(garage.sign.getStatus()==signStatus.available)
		  	{
			    Ticket ticket = garage.purchase_ticket();
			    garage.print_ticket(ticket);
			    System.out.println("Generated ticket # " + ticket.getId());
			    //System.out.println("Entry Time: " + ticket.getEntryTime());
			    System.out.println("Entry Time: " + dateFormat.format(ticket.getEntryTime()));
			    //String ticket_printed = prompt_string("[Ticket printed? Y/n] ", "y");
			    String ticket_printed = printString("[Ticket printed? Y/N] ", "y");
			    if(!ticket_printed.equals("y")) {
			      garage.printing_failed(ticket);
			      System.out.println("Printing error - Ticket is VOIDED.");
			    } else {		      
			        garage.enter_success(ticket);
			        System.out.println(" You have entered garage.");
			      }
			    printContinue();
			  }
		  	else
		  	{
		  		System.out.println("Garage is FULL.");
			      //prompt_continue();
			      printContinue();
			      return;
		  	}
		  	
		  }
	  
	  public void exitMenu() {
		    while(true) {
		    	this.print_status();
		      int choice =printMenu("Garage Exit ", new String[]{
		        "Payment Ticket",
		        "Return to Main Menu"
		      });
		      switch (choice) {
		        case 1:
		        	getTicketID();
		        	ticket =garage.getTicket(ticketID);
		        	if(ticket == null) 
		        	{
		        		System.out.println("\nInvalid ticket ID.\n"); 
		        		printContinue(); 
		        		break;
		        	}
		        	Date now = new Date();
		        	ticket.setExitTime(now );
					amountDue = ticket.calculateFee(garage.getFeeRate());
					System.out.println("\nAmount due: " + df.format(amountDue) + "\n"); 
					paymentMenu(amountDue, ticket, false);
					printContinue();
		          break;
		        case 2:
		          return;
		        default:
		          System.out.println("Unknown option.");
		          break;
		      }
		    }
		  }
	  public int getTicketID(){
			System.out.println("Enter ticket ID: ");
			ticketID = input.nextInt();
			return ticketID;
		}
	  
	  public void paymentMenu(double amountDue, Ticket ticket, boolean isFlatRate){
			
			int choice =printMenu("Please Select an option Payment", new String[]{
			        "Cash Payment",
			        "Credit Payment",
			        "Return to Main Menu"
			      });
			switch(choice){
			case 1: 
				System.out.println("Please enter cash amount: ");
				//String ticket_printed = printString("Please enter cash amount: ", "0");
				double paymentAmount = input.nextInt();
				//CashPayment cp = new CashPayment(amountDue, paymentAmount);
				//CashPayment cp = new CashPayment(amountDue, paymentAmount);
				/*
				while(cp.getAmountFee()>0){
					System.out.println("Remaining balance: $"+ df.format(cp.getAmountFee())); 
					System.out.println("Please enter cash: ");
					paymentAmount = input.nextInt();
					cp.makePostCashPayment(paymentAmount);
					}
				*/
				while( paymentAmount < amountDue)
				{
					System.out.println("Cash amount is less than amount due: $"+df.format(amountDue));	
					System.out.println("Please enter again cash amount: ");
					paymentAmount = input.nextInt();
				}
				CashPayment cp = new CashPayment(amountDue, paymentAmount);
				System.out.println("Please take balance change: $" + df.format(cp.getBalanceCash())); 
				 receipt = new Receipt(cp);
				receipt.printReceipt();
				garage.addReceipt(receipt);
				//pause();
				//if(isFlatRate==true)garage.exitGarage(); 
				//if(isFlatRate==false)garage.exitGarage(ticket); 
				garage.exit_success(ticket);
		        System.out.println("[You have exited garage.]");
				break;	
			case 2: 
				System.out.println("Please enter account number (16 digits no dashes): ");
				String accountNum = input.next();
				System.out.println("Please enter expiration date (format MM/yyyy): ");
				String expDate = input.next();
				//CreditPayment ep = new CreditPayment(amountDue, accountNum, expDate);
				CreditPayment ep = new CreditPayment( accountNum, expDate,amountDue);
				while(!ep.isAccountValid()){
					System.out.println("Please enter again account number (16 digits no dashes): ");
					accountNum = input.next();
					System.out.println("Please enter again expiration date (format MM/yyyy): ");
					expDate = input.next();
					
					ep = new CreditPayment( accountNum, expDate,amountDue);
				}
				receipt = new Receipt(ep);
				receipt.printReceipt();
				garage.addReceipt(receipt); 
				garage.exit_success(ticket);
		        System.out.println(" You have exited garage.");
				break;
			case 3: break;
			default:
				System.out.println("Invalid selection.\n");
				paymentMenu(amountDue, ticket, isFlatRate); break;
			}
		}
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Garage garage = new Garage();
		Controller mController = new Controller(garage);
		mController.main_menu();
	  }

	
}
