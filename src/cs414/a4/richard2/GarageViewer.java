package cs414.a4.richard2;

import java.text.DecimalFormat;
import org.joda.time.DateTime;

public class GarageViewer extends Viewer  {

	private Garage garage;
	  //private GarageView garage_view;

	  public GarageViewer(Garage garage) {
	    this.garage = garage;
	    //garage_view = new GarageView(garage);
	  }

	  public void print_status() {
	    //clearscreen();
	    //garage_view.print_garage_status();
		  this.print_garage_status();
	  }
	  
	  public void print_garage_status() {
		    DateTime now = new DateTime();
		    System.out.print("Entrace Gate: " + garage.entrance_gate.state_as_string());
		    System.out.print("\tExit Gate: " + garage.exit_gate.state_as_string());
		    System.out.print("\tSign: " + garage.capacity_sign.status_as_string());
		    System.out.println("");
		    // System.out.println("Capacity: " + garage.capacity_sign.status_as_string());
		    System.out.print("Current time: " + now.toString("KK:mm aa"));
		    // System.out.print("\t     Rate: " + String.format("$%0.02f/hr", garage.hourly_rate()));
		    DecimalFormat money = new DecimalFormat("$0.00");
		    double rate = garage.hourly_rate();
		    System.out.print("\t     Rate: " + money.format(rate) + "/hr");
		    System.out.print("\tCapacity: " + garage.ticketTrans.getActiveTickets().size() + "/" + garage.max_capacity());
		    System.out.println("");
		    System.out.println("");
		  }


	  public void modify_rate() {
	    String new_rate_string = prompt_string("New rate ($/hr): ", "");
	    double new_rate;
	    try {
	      new_rate = Double.parseDouble(new_rate_string);
	    }
	    catch (NumberFormatException e) {
	      System.out.println("Invalid rate!");
	      return;
	    }
	    if(new_rate <= 0.0) {
	      System.out.println("Invalid rate!");
	      return;
	    }
	    garage.hourly_rate(new_rate);
	  }

	  public void modify_max_capacity() {
	    String new_max_capacity_string = prompt_string("New max capacity: ", "");
	    int new_max_capacity;
	    try {
	      new_max_capacity = Integer.parseInt(new_max_capacity_string);
	    }
	    catch (NumberFormatException e) {
	      System.out.println("Invalid max capacity!");
	      return;
	    }
	    if(new_max_capacity <= 0) {
	      System.out.println("Invalid max capacity!");
	      return;
	    }
	    garage.max_capacity(new_max_capacity);
	  }

	  public void garage_management() {
	    while(true) {
	      print_status();
	      int choice = prompt_menu("Garage Management", new String[]{
	        "Modify rate",
	        "Modify maximum capacity",
	        // "Occupation reports",
	        "[Return to Main Menu]"
	      });

	      switch (choice) {
	        case 1:
	          modify_rate();
	          break;
	        case 2:
	          modify_max_capacity();
	          break;
	        case 4:
	          // occupapation_report_menu();
	          return;
	        case 5:
	          return;
	        default:
	          System.out.println("Unknown option.");
	          break;
	      }
	    }
	  }

	  public void main_menu() {
	    while(true) {
	      print_status();
	      int choice = prompt_menu("Main", new String[]{
	        "Garage Entrance Kiosk",
	        "Garage Exit Kiosk",
	        "Garage Management",
	        "[Exit Simulator]"
	      });

	      switch (choice) {
	        case 1: // stuff
	          EntryViewer entrance_kiosk = new EntryViewer(garage);
	          entrance_kiosk.run();
	          // this.garage_entrance_kiosk_menu();
	          break;
	        case 2:
	          //ExitKioskController exit_kiosk = new ExitKioskController(garage);
	          //exit_kiosk.run();
	          break;
	        case 3:
	          garage_management();
	          break;
	        case 4:
	          return;
	        case 5:
	          return;
	        default:
	          System.out.println("Unknown option.");
	          break;
	      }
	    }
	  }

	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Garage garage = new Garage();
	    GarageViewer garage_controller = new GarageViewer(garage);
	    garage_controller.main_menu();
	  }

	

}
