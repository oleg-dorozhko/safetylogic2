package pixeleditor;

import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import javafx.scene.image.WritableImage;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.canvas.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
    
public class GameModel {
	
	public MainApp app = null;
    public It hero;
    public It cursor;
	public static int windowWidth = 20;
	public static int windowHeight = 20;
	public static int cellWidth = 20;
	public static int cellHeight = 20;
	
    
    public GameModel(MainApp app) {
        this.app = app;
    }
       
    public ImageColor im = null;

    public  boolean is_working = false;
    
    private static Inventory inventory = new Inventory();
    
    public static void setInventory(Inventory inventory) {
    	if(inventory != null && GameModel.inventory != null) {
    		ListView link = GameModel.inventory.getListView();
    		inventory.setListView(link);
    		
    	}
    	GameModel.inventory = inventory;
    	GameModel.inventory.refresh();
	}

	private static Stats stats = new Stats();
	
    private static StatChangeRules statChangeRules = new StatChangeRules();
	private static GameEvents gameEvents = new GameEvents();
	private static Label labErrorMessage = null;  
    
    private int width_cols = 0;  
    
    private int height_rows = 0;

    private  InUseList inUseList = new InUseList();
	
	public  void setInUse(InUseList inUseList) {
	
		if(inUseList != null && this.inUseList != null) {
    		ListView link = this.inUseList.getListView();
    		inUseList.setListView(link);
    		
    	}
    	this.inUseList = inUseList;
    	this.inUseList.refresh();
	}

		
		
    
    private boolean cursorUndefined= true;
	public ArrayList<Cell> cells = null;
	private MdfBufferStorage mbs = null;
	
	 public void _initCells() throws Exception {
	    	
	       this.cells =   new_loadPuzzleFromFile(); 	
//	       
//	       int cw = GameModel.cellWidth;
//	       int ch = GameModel.cellHeight;
//	       
//	       ArrayList<int[]> list = new ArrayList<int[]>();
//	       int numberOfcolors = 8;
//	       for(int i=0;i<numberOfcolors;i++) {
//	    	   list.add(HelperRandom.getRndIntColor());
//	       }
//	       
//	       ArrayList<int[]> list2 =  new ArrayList<int[]>();
//	       for(int i=0;i<numberOfcolors;i++) {
//	    	   int[] cnt = new int[1];
//	    	   cnt[0] = HelperRandom.getRandomInt(0, numberOfcolors);
//	    	   list2.add(cnt);
//	       }
//	       
//	       Collections.shuffle(list2);
//	       
	       
	     
	       
	       
	       
//	       	int counter=0;
//	       	for(int i=0;i<GameModel.windowWidth;i++) {
//	       		for(int j=0;j<GameModel.windowHeight;j++) {
//	       		
//	       			//int[] color = HelperRandom.iconv(Color.RED);
//	       			
//	       			//int[] color = list.get(list2.get(counter++)[0]);
//	       			//if(counter>=list2.size()) counter=0;
//	       			int[] color = list.get(HelperRandom.getRandomInt(0, numberOfcolors));
//	       			this.cells.add(new Cell(i,j,color));
//	       		//	this.cells.add(new Cell(i,j,color));
//	       		
//	       		}
//	       	}
	       	
	       	this.mbs  = new MdfBufferStorage(this);
			
		}
	    
	public static void err(String s) {
		if(GameModel.labErrorMessage != null) { 
			
			final String message_text_style="-fx-border-color: #ff7f7f;-fx-border-width: 2px;-fx-padding: 3px;";//"-fx-border-width: 6px;-fx-border-radius: 3px;-fx-border-style: solid;-fx-border-color: #ff7f7f;";
			GameModel.labErrorMessage.setStyle("-fx-opacity: 1;"+message_text_style);
		
			 Thread system_message_thread=new Thread(new Runnable()
			    {

			        public void run()
			        {

			            try
			            {
			                Thread.sleep(3000);
			            }
			            catch(InterruptedException ex)
			            {

			            }

			            Platform.runLater(new Runnable()
			            {

			                public void run()
			                {

			                	GameModel.labErrorMessage.setStyle("-fx-opacity: 0;"+message_text_style);

			                }   

			            });

			        }   

			    });

			    system_message_thread.start();	
			 
			
			
			
			GameModel.labErrorMessage.setText(s);
		}
	}
	
    public   void update_CW_CH() throws Exception {
        
        if(im == null) throw new Exception(" im == null");
        this.width_cols = (int) ( this.app.canvas_width / this.im.cols );
        this.height_rows = (int) ( this.app.canvas_height / this.im.rows );
        //this.screen.txt1.setText(""+this.cols);
        //this.screen.txt2.setText(""+this.rows);
    }
    
    public int getWidthOfCols() {
        return this.width_cols;
    }
    
    public int getHeightOfRows() {
        return this.height_rows;
    }
    // ctrlz here?
    public   void setImageColor(ImageColor im)  throws Exception {
            
            this.im = im;
            update_CW_CH();
            
    }
    
    // ctrlz here?
    public   void setColorsArray(ItStack[][] copy_arr_cell_2d,int cols,int rows) throws Exception  {
        
        this.im = new ImageColor(cols,rows,copy_arr_cell_2d);
        update_CW_CH();
    
    }
    

    
    public void initGameFields()  throws Exception {
        
        //setCols();
        //setRows();
        //gold_counter = 0; 
        /////////////////////////////////
        //generateNewPuzzle();
    	
    	////////////////////
        /////// loadPuzzleFromFile();
        ////////////////////
         
         
         /////////////////////////////////
         
       // if(im.get(heroPositionX,heroPositionY).equals(Color.WHITE)) {
           
       //     flyToNotWhiteSpace();
       
        
      //  } else {
      //              ArrayList<ImagePointColor> list =  MainGraphics.pointNearWith(im, heroPositionX,heroPositionY, im.get(heroPositionX,heroPositionY));
      //              if(list.size()==8) {  
      //                   flyToNotWhiteSpace();
      //              }
      //  }
        
    	this.hero = findHero();
    	
    	
    	
    	// String id = HelperMD5.md5(HelperRandom.getRandomString(32));
  //      ItemType ht = ModelMap.getTypesOfItems().getByEnLocaleName("hero");
  //      this.hero = new It( ht );
  //      this.hero.setIp(new ImagePoint(35,35));
       
  //      im.get(35, 35).getStack().push(hero);
        
        //id = HelperMD5.md5(HelperRandom.getRandomString(32));
		ItemType ct = ModelMap.getTypesOfItems().getByEnLocaleName("cursor"); //
		this.cursor = new It(ct); 
		this.setCursorUndefined(true);
        
        this.app.redrawBoardPro();
        
    }
    
    private It findHero() throws Exception {
    	  for(int j=0;j<im.rows;j++)
          {
              for(int i=0;i<im.cols;i++)
              {
            	  ItStack st = im.get(i, j);
            	  Stack<It> st2 = st.getStack();
            	  for(int n=0;n<st2.size();n++) {
            		  It it = st2.get(n);
            		  if(it.getEnLocaleName().equals("hero")) {
            			  return new It(it);
            		  }
            	  }
              }
          }
		throw new Exception("Hero not found in world items");
	}

	private void setCursorUndefined(boolean b) {
    	
		this.cursorUndefined = b;
		
	}

//   
//    
//    public Color getRealColor(int x,int y) throws Exception {
//        Place p = ModelMap.getRealPlaces().findPlaceByXY(x,y);
//        if(p == null) throw new Exception("Not found place ["+x+","+y+"]");
//        return p.getColorPoint().getColor1();
//        
//    }
//    
//    
    
    public  void processSecondaryClick(int[] point) throws Exception  {
        
    	if( is_working ) return;
    
    	is_working = true;
    	
    	ImagePoint oldPoint = new ImagePoint(this.hero.getIp()); 
          
        ImagePoint newPoint = new ImagePoint(point[2],point[3]); 
          
        if(oldPoint.equals(newPoint)) { 

              is_working = false;
            
        	  return;
        }
    	
        //this.hero.getIp().getX();
        //this.hero.getIp().getY();
                 
        int newx = point[2];
        int newy = point[3];
        
        if( this.isCursorUndefined()==true) {
            
            ColorPoint light = ColorPoint.getTransparentColorPoint( im.get(newx,newy).getStack().peek().getColorPoint() );
            //String id = HelperMD5.md5(HelperRandom.getRandomString(32));
            this.cursor.setColorPoint(light);
            this.cursor.setIp(new ImagePoint(point[2],point[3]));
        
            this.setCursorUndefined(false);/// = new Cursor(id, "cursor","подсветка",new ImagePoint(newx,newy), light);
        
        }            
        else {
        
            this.setCursorUndefined(true);
        
        }
        
        this.app.redrawBoardPro();
       
        //if((point[2] == this.cursorColorPoint.x) && (point[3] == this.cursorColorPoint.y))   {
          
            // if( this.cursor.undefined )) {
                // int dx1 = Math.abs(newx-oldx);
                // int dy1 = Math.abs(newy-oldy);
                        
                // if(dx1 > 1 || dy1 > 1)
                // {
                    
                // return;
                // } 
                // this.underCursorColor = this.im.get(point[2],point[3]);
                // this.cursorColorPoint =  new ImagePointColor(point[2],point[3],getTransparent(this.im.get(point[2],point[3])));
               
                
            // }
            // else {
                // if((this.cursorColorPoint.x == point[2])&&(this.cursorColorPoint.y == point[3])) {
                    // this.cursorColorPoint =  new ImagePointColor(0,0,Color.rgb(0,0,0));
                    // this.underCursorColor = null;
                // }
                // else {
                    // System.out.println("eq");
                    
      // //              processSecondaryClick_part_two(point);
                    
                    // return;
                    
                // }
            // }
                
        // MainGraphics.fillPixel(this.im, oldx, oldy, this.underHeroColor);
                
                
                // // // // // // // // // // // // // // // // // // return;
        // // // // // // // // // // // // // // // // // // //}
        
        
        is_working = false;
      
    }
    
    boolean isCursorUndefined() {

    	return this.cursorUndefined;
    
    }

	private It getLocationAsIt(ImagePoint point) {
    	Stack<It> st = im.get(point.getX(),point.getY()).getStack();
    	if(st.size()>0) return st.peek();
    	return null;
    }

