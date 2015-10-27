package cs414.a4.richard2;

public class Garage {

	
	public Sign sign;

	public EntryKiosk entry;
	public Gate entryGate;

	  //public ExitKiosk exit_kiosk;
	  private Gate exit_gate;
	  
	  private int maxSpaces = 3;
	  public int usedSpaces = 0;
	  
	  //public Spaces spaces;

	  private TicketTransaction ticketTrans;

	  private double feeRate = 10.0;
	  

	  public Garage() {
	    sign  = new Sign();
	    //spaces = new Spaces();
	    //ticketTrans       = new TicketTransaction(sign, spaces);
	    ticketTrans       = new TicketTransaction(this);
	    entryGate  = new Gate();
	    entry = new EntryKiosk(entryGate, ticketTrans);
	    exit_gate      = new Gate();
	    //exit_kiosk = new ExitKiosk(exit_gate, ticketTrans);
	  }

	  public EntryKiosk getEntry() {
	    return entry;
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
	    ticketTrans.updateSpace();
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

	  
}
