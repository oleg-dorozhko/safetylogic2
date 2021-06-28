package pixeleditor;

import java.util.ArrayList;
//[ "makeSet":["branch","stone","seaWeed"], "resultIt": "axe"]
public class UniversalRules {
    
    private ArrayList<UniversalRule> universalRules = null;
     
    public UniversalRules() {
        this.universalRules = new ArrayList< UniversalRule>();
    }
    
    public void addRule(UniversalRule makeItRule) {
        
        this.universalRules.add(makeItRule);
        
    }
    
    public UniversalRule getUniversalRule(ArrayList<String> beforeItems, ArrayList<String> afterItems) throws Exception {
    	for(int i=0;i<universalRules.size();i++) {
            UniversalRule t = universalRules.get(i);
            if( UniversalRule.listEquals(t.getBeforeItems(), beforeItems)) {
            if( UniversalRule.listEquals(t.getAfterItems(), afterItems)) return t;    
            }
            }
        
        throw new Exception("Not found rule: " + new UniversalRule(beforeItems,afterItems));
    }
    
    
    
    
//    public boolean hasRuleFor( ) {
//        
//        for(int i=0;i<makeItRules.size();i++) {
//            MakeItRule t = makeItRules.get(i);
//            if( t.generator.(place.getId())) {
//                
//                if(item.getId().equals(t.thing) ) return true;
//            
//            }
//        }
//        return false;
//    }
    
    public ArrayList<UniversalRule> getUniversalRules() {
		return universalRules;
	}

	public UniversalRule getUniversalRuleByAfterItems(ArrayList<String> afterItems) throws Exception {
    	
    	 for(int i=0;i<universalRules.size();i++) {
             UniversalRule t = universalRules.get(i);
             if( UniversalRule.listEquals(t.getAfterItems(), afterItems)) return t;    
             
             }
         
         throw new Exception("Not found where result: " + UniversalRule.toStr(afterItems)  );
         
	}
    
// public String getMakeListByResultIt(It resultIt ) {
//         
//	    ArrayList<It> makeList = new ArrayList<String>();
//         
//        for(int i=0;i<makeItRules.size();i++) {
//            MakeItRule t = makeItRules.get(i);
//            if(t.getResultIt().equals(resultIt)) {
//                
//                
//                    makeList.add( t.getResultIt()) ;
//                
//            
//            }
//        }
//        System.out.println( "Not found for " + makeList  );
//        return null;
//    }
	
	public ArrayList<String> lookFor(ArrayList<String> beforeItems) throws Exception {
		
		for(int i=0;i<universalRules.size();i++) {
            UniversalRule t = universalRules.get(i);
            if(UniversalRule.listEquals(t.getBeforeItems(), beforeItems)) {
            	return t.getAfterItems();
            }
        }
        
		throw new Exception("Not found rule for: " + UniversalRule.toStr(beforeItems)  ); 
        
	}

// 
//    public ArrayList<String>  generate( ArrayList<String> beforeItems ) throws Exception {
//        
//        
//    }
    
    // public Place findPlaceByColor(Color color, Color color2) {
        
        // if(color2 !=null) {
            
            // for(int i=0;i<places.size();i++) {
                // Place p = places.get(i);
                // if(p.color.equals(color)) {
                    // if(p.color2!=null ) {
                        // if(p.color2.equals(color2)) return p;
                    // }
                // }
            // }
            
        // }
        // else {
             // for(int i=0;i<places.size();i++) {
                    // Place p = places.get(i);
                    // if(p.color.equals(color)) {
                        
                        // if(p.color2==null ) return p;
                        
                    // }
             // }
        // }
        
        // return null;
        
    // }
    
    // public ObservableList<String> getSelectedItems() {
    //    return this.listView.getSelectionModel().getSelectedItems();
    // }
    
    //public void removeItem(String key) {
       
       // do {
    //        boolean found=false;
    //        for(int i=0;i<items.size();i++) {
    //                if( items.get(i).id.equals(key) ) { items.remove(i); found=true; break; }
    //        }
        
       // }
       // while(found);
        
       // this.items.remove(new Item(key));
        
    //}
    
    // public void toList(ListView listView) {
        
        // this.listView = listView;
        // for(int i=0;i< this.items.size();i++) {
            // listView.getItems().add(""+this.items.get(i).toString());
        // }    
        
    // }
    
    // public void refresh() {
        
        // listView.getItems().clear();
        // for(int i=0;i< this.items.size();i++) {
            // listView.getItems().add(this.items.get(i).toString());
        // }    
        
    // }
    
    public String toString() {
        
        StringBuilder buf = new StringBuilder();
        for(int i=0;i< this.universalRules.size();i++) {
            buf.append( "" + this.universalRules.get(i)+",");
        }    
        return "LookFor rules: "+buf.toString();
        
    }

	
	
    
}