    public static void showAlertWithMessage(String message) {
	    
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    } 

    
    public void processPrimaryClick(int[] point) throws Exception {
    	
    	if(is_working) return;
    	
    	is_working = true;
    	
        if(this.isCursorUndefined()==false) {

        	is_working = false;
        	return;
        }
        
//        if(hero.isUndefined() == true) {
//        	is_working = false;
//        	return;
//        }
        
       // //TODO conditions include stats
        
        ImagePoint oldPoint = new ImagePoint(this.hero.getIp()); 
        
        ImagePoint newPoint = new ImagePoint(point[2],point[3]); 
        
        if(oldPoint.equals(newPoint)) {
        	is_working = false;
        	return;
        }
      
        
       /// TODO
        //// TODO
        //// TODO TODO TODO статы добавляем при выполнении условий, и удаляем при выполнении других условий
        /// TODO например, с песка в воду, добавляем в хироу статс оксиген
        /// TODO а если юзаем топор нипадецки то уменьшаем хп топора
        /// а если хп топара около 0 то он мало-мало-мало деревьев рубит
        /// труд делает голодным чем просто когда туда-сюда ходим
        ///////////////////////////////////////////////////////////
        
        //me = define movementEvent (it,it)
        //doReactionOnEvent(me)
        ///
        int oldx = oldPoint.getX();
        int oldy = oldPoint.getY();
        int newx = newPoint.getX();
        int newy = newPoint.getY();
        
         
        //it from old point
        It oldIt = getLocationWithoutHeroAsIt(oldPoint);
        //it from new point
        It newIt = getLocationAsIt(newPoint);
        
        if(newIt == null) {
        	
        	System.out.println("Its impossible");
        	System.exit(1);
        	 
        }  
        	
        ArrayList<String> beforeItems = new ArrayList<String>();
        beforeItems.add(ModelMap.getTypesOfItems().getByEnLocaleName("move").getId()); 
        beforeItems.add(oldIt.getItemType().getId()); 
             
         ArrayList<String> afterItems = new ArrayList<String>();
    	 afterItems.add(newIt.getItemType().getId()); 
                      
 		  try 
 		  {
 			  UniversalRule rule = ModelMap.getUniversalRules().getUniversalRule( beforeItems, afterItems );
 		  }
 		  catch(Exception ex) {
 			// no found move rule
 			 String gameErrMessage = GameRegExp.extr(ex.getMessage()); 
 			 if(gameErrMessage != null) err(gameErrMessage);
 			 
 			 is_working = false;
 			 
 			 return;
 			 
 		  }
     		   
        	
        	
        	
        	if(newIt.getFirstLocaleName().equals("new item")) {
	        	 
	        	 // create a text input dialog
	            TextInputDialog td = new TextInputDialog();
	            td.setContentText("This cool item nonamed. What is its name?");
	            // show the text input dialog
	            td.showAndWait();
	
//	            It it = new It(newIt);
//	            System.out.println(it.getId());
//	            String name = td.getEditor().getText();
//	           
//	            it.setFirstLocaleName(name);
//	            im.get(newx, newy).getStack().pop();
//	            // set the text of the label
//	            System.out.println(td.getEditor().getText());
//	            im.get(newx, newy).getStack().push(it);   
	            //ModelMap.getTypesOfItems().add(new It(it));
	            is_working = false;
	            return;
        	}
        	
//        	
//	         t = this.gameEvents.getEventForTwoState(oldIt, newIt);
//	        if(t==null) {
//	        	showAlertWithMessage("Not found event "+oldIt+" <--> "+newIt);
//	        	this.gameEvents.addEvent(new GameEvent(""+oldIt.getId()+"_"+newIt.getId(),oldIt,newIt));
//	        	return;
//	        }
	        
        
        
        int dx1 = Math.abs(newx-oldx);
        int dy1 = Math.abs(newy-oldy);
                        
        if(dx1 > 1 || dy1 > 1) {
        	is_working = false;
        	return;
        }
        
//        int sz = im.get(newx, newy).getStack().size();
//        if(sz>1) {
//        	 
//        	  takeItem( newx, newy) ; //  	moveHero(point);
//        }
//        else {
       
        	moveHero(point);
        	
//        	
//            if(t!=null) {
//            
//            	StatChangeRule statChangeRule = statChangeRules.getStatChangeRuleForEvent(t.getId());
//            	if(statChangeRule != null) {
//            		System.out.println(statChangeRule);
//            		executeReaction(statChangeRule);
//            	}
//            	
//            }
        	
       // }
        
        
        //TODO оценка статов, рекурсивная или когда постепенно исчезает выделенный ресурс (тоже цикл)
        //например, условием цикла сделать пока массив не пуст выполнять
        
        
        
        this.app.redrawBoardPro();
        //System.out.println(hero);  
        is_working = false;
        
       
    }
    
    private void executeReaction(StatChangeRule statChangeRule) {
		stats.changeByRule(statChangeRule);		
	}

	private It getLocationWithoutHeroAsIt(ImagePoint oldPoint) {
    	Stack<It> st = im.get(oldPoint.getX(),oldPoint.getY()).getStack();
    	if(st.size()>1) {
    		It h = new It(st.pop());
    		It res = new It(st.peek());
    		st.push(h);
    		return res;
    	}
    	else {
    		if(st.size()>0) return new It(st.peek());	
    	}
    	return null;
	}

	private boolean takeItem(int x, int y) {
		 
		It it = new It(im.get(x,y).getStack().peek());
		
		if(it.getEnLocaleName().equals("hero")) return false;
		
		if(it.getFirstLocaleName().equals("new item")) {
			System.out.println("Cannot take nonamed item");
			return false;
		}
			
	//	it.setUndefined(true);
    	int i = this.inventory.addIt( it );
    	 
    		//ModelMap.getRealItems().removeItem(it.getIp().getX(),it.getIp().getY());
    	 ItStack st =  im.get(x,y);
         It m = st.getStack().peek();
         
         if(m.getEnLocaleName().equals("hero")) {
         err("Cannot");
         return false;
        	 //hero.setUndefined(true);
         }
         
         st.getStack().pop();
         
         //im.set( it.getIp().getX(),it.getIp().getY(), st );
    	  
    	return true;
		
	}

	 
//
//	private It get_location_as_item(int[] point) {
//		It cp = this.im.get(point[2], point[3]).getStack().peek();
//		if(cp.typeOf("It")) return  cp;
//		return null;
//		//return ModelMap.getRealItems().findItemByXYColorPoint(point[2], point[3], cp);
//		 
//	}

	private void moveHero(int[] point) throws Exception {
		
		int x = hero.getIp().getX();
	    int y = hero.getIp().getY();
	    
	    this.im.get(x,y).getStack().pop();
	    String id = HelperMD5.md5(HelperRandom.getRandomString(32));
	    ItemType heroType = ModelMap.getTypesOfItems().getByEnLocaleName("hero");
		this.hero = new It( heroType ,  new ImagePoint(point[2],point[3]) );  
	     
	    this.im.get(point[2], point[3]).getStack().push(this.hero);
	    
	    //Item item = ModelMap.getRealItems().findItemByXY(x, y);
	    //if(item != null) {
	    //	this.im.set(x,y,item.getColorPoint());
	    //}
	    //else 
	    //	this.im.set(x,y,ModelMap.getRealPlaces().findPlaceByXY(x, y).getColorPoint()); 
    	
	   
		
	}

	// public static void processPrimaryClick(int[] point) {
        
        // if(!Color.rgb(0,0,0).equals(this.cursorColorPoint.color)) return;
        
         // // if(im.get(heroPositionX,heroPositionY).equals(Color.WHITE)) {
           
            // // flyToNotWhiteSpace();
       
        
        // // }
        
                  // int oldx = this.heroPositionX;
        // int oldy = this.heroPositionY;
        // Color oldColor = this.underHeroColor;
        
        
               
        // int newx = point[2];
        // int newy = point[3];
        
        // Color newColor = this.im.get(newx,newy);
         
         
        
        
        // int dx1 = Math.abs(newx-oldx);
                        // int dy1 = Math.abs(newy-oldy);
                        
        // if(dx1 > 1 || dy1 > 1) return;

        
       
        
        // MainGraphics.fillPixel(this.im, oldx, oldy, oldColor);
        
   // if(point[2] == oldx && point[3]==oldy) {
            // // clear_if_without_gold();
            // //teleport_for_free();
            // //this.screen.redrawBoard();
            // return;
        // }
        
            
            // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, oldx, oldy, Color.WHITE ); 
            // // if(list.size()==8) {
               // // MainGraphics.fillPixel(this.im, oldx, oldy, Color.WHITE);
               // // flyToNotWhiteSpace();
               // // this.screen.redrawBoard(); 
               // // return; 
            // // }
           
        
         
     
         
         
         // if (newColor.equals(Color.WHITE)) {
            
            // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
            // // if(list.size()>0) {
            // // //flyToNotWhiteSpace();
            // // //this.screen.redrawBoard();
            // // }
              // return; 
        
       // }
        
      
         
         
         
         
         
         
        
        // boolean moved = false;
        // if(point[2] == oldx && point[3]==oldy) {
            // moved = false;
        // }
        // // else if (newColor.equals(Color.WHITE) && oldColor.equals(Color.WHITE)) { 
        // //               
        // //}
        // else 
        // {
            
            
            // // int dx = Math.abs(point[2] - this.heroPositionX);
            // // int dy = point[3] - this.heroPositionY ; //antigravitation
           
                
                // int q1 = MainGraphics.countNear( this.im, oldx, oldy, oldColor );
                // System.out.println("q1="+q1);
                
                // int q2 = MainGraphics.countNear( this.im, newx, newy, newColor);
                // System.out.println("q2="+q2);
                
                // int q7 = MainGraphics.countNear( this.im, newx, newy, oldColor);
                // System.out.println("q7="+q7);
                
                // int q8 = MainGraphics.countNear( this.im, oldx, oldy, newColor);
                // System.out.println("q8="+q8);
                                
       
                // if(oldColor.equals(newColor)) {
                     
                   
                    // //    { this.moveHero(point); moved=true;}
                    
                   // //  if(q1!=8 && q2 !=8) //РїРѕР»Р·Р°С‚СЊ РїРѕ СЃС‚РµРЅРѕС‡РєР°Рј
                   
                   // {
                    
                    // //int oldx = this.heroPositionX;
                    // //int oldy = this.heroPositionY;
                    // //Color oldUnderColor = MainGraphics.cloneColor(this.underHeroColor);
                    // //MainGraphics.setHero(this.im, point[2], point[3]);
                    // //MainGraphics.fillPixel(this.im, oldx, oldy, oldUnderColor);
                   


                        // int dx = Math.abs(newx-oldx);
                        // int dy = Math.abs(newy-oldy);
                        
                        // if(dx != dy && dy !=0 && dx != 0) moved=false;
                        // else moved=true;
                        
            // // if(dx> 0 && dy==0) 
            // // {
                 // // moved=true;
            // // } else if ( dx<0  && dy==0) {
                 // // moved=true;
            // // }
                // // ||  ((dx>0) && (dy>0) && (dx==dy)) || 


                  
                    
                     // }
                   
                    
                    
                    
                // }
                // //else if(newColor.equals(Color.WHITE)) { 
                
                    // //q = MainGraphics.countNear(this.im,point[2], point[3], Color.WHITE);
                    // //System.out.println("q="+q);
                    // // if(q2!=8)    {
                    // //    swapWhite(point);
                    // //    moved=true;
                    // //}
                
                
                // //}
               
                // else  
                // {
            
        // //            this.screen.showAlertWithMessage("Other color on ["+point[2]+","+point[3]+"]");
                  
                    // int dx = Math.abs(newx-oldx);
                    // int dy = Math.abs(newy-oldy);
                    // if(dx<=1 && dy<=1) 
                    // {
                    
                        // if(newColor.equals(Color.GOLD)) { 
                            
                            // if(collectGold(oldx,oldy, newx,newy)){ 
                               
                                // //MainGraphics.setHero(this.im,  newx,newy); 
                            // }
                            // else MainGraphics.setHero(this.im,  oldx,oldy); 
                            // this.screen.redrawBoard();
                            // return;
                        
                        // } 
                        // else 
                        // {
                             
                // //////////////////////////////////////////////////////////////////            
                    // //        if(q7==8&&q8==1) {
                        // if((q2==0)&&(q7==8)) { //portal
                                
                                // ImagePointColor icp = is_portal_there(oldColor,newColor);
                                // if(icp != null) {
                                
                                    // System.out.println("moving througn portal");
                                   // // for (int y = 0; y < im.rows; y++) {
                                   // //     for (int x = 0; x < im.cols; x++) {
                                                
                                   // //                Color t = im.get(x,y);
                                   // //                ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(this.im,x,y, t);
                                   // //                 if(t.equals(newColor) && list.size()==6 ) {
                                                        // MainGraphics.fillPixel(this.im,   oldx,  oldy, oldColor); 
                                                         // MainGraphics.setHero(this.im,   icp.x,  icp.y); 
                                                         // newx = icp.x;
                                                         // newy= icp.y;
                                                         // moved=true;
                                                         // this.screen.redrawBoard();
                                                        // return;
                                   // //                 }
                                   // //     }
                                    // }
                            // }
                            // else {
                                    // //System.out.println("from portal");
                   // ///////////////////////////////////////////////////////////////////////
                     // System.out.println("Across");
                    // moved=true;
                                           // // this.screen.showAlertWithMessage(" Swap colors allowed ");
                                               // // int[] old_point2 = new int[4];
                                               // // old_point2[2] = oldx; 
                                               // // old_point2[3] = oldy;
                                               // // MainGraphics.swapB(this.im,point,old_point2,oldColor); 
                            // }                 
                                                // //moved=true;
                        // }                    
                    // }
                // }
        
    // }
        // if(moved) MainGraphics.setHero(this.im, newx,newy);
        // else MainGraphics.setHero(this.im, oldx, oldy); 
        
        // this.screen.redrawBoard();
    // }
    
    
     // public static ImagePointColor is_portal_there(Color oldColor, Color newColor) {
          // ArrayList<ImagePointColor> li = new  ArrayList<ImagePointColor> ();
        // for (int y = 0; y < im.rows; y++) {
            // for (int x = 0; x < im.cols; x++) {
                    
                // Color t = im.get(x,y);
                       
                // if(t.equals(oldColor)) {
                        
