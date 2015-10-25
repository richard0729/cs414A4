package cs414.a4.richard2;

import java.util.*;

import org.joda.time.DateTime;


class TicketTransaction {

  private List<Ticket> tickets = new ArrayList<Ticket>();
  private List<Ticket> activeTickets = new ArrayList<Ticket>();

  private Sign capacitySign;
  private int maxSpaces;
  private int numCount =0;

  public TicketTransaction() { }
  public TicketTransaction(Sign capacitySign, int maxSpaces) {
    this.capacitySign = capacitySign;
    this.maxSpaces = maxSpaces;
  }
  
  public int increaseId() {
	    ++numCount;
	    return numCount;
	  }

  public TicketTransaction setMaxSpaces(int newSpaces) {
    maxSpaces = newSpaces;
    return this;
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

  /*
  public void updateSpace() {
    int ticket_count = getActiveTickets().size();
    if(ticket_count > maxSpaces) {
      throw new IllegalStateException("Garage OverFull");
    }
    update_sign();
  }
  */
  public void updateSpace() {
	  boolean mFull = isFull();
	  capacitySign.updateSign(mFull);
  }
  
  public boolean isFull() {
    int ticket_count = getActiveTickets().size();
    return ticket_count >= maxSpaces;
  }
/*
  public void update_sign() {
    if(isFull()) {
    	capacitySign.full();
    } else {
    	capacitySign.available();
    }
*/
  
}


