package pixeleditor;
//////////////////////////////
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ModelMap {
    
    private static TypesOfItems typesOfItems = null;
    private static boolean dataLoaded = false;
    
    //private static Items real_items = null;
    //private static Places real_places = null;
    //private static Places places = null;
    //private static LookForRules lookForRules = null;
    
    private static UniversalRules universalRules = null;
    
    public ModelMap() {
         
        //JSON_Map.initMap();
        
    }
    
//    public static Places getRealPlaces() {
//        return ModelMap.real_places;
//    }
//    
//    public static Items getRealItems() {
//        return ModelMap.real_items;
//    }
  
    public static ItemType readItemType( JsonReader reader ) throws Exception {
     
        String id = null; //HelperMD5.md5(HelperRandom.getRandomString(32)); ;
        String color = null;
        String enLocaleName = "undefined enLocaleName";
        String firstLocaleName = "имя не указано";
        String color2 = null;
        
        reader.beginObject();
            
            while (reader.hasNext()) 
            {
                String name = reader.nextName();
                if (name.equals("id")) 
                {
                    id = reader.nextString();
                } 
                else if  (name.equals("color")) 
                {
                    color = reader.nextString();
                }
                else if  (name.equals("firstLocaleName")) 
                {
                    firstLocaleName = reader.nextString();
                }
                else if  (name.equals("enLocaleName")) 
                {
                    enLocaleName = reader.nextString();
                }
                else if  (name.equals("alt")) 
                {
                    firstLocaleName = reader.nextString();
                }
                else if  (name.equals("t_id")) 
                {
                    enLocaleName = reader.nextString();
                }
                else if  (name.equals("color2")) 
                {
                    color2 = reader.nextString();
                }                
                else 
                {
                
                    throw new Exception("loading not ok, name "+name+" NOT FOUND");
                    //reader.skipValue();
                }
            }
            
        reader.endObject();
        
        if(id != null && color!=null && color2!=null ) return new ItemType( id, enLocaleName, firstLocaleName,   new ColorPoint( GameRegExp.getColorFromString(color),GameRegExp.getColorFromString(color2))); 
        
        throw new Exception("loading not ok, wrong for " + enLocaleName);
        
        //if(color!=null ) return new Item(id,GameRegExp.getColorFromString(color));
        //return null; //new Item(id);
    
    }
    
    public static StatItem readStatItem( JsonReader reader ) throws Exception {
        
        String id = HelperMD5.md5(HelperRandom.getRandomString(32)); 
        int qty = 0;
        String fln = new String("undefined first_locale_name");
        
        reader.beginObject();
            
            while (reader.hasNext()) 
            {
                String name = reader.nextName();
                if (name.equals("name")) 
                {
                    id = reader.nextString();
                } 
                else if  (name.equals("alt")) 
                {
                    fln = reader.nextString();
                } 
                else if  (name.equals("qty")) 
                {
                    qty = reader.nextInt();
                }            
                else 
                {
                  //this is hero stats oxygen"condition when show":"location:water,"  
                    throw new Exception("loading not ok, name "+name+" NOT FOUND");
                    //reader.skipValue();
                }
            }
            
        reader.endObject();
        return new StatItem( id,  fln,  qty ); 
        
    }
    
//    public static Place readPlace( JsonReader reader ) throws Exception {
//     
//        String id = null;
//        String color = null;
//        String alt = null;
//        String color2 = null;
//        
//        reader.beginObject();
//            
//            while (reader.hasNext()) 
//            {
//                String name = reader.nextName();
//                if (name.equals("id")) 
//                {
//                    id = reader.nextString();
//                } 
//                else if  (name.equals("color")) 
//                {
//                    color = reader.nextString();
//                }
//                else if  (name.equals("alt")) 
//                {
//                    alt = reader.nextString();
//                } 
//                else if  (name.equals("color2")) 
//                {
//                    color2 = reader.nextString();
//                }
//                else 
//                {
//                    
//                    throw new Exception("loading place not ok, name "+name+" NOT FOUND");
//                    //reader.skipValue();
//                }
//            }
//            
//        reader.endObject();
//       // System.out.println("id="+id);
//      //  System.out.println("color="+color);
//      //  System.out.println("color2="+color2);
//        if(fln == null) fln = new String(id);
//        if(color!=null && color2!=null) return new It( fln, new ImagePoint(), new ColorPoint( GameRegExp.getColorFromString(color),GameRegExp.getColorFromString(color2))); 
//        
//        return null;
//        
//        // 
//        
//        // if(color!=null ) return new Place(id,GameRegExp.getColorFromString(color));
//        // return new Place(id);
//    
//    }
    
      public static LookForRule readLookForRule ( JsonReader reader ) throws Exception {
     
        String generator = null;
        String thing = null;
        String condition = null;
        
        reader.beginObject();
            
            while (reader.hasNext()) 
            {
                String name = reader.nextName();
                if (name.equals("generator")) 
                {
                    generator = reader.nextString();
                } 
                else if  (name.equals("thing")) 
                {
                    thing = reader.nextString();
                } 
                else if  (name.equals("condition")) 
                {
                    condition = reader.nextString();
                }
                else 
                {
                    
                    throw new Exception("loading lookForRule not ok, name "+name+" NOT FOUND");
                    //reader.skipValue();  
                }
            }
            
        reader.endObject();
        
        return new LookForRule(generator,thing,condition);
    
    }
    
    
//    public static Places getPlaces() {
//        return ModelMap.places;
//    }

	public static UniversalRules getUniversalRules() {
		 
		return ModelMap.universalRules;
	} 
	
//    public static LookForRules getLookForRules() {
//        return ModelMap.lookForRules;
//    }
//    
    public static TypesOfItems getTypesOfItems() {
        return ModelMap.typesOfItems;
    }
    

	private static UniversalRule readUniversalRule(JsonReader reader) throws Exception {
		
		ArrayList<String> beforeItems = null;
		ArrayList<String> afterItems = null;

		reader.beginObject();
	            
	    while (reader.hasNext()) 
	    {
	    	String name = reader.nextName();
	        if (name.equals("beforeItems")) 
                {
	        		
        	  		beforeItems = test(reader);
        	  		
                } 
	                else if  (name.equals("afterItems")) 
	                {
	                    afterItems = test( reader);
	                } 
	                
	                else 
	                {
	                    
	                    throw new Exception("loading universalRule not ok, name "+name+" NOT FOUND");
	                    //reader.skipValue();  
	                }
	            }
	            
	        reader.endObject();
	        
	        return new UniversalRule(beforeItems,afterItems);
	}

//	private static GameEvent readGameEvent(JsonReader reader) throws Exception {
//		
//		String eventId = null;
//	      String itId1 = null;
//	      String itId2 = null;
//	     
//	        reader.beginObject();
//	            
//	            while (reader.hasNext()) 
//	            {
//	                String name = reader.nextName();
//	                if (name.equals("eventId")) 
//	                {
//	                    eventId = reader.nextString();
//	                } 
//	                else if  (name.equals("itId1")) 
//	                {
//	                    itId1 = reader.nextString();
//	                }
//	                else if  (name.equals("itId2")) 
//	                {
//	                    itId2 = reader.nextString();
//	                }
//	                else 
//	                {
//	                    
//	                    throw new Exception("loading GameEvent not ok, name "+name+" NOT FOUND");
//	                    //reader.skipValue();  
//	                }
//	            }
//	            
//	        reader.endObject();
//	        It it1 = typesOfItems.getById(itId1);
//	        It it2 = typesOfItems.getById(itId2);
//	        if(it1 != null && it2 != null) {
//	        return new GameEvent(eventId, it1 ,it2);
//	        }
//	        else {
//	        	//it1 = items.getById(itId1);
//	 	        //it2 = items.getById(itId2);
//	 	        //if(it1 != null && it2 != null) {
//	 	        //return new GameEvent(eventId, it1 ,it2);
//	 	        //}
//	        }
//	        return null;
//	}

	private static StatChangeRule readStatChangeRule(JsonReader reader) throws Exception {
		
		  String eventId = null;
	      String statId = null;
	      int diff = 0;
	        
	        reader.beginObject();
	            
	            while (reader.hasNext()) 
	            {
	                String name = reader.nextName();
	                if (name.equals("eventId")) 
	                {
	                    eventId = reader.nextString();
	                } 
	                else if  (name.equals("statId")) 
	                {
	                    statId = reader.nextString();
	                } 
	                else if  (name.equals("diff")) 
	                {
	                    diff = reader.nextInt();
	                }
	                else 
	                {
	                    
	                    throw new Exception("loading statChangeRule not ok, name "+name+" NOT FOUND");
	                    //reader.skipValue();  
	                }
	            }
	            
	        reader.endObject();
	        
	        return new StatChangeRule(eventId,statId,diff);
	}

	private static MakeItRule readMakeItRule(JsonReader reader) throws Exception {
		
		ArrayList<String> makeSet = null;
	    String resultIt = null;
	    //String condition = null;
	        
	    reader.beginObject();
	            
	    while (reader.hasNext()) 
	    {
	    	String name = reader.nextName();
	        if (name.equals("makeSet")) 
                {
	        		
        	  		makeSet = test(reader);
        	  		
                } 
	                else if  (name.equals("resultIt")) 
	                {
	                    resultIt = reader.nextString();
	                } 
	                
	                else 
	                {
	                    
	                    throw new Exception("loading makeItRule not ok, name "+name+" NOT FOUND");
	                    //reader.skipValue();  
	                }
	            }
	            
	        reader.endObject();
	        
	        return new MakeItRule(makeSet,resultIt);
	    
		 
	}

	private static ArrayList<String> test(JsonReader reader) throws Exception {
		reader.beginArray();
  		ArrayList<String> list = new ArrayList<String>();
		 
  		
		while(reader.hasNext()) {
  			//makeSet = getArrayListOfMakeSet(reader.nextString().split(","));
			list.add(reader.nextString());
  		}	
  		reader.endArray();
  		return list;
		
	}

	private static ArrayList<String> getArrayListOfMakeSet(String[] str) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<list.size();i++) {
			list.add(str[i]);
		}
		return list;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void saveData(GameModel model) throws  Exception {
		  
		 //JsonWriter writer = new JsonWriter(new PrintWriter("data/items2.json",  "UTF-8"));
	     //writer.setIndent("    ");
	     //writeItemsArray(writer, getItems());
	     //writer.close();
		
		JsonWriter  writer = new JsonWriter(new PrintWriter("data/itemTypes_2.json",  "UTF-8"));
	     writer.setIndent("    ");
	     writeItemTypeArray(writer, ModelMap.typesOfItems.getTypesOfItems());
	     writer.close();
	     
	     JsonWriter  writer2 = new JsonWriter(new PrintWriter("data/universalRules_2.json",  "UTF-8"));
	     writer2.setIndent("    ");
	     writeUniversalRuleArray(writer2, ModelMap.universalRules.getUniversalRules());
	     writer2.close();
	     
	     JsonWriter  writer3 = new JsonWriter(new PrintWriter("data/inventoryItems_2.json",  "UTF-8"));
	     writer3.setIndent("    ");
	     writeInventoryItemArray(writer3, GameModel.getInventory().getItems());
	     writer3.close();
	     
	     JsonWriter  writer31 = new JsonWriter(new PrintWriter("data/inUseItems_2.json",  "UTF-8"));
	     writer31.setIndent("    ");
	     writeInUseItemArray(writer31, model.getInUseList().getItems());
	     writer31.close();
	     
	     JsonWriter  writer4 = new JsonWriter(new PrintWriter("data/worldMap_2.json",  "UTF-8"));
	     writer4.setIndent("    ");
	     writeWorldItemArray( writer4, model.getWorldItemsArray());
	     writer4.close();
	     
	     GameModel.showAlertWithMessage("Saving data ok");
	}
	
	private static void writeInUseItemArray(JsonWriter writer, ArrayList<It> items) throws Exception {
		 writer.beginArray();
 		  
		  for (It item : items) {
		       writeInventoryItem(writer, item);
		  }
		  
		  writer.endArray();		
	}

	private static void writeWorldItemArray(JsonWriter writer, ArrayList<It> items) throws Exception {
		
		writer.beginArray();
		  
		  for (It item : items) {
		       writeWorldItem(writer, item);
		  }
		  
		  writer.endArray();
	}

	private static void writeWorldItem(JsonWriter writer, It item) throws Exception {
		 writer.beginObject();
	     writer.name("id").value(  item.getId() );
	     writer.name("itemTypeId").value(  item.getItemType().getId() );
	   //  writer.name("enLocaleName").value(item.getEnLocaleName());
	   //  writer.name("color").value(""+HelperRandom.strColor(item.getColorPoint().getColor0()));
	   //  writer.name("color2").value(""+HelperRandom.strColor(item.getColorPoint().getColor1()));
	   //  writer.name("firstLocaleName").value(item.getFirstLocaleName());
	     String ip = ""+item.getIp().getX()+","+item.getIp().getY();
	     writer.name("ip").value(ip);
	     writer.endObject();	
		
	}

	private static void writeInventoryItemArray(JsonWriter writer, ArrayList<It> items) throws Exception {
		  
		  writer.beginArray();
		  		  
		  for (It item : items) {
		       writeInventoryItem(writer, item);
		  }
		  
		  writer.endArray();
		
	}

	private static void writeInventoryItem(JsonWriter writer, It item) throws Exception {
		 writer.beginObject();
	     writer.name("id").value(  item.getId() );
	     writer.name("itemTypeId").value(  item.getItemType().getId() );
	   //  writer.name("enLocaleName").value(item.getEnLocaleName());
	   //  writer.name("color").value(""+HelperRandom.strColor(item.getColorPoint().getColor0()));
	   //  writer.name("color2").value(""+HelperRandom.strColor(item.getColorPoint().getColor1()));
	   //  writer.name("firstLocaleName").value(item.getFirstLocaleName());
	     String ip = new ImagePoint(0,0).toString();
	     writer.name("ip").value(ip);
	     writer.endObject();	
		
	}

	private static void writeItem(JsonWriter writer, It item) throws Exception {
		 writer.beginObject();
	     writer.name("id").value(  item.getId() );
	     writer.name("itemTypeId").value(  item.getItemType().getId() );
	   //  writer.name("enLocaleName").value(item.getEnLocaleName());
	   //  writer.name("color").value(""+HelperRandom.strColor(item.getColorPoint().getColor0()));
	   //  writer.name("color2").value(""+HelperRandom.strColor(item.getColorPoint().getColor1()));
	   //  writer.name("firstLocaleName").value(item.getFirstLocaleName());
	     String ip = ""+item.getIp().getX()+","+item.getIp().getY();
	     writer.name("ip").value(ip);
	     writer.endObject();	
	}

	private static void writeUniversalRuleArray(JsonWriter writer,  ArrayList<UniversalRule> arrayList) throws IOException {
		  writer.beginArray();
		     for (UniversalRule rule : arrayList) {
		       writeUniversalRule(writer, rule);
		     }
		     writer.endArray();
		
	}

	private static void writeUniversalRule(JsonWriter writer, UniversalRule rule) throws IOException {
		 writer.beginObject();
		 ArrayList<String> list = rule.getBeforeItems();
		 String h = "";
		 for (String id : list) {
		       h += ModelMap.typesOfItems.getById(id).getEnLocaleName() + ",";
		 }
		 
		 ArrayList<String> list2 = rule.getAfterItems();
		 String h2 = "";
		 for (String id : list2) {
		       h2 += ModelMap.typesOfItems.getById(id).getEnLocaleName() + ",";
		 }
		 
		 
	     writer.name("beforeItems").value( h );
	     writer.name("afterItems").value( h2  );
	     writer.endObject();
		
	}

	public static void writeItemTypeArray(JsonWriter writer, ArrayList<ItemType> arrayList) throws IOException {
		     writer.beginArray();
		     for (ItemType item : arrayList) {
		       writeItemType(writer, item);
		     }
		     writer.endArray();
		   }
	 
