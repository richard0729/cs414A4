package cs414.a4.richard2;

class Gate {
  public String state = "closed";

  public void close() {
    state = "closed";
  }

  public void open() {
    state = "open";
  }

  public void auto_open() {
    open();
    close();
  }
  

  public String state_as_string() {
    return state;
  }
  
  private GateType type;
  public Gate(GateType t){
		type = t;		
	}
	
	void closeGate(){		
		System.out.println(type + " gate closed.\n");
	}
	void openGate(){
		System.out.println(type + " gate open.");
	}	
	public GateType getType(){
		return type;
	}
	
	public void autoOpenClose() {
		openGate();
		closeGate();
	  }
  
}
