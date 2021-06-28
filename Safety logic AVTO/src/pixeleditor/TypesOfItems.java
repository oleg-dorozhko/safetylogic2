package pixeleditor;

import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;

public class TypesOfItems {
    
    private ArrayList<ItemType> typesOfItems = null;
    private ListView<String> listView = null;
     
    public TypesOfItems() {
        this.typesOfItems = new ArrayList<ItemType>();
    }
    
    public ArrayList<ItemType> getTypesOfItems() {
        return this.typesOfItems;
    }
    
    public void add(ItemType item) {
        
         
        this.typesOfItems.add(item);
        
    }
    
    public ObservableList<String> getSelectedItems() {
        return this.listView.getSelectionModel().getSelectedItems();
    }
    
    
    public ItemType getById(String id) {
            
        for(int i=0;i<typesOfItems.size();i++) {
            ItemType item = typesOfItems.get(i);
            if( item.getId().equals(id) ) return item;
        }
        return null;
        
    }
    
    public Integer getIndexById(String id) {
        
        for(int i=0;i<typesOfItems.size();i++) {
            ItemType item = typesOfItems.get(i);
            if( item.getId().equals(id) ) return (i);
        }
        return null;
        
    }
    
    
/******************
	public It findItemByXY(int x, int y) {
		 
        for(int i=0;i<typesOfItems.size();i++) {
            It p = typesOfItems.get(i);
            //System.out.println(p);
            if( p.getIp().getX() == x && p.getIp().getY() == y ) return p;
        }
        
        return null;
		
	}  
   
    public void removeItem(int x, int y) {
       
       for(int i=0;i<typesOfItems.size();i++) {
    	   It p = typesOfItems.get(i);
    	   if( p.getIp().getX() == x && p.getIp().getY() == y )  { typesOfItems.remove(i); break; }
           //         if( items.get(i).getId().equals(key) ) { items.remove(i); break; }
            }
        
       // }
       // while(found);
        
       // this.items.remove(new Item(key));
        
    }
    *******/
    public void toList(ListView<String> listView) {
        
        this.listView = listView;
        for(int i=0;i< this.typesOfItems.size();i++) {
            listView.getItems().add(""+this.typesOfItems.get(i).toString());
        }    
        
    }
    
     public void refresh() {
        
        listView.getItems().clear();
        for(int i=0;i< this.typesOfItems.size();i++) {
            listView.getItems().add(this.typesOfItems.get(i).toString());
        }    
        
    }
    
    public String toString() {
        
        StringBuilder buf = new StringBuilder();
        for(int i=0;i< this.typesOfItems.size();i++) {
            buf.append( this.typesOfItems.get(i)+",");
        }    
        return "Items: "+buf.toString();
        
    } 
/**************
	public It getByFirstLocaleName(String first_locale_name) {
		 for(int i=0;i<typesOfItems.size();i++) {
	            It item = typesOfItems.get(i);
	            if( item.getFirstLocaleName().equals(first_locale_name) ) return item;
	        }
	        return null;
	}

	public It findItemByXYColorPoint(int x, int y, ColorPoint cp) {
		  for(int i=0;i<typesOfItems.size();i++) {
	            It p = typesOfItems.get(i);
	            //System.out.println(p);
	            if( p.getIp().getX() == x && p.getIp().getY() == y ) {
	            	if(p.getColorPoint().equals(cp)) return p;
	            }
	        }
	        
	      
		return null;
	}
*******/
	public ItemType findItemByColor(Color c1, Color c2) throws Exception {
		
		ColorPoint cp = new ColorPoint(c1,c2); 
		for(int i=0;i<typesOfItems.size();i++) {
	            ItemType p = typesOfItems.get(i);
	            
	            if(p.getColorPoint().equals(cp)) return p;
	            
	        }
	        
	      
		 throw new Exception("Not found for colors "+cp);
	}

	public ItemType getByEnLocaleName(String enLocaleName)  {
		
		 for(int i=0;i<typesOfItems.size();i++) {
	         ItemType item = typesOfItems.get(i);
	         if( item.getEnLocaleName().equals(enLocaleName) ) return item;
	     }
		 
		 System.out.println("Not found " + enLocaleName);
		 return null;
		 
	}

	public boolean containItemType(ItemType itemType) {
		 
			ItemType s = getById(itemType.getId());
			if(s!=null)
				return true;
			  return false;
		 
	}

	public void removeItemType(ItemType itemType) {
		Integer index = getIndexById(itemType.getId());
		if(index!=null) typesOfItems.remove(index.intValue());
		
	}
	
}