//
//	   public static void writeItemsArray(JsonWriter writer, ArrayList<ItemType> arrayList) throws IOException {
//	     writer.beginArray();
//	     for (ItemType item : arrayList) {
//	       writeItemType(writer, item);
//	     }
//	     writer.endArray();
//	   }

	   public static void writeItemType(JsonWriter writer, ItemType item) throws IOException {
	     writer.beginObject();
	     writer.name("id").value(  item.getId() );
	     writer.name("enLocaleName").value(item.getEnLocaleName());
	     writer.name("color").value(""+HelperRandom.strColor(item.getColorPoint().getColor0()));
	     writer.name("color2").value(""+HelperRandom.strColor(item.getColorPoint().getColor1()));
	     writer.name("firstLocaleName").value(item.getFirstLocaleName());
	     writer.endObject();
	   }
	   
	   ////////////////////////////////////////////////////////////////////////////////

	public static void loadData(GameModel model) {

		JsonReader reader = null;
		JsonReader reader2 = null;
		JsonReader reader4 = null;
		JsonReader  reader5 = null;
		JsonReader  reader6 = null;
		
		try 
	        {
	            
	            
	            File f = new File("data/itemTypes_2.json"); 
	            FileInputStream fis = new FileInputStream(f);
	            reader = new JsonReader(new InputStreamReader(fis, "UTF-8"));
	            	            
	            System.out.println("Load itemTypes");    
	        
	            TypesOfItems itemTypes = new TypesOfItems();

	            reader.beginArray();
	            while (reader.hasNext()) {
	                ItemType itemType = readItemTypePro(reader);
	                System.out.println(itemType);
	                if(itemTypes.containItemType(itemType)) {
	                	System.out.println("Double itemType: "+itemType);
	                	System.exit(1);
	                	
	                }
	                itemTypes.add(itemType);

	            }
	            reader.endArray();
	            
	            ModelMap.typesOfItems = itemTypes;
	            
	            
	            File f2 = new File("data/universalRules_2.json"); 
	            FileInputStream fis2 = new FileInputStream(f2);
	            reader2 = new JsonReader(new InputStreamReader(fis2, "UTF-8"));
	            	            
	            System.out.println("Load universalRules");    
	        
	            UniversalRules universalRules = new UniversalRules();

	            reader2.beginArray();
	            while (reader2.hasNext()) {
	                UniversalRule universalRule = readUniversalRulePro(reader2);
	                System.out.println(universalRule);
	                universalRules.addRule(universalRule);

	            }
	            reader2.endArray();
	            
	            ModelMap.universalRules = universalRules;
	            
	     
	                   
	            File f4 = new File("data/inventoryItems_2.json"); 
	            FileInputStream fis4 = new FileInputStream(f4);
	            reader4 = new JsonReader(new InputStreamReader(fis4, "UTF-8"));
	            	            
	            System.out.println("Load inventory");    
	        
	            Inventory inventory = new Inventory();

	            reader4.beginArray();
	            while (reader4.hasNext()) {
	            	
	            	String id = null;
	            	String itemTypeId = null;
	            	
	            	reader4.beginObject();
	            	 
	            	while (reader4.hasNext()) {
	            	String s =  reader4.nextName();
	            	if(s.equals("id")) {
	            		id = reader4.nextString();
	            	} 
	            	else if (s.equals("itemTypeId")) {
	            		itemTypeId = reader4.nextString();
	            	}
	            	  else if  (s.equals("ip")) 
	                  {
	                      String ips = reader4.nextString();
	                  }
	                            
	                  else 
	                  {
	                  
	                      throw new Exception("loading not ok, name "+s+" NOT FOUND");
	                      //reader.skipValue();
	                  }  
	            	//System.out.println(s);
	                 }
	            	 
	                reader4.endObject();
	                
	                ItemType itemType = ModelMap.getTypesOfItems().getById(itemTypeId);
	                System.out.println(itemType);
	                It it = new It(itemType);
	                it.setId(id);
	                inventory.addIt(it);
	            	
	            }
	            reader4.endArray();
	            GameModel.setInventory(inventory);
	            
	            System.out.println("Load inUse");
	           
	            InUseList inUse = new InUseList();
	            File f6 = new File("data/inUseItems_2.json");
	            FileInputStream fis6 = new FileInputStream(f6);
	            reader6 = new JsonReader(new InputStreamReader(fis6, "UTF-8"));
	            
	         
	            reader6.beginArray();
	            while (reader6.hasNext()) {
	            
	            	
	                //System.out.println(itemType);
	                It it = getInventoryItem(reader6);
	                inUse.addIt(it);
	                      

	            }
	            reader6.endArray();
	            
	            model.setInUse(inUse);
	            
	            System.out.println("Not implemented");    

	            File f5 = new File("data/worldMap_2.json");
	            FileInputStream fis5 = new FileInputStream(f5);
	            reader5 = new JsonReader(new InputStreamReader(fis5, "UTF-8"));
	            	            
	            
	   	    
			   	 ArrayList<It> arrayList  =  readWorldItemArray( reader5);
			   	    
			   	 model.setItems2ImageColor(arrayList);
			   	     
			   	 GameModel.showAlertWithMessage("Loading data ok");
			   	 
			   	 dataLoaded = true;
	     
	        }
	        catch(Exception ex){
	        	ex.printStackTrace();
	        }
	        
	        
		
	}
	
	   public static It getInventoryItem(JsonReader reader6) throws Exception {
       	
		   String id = null;
       	String idItemType = null;
       	String ips = null;
       	
       	reader6.beginObject();
       	  while (reader6.hasNext()) 
             {
                 String name = reader6.nextName();
                 if (name.equals("id")) 
                 {
               	  id =  reader6.nextString();
               	  //System.out.println(s);
                 } 
                 else if (name.equals("itemTypeId")) {
               	  idItemType =   reader6.nextString();
                 }
                 else if  (name.equals("ip")) 
                 {
                     ips = reader6.nextString();
                 }
                           
                 else 
                 {
                 
                     throw new Exception("loading not ok, name "+name+" NOT FOUND");
                     //reader.skipValue();
                 }    
               }
           reader6.endObject();
           ItemType itemType = ModelMap.getTypesOfItems().getById(idItemType);
           
           It it = new It(itemType, new ImagePoint(0,0));
	            it.setId(id);
           return it;
	                
       }

	
	   private static ArrayList<It> readWorldItemArray( JsonReader reader ) throws Exception {
		   	 
		   ArrayList<It> worldItems = new ArrayList<It>();
		   //ImageColor im = new ImageColor();
		   reader.beginArray();
	         while (reader.hasNext()) {
	        	 
	        	 
	         	 It it = readWorldItem(reader);
	         	 worldItems.add(it);

	         }
	         reader.endArray();
	         return worldItems;
   	    
	   }
	   
