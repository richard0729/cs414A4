package cs414.a4.richard2;


class EntryKiosk {
	  private Gate gate;
	  //private TicketTransaction ticketTrans;
	  private Garage garage;

	  /*
	  public EntryKiosk(Gate gate, TicketTransaction ticketTrans) {
	    this.gate = gate;
	    this.ticketTrans = ticketTrans;
	  }
	  */
	  public EntryKiosk(Garage m_garage)
	  {
		  garage = m_garage;
		  
	  }

	  public Ticket purchase_ticket() {
	    //return ticketTrans.issueTicket();
		  return garage.issueTicket();
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
	    gate.auto_open();
	    ticket.enter_now();
	    //ticketTrans.update_sign();
	    //ticketTrans.updateSpace();
	    garage.updateSpace();
	  }

	  public boolean can_purchase() {
	    //return ! ticketTrans.isFull();
		  return ! garage.isFull();
	  }

	  public String no_purchase_reason() {
	    //if(ticketTrans.isFull()) {
		  if(garage.isFull()) {
	      return "Garage is full.";
	    }
	    return null;
	  }

	}
