package cs414.a4.richard2;


class EntryKiosk {
	  private Gate gate;
	  private TicketTransaction ticketTrans;

	  public EntryKiosk(Gate gate, TicketTransaction ticketTrans) {
	    this.gate = gate;
	    this.ticketTrans = ticketTrans;
	  }

	  public Ticket purchase_ticket() {
	    return ticketTrans.issueTicket();
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
	    ticketTrans.updateSpace();
	  }

	  public boolean can_purchase() {
	    return ! ticketTrans.isFull();
	  }

	  public String no_purchase_reason() {
	    if(ticketTrans.isFull()) {
	      return "Garage is full.";
	    }
	    return null;
	  }

	}