private static It readWorldItem(JsonReader reader) throws Exception {
    
	String id = null;
    String itemTypeId = null;
    String ips = null; 
       
    reader.beginObject();
        
        while (reader.hasNext()) 
        {
            String name = reader.nextName();
            if (name.equals("id")) 
            {
                id = reader.nextString();
            }
            else if  (name.equals("itemTypeId")) 
            {
                itemTypeId = reader.nextString();
            }
            else if  (name.equals("ip")) 
            {
                ips = reader.nextString();
            }
                      
            else 
            {
            
                throw new Exception("loading not ok, name "+name+" NOT FOUND");
                //reader.skipValue();
            }
        }
        
    reader.endObject();
    
    ItemType t = new ItemType(ModelMap.typesOfItems.getById(itemTypeId));
    ImagePoint ip = ImagePoint.fromString(ips);
    if(ip==null)  throw new Exception("ip format WRONG");
	It it = new It(t,ip );
    return it;
    
    
    //throw new Exception("loading not ok for " + id + " " + itemTypeId);
    

	}

private static UniversalRule readUniversalRulePro(JsonReader reader) throws Exception {
	
	 ArrayList<String> beforeItems = null;
	 ArrayList<String> afterItems = null;
     
     reader.beginObject();
         
         while (reader.hasNext()) 
         {
             String name = reader.nextName();
             if (name.equals("beforeItems")) 
             {
                 beforeItems = UniversalRule.fromStr(reader.nextString());
             } 
             else if  (name.equals("afterItems")) 
             {
            	 afterItems = UniversalRule.fromStr(reader.nextString());
             } 
             else 
             {
                 
            	 throw new Exception("loading UniversalRule not ok, name "+name+" NOT FOUND");
                   
             }
         }
         
     reader.endObject();
     
      
     ArrayList<String> list1 = new ArrayList<String>();
	 for (String enLocaleName : beforeItems) {
		 System.out.println(enLocaleName);
	        list1.add(ModelMap.typesOfItems.getByEnLocaleName(enLocaleName).getId());
	 }
	 
	 ArrayList<String> list2 = new ArrayList<String>();
	 for (String enLocaleName : afterItems) {
		 System.out.println(enLocaleName);
	        list2.add(ModelMap.typesOfItems.getByEnLocaleName(enLocaleName).getId());
	 }
     
     
     return new UniversalRule(list1,list2);

}



