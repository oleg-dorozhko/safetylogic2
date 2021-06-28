package pixeleditor;

import java.util.ArrayList;

public class GameEvents {
    
    private ArrayList<GameEvent> gameEvents = null;
     
    public GameEvents() {
        this.gameEvents = new ArrayList<GameEvent>();
    }
    
    public void addEvent(GameEvent gameEvent) {
        
        this.gameEvents.add(gameEvent);
        
    }
       
  public GameEvent getEventForTwoState(It st1, It st2) {
  
  for(int i=0;i<gameEvents.size();i++) {
      GameEvent t = gameEvents.get(i);
      t = t.equalBoth( st1, st2);
      if( t != null) {
          
          return t;
      
      }
  }
  System.out.println( "Not found for " + st1 + " "+st2 );
  return null;
} 
  
    
//    public StatChangeRule getStatChangeRuleForEvent(String eventId) {
//        
//        for(int i=0;i<statChangeRules.size();i++) {
//            StatChangeRule t = statChangeRules.get(i);
//            if(t.getEventId().equals( eventId )) {
//                
//                return t;
//            
//            }
//        }
//        System.out.println( "Not found " + eventId  );
//        return null;
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
        for(int i=0;i< this.gameEvents .size();i++) {
            buf.append( this.gameEvents .get(i)+",");
        }    
        return "Game Events: "+buf.toString();
        
    }
    
}