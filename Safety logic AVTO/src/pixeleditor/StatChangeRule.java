package pixeleditor;

public class StatChangeRule {
    
    
    private String eventId = "unknown";
    private String statId = "unknown";
    private int diff  = 0;
    
    public StatChangeRule( String eventId, String statId, int diff ) {
        this.eventId = new String(eventId);
        this.statId = new String(statId);
        this.diff = diff;
    } 
         

    public String toString() {
        return  this.eventId + " -> " + this.statId + " diff: "+this.diff;     
    }


	public String getEventId() {
		
		return this.eventId;
	}


	public String getStatId() {
		
		return this.statId;
	}


	public int getDiff() {
		
		return this.diff;
	}        

}