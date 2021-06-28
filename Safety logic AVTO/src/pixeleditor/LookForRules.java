package pixeleditor;

import java.util.ArrayList;
////////////////////////////////////
/*******
вода Поиск просто ничего 
Поиск с предметом удочка рыба
поиск в лесу приведет нас к дереву и это
дерево вишня или банан
или к сухому дереву - сорвать ветку
дереву знаний принести воды и получить рецепт на листке
******/
//////////////////////////////////////////////////////
public class LookForRules {
    
    private ArrayList<LookForRule> lookForRules = null;
     
    public LookForRules() {
        this.lookForRules = new ArrayList<LookForRule>();
    }
    
    public void addRule(LookForRule lookForRule) {
        
        this.lookForRules.add(lookForRule);
        
    }
    
    public boolean hasRuleFor(It place, It item) {
        
        for(int i=0;i<lookForRules.size();i++) {
            LookForRule t = lookForRules.get(i);
            if(t.getGenerator().equals(place.getId())) {
                
                if(item.getId().equals(t.getThing()) ) return true;
            
            }
        }
        return false;
    }
    
    public String generate(It f, String condition) {
        
        for(int i=0;i<lookForRules.size();i++) {
            LookForRule t = lookForRules.get(i);
            if(t.getGenerator().equals(f.getId())) {
                
                if(t.getCondition() != null) {
                    if(condition != null) {
                        if(t.getCondition().equals(condition)) return new String(t.getThing());
                    }
                } else {
                    return new String(t.getThing());
                }
            
            }
        }
        System.out.println( "Not found " + f.getId() + " or condition ["+ condition + "] is not true"  );
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
        for(int i=0;i< this.lookForRules.size();i++) {
            buf.append( this.lookForRules.get(i)+",");
        }    
        return "LookFor rules: "+buf.toString();
        
    }
    
}