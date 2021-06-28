package pixeleditor;

import java.util.ArrayList;
//[ "makeSet":["branch","stone","seaWeed"], "resultIt": "axe"]
public class MakeItRules {
    
    private ArrayList<MakeItRule> makeItRules = null;
     
    public MakeItRules() {
        this.makeItRules = new ArrayList<MakeItRule>();
    }
    
    public void addRule(MakeItRule makeItRule) {
        
        this.makeItRules.add(makeItRule);
        
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
    
    public MakeItRule getMakeItRuleByResultIt(It resultIt) throws Exception {
    	
    	 for(int i=0;i<makeItRules.size();i++) {
             MakeItRule t = makeItRules.get(i);
                if(t.getResultIt().equals(resultIt)) {
                	return t;
                }
             
             }
         
         throw new Exception("Not found where result: " + resultIt  );
         
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
 
    public String generate( ArrayList<String> makeList ) {
        
        for(int i=0;i<makeItRules.size();i++) {
            MakeItRule t = makeItRules.get(i);
            if(t.makeListEquals(makeList)) {
                
                
                    return new String(t.getResultIt() );
                
            
            }
        }
        System.out.println( "Not found for " + makeList  );
        return null;
    }
    
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
        for(int i=0;i< this.makeItRules.size();i++) {
            buf.append( this.makeItRules.get(i)+",");
        }    
        return "LookFor rules: "+buf.toString();
        
    }

	
    
}