                       // // ArrayList<ImagePointColor> list1 = MainGraphics.pointNearWith(im, x, y, oldColor ); 
                        // ArrayList<ImagePointColor> list2 = MainGraphics.pointNearWith(im, x, y, newColor );
                        // if( (list2.size()==8)) {
                            // int n = MainGraphics.getRandomInt(0,list2.size());
                            // return new ImagePointColor(list2.get(n).x,list2.get(n).y, im.get(list2.get(n).x,list2.get(n).y));
                            // //li.add(new ImagePointColor(x,y,im.get(x,y)));
                            
                        // }
                // }
            // }
        // }
        // //if(li.size()>0) return li.get(MainGraphics.getRandomInt(0,li.size()));             
        // return null;
    // }
    
    // public static boolean collectGold(int oldx,int oldy, int x,int y) {
         // ArrayList<ImagePointColor> listG = MainGraphics.pointNearNotWith(this.im,x,y, Color.GOLD);
          // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(this.im,this.heroPositionX,this.heroPositionY, this.underHeroColor);
        // //ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(this.im,x,y, this.underHeroColor);
         // System.out.println("q3="+list.size()+" listGq="+listG.size());
                                
        // if((list.size()<7) && (listG.size()==8)) { 
        
            // ArrayList<ImagePointColor> list2 = MainGraphics.pointNearWith(this.im, x,y, this.underHeroColor); 
            // if(list2.size()==8) 
            // {
                // MainGraphics.fillPixel(this.im,   x,  y, this.underHeroColor); 
                // MainGraphics.setHero(this.im, this.heroPositionX, this.heroPositionY); 
                // gold_counter++;
                // if(gold_counter>=this.MAX_GOLD_COUNTER) {
                    // screen.newGame.setVisible(true);
                // }
                // return true;
            // }
            // else {
                
                // ArrayList<ImagePointColor> list4 = new ArrayList<ImagePointColor>(); 
                // for(int i=0;i<listG.size();i++) {
                    
                    // boolean found = false;
                    // for(int j=0;j<list4.size();j++) {
                        // if(list4.get(j).color.equals(listG.get(i).color)) {
                            // found=true;
                            // break;
                        // }
                    // }
                    // if( (!found) && (!listG.get(i).color.equals(this.underHeroColor))) 
                        // list4.add(listG.get(i)); 
                // }
                
                // if((list4.size()==1) &&(list.size()==1)) {
                    // MainGraphics.fillPixel(this.im,   x,  y, list4.get(0).color); 
                    // MainGraphics.setHero(this.im, this.heroPositionX, this.heroPositionY); 
                    // gold_counter++;
                     // if(gold_counter>=this.MAX_GOLD_COUNTER) {
                    // screen.newGame.setVisible(true);
                // }
                    // return true;
                // }
                
                
                
                
             // System.out.println("q5="+list2.size());
            // }
            
        
            // //this.im.set(x,y,this.underHeroColor);
            // //clear_if_without_gold();
            // //teleport_for_free();
            
            
        // }
        // return false;
    // }
    
    // public static void clear_if_without_gold() {
        // boolean found=true;
        // for (int y = 0; y < im.rows; y++) {
                                // for (int x = 0; x < im.cols; x++) {
                                   // if(this.im.get(x,y).equals(Color.GOLD)) {
                                   
                                    // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(this.im,x,y, this.underHeroColor);
                                        // //System.out.println("q3="+list.size());
                                        // if(list.size()>0) { found=false; break;
                                        // }
                                   
                                   
                                   // }
                                // }
                             // }
                             
                             // if(found==true) {
                             
                             
                              // for (int y = 0; y < im.rows; y++) {
                                // for (int x = 0; x < im.cols; x++) {
                                   // if(this.im.get(x,y).equals(this.underHeroColor)) {
                                    // this.im.set(x,y,Color.WHITE);
                                   // }                                       
                             
                             
                             
                             // }
                              // }
                             // }
    // }
    
    // public static boolean teleport_for_free() {
     // ArrayList<ImagePointColor> list1 = new  ArrayList<ImagePointColor>(); 
                            // ImagePointColor icp = null;
                             // for (int y = 1; y < im.rows-1; y++) {
                                // for (int x = 1; x < im.cols-1; x++) {
                                   // list1.add(new ImagePointColor(x,y,im.get(x,y)));
                                // }
                             // }
                             
                             // Collections.shuffle(list1);
                             
                             // for(int i=0;i<list1.size();i++) {
                             // ImagePointColor ip = list1.get(i);
                             // if(ip.color==Color.WHITE) continue;
                              // if(im.get(ip.x,ip.y).equals(this.underHeroColor)) {
                                        // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(this.im,ip.x,ip.y, this.underHeroColor);
                                        // //System.out.println("q3="+list.size());
                                        // if((list.size()<8) && (!ip.color.equals(Color.WHITE))) { icp = new ImagePointColor(ip.x,ip.y,null);
                                            // break;
                                        // }
                                    // }
                             
                             // }
                             
                             
                             
                             
                             
                             
                             
                             // if(icp==null) {
                                 // boolean foundNotWhite = false;
                                // for(int i=0;i<list1.size();i++) 
                                     // if(list1.get(i).color.equals(Color.WHITE)) continue;
                                      // else {   this.underHeroColor =  list1.get(0).color; foundNotWhite = true; break;  }
                             
                               // if(foundNotWhite==false) {
                                 // System.out.println("Not found. Error #578");
                                // try 
                        // {
                            // this.initGameFields();
                             
                        // } 
                        // catch (Exception ex) {
                              // ex.printStackTrace();
                        // }
                                // return true;
                                // //System.exit(1);
                               
                               // }
                               
                                
                                // if(!teleport_for_free()) {
                                // System.out.println("Not found. Error #579");
                                // System.exit(1);
                               
                                // }                                    
                                // System.out.println("Found.  #580");
                                // return true;    
                                
                             // }
                             // else { 
                             // MainGraphics.setHero(this.im, icp.x, icp.y); 
                              // System.out.println("Found.  #581");
                             // }
                             // return true;
    
    // }
    
    // public static void swapWhite(int[] point) {
        // int oldx = this.heroPositionX;
        // int oldy = this.heroPositionY;
        // Color oldUnderHeroColor =  this.underHeroColor;
        // int[] old_point2 = new int[4];
        // old_point2[2] = oldx; 
        // old_point2[3] = oldy;
        // MainGraphics.swapW(this.im,point,old_point2,oldUnderHeroColor);
    // }
    
    // public static void moveHero(int[] point) {
        
       
        
    // }
    

	   
	private ArrayList<Cell> new_loadPuzzleFromFile() 
    {
		   ArrayList<Cell> cells =  new ArrayList<Cell>();
		   
        try {
        
            File f2 = null;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
        
            BufferedImage img = null;
        
            FileChooser fileChooser = new FileChooser();
            
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
            fileChooser.getExtensionFilters().add(extFilter);
            int[] colsAndRows = null;
            //Show save file dialog
            File f = fileChooser.showOpenDialog(app.getPrimaryStage());
            if(f!=null) {
            	f2=f;
            	colsAndRows = GameRegExp.getColsAndRowsAndCWAndCHFromFileName(f2.getName());
            }
            else 
            {
	            f = new File("images");///an_ailand_and_a_ship_w*xh*_cp.png");
	            
	            String[] list = f.list();
	            
	                for(int i=0;i<list.length;i++) {
	                
	                    // //img = ImageIO.read(f);
	                    System.out.println(list[i]);
	                    if(list[i].contains("testCase1")) {
		                    String s = list[i];
		                   
		                    colsAndRows = GameRegExp.getColsAndRowsAndCWAndCHFromFileName(s);
		                    f2 = new File("images/" + s);
		                   
		                    break;
	                    }
	                    
	                }
            
            }
            
            if(f2==null) throw new Exception();
            
            System.out.println(f2.getName());
             img = ImageIO.read(f2);
        
            //ImageIO.write((RenderedImage) img, "png", out);
            //out.flush();
            //ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            
            GameModel.windowWidth = colsAndRows[0];//*colsAndRows[2];
            GameModel.windowHeight = colsAndRows[1];//*colsAndRows[3];
            
            GameModel.cellWidth = colsAndRows[2];
            GameModel.cellHeight = colsAndRows[3];
           
            Logger.lo("GameModel.windowWidth ="+GameModel.windowWidth);
            Logger.lo("GameModel.windowHeight ="+GameModel.windowHeight);
            Logger.lo("GameModel.cellWidth ="+GameModel.cellWidth);
            Logger.lo("GameModel.cellHeight ="+GameModel.cellHeight);
            
            		
            int w =  GameModel.windowWidth;///GameModel.cellWidth;
            int h =  GameModel.windowHeight;///GameModel.cellHeight;
            for(int i = 0; i < w; i++) {
                for(int j = 0; j < h; j++) {
                    java.awt.Color myColor = new java.awt.Color(img.getRGB(i , j )); 
                    int[] color = new int[4];
                    color[0] = myColor.getRed();
                    color[1] = myColor.getGreen();
                    color[2] = myColor.getBlue();
                    color[3] = 255; 
 	       			cells.add(new Cell(i,j,color));
                    
                    //System.out.print(myColor + ", ");
                }
                //System.out.println();
            }
            
            return cells;
//            
//            
//            
// 	       this.cells = new ArrayList<Cell>();	
// 	       	int counter=0;
// 	       	for(int i=0;i<GameModel.windowWidth;i++) {
// 	       		for(int j=0;j<GameModel.windowHeight;j++) {
// 	       		
// 	       			int[] color = list.get(HelperRandom.getRandomInt(0, numberOfcolors));
// 	       			this.cells.add(new Cell(i,j,color));
// 	       		//	this.cells.add(new Cell(i,j,color));
// 	       		
// 	       		}
// 	       	}
// 	       	
//            
//            
//            
//            
//           // javafx.scene.image.Image fimg =  new javafx.scene.image.Image(in);
//            
//           // GraphicsContext gc1 = this.app.getCanvas().getGraphicsContext2D();
//           // gc1.drawImage(fimg,0,0,this.app.getCanvas().getWidth(),this.app.getCanvas().getHeight());
//                            
//           // ImageColor im = new ImageColor(  colsAndRows[0], colsAndRows[1] );
//                            
                          
                                          
        } 
        catch ( Exception ex) {
            ex.printStackTrace();
        }
		return cells;
            
            
    }
    
    
	
