package pixeleditor;

public class GameEvent {
	
	private It stateBefore = null;
	//in use
	private It stateAfter = null;
	private String eventId = null;
	
	public GameEvent(String eventId,  It stateBefore, It stateAfter ) {
		this.eventId = new String(eventId);
		this.setStateBefore(new It(stateBefore));
		this.stateAfter = new It(stateAfter);
	}
	
	public GameEvent equalBoth(It stateBefore, It stateAfter) {
		if(stateBefore.getId().equals(this.stateBefore.getId()) && stateAfter.getId().equals(this.stateAfter.getId())) return this;
		return null;
	}

	public It getStateBefore() {
		return stateBefore;
	}

	public void setStateBefore(It stateBefore) {
		this.stateBefore = stateBefore;
	}

	public It getStateAfter() {
		return stateAfter;
	}

	public void setStateAfter(It stateAfter) {
		this.stateAfter = stateAfter;
	}
	
	public String toString() {
		return ""+this.eventId+" (before: "+this.stateBefore+" after: "+this.stateAfter+")";
	}

	public String getId() {
		
		return this.eventId;
	}
	

}
