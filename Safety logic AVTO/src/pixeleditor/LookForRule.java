package pixeleditor;

public class LookForRule {
    
    
    private String generator = null;
    private String thing = null;
    private String condition = null;
    
    public LookForRule( String generator, String thing, String condition ) {
        this.setGenerator(generator);
        this.setThing(thing);
        this.setCondition(condition);
    } 

         

    public String toString() {
        //if(color2 == null) return this.id + ": " + this.color.toString();
        return  this.getGenerator() + " -> " + this.getThing() + " (conditions: "+this.getCondition()+" )"; // + ": " + this.color.toString() + ": "  + this.color2.toString();     
    }



	public String getThing() {
		return thing;
	}



	public void setThing(String thing) {
		this.thing = thing;
	}



	public String getGenerator() {
		return generator;
	}



	public void setGenerator(String generator) {
		this.generator = generator;
	}



	public String getCondition() {
		return condition;
	}



	public void setCondition(String condition) {
		this.condition = condition;
	}        

}