package pixeleditor;

import java.util.ArrayList;
import java.util.Arrays;

//[ "beforeItems":["branch","stone","seaWeed"], ["afterItems": "axe"]
public class UniversalRule {
    
    
    private ArrayList<String> beforeItems = null; //id11...id1N
    private ArrayList<String> afterItems = null; //id21...id2M
    
    public UniversalRule( ArrayList<String> beforeItems, ArrayList<String> afterItems ) {
        this.beforeItems = beforeItems;
        this.afterItems = afterItems;
        
    } 

    public String toString() {
    	return  ""+ toStr(this.beforeItems) + " -> " + toStr(this.afterItems);     
    }

	public static String toStr(ArrayList<String> makeSet2) {
		String r="";
		for(String s : makeSet2) {
			String name = ModelMap.getTypesOfItems().getById(s).getEnLocaleName();
			r += (name+","); 
		}
		return r;
	}
	
	public static ArrayList<String> fromStr(String r) {
		ArrayList<String> list =  new ArrayList<String>(Arrays.asList(r.split(","))); 
		return list;
	}

	public static boolean listEquals(ArrayList<String> fList, ArrayList<String> sList) {
		ArrayList<String> ts = cloneMakeSet(fList);
		for(String s : sList) {
			if(ts.contains(s)) {
				ts.remove(s);
			}
			
		}
		if((ts.size()==0) && ( fList.size() == sList.size() )) return true;
		return false;
	}

	private static ArrayList<String> cloneMakeSet(ArrayList<String> makeSet2) {
		ArrayList<String> ts = new ArrayList<String>();
		for(String s : makeSet2)  ts.add(s);
		return ts;
	}
	
	public ArrayList<String> getBeforeItems() {
		 
		return this.beforeItems;
	}
	
	public ArrayList<String> getAfterItems() {
		 
		return this.afterItems;
	}

	       

}