	private void old_loadPuzzleFromFile() 
    {
        try {
        
            File f2 = null;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
        
            BufferedImage img = null;
        
            File f = new File("images");///an_ailand_and_a_ship_w*xh*_cp.png");
            int[] colsAndRows = null;
            String[] list = f.list();
            
                for(int i=0;i<list.length;i++) {
                
                    // //img = ImageIO.read(f);
                    System.out.println(list[i]);
                    String s = list[i];
                   
                    colsAndRows = GameRegExp.getColsAndRowsFromFileName(s);
                    f2 = new File("images/" + s);
                   
                    break;
                    
                }
            
            
            if(f2==null) throw new Exception();
            
            System.out.println(f2.getName());
             img = ImageIO.read(f2);
        
            ImageIO.write((RenderedImage) img, "png", out);
            out.flush();
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            javafx.scene.image.Image fimg =  new javafx.scene.image.Image(in);
            
            GraphicsContext gc1 = this.app.getCanvas().getGraphicsContext2D();
            gc1.drawImage(fimg,0,0,this.app.getCanvas().getWidth(),this.app.getCanvas().getHeight());
                            
                            ImageColor im = new ImageColor(  colsAndRows[0], colsAndRows[1] );
                            
                            this.setImageColor(im);
                            
                            
                            WritableImage snap = gc1.getCanvas().snapshot(null, null);
                            
                            for (int y = 0; y < im.rows; y++) {
                                for (int x = 0; x < im.cols; x++) {
                                    
                                    Color c1  =  snap.getPixelReader().getColor(x*this.width_cols, y*this.height_rows);
                                    Color c2  =  snap.getPixelReader().getColor(x*this.width_cols+1, y*this.height_rows);
                                   
                                    ColorPoint cp = new ColorPoint(c1,c2);
                                    
                                    ItemType p = ModelMap.getTypesOfItems().findItemByColor(c1,c2);
                                    if(p!=null) {
                                        //if(p.getEnLocaleName().equals("water")) {
                                        //	 System.out.println("water ");
                                        //}
                                        It tp = new It(p,new ImagePoint(x,y));
                                        ItStack st = new ItStack();
                                        st.getStack().push(tp);
                                        im.set( x, y, st );
                                        
                                        //ModelMap.getRealPlaces().addPlace(tp);
                                        
                                    } else {
//                                    	It p2 = ModelMap.getItems().findItemByColor(c1,c2);
//                                        if(p2!=null) {
//                                        
//                                        	It tp = new It(p2.getId(),new ImagePoint(x,y),new ColorPoint(c1,c2),p2.getAlt());
//                                            ItStack st = new ItStack();
//                                            st.getStack().push(tp);
//                                            im.set( x, y, st );
                                        	 System.out.println("Not found ");
                                           System.out.println(c1+"--"+c2);
//                                        }
                                    }
                        
                                }
                            }
                             
                           
                             
            this.setImageColor(im);
            
           
            
           // MainApp.defineHeroPositionAndSetHero();   
            
           // this.screen.redrawBoard();    
                            
        } 
        catch ( Exception ex) {
            ex.printStackTrace();
        }
            
            
    }
    
    
    @SuppressWarnings("unused")
	private   void generateNewPuzzle() throws Exception {
             
        //generate random seed 9 5, plus, rotate plus 45, median, rotate plus 45, median
    	
    	
       ////////////////////////////////////////////////////////////////      
   //     ImageColor im1 = new ImageColor(28,28);
    
    	   ImageColor im1 = new ImageColor(28,28);
    ////////////////////////////////////////////////////////
    	   
    	   
    	//    ImageColor im2 = MainGraphics.generate_ailand(im1);
        //ImageColor im2 = MainGraphics.generate_random_seed(im1);
     //   ImageColor im3 = MainGraphics.plus(im2);
      //  ImageColor im4 = MainGraphics.rotate_plus_45(im3);
      //  ImageColor im5 = MainGraphics.median(im4);
      //  ImageColor im6 = MainGraphics.rotate_plus_45(im5);
        
     //   ImageColor im8 = MainGraphics.median(im6);
     //   im8 = MainGraphics.border_minus(im8);
        ImageColor  im8 = im1;//MainGraphics.plus(im3);
    //    im8 = MainGraphics.plus(im3);
        System.out.println("cols="+im8.cols);
        System.out.println("rows="+im8.rows);
        //im8 = MainGraphics.plus(im8);
        ////////////////////////////////////         
   //     ImagePoint p = MainGraphics.getCenterPoint(im8);
           
	    // very nice here
        //
        //      while(true) {      
        //          p = find_nearest_not_white(); //try_to_fly();
        //          if(p==null) {
        //            register_all_places_clear();
        //            break;
        //            }
        //            if( single_cell(p)) clear_cell(p);
        //              else break;  
        //      }  
        //        if(all_places_clear()) {
        //            pazzle_solved();
        //            exit();
        //        }
        //        
        /////////////////////////////////
        
           /////////////////////////////
       // MainGraphics.setHero(im8,p.x,p.y);
      
      
     ///   MainGraphics.setWhiteCell(im8,p.x,p.y);
      //  im8 = MainGraphics.setGold(im8);
        
        
        //im8 = MainGraphics.setPortals(im8);
        this.setImageColor(im8);
            
    }
    
    // public static ImagePoint  getHeroPos() {
        // return new ImagePoint ( heroPositionX, heroPositionY );
    // }
    
    // public static ImagePoint getCursorPos() {
        
        // return new ImagePoint(cursorPositionX,cursorPositionY);
        // //if(Color.rgb(0,0,0).equals(this.cursorColorPoint.color)) return null;
        // //return this.cursorColorPoint;
    // }
    
     // public static Place getCursorPlace() {
        
        // return this.cursor;
        // //if(Color.rgb(0,0,0).equals(this.cursorColorPoint.color)) return null;
        // //return this.cursorColorPoint;
    // }
    
    
    public void lookForItems() throws Exception {
    
        if(this.isCursorUndefined()) {
        	err("Set cursor before, please.");
        	return;
        }
        
        int x = cursor.getIp().getX();
        int y = cursor.getIp().getY();
        It it = null;
        try
        {
        	it = im.get(x,y).getStack().peek();
        }
        catch(EmptyStackException ex) {
        	System.out.println("Prokopal planetu naskvoz");
        	System.exit(1);
        }
        
        
        // ModelMap.getRealItems().findItemByXY(cursor.getIp().getX(),cursor.getIp().getY());
        
        System.out.println("it="+it);
        System.out.println("itType="+it.getItemType());
        	
        	
        		ArrayList<String> beforeItems = new ArrayList<String>();
        		beforeItems.add(it.getItemType().getId());
        		beforeItems.add(ModelMap.getTypesOfItems().getByEnLocaleName("search").getId());
        		System.out.println("Search in: " + ModelMap.getUniversalRules());
        		ArrayList<String> ids = null;
        		try {
				ids = ModelMap.getUniversalRules().lookFor( beforeItems  );
        		}
        		catch(Exception ex) {
        			err(ex.getMessage());
        			return;
        		}
        		
				System.out.println(ids);
     	        
     	        for(String id: ids) {
					ItemType  item2 = ModelMap.getTypesOfItems().getById(id);
	     	        System.out.println(item2);
	     	        if(item2 !=null) {
	     	        	ItStack n =  (im.get(x,y));
	     	        	It it1 = new It(item2);
	     	        	
	     	        	it1.setIp(new ImagePoint(x,y));
	     	        	n.getStack().push(it1);
	     	        	//im.set(x, y, n);
	     	            // //this.inventory.refresh();
	     	        } 
     	       
     	        }
         this.setCursorUndefined(true);
     	        this.app.redrawBoardPro();
        
        // if(ip.color.equals(Color.rgb(0,128,0))) {
            // int i = MainGraphics.getRandomInt(0,2);
            // if(i==1) {
                // this.inventory.addItem(new Item("branch"));
                // this.inventory.refresh();
            // }
        // } else if(ip.color.equals(Color.rgb(0,255,0))) {
            // int i = MainGraphics.getRandomInt(0,2);
            // if(i==1) {
                // this.inventory.addItem(new Item("stone"));
                // this.inventory.refresh();
            // }
        // }else if(ip.color.equals(Color.rgb(0,0,255))) {
            // int i = MainGraphics.getRandomInt(0,2);
            // if(i==1) {
                // this.inventory.addItem(new Item("fish"));
                // this.inventory.refresh();
            // }
        // }else if(ip.color.equals(Color.rgb(255,255,0))) {
            // int i = MainGraphics.getRandomInt(0,2);
            // if(i==1) {
                // this.inventory.addItem(new Item("vodorosli"));
                // this.inventory.refresh();
            // }
        // }
    
    }
    
    // public static String getHeroPlace() {
         
        // // ImagePointColor ip = getHeroPos();
        // // System.out.println("Place is: "+ip);
        // // Place p = null;
        
        // // if(ip.color !=null) {
        
            // // p = ModelMap.getPlaces().findPlaceByColor(ip.color,null);
        
        // // }
        
        // // if(p==null)   return "unknown";
        // // return p.toString();
    // }
    
    // public static Place getCurrentPlace() {
         
        // // ImagePointColor ip = getCursorPos();
        // // System.out.println("Cursor pos is: "+ip);
        // // if(ip == null) return null;
        
        // // Place p = null;
        
        // // if(ip.color != null) {
        
            // // p = ModelMap.getPlaces().findPlaceByColor(this.underCursorColor,null);
        
        // // }
        
        // // if(p == null)   return new UnknownPlace();
        // // return p ;
    // }
    
//    public  void drawItemUnderCursor(Item item) {
//        
//        if(cursor.undefined) return;
//        
//        item.getIp().setX(cursor.getIp().getX());
//        item.getIp().setY(cursor.getIp().getY());
//        
//     //   ModelMap.getRealItems().addItem(new Item(item));
//        
//        // item = new Item(cursor);
//        
//        // ImagePointColor ip = getCursorPos();
//        // this.underCursorColor = this.im.get(point[2],point[3]);
//        // this.cursorColorPoint =  new ImagePointColor(point[2],point[3],getTransparent(this.im.get(point[2],point[3])));
//               
//        // this.im.set(ip.x,ip.y,item.color);
//        
//        
//        
//        //ArrayList<ImagePointColor> list = MainGraphics.pointNearNotWith(im, icp.x, icp.y, Color.WHITE ); 
//    }

	public static Inventory getInventory() {
		 
		return  inventory;
	}
	
	 public void useSelectedItem() throws Exception {  
   	  
   	  if(this.isCursorUndefined()==false) return;
		   	
   	if( this.getInUseList().getItems().size() >=  this.getInUseList().getCapacity()) {
		err("Not enough space");
		return;
	}
   	  		ObservableList<It> selectedItems =  this.inventory.getSelectedItems();
		   	if(selectedItems.size()==0 || selectedItems.size()>1 ) return;   
		    for(It it : selectedItems){
		   	 
		        System.out.println("selected item " + it);
		        //String enLocaleName = this.inventory.getIdByName(alt);
		        //It item = ModelMap.getItems().getById(enLocaleName);
		        this.inventory.removeIt(it.getId());
		        this.inUseList.addIt(it);
		        break;
		   	 }
	 }
	 
