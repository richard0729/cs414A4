package cs414.a4.richard2;

//import org.joda.time.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Ticket {

  //private static int current_id = 0;

  private TicketTransaction ticketTrans;

  private int id; /** Simple integer-based ticket number */
  private Date entryTime;
  private Date exitTime;
  private boolean isExist = false;
  private boolean isPaid = false;
  private boolean isVoid = false;
  private double HOURS_IN_MILLI = 1000*60*60;
  // private Payment payment;

  public Ticket(TicketTransaction ticketTrans) {    
    this.ticketTrans = ticketTrans;
    //this.id = ticketTrans.increaseId();
  }
  
  public Ticket(int ticketId) {    
	    this.id = ticketId;
	  }

  /* Accessors */
  public boolean getIsVoid() { return isVoid; }
  
  public int getId() { return id; }
  public void setId(int m_Id) { this.id = m_Id; }

  public Date getEntryTime() { return entryTime; }
  
  public void setEntryTime(Date m_entryTime) {
    this.entryTime = m_entryTime;
  }
  
  public Date getExitTime() { return exitTime; }
  
  public void setExitTime(Date m_exitTime) {
    this.exitTime = m_exitTime;
  }
  
  public Ticket enter_now() {
	entryTime = new Date();
	setIsExist(true);
    return this;
  }

  //public Date getExitTime() { return this.exitTime; }
  public Ticket getExitTime(Date new_exit_time) {
	this.exitTime = new_exit_time;
    return this;
  }
  
  public Ticket exitNow() {
	  this.exitTime = new Date();
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
    //Date d = new Date();
    //Hours time_in_garage = Hours.hoursBetween(entryTime, d);
    //Hours time_in_garage = Hours.hoursBetween(entryTime, d);
    //return hourly_rate * (time_in_garage.getHours() + 1);
	  
	  //double hourInGarage =  (exitTime.getTime()/HOURS_IN_MILLI) - (entryTime.getTime()/HOURS_IN_MILLI) +1;            
	  long diff =  exitTime.getTime() - entryTime.getTime();
	  long hourInGarage = diff / (60 * 60 * 1000) % 24 +1;
	  return hourly_rate *hourInGarage;
      
  }

}
