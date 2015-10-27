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
		    int capacity = garage.getMaxSpaces() - garage.getUsedSpaces();
		    System.out.print("Entry Gate: " + garage.entryGate.state_as_string());
		    //System.out.print("\tExit Gate: " + garage.exit_gate.state_as_string());
		    //System.out.print("\tSign: " + garage.sign.status_as_string());
		    System.out.print("\tSign Garage: " + garage.sign.getStatus());
		    System.out.println("");
		    // System.out.println("Capacity: " + garage.capacity_sign.status_as_string());
		    System.out.print("Current time: " + now.toString("KK:mm aa"));
		    // System.out.print("\t     Rate: " + String.format("$%0.02f/hr", garage.hourly_rate()));
		    DecimalFormat money = new DecimalFormat("$0.00");
		    double rate = garage.getFeeRate();
		    System.out.print("\t     Rate: " + money.format(rate) + "/hr");
		    //System.out.print("\tCapacity: " + garage.ticketTrans.getActiveTickets().size() + "/" + garage.getMaxSpaces());
		    System.out.print("\t	Max Spaces: " + garage.getMaxSpaces());
		    System.out.print("\t	Capacity: " + capacity );
		    System.out.println("");
		    System.out.println("");
		  }


	  public void modify_rate() {
	    String input = printString("New rate ($/hr): ", "");
	    double newRate;
	    try {
	    	newRate = Double.parseDouble(input);
	    }
	    catch (NumberFormatException e) {
	      System.out.println("Invalid rate!");
	      return;
	    }
	    if(newRate <= 0.0) {
	      System.out.println("Invalid rate!");
	      return;
	    }
	    garage.setFeeRate(newRate);
	  }

	  public void modify_max_capacity() {
	    String input = printString("New max Spaces: ", "");
	    int newMax;
	    try {
	    	newMax = Integer.parseInt(input);
	    }
	    catch (NumberFormatException e) {
	      System.out.println("Invalid max Spaces!");
	      return;
	    }
	    if(newMax <= 0) {
	      System.out.println("Invalid max Spaces!");
	      return;
	    }
	    garage.setMaxSpaces(newMax);
	  }

	  public void garage_management() {
	    while(true) {
	      print_status();
	      int choice = printMenu("Garage Management", new String[]{
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
	      int choice = printMenu("Main", new String[]{
	        "Garage Entry Kiosk",
	        "Garage Exit Kiosk",
	        "Garage Management",
	        "[Exit Simulator]"
	      });

	      switch (choice) {
	        case 1: // stuff
	          EntryViewer entryViewer = new EntryViewer(garage);
	          entryViewer.run();
	          // this.garage_entryViewer_menu();
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
	    GarageViewer mViewer = new GarageViewer(garage);
	    mViewer.main_menu();
	  }

	

}
