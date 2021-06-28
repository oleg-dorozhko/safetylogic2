package pixeleditor;

import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;

public class Stats {
    
    private ArrayList<StatItem> stats = null;
    private ListView<String> listView = null;
    
    public Stats() {
        this.stats = new ArrayList<StatItem>();
    }
    
    public void addStatItem(StatItem si) {
        
        
        this.stats.add(si);
        
        refresh();
        
    }
    
    public ObservableList<String> getSelectedItems() {
        return this.listView.getSelectionModel().getSelectedItems();
    }
    
//    public void rem_rem_removeStatItem(String key) {
//       
//        for(int i=0;i<this.stats.size();i++) {
//        	StatItem si = stats.get(i);
//        	if( si.likeAlt(key) ) { stats.remove(i); break; }
//        }
//        refresh();
//        
//    }
    
//    public void removeItByAlt(String alt) {
//        
//        for(int i=0;i<stats.size();i++) {
//        	if( stats.get(i).getAlt().equals(alt) ) { inventory_list.remove(i); break; }
//        }
//        refresh();
//        
//       // }
//       // while(found);
//        
//       // this.items.remove(new Item(key));
//        
//    }
//    
    
//    public void toList(ListView<String> listView) {
//        if(listView !=null)
//        	this.listView = listView;
//        if(this.listView != null) {
//		        for(int i=0;i< this.inventory_list.size();i++) {
//		            listView.getItems().add(""+this.inventory_list.get(i).toString());
//		        }    
//        }
//        
//    }
    
     public void setListView(ListView<String> listView) {
		this.listView = listView;
		refresh();
	}

	public void refresh() {
        if(listView == null) return;
        listView.getItems().clear();
        for(int i=0;i< this.stats.size();i++) {
            listView.getItems().add( this.stats.get(i).getView() );
        }    
        
    }
    
    public String toString() {
        
        StringBuilder buf = new StringBuilder();
        for(int i=0;i< this.stats.size();i++) {
            buf.append( this.stats.get(i)+",");
        }    
        return "Items in inventory: "+buf.toString();
        
    }

	public ArrayList<StatItem> getItems() {
		 
		return this.stats;
	}

	public void changeByRule(StatChangeRule statChangeRule) {
        for(int i=0;i<this.stats.size();i++) {
        	StatItem si = stats.get(i);
        	if( si.getId().equals(statChangeRule.getStatId()) ) { 
        		si.changeStatItem(statChangeRule.getDiff());
        	}
        }
        refresh();
		
	}

	 
}