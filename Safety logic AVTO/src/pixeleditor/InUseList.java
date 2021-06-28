package pixeleditor;

import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;

public class InUseList {
    
    private ArrayList<It> inUse_list = null;
    private ListView<It> listView = null;
    private int capacity = 2;
    
    public InUseList() {
        this.inUse_list = new ArrayList<It>();
    }
    
    public int addIt(It it) {
        
        if( this.inUse_list.size() >= this.capacity ) return 0;
        
        this.inUse_list.add(it);
        
        refresh();

        return 1;
        
    }
    
    public ArrayList<It> getItems() {
		// TODO Auto-generated method stub
		return this.inUse_list;
	}
    
    public void removeIt(It it) {
        
        for(int i=0;i<this.inUse_list.size();i++) {
                    if( inUse_list.get(i).getId().equals(it.getId()) ) { inUse_list.remove(i); break; }
        }
        refresh();
        
        
    }
    
    public ObservableList<It> getSelectedItems() {
        return this.listView.getSelectionModel().getSelectedItems();
    }
    
//    public void removeIt(String key) {
//       
//        for(int i=0;i<inUse_list.size();i++) {
//                    if( inUse_list.get(i).getId().equals(key) ) { inUse_list.remove(i); break; }
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
//    public void removeItByAlt(String alt) {
//        
//        for(int i=0;i<inUse_list.size();i++) {
//                    if( inUse_list.get(i).g.equals(alt) ) { inUse_list.remove(i); break; }
//        }
//        refresh();
//        
//       // }
//       // while(found);
//        
//       // this.items.remove(new Item(key));
//        
//    }
    
    
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
    
    public void setListView(ListView<It> listView) {
		this.listView = listView;
	}
    
    public void refresh() {
        if(listView != null) {
	        listView.getItems().clear();
	//        indexListView.getItems().clear();
	        for(int i=0;i< this.inUse_list.size();i++) {
	        	
	            listView.getItems().add( this.inUse_list.get(i) );
	  //          indexListView.getItems().add(this.inventory_list.get(i).getId() ); 
	        }    
        }
    }

//	public void refresh() {
//        
//        listView.getItems().clear();
//        for(int i=0;i< this.inUse_list.size();i++) {
//            listView.getItems().add( this.inUse_list.get(i).getAlt() );
//        }    
//        
//    }
    
    public String toString() {
        
        StringBuilder buf = new StringBuilder();
        for(int i=0;i< this.inUse_list.size();i++) {
            buf.append( this.inUse_list.get(i)+",");
        }    
        return "Items in use: "+buf.toString();
        
    }

	public ArrayList<It> getInUseList() {
		 
		return this.inUse_list;
	}

	public int getCapacity() {
		// TODO Auto-generated method stub
		return this.capacity;
	}

	public ListView getListView() {
		return this.listView;
	}

	 
}