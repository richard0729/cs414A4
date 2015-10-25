package cs414.a4.richard2;

public class EntryViewer extends Viewer {

	private Garage garage;
	  private GarageViewer garage_view;
	  private EntryKiosk kiosk;

	  public EntryViewer(Garage garage) {
	    this.garage = garage;
	    garage_view = new GarageViewer(garage);
	    kiosk = garage.entrance_kiosk();
	  }
	  /*
	  public void print_status() {
	    clearscreen();
	    garage_view.print_garage_status();
	  }
		*/
	  public void purchase_ticket() {
	    if(! kiosk.can_purchase()) {
	      System.out.println("Cannot purchase ticket: " + kiosk.no_purchase_reason());
	      prompt_continue();
	      return;
	    }
	    Ticket ticket = kiosk.purchase_ticket();
	    kiosk.print_ticket(ticket);
	    System.out.println("Generated ticket # " + ticket.getId());
	    String ticket_printed = prompt_string("[Ticket printed? Y/n] ", "y");
	    if(!ticket_printed.equals("y")) {
	      kiosk.printing_failed(ticket);
	      System.out.println("Printing error - Ticket VOIDED. Sorry.");
	    } else {
	      String gate_opened = prompt_string("[Gate opened? Y/n] ", "y");
	      if(!gate_opened.equals("y")) {
	        kiosk.gate_failed(ticket);
	        System.out.println("Gate error - Ticket VOIDED. Sorry.");
	      } else {
	        kiosk.enter_success(ticket);
	        System.out.println("[Gate auto open/close. You have entered garage.]");
	      }
	    }
	    prompt_continue();
	  }

	  public void run() {
	    while(true) {
	    	garage_view.print_status();
	      int choice = prompt_menu("Garage Entrance Kiosk", new String[]{
	        "Purchase Ticket",
	    //    "Maintenance Mode",
	        "[Test System - Return to Main Menu]"
	      });
	      switch (choice) {
	        case 1:
	          purchase_ticket();
	          break;
	        case 2:
	          return;
	        case 3:
	          return;
	        default:
	          System.out.println("Unknown option.");
	          break;
	      }
	    }
	  }

	  
}
