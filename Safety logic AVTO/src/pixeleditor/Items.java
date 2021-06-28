package pixeleditor;

import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;

public class Items {
    
    private ArrayList<It> items = null;
    private ListView<String> listView = null;
     
    public Items() {
        this.items = new ArrayList<It>();
    }
    
    public ArrayList<It> getItems() {
        return this.items;
    }
    
    public void addItem(It item) {
        
         
        this.items.add(item);
        
    }
    
    public ObservableList<String> getSelectedItems() {
        return this.listView.getSelectionModel().getSelectedItems();
    }
    
    
    public It getById(String id) {
            
        for(int i=0;i<items.size();i++) {
            It item = items.get(i);
            if( item.getId().equals(id) ) return item;
        }
        return null;
        
    }

	public It findItemByXY(int x, int y) {
		 
        for(int i=0;i<items.size();i++) {
            It p = items.get(i);
            //System.out.println(p);
            if( p.getIp().getX() == x && p.getIp().getY() == y ) return p;
        }
        
        return null;
		
	}  
   
    public void removeItem(int x, int y) {
       
       for(int i=0;i<items.size();i++) {
    	   It p = items.get(i);
    	   if( p.getIp().getX() == x && p.getIp().getY() == y )  { items.remove(i); break; }
           //         if( items.get(i).getId().equals(key) ) { items.remove(i); break; }
            }
        
       // }
       // while(found);
        
       // this.items.remove(new Item(key));
        
    }
    
    public void toList(ListView<String> listView) {
        
        this.listView = listView;
        for(int i=0;i< this.items.size();i++) {
            listView.getItems().add(""+this.items.get(i).toString());
        }    
        
    }
    
     public void refresh() {
        
        listView.getItems().clear();
        for(int i=0;i< this.items.size();i++) {
            listView.getItems().add(this.items.get(i).toString());
        }    
        
    }
    
    public String toString() {
        
        StringBuilder buf = new StringBuilder();
        for(int i=0;i< this.items.size();i++) {
            buf.append( this.items.get(i)+",");
        }    
        return "Items: "+buf.toString();
        
    }

	public It getByFirstLocaleName(String first_locale_name) {
		 for(int i=0;i<items.size();i++) {
	            It item = items.get(i);
	            if( item.getFirstLocaleName().equals(first_locale_name) ) return item;
	        }
	        return null;
	}

	public It findItemByXYColorPoint(int x, int y, ColorPoint cp) {
		  for(int i=0;i<items.size();i++) {
	            It p = items.get(i);
	            //System.out.println(p);
	            if( p.getIp().getX() == x && p.getIp().getY() == y ) {
	            	if(p.getColorPoint().equals(cp)) return p;
	            }
	        }
	        
	      
		return null;
	}

	public It findItemByColor(Color c1, Color c2) throws Exception {
		
		ColorPoint cp = new ColorPoint(c1,c2); 
		for(int i=0;i<items.size();i++) {
	            It p = items.get(i);
	            
	            if(p.getColorPoint().equals(cp)) return p;
	            
	        }
	        
	      
		 throw new Exception("Not found for colors "+cp);
	}

    
}