	 public void notUseSelectedItem() {
			
			if(this.isCursorUndefined()==false) return;
			
			ArrayList<It> inventoryItems =  this.getInventory().getItems();
			if(inventoryItems.size() >= this.getInventory().getCapacity()) {
				err("Need more space in inventory");
				return;
			}
			
			ObservableList<It> selectedItems =  this.getInUseList().getSelectedItems();
		   	if(selectedItems.size()==0 || selectedItems.size()>1 ) return;   
		    for(It it : selectedItems){
		   	 
		        System.out.println("selected item " + it);
		        //String enLocaleName = this.inventory.getIdByName(alt);
		        //It item = ModelMap.getItems().getById(enLocaleName);
		        this.inventory.addIt(it);
		        this.inUseList.removeIt(it);
		        break;
		   	 }
			
			
		}
	    
	 
      public void dropSelectedItems() throws Exception {  
    	  
    	  System.out.println("In dropSelectedItems:");
    	  
    	  if(this.isCursorUndefined()) {
    		  err("Set cursor before");
    		  return;
    	  }
              
    	  ObservableList<It> selectedItems =  this.inventory.getSelectedItems();
 		  
		  if(selectedItems.size()==0) return;

    	  
          int x = cursor.getIp().getX();
          int y = cursor.getIp().getY();
          It it = null;
          try
          {
          	it = im.get(x,y).getStack().peek();
          }
          catch(EmptyStackException ex) {
          	System.out.println("Prokopal planetu naskvoz");
          	System.exit(1);
          }
          
          //System.out.println("000 "+it);
          if(it==null) System.exit(1);

          ArrayList<String> beforeItems = new ArrayList<String>();
  		  beforeItems.add(it.getItemType().getId()); 
  		  beforeItems.add(ModelMap.getTypesOfItems().getByEnLocaleName("search").getId());
  		  
  		  try
  		  {
  		  
  		  
  			  ArrayList<String> ids = ModelMap.getUniversalRules().lookFor( beforeItems );
  			  System.out.println("00700 ids=" + ids);
             
    		  for(It t : selectedItems) {
	        	 
    			System.out.println("selected item " + t);
    			
    			
    			It item = null;
		            
    			try {
	    			 
		            	item = this.inventory.getById( t.getId());
	    			  
	    			    this.inventory.getItems().remove(item);
	    			    
	  //  			    item.setUndefined(false);
	    			  
	    		 }
		         catch(Exception ex) {
		            	
		           	System.out.println(ex.getMessage());
		        
		         }
    			System.out.println("t="+t);
		            
		            if(!ids.contains(t.getItemType().getId())) {
		            
		            	It it2 = new It(t.getItemType());
		            	it2.setIp(it.getIp());
		            	
		            	im.get(x,y).getStack().push(it2);
		            
		            }
    			
    		  }
    	  
          }
  		  catch(Exception ex) {
  		  
  			System.out.println(ex.getMessage());
  			
  			 for(It t : selectedItems) {
	        	 
     			System.out.println("selected item " + t);
     			
     			
     			It item = null;
 		            try {
 	    			   item = this.inventory.getById( t.getId());
 	    			  
 	    			  this.inventory.getItems().remove(item);
 	//    			  item.setUndefined(false);
 	    			  im.get(x,y).getStack().push(new It(item));
 	    			 
 		            }
 		            catch(Exception ex1) {
 		            	System.out.println(ex1.getMessage());
 		            }
 		            
     			
     		  }
  			
  		  }
  		  
  		  
  		  
  		  
				
	           // It item = this.inventory.getById(id); // ModelMap.getTypesOfItems().getById(enLocaleName);
//	            
//	            


//	            
//	            if(ids == null) {
//	            	
//	            	
//	            	if(item==null && hero.getFirstLocaleName().equals(s)) {
//     	        		System.out.println("230");
//     	        		hero.getIp().setX(x);
//     	        		hero.getIp().setY(y);
//     	        		hero.setUndefined(false);
//     	        		
//     	        		im.get(x,y).getStack().push(new It(hero));
//     	        	         	        		
//     	        		this.inventory.removeItByName(s);    
//     	        	}
//	            	else {
//		     	        		System.out.println("333");
//		     	        		im.get(x,y).getStack().push(new It(item));
//		     	        		this.inventory.removeItByName(s);    
//		     	        	
//	            	}
//	            	
//	            	
//	            	break;
//	            	
//	            	
//	            	
//	            	
//	            } else {
//	            
//		            System.out.println("001"+ ModelMap.getTypesOfItems());
//		            for(String id1: ids)  {
//	     	        It item2 = this.inventory.getById(id1);//ModelMap.getTypesOfItems().getById(id1);
//	     	        System.out.println(item2);
//	     	        if(it !=null) {
//	     	        	System.out.println("111");
//	     	        	
//	     	        	if(item==null && hero.getFirstLocaleName().equals(s)) {
//	     	        		System.out.println("330");
//	     	        		hero.getIp().setX(x);
//	     	        		hero.getIp().setY(y);
//	     	        		hero.setUndefined(false);
//	     	        		
//	     	        		im.get(x,y).getStack().push(new It(hero));
//	     	        		this.inventory.removeItByName(s);    
//	     	        	}
//	     	        	else {
//	     	        	if(item.equals(item2)) {
//	     	        		this.inventory.removeItByName(s);    
//	     	        		System.out.println("222");
//	     	        	}
//	     	        	else {
//	     	        		System.out.println("333");
//	     	        		im.get(x,y).getStack().push(new It(item));
//	     	        		this.inventory.removeItByName(s);    
//	     	        	}
//	     	        	}
//	     	        	break;
//	     	        	
//	     	        	
//	     	        }
//		            }
     	        
//	            }
     	        
//     	       System.out.println("444");
//        }
 //        hero.setUndefined(false);
         this.setCursorUndefined(true);
         this.inventory.refresh();
         this.app.redrawBoardPro(); 
//     }
   }
    
//      
     public  void linkSelected() throws Exception {
    
    	 if(this.isCursorUndefined()==false) {
    		 err("Unset cursor before, please.");
    		 return;
    	 }
    	 
// 		ImagePoint ip = this.cursor.getIp();
 		
//        // ImagePointColor ip = getHeroPos();
//        // System.out.println("Place is: "+ip);
//        
//        // ArrayList<String> axe = new ArrayList<String>();
//        // axe.add("branch");
//        // axe.add("vodorosli");
//        // axe.add("stone");
//         
        ObservableList<It> selectedItems =  this.inventory.getSelectedItems();
        if( selectedItems.size() < 1) {
        	 err("Select item before, please.");
    		 return;
        }
        
        
      ArrayList<String> beforeItems  = new ArrayList<String>();    
      for(It it : selectedItems) {
 
    	  beforeItems.add(it.getItemType().getId());
    	  System.out.println("selected item " + it);
 
      }
 
		  beforeItems.add(ModelMap.getTypesOfItems().getByEnLocaleName("make").getId());
  		  
		  try {
			  
		       	ArrayList<String> keys = ModelMap.getUniversalRules().lookFor(beforeItems);
		       	if(keys.size() > 1) {
		       		err("More than one rule found. Correct your json");
		       		return;
		       	}
		       	
	       	It it2 = new It(ModelMap.getTypesOfItems().getById(keys.get(0)));
	       	it2.setIp(new ImagePoint(0,0));
	       
	       	System.out.println(""+it2);
	       	//im.get(ip.getX(),ip.getY()).getStack().push(it2);
	        
	       	
	       	
	        ObservableList<It> selectedItems1 =  this.inventory.getSelectedItems();
	        ArrayList<String> beforeItems1  = new ArrayList<String>();    
	      for(It it : selectedItems1) {
	    	  
		    	  try {
		    		  
		    		  System.out.println("removing item " + it);
		    		  this.inventory.removeOne(it.getId());
		    	 
		    	  }
		    	 catch(Exception ex)
	        	 {
	        		 System.out.println(ex.getMessage());   
	////        	//	 workDone=true;
	////        	//	 break;
	         	}

		    	  
	      }
	      
	      
	       	
//	        for(int i=0;i<beforeItems1.size();i++) {
//	        	//String s = ts.get(i);
////           	 System.out.println(s);
////           	 try {
////           		 It it =  ModelMap.getTypesOfItems().getById(s);
//           		 
////           		 
////           	 }
////           	 catch(Exception ex)
////           	 {
////           		 System.out.println(ex.getMessage());   
////           	//	 workDone=true;
////           	//	 break;
////            	}
//       	}
//	       	
//	       	
	      
	       this.inventory.addIt(it2);
	      
	      	err("Action completed.");
	       	this.setCursorUndefined(true);
	        this.inventory.refresh();
	        this.app.redrawBoardPro();
	        
	        
		 }
     	 catch(Exception ex)
     	 {
     		 System.out.println(ex.getMessage());
     		 return;
     	//	 workDone=true;
     	//	 break;
      	}
		  
//        	 
//             
//             
////             boolean workDone = false;
////             while(!workDone) {
//	             for(int i=0;i<ts.size();i++) {
//	            	 String s = ts.get(i);
//	            	 System.out.println(s);
//	            	 try {
//	            		 It it =  ModelMap.getTypesOfItems().getById(s);
//	            		 this.inventory.removeIt(it.getId());
//	            		 
//	            	 }
//	            	 catch(Exception ex)
//	            	 {
//	            		 System.out.println(ex.getMessage());   
//	            	//	 workDone=true;
//	            	//	 break;
//	             	}
//	        	}
//	             
//             //}
//	        		 for(String key: keys ) 
//	        			 	this.inventory.addIt(ModelMap.getTypesOfItems().getById(key));
//        }
//        
//    
    }

	public void takeSelected() {
		
		if(this.isCursorUndefined()==true) {
			err("Set cursor on item before");
			return;
		}
		
		if( this.getInventory().getItems().size() >=  this.getInventory().getCapacity()) {
			err("Not enough space");
			return;
		}
		
		ImagePoint ip = this.cursor.getIp();
		int sz = im.get(ip.getX(), ip.getY()).getStack().size();
        if(sz>1) {
        	 
        	  takeItem( ip.getX(), ip.getY()) ; //  	moveHero(point);
        }
        this.setCursorUndefined(true);
        this.inventory.refresh();
        this.app.redrawBoardPro();
		
	}

	public Stats getStats() {
		// TODO Auto-generated method stub
		return this.stats;
	}

	public static void setStats(Stats stats) {
		 
		GameModel.stats = stats;
		
	}

	public static void setStatChangeRules(StatChangeRules statChangeRules2) {
		GameModel.statChangeRules = statChangeRules2;
		
	}

	public static void setGameEvents(GameEvents gameEvents) {
		GameModel.gameEvents = gameEvents;
		
	}

	public InUseList getInUseList() {
		return this.inUseList;
	}

	public void showStats() {
		
		if(this.isCursorUndefined()==true) return;
		
		It newIt = getLocationAsIt(cursor.getIp());
		
		System.out.println("#1 " + newIt);
        
	}

	public void repairSelectedItem(){
		
		 if(this.isCursorUndefined()==false) {
    		 err("Unset cursor before, please.");
    		 return;
    	 }
    	   
        ObservableList<It> selectedItems =  this.inventory.getSelectedItems();
        if( selectedItems.size() < 1 ) {
        	 err("Select item before, please.");
    		 return;
        }
        
        if( selectedItems.size() > 1 ) {
       	 err("Too many selected items. Unset, please");
   		 return;
       }
       String id = selectedItems.get(0).getId();
         
      ArrayList<String> afterItems  = new ArrayList<String>();    
      for(It it : selectedItems) {
 
    	  afterItems.add(it.getItemType().getId());
    	  System.out.println("selected item " + it);
 
      }
 
		  //.add(ModelMap.getTypesOfItems().getByEnLocaleName("make").getId());
  		  UniversalRule rule = null;
		  try {
			  
		       	rule = ModelMap.getUniversalRules(). getUniversalRuleByAfterItems(afterItems);
		  }
		  catch(Exception ex) {
			  err( ex.getMessage());
		  }
		  
		  
			 this.inventory.removeOne(id);
	       	   this.inventory.refresh();
      		  

		  
		  ArrayList<String> beforeItems = rule.getBeforeItems();
		  
		  for(String id1: beforeItems) {
		  
			ItemType type =   ModelMap.getTypesOfItems().getById(id1);
	       	if(type.getEnLocaleName().equals("make")) continue;
			It it2 = new It(type);
	       	it2.setIp(new ImagePoint(0,0));
	       	
	       	System.out.println(""+it2);
	       	
	       	this.inventory.addIt(it2);
	       	
		  }
	       	//im.get(ip.getX(),ip.getY()).getStack().push(it2);
	        
	       
		    	  
	      
	       	
//	        for(int i=0;i<beforeItems1.size();i++) {
//	        	//String s = ts.get(i);
////           	 System.out.println(s);
////           	 try {
////           		 It it =  ModelMap.getTypesOfItems().getById(s);
//           		 
////           		 
////           	 }
////           	 catch(Exception ex)
////           	 {
////           		 System.out.println(ex.getMessage());   
////           	//	 workDone=true;
////           	//	 break;
////            	}
//       	}
//	       	
//	       	
	      
	       
	      	err("Action completed.");
	       	this.setCursorUndefined(true);
	        this.inventory.refresh();
	        this.app.redrawBoardPro();
	        
	        
		 
		  
//        	 
//             
//             
////             boolean workDone = false;
////             while(!workDone) {
//	             for(int i=0;i<ts.size();i++) {
//	            	 String s = ts.get(i);
//	            	 System.out.println(s);
//	            	 try {
//	            		 It it =  ModelMap.getTypesOfItems().getById(s);
//	            		 this.inventory.removeIt(it.getId());
//	            		 
//	            	 }
//	            	 catch(Exception ex)
//	            	 {
//	            		 System.out.println(ex.getMessage());   
//	            	//	 workDone=true;
//	            	//	 break;
//	             	}
//	        	}
//	             
//             //}
//	        		 for(String key: keys ) 
//	        			 	this.inventory.addIt(ModelMap.getTypesOfItems().getById(key));
//        }
//        
//    
		
		
		
		
		
		
		 
		
	}
//
//	public void summonRandom() {
//		
//		if(this.hero.isUndefined()==false) {
//			
//			int x = this.hero.getIp().getX();
//			int rx = HelperRandom.getRandomInt(0, 10);
//			
//			int y = this.hero.getIp().getY();
//			int ry = HelperRandom.getRandomInt(0, 10);
//			
//			int cx = x-5;
//			//if(x<0) { x=5;
//			
//			rx = x-5+rx;
//			ry = y-5+ry;
//			String id = HelperMD5.md5(HelperRandom.getRandomString(32));
//			It it = new It(id,"new item","новый предмет", new ImagePoint(rx,ry), new ColorPoint( HelperRandom.getRandomColorPoint()),1);
//	 
//			
//			ItStack st = im.get(rx, ry);
//			st.getStack().push(it);
//			
//			this.app.redrawBoardPro();
//			 
//			
//		}
//		
//	}
//
//	public void cloneItem() {
//		 
//		if(this.cursor.isUndefined()==true) return;
//		
//		It newIt = getLocationAsIt(cursor.getIp());
//		
//		int x =  newIt.getIp().getX();
//		
//		int y =  newIt.getIp().getY();
//		
//		It it = new It(newIt);
//		
//		ItStack st = im.get(x, y);
//		st.getStack().add(it);
//		this.cursor.setUndefined(true);
//		this.app.redrawBoardPro();
//		
//		
//	}
//
//	 

	public void setLabErrorMessageLink(Label labErrorMessage) {
		GameModel.labErrorMessage  = labErrorMessage;
		
	}

	public void addCustomItem() {
		err("Interface not implemented. Notepad++, edit, itemTypes_2.json");
		
	}

	public void addCustomRule() {
		err("Interface not implemented. Notepad++, edit, universalRules_2.json");
	}

