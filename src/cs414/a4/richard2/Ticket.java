package cs414.a4.richard2;

import org.joda.time.*;

class Ticket {

  //private static int current_id = 0;

  private TicketTransaction ticketTrans;

  private int id; /** Simple integer-based ticket number */
  private DateTime entryTime;
  private DateTime exitTime;
  private boolean isExist = false;
  private boolean isPaid = false;
  private boolean isVoid = false;
  // private Payment payment;

  public Ticket(TicketTransaction ticketTrans) {    
    this.ticketTrans = ticketTrans;
    //this.id = ticketTrans.increaseId();
  }
  
  public Ticket(int ticketId) {    
	    this.id = ticketId;
	  }

  /* Accessors */

  public int getId() { return id; }
  public void setId(int m_Id) { this.id = m_Id; }

  public DateTime getEntryTime() { return entryTime; }
  
  Ticket setEntryTime(DateTime m_entryTime) {
    this.entryTime = m_entryTime;
    return this;
  }
  public Ticket enter_now() {
	entryTime = new DateTime();
	setIsExist(true);
    return this;
  }

  public DateTime getExitTime() { return this.exitTime; }
  public Ticket getExitTime(DateTime new_exit_time) {
	this.exitTime = new_exit_time;
    return this;
  }
  
  public Ticket exitNow() {
	  this.exitTime = new DateTime();
	  setIsExist(false);
    return this;
  }

  public boolean getIsExist() { return this.isExist; }
  public Ticket setIsExist(boolean new_isExist) {
	this.isExist = new_isExist;
	//ticketTrans.updateSpace();
    return this;
  }

  public boolean isPaid() { return isPaid; }
  public Ticket isPaid(boolean m_isPaid) {
    isPaid = m_isPaid;
    return this;
  }

  /*
  // Helper for testing
  public static void reset_ids() {
    current_id = 0;
  }
  */

  public void voidTicket() {
	setIsExist(false);
    this.isVoid = true;
  }

  public double calculateFee(double hourly_rate) {
    DateTime d = new DateTime();
    Hours time_in_garage = Hours.hoursBetween(entryTime, d);
    return hourly_rate * (time_in_garage.getHours() + 1);
  }

}
