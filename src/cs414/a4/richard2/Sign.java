package cs414.a4.richard2;

class Sign {

  private String state = "PARKING AVAILABLE";

  public void available() {
    state = "PARKING AVAILABLE";
  }

  public void full() {
    state = "FULL";
  }

  public String status_as_string() {
    return state;
  }
  
  private signStatus status;
  
  public void updateSign(boolean isFull) {
	  if(isFull)
		  status  = signStatus.full;
	  else
		  status  = signStatus.available;
  }

}