	public ArrayList<It> getWorldItemsArray() {
		
		 ArrayList<It> items = new  ArrayList<It>();
		for(int i=0;i<this.im.cols;i++)
        {
            for(int j=0;j<this.im.rows;j++)
            {
            	Stack<It> st = this.im.get(i,j).getStack();
            	for(int i1=0;i1<st.size();i1++) {
            		items.add(new It(st.get(i1)));
            	}
            }
            
        }
		
		return items;
	}

	public void setItems2ImageColor(ArrayList<It> items) throws Exception {
		
		int cols = 0;
		int rows = 0;
		for(int i=0;i<items.size();i++)
        {
			It it = items.get(i);
			int x = it.getIp().getX();
			int y = it.getIp().getY();
			if(x > cols) cols = x;
			if(y > rows) rows = y;
        }
		
		ImageColor im = new ImageColor(cols+1,rows+1);
		
		for(int i=0;i<items.size();i++) {
			
			It it = items.get(i);
			int x = it.getIp().getX();
			int y = it.getIp().getY();
		
			ItStack st =  im.get(x, y);
			st.getStack().push(it);
			im.set(x, y, new ItStack(st));
			
		}
		
		setImageColor(im);
		
	}

	public Cell getCellXY(int i, int j) {
		for (Cell cell : cells) {
			if((cell.x == i) && (cell.y==j)) return cell;
		}
		return null;
	}
	
	public int[] getColorXY(int i, int j) {
		for (Cell cell : cells) {
			if((cell.x == i) && (cell.y==j)) return cell.getMyColor();
		}
		return null;
	}


    public  Cell firstCell = null;
    public Cell secondCell  = null;
    public boolean processChangeCalled = false;
    public boolean processChangeRightCalled = false;
    
	public void processSecondaryClickOnCanvas0(Cell cell) throws Exception {
		 
		if(cell == null) return;
		
		if((firstCell != null) && (secondCell != null)) return; 
			
		
		if(firstCell == null) {
			 firstCell = cell;
			 secondCell = null;
		 } 
		 else {
			 
			 if(secondCell==null) {
				 secondCell = cell;
				 processRightChange(firstCell,secondCell);
				 this.app.redrawCanvases();
				 firstCell = null;
				 secondCell = null;
				 processChangeCalled=false;
			 }
			 else {
				 firstCell = null;
				 secondCell = null;
			 }
			 
		 }
		
	}
	
	public  ArrayList<Cell> defineMdfSameNeigh(int i, int j, int[] color) throws Exception {
	    
	     ArrayList<Cell> list = new ArrayList<Cell>();
	     if(i<0) return list;
	     if(j<0) return list;
	    
	     
	         
	         int n=0;
	         int[] color0 = getColorXY(i-1,j-1);
	         int[] color1 = getColorXY(i,j-1);
	         int[] color2 = getColorXY(i+1,j-1);
	         int[] color3 = getColorXY(i-1,j);
	         int[] color4 = getColorXY(i,j);
	         int[] color5 = getColorXY(i+1,j);
	         int[] color6 = getColorXY(i-1,j+1);
	         int[] color7 = getColorXY(i,j+1);
	         int[] color8 = getColorXY(i+1,j+1);
	         
	         int[] greys = new int[4];
	         greys[0] = 13;
	         greys[1] = 13;
	         greys[2] = 13;
	         greys[3] = 255;
	         
	         if(color0 == null) color0 = greys;
	         if(color1 == null) color1 = greys;
	         if(color2 == null) color2 = greys;
	         if(color3 == null) color3 = greys;
	         if(color4 == null) color4 = greys;
	         if(color5 == null) color5 = greys;
	         if(color6 == null) color6 = greys;
	         if(color7 == null) color7 = greys;
	         if(color8 == null) color8 = greys;
	        
	         if(   ( Cell.compare(color0, color)  ) ) {
	             n++;
	             list.add(new Cell(i-1,j-1,color0));
	         } 
	        
	          if( ( Cell.compare(color1, color)  )) {
	             n++;
	             list.add(new Cell(i,j-1,color1));
	         } 
	        
	          if(  (Cell.compare(color2, color) )) {
	             n++;
	             list.add(new Cell(i+1,j-1,color2));
	         } 
	        
	          if( ( Cell.compare(color3, color) )) {
	             n++;
	             list.add(new Cell(i-1,j,color3));
	         } 
	        
	         if(  ( Cell.compare(color5, color)   )) {
	             n++;
	             list.add(new Cell(i+1,j,color5));
	         } 
	        
	         if(  ( Cell.compare(color6, color)   )) {
	             n++;
	             list.add(new Cell(i-1,j+1,color6));
	         } 
	        
	         if( ( Cell.compare(color7, color)  )) {
	             n++;
	             list.add(new Cell(i,j+1,color7));
	         } 
	        
	         if(  ( Cell.compare(color8, color) )) {
	             n++;
	             list.add(new Cell(i+1,j+1,color8));
	         } 
	               
	     
	    
	 	return list;
	    
	}   
	
	@SuppressWarnings("unchecked")
	public  ArrayList<Cell> defineEmpty(int i, int j)  {
	    
	     ArrayList<Cell> list = new ArrayList<Cell>();
	     //if(i<0) return list;
	     //if(j<0) return list;
	         
	         int n=0;
	         list.add(getCellXY(i-1,j-1));
	         list.add(getCellXY(i,j-1));
	         list.add(getCellXY(i+1,j-1));
	         list.add(getCellXY(i-1,j));
	         list.add(getCellXY(i,j));
	         list.add(getCellXY(i+1,j));
	         list.add(getCellXY(i-1,j+1));
	         list.add(getCellXY(i,j+1));
	         list.add(getCellXY(i+1,j+1));
	         
	         ArrayList<Cell> list2 = new ArrayList<Cell>();
	         for(Cell c: list) {
	        	 if(c==null) list2.add(c);
	         }
	        	 
	         return list2;
	}
	
public  ArrayList<Cell> defineNeigh(int i, int j, int[] color)  {
    
     ArrayList<Cell> list = new ArrayList<Cell>();
     if(i<0) return list;
     if(j<0) return list;
    
     
         
         int n=0;
         int[] color0 = getColorXY(i-1,j-1);
         int[] color1 = getColorXY(i,j-1);
         int[] color2 = getColorXY(i+1,j-1);
         int[] color3 = getColorXY(i-1,j);
         int[] color4 = getColorXY(i,j);
         int[] color5 = getColorXY(i+1,j);
         int[] color6 = getColorXY(i-1,j+1);
         int[] color7 = getColorXY(i,j+1);
         int[] color8 = getColorXY(i+1,j+1);
        
         if( (color0 !=null) && ( !Cell.compare(color0, color)  ) ) {
             n++;
             list.add(new Cell(i-1,j-1,color0));
         } 
        
          if((color1 !=null) && ( !Cell.compare(color1, color)  )) {
             n++;
             list.add(new Cell(i,j-1,color1));
         } 
        
          if((color2 !=null) && ( !Cell.compare(color2, color) )) {
             n++;
             list.add(new Cell(i+1,j-1,color2));
         } 
        
          if((color3 !=null) && ( !Cell.compare(color3, color) )) {
             n++;
             list.add(new Cell(i-1,j,color3));
         } 
        
         if((color5 !=null) && ( !Cell.compare(color5, color)   )) {
             n++;
             list.add(new Cell(i+1,j,color5));
         } 
        
         if((color6 !=null) && ( !Cell.compare(color6, color)   )) {
             n++;
             list.add(new Cell(i-1,j+1,color6));
         } 
        
         if((color7 !=null) && ( !Cell.compare(color7, color)  )) {
             n++;
             list.add(new Cell(i,j+1,color7));
         } 
        
         if((color8 !=null) && ( !Cell.compare(color8, color) )) {
             n++;
             list.add(new Cell(i+1,j+1,color8));
         } 
               
     
    
 	return list;
    
}   

public  synchronized ArrayList<Cell> defineNeighNeigh(int i, int j, int[] color)   {
    
    ArrayList<Cell> list = new ArrayList<Cell>();
    if(i<0) return list;
    if(j<0) return list;
   
    
        
        int n=0;
        int[] color0 = getColorXY(i-1,j-1);
        int[] color1 = getColorXY(i,j-1);
        int[] color2 = getColorXY(i+1,j-1);
        int[] color3 = getColorXY(i-1,j);
        int[] color4 = getColorXY(i,j);
        int[] color5 = getColorXY(i+1,j);
        int[] color6 = getColorXY(i-1,j+1);
        int[] color7 = getColorXY(i,j+1);
        int[] color8 = getColorXY(i+1,j+1);
      
        
        if(Cell.compare(color,color0) ) {
            n++;
            list.add(new Cell(i-1,j-1,color0));
        } 
       
         if( Cell.compare(color,color1)  ) {
            n++;
            list.add(new Cell(i,j-1,color1));
        } 
       
         if(Cell.compare(color,color2)  ) {
            n++;
            list.add(new Cell(i+1,j-1,color2));
        } 
       
        if(Cell.compare(color,color3) ) {
            n++;
            list.add(new Cell(i-1,j,color3));
        } 
       
        if(Cell.compare(color,color5)) {
            n++;
            list.add(new Cell(i+1,j,color5));
        } 
       
        if(Cell.compare(color,color6) ) {
            n++;
            list.add(new Cell(i-1,j+1,color6));
        } 
       
        if(Cell.compare(color,color7) ) {
            n++;
            list.add(new Cell(i,j+1,color7));
        } 
       
        if(Cell.compare(color,color8)) {
            n++;
            list.add(new Cell(i+1,j+1,color8));
        } 
              
    
   
	return list;
   
}   
	
	public void processChange() throws Exception {
		
		
		ArrayList<Cell> neighs = defineNeigh(secondCell.x, secondCell.y,secondCell.getMyColor());
		
		
		Cell temp = new Cell(getCellXY(firstCell.x,firstCell.y));
		cells.remove(getCellXY(firstCell.x,firstCell.y));
		
		Cell rndNeigh =  neighs.get(HelperRandom.getRandomInt(0,neighs.size()));
		
		rndNeigh = new Cell(getCellXY(rndNeigh.x,rndNeigh.y));
		cells.remove(getCellXY(rndNeigh.x,rndNeigh.y));
		
		
		cells.add( new Cell(rndNeigh.x,rndNeigh.y,temp.myColor));
		cells.add( new Cell(temp.x,temp.y,rndNeigh.myColor));
		
		 
		
	
	}
	
	
	public void processRightChange(Cell cell, Cell cell2) {
		
		//for(int i=0;i<1000;i++) {
		 
			MyThread5 t = null;
			try {
				//cell = new Cell(getCellXY(HelperRandom.getRandomInt(0, 380/20),HelperRandom.getRandomInt(0, 380/20)));
			//	t = new MyThread( this, firstCell, secondCell );
				//this.mbs  = new MdfBufferStorage(this);
				t = new MyThread5( this, mbs, cell, cell2 );
				Thread th = new Thread(t);
				th.start();	
				//th.join();	
				
				
			} catch (Exception e) {
				 
				System.out.println(e.getMessage());  
				e.printStackTrace();
			}
		 
		//}

	
	}
	
public void processLeftChange(Cell cell, Cell cell2) {
		  
			//MyThread3 t= null;
			//MyThread6 t = null;
			MyThread t=null;
			try {
				 
				//t = new MyThread( this, mbs, cell, cell2 );
				t = new MyThread( this, mbs, cell, cell2);
				Thread th = new Thread(t);
				th.start();	
				//th.join();	
				
				
			} catch (Exception e) {
				 
				System.out.println(e.getMessage());  
				e.printStackTrace();
			}
		 
		 

	
	}

	public void processPrimaryClickOnCanvas0(Cell cell) {
		
		
		if(cell == null) return;
		
		if((firstCell != null) && (secondCell != null)) return; 
			
		
		if(firstCell == null) {
				 firstCell = cell;
				 secondCell = null;
		 } 
		 else {
			 
				 if(secondCell==null) {
					 secondCell = cell;
					 processLeftChange(firstCell,secondCell);
					 this.app.redrawCanvases();
					 firstCell = null;
					 secondCell = null;
					 processChangeCalled=false;
				 }
				 else {
					 firstCell = null;
					 secondCell = null;
				 }
			 
		 }
  	
			
	}

