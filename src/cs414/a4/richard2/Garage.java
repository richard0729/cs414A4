package cs414.a4.richard2;

import java.util.ArrayList;
import java.util.List;

//import org.joda.time.Date;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Garage {

	
	public Sign sign;

	//public EntryKiosk entry;
	public Gate entryGate;

	  //public ExitKiosk exitKiosk;
	  private Gate exitGate;
	  
	  private int maxSpaces = 3;
	  public int usedSpaces = 0;
	  
	  //public Spaces spaces;

	  //private TicketTransaction ticketTrans;

	  private double feeRate = 10.0;
	  
	  private List<Ticket> ticketTrans = new ArrayList<Ticket>();
	  private List<Ticket> activeTickets = new ArrayList<Ticket>();
	  private List<Receipt> receipts = new ArrayList<Receipt>();
	  private List<Ticket> usageTickets = new ArrayList<Ticket>();

	  //private Sign sign;
	  //private int maxSpaces;
	  private int numCount =0;
	  private Spaces spaces;
	  //private this this;
	  

	  public Garage() {
	    sign  = new Sign();
	    //spaces = new Spaces();
	    //ticketTrans       = new TicketTransaction(sign, spaces);
	    //ticketTrans       = new TicketTransaction(this);
	    entryGate  = new Gate(GateType.entry);
	    //entry = new EntryKiosk(entryGate, ticketTrans);
	    exitGate      = new Gate(GateType.exit);
	    //exit_kiosk = new ExitKiosk(exit_gate, ticketTrans);
	  }

	  

	  /*
	  public ExitKiosk exit_kiosk() {
	    return exit_kiosk;
	  }
	  */

	  public double getFeeRate() { return feeRate; }
	  public void setFeeRate(double newRate) {
	    feeRate = newRate;
	  }

	  public int getMaxSpaces() { return maxSpaces; }
	  public void setMaxSpaces(int newMax) {
	    maxSpaces = newMax;
		 // this.spaces.setMaxSpaces(newMax); 
	    //ticketTrans.setMaxSpaces(new_capacity);
	    updateSpace();
	  }
	  
	  public int getUsedSpaces() { return usedSpaces; }
	  public void setUsedSpaces(int newUsed) {
		  usedSpaces = newUsed;
		 // this.spaces.setMaxSpaces(newMax); 
	    //ticketTrans.setMaxSpaces(new_capacity);
	    //ticketTrans.updateSpace();
	    //return this;
	  }

	  
	  public int increaseId() {
		    ++numCount;
		    return numCount;
		  }

	  public Ticket issueTicket() {
		++numCount;
		Ticket mTicket = new Ticket(numCount);
		//mTicket.setId(this.increaseId());	
		Date m_entryTime = new Date();
		mTicket.setEntryTime(m_entryTime);
		this.ticketTrans.add(mTicket);
	    return mTicket;
	  }

	  public Ticket getTicket(int id) {
	    try {
	      //return ticketTrans.get(id);
	    	for(Ticket ticket : activeTickets){
				if(ticket.getId()==id){
					return ticket;
				}
			}
			return null;
	    }
	    catch (java.lang.IndexOutOfBoundsException e) {
	      return null;
	    }
	  }

	  public List<Ticket> getActiveTickets() {
	    activeTickets = new ArrayList<Ticket>();
	    for(Ticket t : ticketTrans) {
	      if(t.getIsExist()) {
	        activeTickets.add(t);
	      }
	    }
	    return activeTickets;
	  }

	  public List<Ticket> getUsageTickets() {
		usageTickets = new ArrayList<Ticket>();
	    for(Ticket t : ticketTrans) {
	      if(!t.getIsVoid()) {
	    	  usageTickets.add(t);
	      }
	    }
	    return usageTickets;
	  }	  

	  public void updateSpace() {
		  boolean mFull = isFull();
		  //sign.updateSign(mFull);
		  sign.updateSign(mFull);
	  }
	  
	  public boolean isFull() {
		int msize = getActiveTickets().size();
		setUsedSpaces(msize);
	    //return this.usedSpaces >= this.spaces.getMaxSpaces();
		//return msize >= this.getMaxSpaces();
		return msize >= this.maxSpaces;
	  }
	  
	  public void addReceipt(Receipt r){
			receipts.add(r);
		}

	  public Ticket purchase_ticket() {
	    //return ticketTrans.issueTicket();
		  return this.issueTicket();
	  }

	  public void print_ticket(Ticket ticket) {
	    // ... hardware trigger hardware print
	  }

	  public void printing_failed(Ticket ticket) {
	    ticket.voidTicket();
	  }

	  public void gate_failed(Ticket ticket) {
	    ticket.voidTicket();
	  }

	  public void enter_success(Ticket ticket) {
		//entryGate.auto_open();
		entryGate.openGate();
	    ticket.enter_now();
	    entryGate.closeGate();
	    //ticketTrans.update_sign();
	    //ticketTrans.updateSpace();
	    this.updateSpace();
	  }
	  
	  //Exit
	  public void exit_success(Ticket ticket) {
		  //entryGate.auto_open();
		  exitGate.openGate();  
		  ticket.exitNow();
		  exitGate.closeGate();
		    //registry.update_sign();
		    this.updateSpace();
		  }
	  
	  public Ticket get_ticket(int ticket_id) {
		    //Ticket t = registry.get_ticket_by_id(ticket_id);
		    //if(t == null || ! t.is_in_this()) {
			  Ticket t =  this.getTicket(ticket_id);
			  if(t == null || ! t.getIsExist()) {
		      return null;
		    }
		    return t;
		  }

		  public boolean process_payment(Ticket ticket, String ccard, double amount) {
		    ticket.isPaid(true);
		    return true;
		  }
		  public String provide_ticket(String input_ticket) {
			    int ticket_id;
			    try {
			      ticket_id = Integer.parseInt(input_ticket);
			    }
			    catch (java.lang.NumberFormatException e) {
			      return "Invalid ticket #";
			    }
			    Ticket ticket = get_ticket(ticket_id);
			    if(ticket == null) {
			      return "Ticket not found!";
			    }

			    System.out.println("Accepted ticket # " + ticket.getId());

			    double hourly_rate = this.getFeeRate();
			    double payment_amount = ticket.calculateFee(hourly_rate);
			    return "";
			    /*
			    return
			      "Charge: "
			      + ticket.get_time_in_this()
			      + " hours @ "
			      + NumberFormat.getInstance().format(hourly_rate)
			      + "/hr = "
			      + NumberFormat.getCurrencyInstance().format(payment_amount)
			      + " TOTAL";
				*/
			  }
		  /*
		  public String pay_for_ticket(String input_ticket, String ccard, String want_receipt) {
		    int ticket_id;
		    try {
		      ticket_id = Integer.parseInt(input_ticket);
		    }
		    catch (java.lang.NumberFormatException e) {
		      return "Invalid ticket #";
		    }
		    Ticket ticket = get_ticket(ticket_id);
		    double hourly_rate = this.hourly_rate();
		    double payment_amount = ticket.calculate_charge(hourly_rate);
		    if(process_payment(ticket, ccard, payment_amount)) {
		      System.out.println("Payment Accepted.");
		      if(want_receipt.equals("y")) {
		        print_receipt(ticket);
		        System.out.println("[Receipt Printed]");
		      }
		      exit_success(ticket);
		      System.out.println("[Gate auto open/close. You have exited this.]");
		      return "[You have exited]";
		    } else {
		      System.out.println("Payment Rejected!");
		      return "Payment Rejected!";
		    }
		  }
		*/
}
