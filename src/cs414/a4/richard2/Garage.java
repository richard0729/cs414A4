package cs414.a4.richard2;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Garage {

	
	public Sign sign;

	public EntryKiosk entry;
	public Gate entryGate;

	  public ExitKiosk exitKiosk;
	  private Gate exit_gate;
	  
	  private int maxSpaces = 3;
	  public int usedSpaces = 0;
	  
	  //public Spaces spaces;

	  //private TicketTransaction ticketTrans;

	  private double feeRate = 10.0;
	  
	  private List<Ticket> ticketTrans = new ArrayList<Ticket>();
	  private List<Ticket> activeTickets = new ArrayList<Ticket>();
	  private List<Receipt> receipts = new ArrayList<Receipt>();

	  //private Sign sign;
	  //private int maxSpaces;
	  private int numCount =0;
	  private Spaces spaces;
	  //private Garage garage;
	  

	  public Garage() {
	    sign  = new Sign();
	    //spaces = new Spaces();
	    //ticketTrans       = new TicketTransaction(sign, spaces);
	    //ticketTrans       = new TicketTransaction(this);
	    entryGate  = new Gate();
	    //entry = new EntryKiosk(entryGate, ticketTrans);
	    exit_gate      = new Gate();
	    //exit_kiosk = new ExitKiosk(exit_gate, ticketTrans);
	  }

	  public EntryKiosk getEntry() {
	    return entry;
	  }
	  
	  public ExitKiosk getExit() {
		    return exitKiosk;
	  }

	  /*
	  public ExitKiosk exit_kiosk() {
	    return exit_kiosk;
	  }
	  */

	  public double getFeeRate() { return feeRate; }
	  public Garage setFeeRate(double newRate) {
	    feeRate = newRate;
	    return this;
	  }

	  public int getMaxSpaces() { return maxSpaces; }
	  public Garage setMaxSpaces(int newMax) {
	    maxSpaces = newMax;
		 // this.spaces.setMaxSpaces(newMax); 
	    //ticketTrans.setMaxSpaces(new_capacity);
	    updateSpace();
	    return this;
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
	    //Ticket mTicket = new Ticket(this.increaseId());
		//this.increaseId();
		++numCount;
		Ticket mTicket = new Ticket(numCount);
		//mTicket.setId(this.increaseId());	
		DateTime m_entryTime = new DateTime();
		mTicket.setEntryTime(m_entryTime);
		this.ticketTrans.add(mTicket);
	    return mTicket;
	  }

	  public Ticket getTicket(int id) {
	    try {
	      return ticketTrans.get(id);
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


	  public void updateSpace() {
		  boolean mFull = isFull();
		  //sign.updateSign(mFull);
		  sign.updateSign(mFull);
	  }
	  
	  public boolean isFull() {
		int msize = getActiveTickets().size();
		setUsedSpaces(msize);
	    //return garage.usedSpaces >= this.spaces.getMaxSpaces();
		return msize >= this.getMaxSpaces();
	  }
	  
	  public void addReceipt(Receipt r){
			receipts.add(r);
		}
}