	public CellStats[][] loadRules() throws Exception {
		 
		this._initCells();
		this.app.redrawCanvases();
		
		if(this.cells==null) return null;
		 if(this.cells.size()==0) return null;
		 
		 int w =  GameModel.windowWidth;///GameModel.cellWidth;
         int h =  GameModel.windowHeight;///GameModel.cellHeight;
         
         CellStats[][] cellStats = new  CellStats[w][h];
         for(int i = 0; i < w; i++) {
             for(int j = 0; j < h; j++) {
            	 Cell c = getCellXY(i,j); 
            	 ArrayList<Cell> neighs = defineNeigh(c.x, c.y, c.myColor); 
            	 ArrayList<Cell> neighs2 = defineNeighNeigh(c.x, c.y, c.myColor);
            	ArrayList<Cell> diff = defineEmpty(c.x, c.y);
            	 Logger.lo("cell="+c+" empties: "+ diff.size());
            	 Logger.lo("cell="+c+" other colors: "+ neighs.size());
            	 Logger.lo("cell="+c+" same colors:"+ neighs2.size());
            	 
            	 neighs.add(0, c);
            	 
            	
				cellStats[i][j] = new CellStats( diff, neighs, neighs2 ); 
        		 
             }
         }
         
         return cellStats;
		 
	
	}

	public void saveRules(Window primaryStage) throws IOException {
		 FileChooser fileChooser = new FileChooser();
         
         //Set extension filter
         FileChooser.ExtensionFilter extFilter = 
                 new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
         fileChooser.getExtensionFilters().add(extFilter);
       
         //Show save file dialog
         File file = fileChooser.showSaveDialog(primaryStage);
         
         Canvas canvas = this.app.getCanvas0();
         int w = (int) canvas.getWidth();
         int h = (int) canvas.getHeight();
         
         if(file != null) {
             
                 //WritableImage writableImage = new WritableImage(w,h);
                 //canvas.snapshot(null, writableImage);
                 
            	 BufferedImage img = new BufferedImage( w, h, BufferedImage.TYPE_INT_RGB );
            	 
            	 for(int i=0;i<w;i++) {
            		 for(int j=0;j<h;j++) {
            			 int[] color = getCellXY(i,j).getMyColor();
		            	 int r = color[0];
		            	 int g = color[1];
		            	 int b = color[2];
		            	 int a = color[3]; // alpha (transparency) component 0...255
		            	 int col = (a << 24) | (r << 16) | (g << 8) | b;
		            	 img.setRGB(i, j, col);
            		 }
            	 }
            	 
            	 
            	// RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                 ImageIO.write(img, "png", file);
             	 
                 //Logger.getLogger(JavaFX_DrawOnCanvas.class.getName()).log(Level.SEVERE, null, ex);
             
         
         }
		
	}

	public synchronized void addCell(Cell newCellM) {
		cells.add(newCellM);
	}

	public synchronized void removeCell(Cell linkCellM) {
		cells.remove(linkCellM);
		
	}
	
	
	
	
	
	
	
	
	
	  
	
    
    
    // private void whenUserClickedOnCanvas(MouseEvent event) {
                    
        
        // // Get the graphics context of the canvas
        // GraphicsContext gc = getCanvas().getGraphicsContext2D();
        // WritableImage snap = gc.getCanvas().snapshot(null, null);
        // PixelReader pr =  snap.getPixelReader();
        
        // //int[] point = get_selected_seed(event);

        // if(cellEmpty(pr,event)) { 
            
            // //System.out.println("#1");
    
            // fillCell_pro(event);
        // }
        
        // else {
            
            // //System.out.println("#2");
    
            // emptyCell_pro(event);
        // }

        // redrawBoard();
    
    // }


// private boolean cellEmptyXY( int n, int m ) {
    
    // Color c1 = this.im.colors_array[n][m]; 
    // return c1.equals( this.color_empty);
 
// }

// private boolean cellEmpty( MouseEvent e ) {
    
    // int[] point = get_selected_seed(e);
    // Color c1 = getColorFromCell(pr,point[0],point[1]);
    // //Color c2 =  this.colors[ arr_cell_2d [point[2]] [point[3]] ];
    // return c1.equals( this.color_empty);
// }


    // private void fillCell_pro(MouseEvent e){
        
        // int[] point = get_selected_seed(e);
        
        // this.im.colors_array[point[2]][point[3]] =  this.color_when_painted; 
        
    // }



    // private void emptyCell_pro(MouseEvent e){
        
        // int[] point = get_selected_seed(e);
        
        // this.im.colors_array[point[2]][point[3]] =  this.color_empty; 
     
    // }
    
    // private void setCols() {
    // int cols = 10;
    // String s1 = txt1.getText().toString();    
    // if (s1.matches("^[0-9]+$")) 
    // {
        // cols = Integer.parseInt(s1);
        // if(cols<=10) cols=10;
        // else if(cols>600) cols=600;
    // }
    // this.cols = cols; 
    // txt1.setText(""+this.cols);
// }

// private void setRows() {
    // int rows = 10;
    // String s2 = txt2.getText().toString();    
    // if (s2.matches("^[0-9]+$")) 
    // {
        // rows = Integer.parseInt(s2);
        // if(rows<=10) rows=10;
        // else if(rows>600) rows=600;
    // }
    // this.rows = rows;
    // txt2.setText(""+this.rows);
// }

// // // public static void flyToNotWhiteSpace() {
    
    // // // getAreaArray( heroPositionX, heroPositionY );
        
        
				// // // int res = 0;
                // // // do {  
                        // // // res = ModDummyFast.dummy_fast_thread ( );
                        // // // try {
                        // // // Thread.sleep(20);
                        // // // }
                        // // // catch(InterruptedException ex) {
                        // // // }
                // // // } 
                // // // while(res == 5);
        
        
        
        // // // ImagePointColor icp = getMaxDistancePointFromHero(ModDummyFast.global_dummy_fast_thread_border_cluster);
        // // // if(icp != null) {
        
            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearNotWith(im, icp.x, icp.y, Color.WHITE ); 
            // // // if(list.size()>0) {
        
                // // // icp = list.get(MainGraphics.getRandomInt(0,list.size()));
                
                // // // // teleport hero to
                // // // int oldx = this.heroPositionX;
                // // // int oldy = this.heroPositionY;
                // // // MainGraphics.fillPixel(this.im, oldx, oldy, Color.WHITE);
                
                // // // this.heroPositionX = icp.x;
                // // // this.heroPositionY = icp.y;
                // // // this.underHeroColor = icp.color;
                // // // MainGraphics.fillPixel(this.im, icp.x, icp.x, Color.RED);
            
            // // // }
            // // // else 
            // // // {
                    // // // System.out.println("Not any not white");
                    // // // System.exit(1);
            // // // }
            
        // // // }
                            
// // // }        
    
    
    // // // public static void getAreaArray(int x, int y) {
    
    // // // ModDummyFast.init_dummy_fast_thread();
					
	// // // ModDummyFast.global_dummy_fast_thread_arr2_all.add( new ImagePointColor(x,y,null) );

    // // // //ModDummyFast.global_dummy_fast_thread_imgData = imgData7;// imgData9;
				
	// // // //ModDummyFast.global_dummy_fast_thread_in_cluster = [];
	
    // // // //ModDummyFast.global_dummy_fast_thread_border_cluster = [];
				
	// // // ModDummyFast.global_dummy_fast_thread_color = im.get(x,y);

	// // // //ModDummyFast.global_removed_x_y_obj = {};

	// // // //ModDummyFast.global_dummy_fast_thread_first_x=x;

	// // // //ModDummyFast.global_dummy_fast_thread_first_y=y;
				
	// // // //ModDummyFast.global_fill_color=getRndColor();
    
    
 
        
    
				// // // int res = 0;
                // // // do {  
                        // // // res = ModDummyFast.dummy_fast_thread ( );
                        // // // try {
                        // // // Thread.sleep(20);
                        // // // }
                        // // // catch(InterruptedException ex) {
                        // // // }
                // // // } 
                // // // while(res == 5);
                
              // // // //  System.exit(1);
// // // }



                // public static boolean hasGoldInArea() {
                
                // int gold = 0;
                // System.out.println("borders.size="+ModDummyFast.global_dummy_fast_thread_border_cluster.size());
                 // System.out.println("in.size="+ModDummyFast.global_dummy_fast_thread_in_cluster.size());
                
                // for(int i=0;i<ModDummyFast.global_dummy_fast_thread_border_cluster.size();i++) {
                    // ImagePointColor icp = ModDummyFast.global_dummy_fast_thread_border_cluster.get(i);
                    // //if(im.get(icp.x,icp.y).equals(Color.GOLD)) gold++;
                    // System.out.println("BORDERCELLS: "  + icp);
                   
                    // int n = MainGraphics.countNear(im, icp.x, icp.y, Color.GOLD);
                  
                   // if(n>0){ 
                   
                   // System.out.println("n="+n);
                   // System.out.println("Bingo");
                       // gold=1;
                       // break;
                   // }
                   // // ArrayList list = MainGraphics.getSameColorNeighbors0( im, Color.GOLD, icp.x, icp.y, 1, 1 );
                   // // if(list.size()>0) {
                   // //      ArrayList<ImagePointColor> arr = (ArrayList<ImagePointColor>) list.get(0);
               
                    // //    if(arr.size()>0)
                    // //        System.out.println("Bingo");
                    
                // }
                
                // // for(int i=0;i<ModDummyFast.global_dummy_fast_thread_in_cluster.size();i++) {
                    
                    // // ImagePointColor icp = ModDummyFast.global_dummy_fast_thread_in_cluster.get(i);
                    // // //if(im.get(icp.x,icp.y).equals(Color.GOLD)) gold++;
                    
                    // // System.out.println(" INNER CELLS: "  + icp);
                    // // ArrayList list = MainGraphics.getSameColorNeighbors0( im, Color.GOLD, icp.x, icp.y, 1, 1 );
                    // // if(list.size()>0) {
                        // // ArrayList<ImagePointColor> arr = (ArrayList<ImagePointColor>) list.get(0);
               
                           // // if(arr.size()>0)
                           
                        // // System.out.println("Bongo");
                    // // }
                // // }
                
                // System.out.println("GOLD found "+gold);
                // if(gold>0) return true;
                // return false;
                
                // }
 // public static void clear_area(){
     
    // for(int i=0;i<ModDummyFast.global_dummy_fast_thread_border_cluster.size();i++) {
    
        // ImagePointColor icp = ModDummyFast.global_dummy_fast_thread_border_cluster.get(i);
        // im.set(icp.x,icp.y,Color.WHITE);
        // //            System.out.println("BORDERCELLS: "  + icp);
                   
        // //            int n = MainGraphics.countNear(im, icp.x, icp.y, Color.GOLD);
                  
        // //           if(n>0){ 
                   
        // //           System.out.println("n="+n);
        // //           System.out.println("Bingo"ModDummyFast.global_dummy_fast_thread_border_cluster.size());
        // //               gold=1;
        // //               break;
        // //           }
                   // // ArrayList list = MainGraphics.getSameColorNeighbors0( im, Color.GOLD, icp.x, icp.y, 1, 1 );
                   // // if(list.size()>0) {
                   // //      ArrayList<ImagePointColor> arr = (ArrayList<ImagePointColor>) list.get(0);
               
                    // //    if(arr.size()>0)
                    // //        System.out.println("Bingo");
                    
    // }
    
     // for(int i=0;i<ModDummyFast.global_dummy_fast_thread_in_cluster.size();i++) {
    
        // ImagePointColor icp = ModDummyFast.global_dummy_fast_thread_in_cluster.get(i);
        // im.set(icp.x,icp.y,Color.WHITE);
     // }
                
// }




// public static void processSecondaryClick_part_two(int[] point) 
// {
    
    // int oldx = this.heroPositionX;
    // int oldy = this.heroPositionY;
    // //Color oldUnderHeroColor =  this.underHeroColor;
    
             
    // int newx = point[2];
    // int newy = point[3];
    
    // //Color newColor = this.im.get(newx,newy);
    
          
    // MainGraphics.fillPixel(this.im, oldx, oldy, this.underHeroColor);
            
            
            // // // // // // // // // // // // // // // // // // return;
    // // // // // // // // // // // // // // // // // // //}
    
    
    
    


    // if(point[2] == oldx && point[3]==oldy) {
         
    // }
    // else {
        // int dx = Math.abs(point[2] - this.heroPositionX);
        // int dy = Math.abs(point[3] - this.heroPositionY);
        // if(dx<=1 && dy<=1) {
            
            // if(im.get(point[2],point[3]).equals(Color.GOLD)) {
                
            // }
            // else { 
            
            // pushPixel(point);
            
