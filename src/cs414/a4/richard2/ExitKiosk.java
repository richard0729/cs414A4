package cs414.a4.richard2;

public class ExitKiosk {

	private Gate gate = new Gate();
	  //private TicketRegistry registry;
	  private Garage garage;

	  /*
	  public ExitKiosk(TicketRegistry registry, Garage garage)
	  throws RemoteException {
	    this.registry = registry;
	    this.garage = garage;
	  }
	  */
	  
	  public ExitKiosk(Garage m_garage)
	  {
		  garage = m_garage;
		  
	  }

	  public void printing_failed(Ticket ticket) {
	    ticket.voidTicket();
	  }

	  public void gate_failed(Ticket ticket) {
	    ticket.voidTicket();
	  }

	  public void exit_success(Ticket ticket) {
	    gate.auto_open();
	    ticket.exitNow();
	    //registry.update_sign();
	    garage.updateSpace();
	  }

	  public Ticket get_ticket(int ticket_id) {
	    //Ticket t = registry.get_ticket_by_id(ticket_id);
	    //if(t == null || ! t.is_in_garage()) {
		  Ticket t =  garage.getTicket(ticket_id);
		  if(t == null || ! t.getIsExist()) {
	      return null;
	    }
	    return t;
	  }

	  public boolean process_payment(Ticket ticket, String ccard, double amount) {
	    ticket.isPaid(true);
	    return true;
	  }

	  public void print_receipt(Ticket ticket) {
	    // ... hardware trigger hardware print
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

	    double hourly_rate = garage.getFeeRate();
	    double payment_amount = ticket.calculateFee(hourly_rate);
	    return "";
	    /*
	    return
	      "Charge: "
	      + ticket.get_time_in_garage()
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
	    double hourly_rate = garage.hourly_rate();
	    double payment_amount = ticket.calculate_charge(hourly_rate);
	    if(process_payment(ticket, ccard, payment_amount)) {
	      System.out.println("Payment Accepted.");
	      if(want_receipt.equals("y")) {
	        print_receipt(ticket);
	        System.out.println("[Receipt Printed]");
	      }
	      exit_success(ticket);
	      System.out.println("[Gate auto open/close. You have exited garage.]");
	      return "[You have exited]";
	    } else {
	      System.out.println("Payment Rejected!");
	      return "Payment Rejected!";
	    }
	  }
	*/
}