public static ItemType readItemTypePro( JsonReader reader ) throws Exception {
    
    String id = null;
    String enLocaleName = null;
    String color = null; 
    String color2 = null;
    String firstLocaleName = "undefined firstLocaleName";
       
    reader.beginObject();
        
        while (reader.hasNext()) 
        {
            String name = reader.nextName();
            if (name.equals("id")) 
            {
                id = reader.nextString();
            }
            else if  (name.equals("enLocaleName")) 
            {
                enLocaleName = reader.nextString();
            }
            else if  (name.equals("color")) 
            {
                color = reader.nextString();
            }
            else if  (name.equals("firstLocaleName")) 
            {
                firstLocaleName = reader.nextString();
            }
           
            else if  (name.equals("color2")) 
            {
                color2 = reader.nextString();
            }                
            else 
            {
            
                throw new Exception("loading not ok, name "+name+" NOT FOUND");
                //reader.skipValue();
            }
        }
        
    reader.endObject();
    
    if(color!=null && color2!=null) {
    	
    	ItemType t = new ItemType( id, enLocaleName, firstLocaleName,  new ColorPoint( GameRegExp.getColorFromString(color),GameRegExp.getColorFromString(color2))); 
    	
    	return t;
    }
    
    throw new Exception("loading not ok for " + id + " " + enLocaleName);
    

}

public static boolean isDataLoaded() {
	 
	return dataLoaded;
}



//	   public void writeUser(JsonWriter writer, User user) throws IOException {
//	     writer.beginObject();
//	     writer.name("name").value(user.getName());
//	     writer.name("followers_count").value(user.getFollowersCount());
//	     writer.endObject();
//	   }
//
//	   public void writeDoublesArray(JsonWriter writer, List<Double> doubles) throws IOException {
//	     writer.beginArray();
//	     for (Double value : doubles) {
//	       writer.value(value);
//	     }
//	     writer.endArray();
//	   }
 


}