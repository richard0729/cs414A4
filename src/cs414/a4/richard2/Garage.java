package cs414.a4.richard2;

public class Garage {

	
	  public Sign capacity_sign;

	  public EntryKiosk entrance_kiosk;
	  public Gate entrance_gate;

	  //public ExitKiosk exit_kiosk;
	  public Gate exit_gate;

	  public TicketTransaction ticketTrans;

	  public double hourly_rate = 5.0;
	  public int max_capacity = 3;

	  public Garage() {
	    capacity_sign  = new Sign();
	    ticketTrans       = new TicketTransaction(capacity_sign, max_capacity);
	    entrance_gate  = new Gate();
	    entrance_kiosk = new EntryKiosk(entrance_gate, ticketTrans);
	    exit_gate      = new Gate();
	    //exit_kiosk = new ExitKiosk(exit_gate, ticketTrans);
	  }

	  public EntryKiosk entrance_kiosk() {
	    return entrance_kiosk;
	  }

	  /*
	  public ExitKiosk exit_kiosk() {
	    return exit_kiosk;
	  }
	  */

	  public double hourly_rate() { return hourly_rate; }
	  public Garage hourly_rate(double new_rate) {
	    hourly_rate = new_rate;
	    return this;
	  }

	  public int max_capacity() { return max_capacity; }
	  public Garage max_capacity(int new_capacity) {
	    max_capacity = new_capacity;
	    ticketTrans.setMaxSpaces(new_capacity);
	    ticketTrans.updateSpace();
	    return this;
	  }

	  
}