            // if(!oldUnderHeroColor.equals(newColor))
                     // {
                            // //System.out.println("Looking for gold...");
                            // //getAreaArray(point[2],point[3]);
                            // //if(!hasGoldInArea())  clear_area();
                            
                            
                     // }
                     // else 
                     // {
                         
                         
                        // // System.out.println("we here #555");
                        
                         
                     // }
            // }
        // }
        // else {
            
             
                
////                    if(oldUnderHeroColor.equals(newColor))
                // {
                    
                    // pushPixel(point);
                    
                    
                // }
            
            
        // }
        
    // }
    
    
    
     
    // // if (newColor.equals(oldColor)) {
       // // // int q4 = MainGraphics.countNear( this.im, newx, newy, newColor);
       // // // if(q4==8) {
         
         // // clear_if_without_gold();
        // // teleport_for_free();
     
     
      // // this.screen.redrawBoard();
     // // return; 
      // // //  }                
    
   // // }
      
    
    
    
                            // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(this.im, point[2], point[3], this.im.get(point[2], point[3]) ); 
                            // // if(list.size()>0) {
                                // // System.out.println("rq="+list.size());
                                // // if(list.size()==8) {
                                // // clear_if_without_gold();
        // // teleport_for_free();
                           // // return; 
                                
                                
                                // // }
                            // // }
    
    
    
    // //this.underHeroColor = oldUnderHeroColor;
    // //MainGraphics.fillPixel(this.im, oldx, oldy, Color.RED );
    // //do {
    // //teleport_for_free();
    // //}
    // //while(this.heroPositionX==0 || this.heroPositionY==0 || this.heroPositionX==im.cols || this.heroPositionX==im.rows);
    
    
    



    
    
    
    // MainGraphics.setHero( this.im, this.heroPositionX, this.heroPositionY ); 

    // this.screen.redrawBoard();










// }








// // // public static void pushPixel(int[] point) {

    // // // if(point[2] >= this.im.cols) return;
        // // // if(point[3] >= this.im.rows) return;
        // // // if(point[2] <0  ) return;
        // // // if(point[3] <0  ) return;
// // // //to right
                    // // // if( ((point[2] - this.heroPositionX) > 0) && ((point[3] - this.heroPositionY) == 0) ) {
                        
                        // // // Color emptyPlace0 = im.get(point[2]+1,point[3]);
                        // // // if( emptyPlace0 != null) { 
                            // // // if(emptyPlace0.equals(Color.WHITE)) {
                                
                                   // // // Color t = im.get(point[2],point[3]);
                                   // // // im.set( point[2], point[3], emptyPlace0 );
                                   // // // im.set( point[2]+1, point[3], t);
                         
                            // // // }
                            // // // else {
                                
                                // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                                // // // if(list.size()>0) {
                                    // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                    // // // if(point2 != null) {
                                        // // // Color t = im.get(point[2],point[3]);
                                        // // // im.set( point[2], point[3], Color.WHITE );
                                        // // // im.set( point2.x , point2.y, t);
                                    // // // }
                                // // // }
                            // // // }
                        // // // }
                        // // // else {
                            
                            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                                // // // if(list.size()>0) {System.out.println("fff0"); 
                                    // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                    // // // if(point2 != null) {
                                        // // // Color t = im.get(point[2],point[3]);
                                        // // // im.set( point[2], point[3], Color.WHITE );
                                        // // // im.set( point2.x , point2.y, t);
                                    // // // }
                                // // // }
                        // // // }
                    // // // }
                    
                    // // // // to left
                    // // // if( ((point[2] - this.heroPositionX) < 0) && ((point[3] - this.heroPositionY) == 0) ) {
                        
                        // // // Color emptyPlace1 = im.get(point[2]-1,point[3]);
                         // // // if( emptyPlace1 != null) {
                        // // // if(emptyPlace1.equals(Color.WHITE)) {
                            
                               // // // Color t = im.get(point[2],point[3]);
                               // // // im.set( point[2], point[3], emptyPlace1 );
                               // // // im.set( point[2]-1, point[3], t);
                     
                        // // // }
                        // // // else {
                            
                             // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                            // // // if(list.size()>0) {
                                // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                // // // if(point2 != null) {
                                    // // // Color t = im.get(point[2],point[3]);
                                    // // // im.set( point[2], point[3], Color.WHITE );
                                    // // // im.set( point2.x , point2.y, t);
                                // // // }
                            // // // }
                        // // // }
                         // // // }
                         // // // else {
                            // // // System.out.println("fff1");
                        // // // }
                        
                    // // // }
                    
                    // // // //to top
                    // // // if( ((point[2] - this.heroPositionX) == 0) && ((point[3] - this.heroPositionY) < 0) ) {
                        
                        // // // Color emptyPlace2 = im.get(point[2],point[3]-1);
                         // // // if( emptyPlace2 != null) {
                        // // // if(emptyPlace2.equals(Color.WHITE)) {
                            
                               // // // Color t = im.get(point[2],point[3]);
                               // // // im.set( point[2], point[3], emptyPlace2 );
                               // // // im.set( point[2], point[3]-1, t);
                     
                        // // // }
                        // // // else {
                            
                            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                            // // // if(list.size()>0) {
                                // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                // // // if(point2 != null) {
                                    // // // Color t = im.get(point[2],point[3]);
                                    // // // im.set( point[2], point[3], Color.WHITE );
                                    // // // im.set( point2.x , point2.y, t);
                                // // // }
                            // // // }
                        // // // }
                         // // // }
                         // // // else {
                            // // // System.out.println("fff2");
                        // // // }
                    // // // }
                    
                    // // // //to bottom
                    // // // if( ((point[2] - this.heroPositionX) == 0) && ((point[3] - this.heroPositionY) > 0) ) {
                        
                        // // // Color emptyPlace3 = im.get(point[2],point[3]+1);
                         // // // if( emptyPlace3 != null) {
                        // // // if(emptyPlace3.equals(Color.WHITE)) {
                            
                               // // // Color t = im.get(point[2],point[3]);
                               // // // im.set( point[2], point[3], emptyPlace3 );
                               // // // im.set( point[2], point[3]+1, t);
                     
                        // // // }
                        // // // else {
                            
                            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                            // // // if(list.size()>0) {
                                // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                // // // if(point2 != null) {
                                    // // // Color t = im.get(point[2],point[3]);
                                    // // // im.set( point[2], point[3], Color.WHITE );
                                    // // // im.set( point2.x , point2.y, t);
                                // // // }
                            // // // }
                        // // // }
                         // // // }
                         // // // else {
                            // // // System.out.println("fff3");
                        // // // }
                    // // // }
                    
                    // // // /////////////////////////////////////////////////////////
                    // // // int dx = point[2] - this.heroPositionX;
                    // // // int dy = point[3] - this.heroPositionY;
                      // // // if( (dx == dy)  && (dx > 0) ) {
                        
                        // // // Color emptyPlace4 = im.get(point[2]+1,point[3]+1);
                         // // // if( emptyPlace4 != null)
                        // // // if(emptyPlace4.equals(Color.WHITE)) {
                            
                               // // // Color t = im.get(point[2],point[3]);
                               // // // im.set( point[2], point[3], emptyPlace4 );
                               // // // im.set( point[2]+1, point[3]+1, t);
                     
                        // // // }
                        // // // else {
                            
                            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                            // // // if(list.size()>0) {
                                // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                // // // if(point2 != null) {
                                    // // // Color t = im.get(point[2],point[3]);
                                    // // // im.set( point[2], point[3], Color.WHITE );
                                    // // // im.set( point2.x , point2.y, t);
                                // // // }
                            // // // }
                        // // // }
                    // // // }
                    
                    // // // if( (dx == dy)  && (dx < 0) ) {
                        
                        // // // Color emptyPlace5 = im.get(point[2]-1,point[3]-1);
                         // // // if( emptyPlace5 != null)
                        // // // if(emptyPlace5.equals(Color.WHITE)) {
                            
                               // // // Color t = im.get(point[2],point[3]);
                               // // // im.set( point[2], point[3], emptyPlace5 );
                               // // // im.set( point[2]-1, point[3]-1, t);
                     
                        // // // }
                        // // // else {
                            
                            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                            // // // if(list.size()>0) {
                                
                                // // // for(int i=0;i<list.size();i++) System.out.println(list.get(i));
                                // // // System.out.println("ux="+this.heroPositionX+",uy="+this.heroPositionY);
                                
                                
                                // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                // // // if(point2 != null) {
                                    // // // Color t = im.get(point[2],point[3]);
                                    // // // im.set( point[2], point[3], Color.WHITE );
                                    // // // im.set( point2.x , point2.y, t);
                                // // // }
                            // // // }
                        // // // }
                    // // // }
                    
                    // // // if( (dx != dy)  && ((dx + dy)==0) && dx > 0 )  {
                        
                        // // // Color emptyPlace6 = im.get(point[2]+1,point[3]-1);
                        // // // if( emptyPlace6 != null)
                        // // // if(emptyPlace6.equals(Color.WHITE)) {
                            
                               // // // Color t = im.get(point[2],point[3]);
                               // // // im.set( point[2], point[3], emptyPlace6 );
                               // // // im.set( point[2]+1, point[3]-1, t);
                     
                        // // // }
                        // // // else {
                            
                            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                            // // // if(list.size()>0) {
                                // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                // // // if(point2 != null) {
                                    // // // Color t = im.get(point[2],point[3]);
                                    // // // im.set( point[2], point[3], Color.WHITE );
                                    // // // im.set( point2.x , point2.y, t);
                                // // // }
                            // // // }
                        // // // }
                    // // // }

                     // // // if( (dx != dy)  && ((dx + dy)==0) && dx < 0 )  {
                        
                        // // // Color emptyPlace7 = im.get(point[2]-1,point[3]+1);
                        // // // if( emptyPlace7 != null)
                        // // // if(emptyPlace7.equals(Color.WHITE)) {
                            
                               // // // Color t = im.get(point[2],point[3]);
                               // // // im.set( point[2], point[3], emptyPlace7 );
                               // // // im.set( point[2]-1, point[3]+1, t);
                     
                        // // // }
                        // // // else {
                            
                            // // // ArrayList<ImagePointColor> list = MainGraphics.pointNearWith(im, point[2], point[3], Color.WHITE ); 
                            // // // if(list.size()>0) {
                                // // // ImagePointColor point2 = getMaxDistancePointFromHero(list);
                                // // // if(point2 != null) {
                                    // // // Color t = im.get(point[2],point[3]);
                                    // // // im.set( point[2], point[3], Color.WHITE );
                                    // // // im.set( point2.x , point2.y, t);
                                // // // }
                            // // // }
                        // // // }
                    // // // }


// // // }

// // // public static ImagePointColor getMaxDistancePointFromHero( ArrayList<ImagePointColor> list ) {
    
    
    
    
    
    
      // // // int x = this.heroPositionX;
    // // // int y = this.heroPositionY;
   // // // double maxd= 0;
     
    // // // int resultIcp = -1;
    // // // for(int i=0;i<list.size();i++) {
                    
        // // // ImagePointColor icp = list.get(i);
        // // // double q = Math.sqrt(Math.abs(icp.x - x)*Math.abs(icp.x - x) + Math.abs(icp.y - y)*Math.abs(icp.y - y));
        // // // if( q > maxd) {
            // // // resultIcp = i;
            // // // maxd = q;
        // // // }
    // // // }

        
    // // // if(resultIcp == -1) return null;
    
    // // // return list.get(resultIcp);
    
    
    
    
    
   
    
    // // // // int x = this.heroPositionX;
    // // // // int y = this.heroPositionY;
    // // // // int maxx = 0;
    // // // // int maxy = 0;
    // // // // int resultIcp = -1;
    // // // // for(int i=0;i<list.size();i++) {
                    
        // // // // ImagePointColor icp = list.get(i);
        // // // // if( Math.abs(icp.x - x) > maxx) {
            // // // // resultIcp = i;
            // // // // maxx = Math.abs(icp.x - x);
        // // // // }
    // // // // }

    // // // // for(int i=0;i<list.size();i++) {
                
        // // // // ImagePointColor icp = list.get(i);
         
        // // // // if( Math.abs(icp.y - y) > maxy) {
            // // // // resultIcp = i;
            // // // // maxy = Math.abs(icp.y - y);
            
        // // // // }           
    // // // // }
        
    // // // // if(resultIcp == -1) return null;
    
    // // // // return list.get(resultIcp);
    
// // // }


    
}