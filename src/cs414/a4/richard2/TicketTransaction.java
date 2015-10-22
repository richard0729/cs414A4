package cs414.a4.richard2;

import java.util.*;


class TicketTransaction {

  private List<Ticket> tickets = new ArrayList<Ticket>();

  private Sign capacitySign;
  private int max_capacity;
  private int numCount =0;

  public TicketTransaction() { }
  public TicketTransaction(Sign capacitySign, int max_capacity) {
    this.capacitySign = capacitySign;
    this.max_capacity = max_capacity;
  }
  
  public int increaseId() {
	    ++numCount;
	    return numCount;
	  }

  public TicketTransaction max_capacity(int new_capacity) {
    max_capacity = new_capacity;
    return this;
  }

  public Ticket issueTicket() {
    //Ticket mTicket = new Ticket(this.increaseId());
	Ticket mTicket = new Ticket(this);
    tickets.add(mTicket);
    return mTicket;
  }

  public Ticket get_ticket_by_id(int id) {
    try {
      return tickets.get(id);
    }
    catch (java.lang.IndexOutOfBoundsException e) {
      return null;
    }
  }

  /** Return a list of active tickets, tickets in the garage */
  public List<Ticket> get_active_tickets() {
    List<Ticket> active_tickets = new ArrayList<Ticket>();
    for(Ticket t : tickets) {
      if(t.is_in_garage()) {
        active_tickets.add(t);
      }
    }
    return active_tickets;
  }

  public void update_capacity() {
    int ticket_count = get_active_tickets().size();
    if(ticket_count > max_capacity) {
      throw new IllegalStateException("Garage OverFull");
    }
    update_sign();
  }

  public boolean is_full() {
    int ticket_count = get_active_tickets().size();
    return ticket_count >= max_capacity;
  }

  public void update_sign() {
    if(is_full()) {
    	capacitySign.full();
    } else {
    	capacitySign.available();
    }
  }

}

