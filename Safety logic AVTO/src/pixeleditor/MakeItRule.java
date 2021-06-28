package pixeleditor;

import java.util.ArrayList;

//[ "makeSet":["branch","stone","seaWeed"], "resultIt": "axe"]
public class MakeItRule {
    
    
    private ArrayList<String> makeSet = null;
    private String resultIt = null;
    
    public MakeItRule( ArrayList<String> makeSet, String resultIt2 ) {
        this.makeSet = makeSet;
        this.setResultIt(resultIt2);
        
    } 

    public String toString() {
        //if(color2 == null) return this.id + ": " + this.color.toString();
        return  ""+ toStr(this.makeSet) + " -> " + this.getResultIt() ;     
    }

	private String toStr(ArrayList<String> makeSet2) {
		String r="";
		for(String s : makeSet2) r += (s+","); 
		return r;
	}

	public boolean makeListEquals(ArrayList<String> makeList) {
		ArrayList<String> ts = cloneMakeSet(makeSet);
		for(String s : makeList) {
			if(ts.contains(s)) {
				ts.remove(s);
			}
			
		}
		if((ts.size()==0) && ( makeSet.size()==makeList.size() )) return true;
		return false;
	}

	private ArrayList<String> cloneMakeSet(ArrayList<String> makeSet2) {
		ArrayList<String> ts = new ArrayList<String>();
		for(String s : makeSet2)  ts.add(s);
		return ts;
	}
	
	
	public String getResultIt() {
		 
		return this.resultIt;
	}

	public void setResultIt(String resultIt2) {
		this.resultIt = resultIt2;
	}        

}