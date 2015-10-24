package cs414.a4.richard2;

class Entrance {
	  private Gate gate;
	  private TicketRegistry registry;

	  public EntranceKiosk(Gate gate, TicketRegistry registry) {
	    this.gate = gate;
	    this.registry = registry;
	  }

	  public Ticket purchase_ticket() {
	    return registry.get_new_ticket();
	  }

	  public void print_ticket(Ticket ticket) {
	    // ... hardware trigger hardware print
	  }

	  public void printing_failed(Ticket ticket) {
	    ticket.void_ticket();
	  }

	  public void gate_failed(Ticket ticket) {
	    ticket.void_ticket();
	  }

	  public void enter_success(Ticket ticket) {
	    gate.auto_open();
	    ticket.enter_now();
	    registry.update_sign();
	  }

	  public boolean can_purchase() {
	    return ! registry.is_full();
	  }

	  public String no_purchase_reason() {
	    if(registry.is_full()) {
	      return "Garage is full.";
	    }
	    return null;
	  }

	}
