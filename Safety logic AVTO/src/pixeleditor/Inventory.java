package pixeleditor;

import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;

public class Inventory {
    
    private ArrayList<It> inventory_list = null;
    //private ListView<String> indexListView = null;
    private ListView<It> listView = null;
    private int capacity = 5;
	 
    public Inventory() {
        this.inventory_list = new ArrayList<It>();
      //  setIndexListView(new ListView<String>());
    }
    
    public int addIt(It it) {
        
        if( this.inventory_list.size() >= this.capacity ) return 0;
        
        this.inventory_list.add(it);
        
        refresh();
        
//        listView.getItems().clear();
//        for(int i=0;i<this.inventory_list.size();i++) {
//        	Item item2 = this.inventory_list.get(i);
//        	//if(!listView.getItems().contains(item2.getId())) {
//        		listView.getItems().add(item2.getAlt());
//        	//}
//        }
        return 1;
        
    }
    
    public ObservableList<It> getSelectedItems() {
    	
        return this.listView.getSelectionModel().getSelectedItems();
    }
    
//    public  String getIdByName(String name) throws Exception {
//    	ObservableList<It> selectedItems =   getSelectedItems();
//    	if(selectedItems.size()==0)  throw new Exception("Not found in listView by ["+name+"]");
//        int index = 0;
//    	for(It t : selectedItems) {
//        	System.out.println("selected item " + t);
//            //if(t_name.equals(name) ) {
//            //	String id = this.indexListView.getItems().get(index);
//            //	It it =  getById(id);
//            //	if(it.getFirstLocaleName().equals(t_name)) return id;
//            //	else throw new Exception("Not equal it by id name and t_name when ["+name+"]");  
//            //}
//            index++;
//         }
//         throw new Exception("Not found in indexListView for ["+name+"]");  
//    }
    
    
    public It getById(String id) throws Exception {
    	for(int i=0;i<inventory_list.size();i++) {
            if( inventory_list.get(i).getId().equals(id) )  return inventory_list.get(i); 
    	}
    	throw new Exception("Not found "+id);
	}

	public void removeIt(String key) {
       
        for(int i=0;i<inventory_list.size();i++) {
                    if( inventory_list.get(i).getId().equals(key) ) { inventory_list.remove(i); break; }
        }
        refresh();
        
       // }
       // while(found);
        
       // this.items.remove(new Item(key));
        
    }
 
    
//    public void removeItByName(String name) throws Exception {
//    	
//    	String enLocaleName = getIdByName(name);
//	    
//        for(int i=0;i<inventory_list.size();i++) {
//                    if( inventory_list.get(i).getId().equals(enLocaleName) ) { inventory_list.remove(i); break; }
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
//	public void setIndexListView(ListView<String> indexListView) {
//		this.indexListView = indexListView;
//	}

     public void setListView(ListView<It> listView2) {
		this.listView = listView2;
	}

	public void refresh() {
        if(listView != null) {
	        listView.getItems().clear();
	//        indexListView.getItems().clear();
	        for(int i=0;i< this.inventory_list.size();i++) {
	        	
	            listView.getItems().add( this.inventory_list.get(i) );
	  //          indexListView.getItems().add(this.inventory_list.get(i).getId() ); 
	        }    
        }
    }
    
    public String toString() {
        
        StringBuilder buf = new StringBuilder();
        for(int i=0;i< this.inventory_list.size();i++) {
            buf.append( this.inventory_list.get(i)+",");
        }    
        return "Items in inventory: "+buf.toString();
        
    }

	public ArrayList<It> getItems() {
		// TODO Auto-generated method stub
		return this.inventory_list;
	}

	public ObservableList<It> getAllItems() {
		
		for(int i=0;i< this.inventory_list.size();i++) {
	        	
	            listView.getItems().add( this.inventory_list.get(i) );
 
	    }
		
		this.listView.getSelectionModel().selectAll();
		
		ObservableList<It> itms = this.listView.getSelectionModel().getSelectedItems();
		
		return itms;
	
	}

	public void removeOne(String id) {
		  for(int i=0;i<inventory_list.size();i++) {
              if( inventory_list.get(i).getId().equals(id) ) { inventory_list.remove(i); break; }
		  }
	}

	public int getCapacity() {
		 
		return this.capacity;
	}

	public ListView<It> getListView() {
		
		return this.listView;
		//		TODO Auto-generated method stub
//		ListView<It> list = new ListView<It>();
//		for(int i=0;i< this.inventory_list.size();i++) {
//		list.getItems().add( this.inventory_list.get(i) );
//		}
//		return list;
	}

 
	
	 
}