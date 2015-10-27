package cs414.a4.richard2;

import java.util.*;

import org.joda.time.DateTime;


class TicketTransaction {
/*
  private List<Ticket> tickets = new ArrayList<Ticket>();
  private List<Ticket> activeTickets = new ArrayList<Ticket>();

  //private Sign sign;
  //private int maxSpaces;
  private int numCount =0;
  private Spaces spaces;
  private Garage garage;

  public TicketTransaction() { }
  public TicketTransaction(Garage mGarage) {
    this.garage = mGarage;
    //this.maxSpaces = maxSpaces;
    //this.spaces = mSpaces;
  }
  
  public int increaseId() {
	    ++numCount;
	    return numCount;
	  }

  public Ticket issueTicket() {
    //Ticket mTicket = new Ticket(this.increaseId());
	//this.increaseId();
	Ticket mTicket = new Ticket(this);
	mTicket.setId(this.increaseId());	
	DateTime m_entryTime = new DateTime();
	mTicket.setEntryTime(m_entryTime);
	this.tickets.add(mTicket);
    return mTicket;
  }

  public Ticket getTicket(int id) {
    try {
      return tickets.get(id);
    }
    catch (java.lang.IndexOutOfBoundsException e) {
      return null;
    }
  }

  public List<Ticket> getActiveTickets() {
    activeTickets = new ArrayList<Ticket>();
    for(Ticket t : tickets) {
      if(t.getIsExist()) {
        activeTickets.add(t);
      }
    }
    return activeTickets;
  }


  public void updateSpace() {
	  boolean mFull = isFull();
	  //sign.updateSign(mFull);
	  garage.sign.updateSign(mFull);
  }
  
  public boolean isFull() {
	int msize = getActiveTickets().size();
	garage.setUsedSpaces(msize);
    //return garage.usedSpaces >= this.spaces.getMaxSpaces();
	return msize >= this.garage.getMaxSpaces();
  }
*/
  
}


