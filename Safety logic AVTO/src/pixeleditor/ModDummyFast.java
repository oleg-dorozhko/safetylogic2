package pixeleditor;

import javafx.scene.paint.Color;
//import javafx.scene.input.MouseEvent;
import java.util.*;

public class ModDummyFast {

//public static int global_dummy_fast_thread_x=0;
//public static int global_dummy_fast_thread_y=0;
//public static int global_dummy_fast_thread_first_x=0;
//public static int global_dummy_fast_thread_first_y=0;

	//public static ImageColor global_dummy_fast_thread_imgData=null;

	public   ArrayList<Cell> global_dummy_fast_thread_in_cluster = null;
public ArrayList<Cell> global_dummy_fast_thread_border_cluster = null;
public   int[] global_dummy_fast_thread_color=null;
public   ArrayList<Cell> global_dummy_fast_thread_arr2_all=null;
public   int global_dummy_fast_thread_radius=200;
public   int global_dummy_fast_thread_radius_counter=0;
public   HashMap<String, Integer>  global_removed_x_y_obj = null;
private   GameModel model = null;

public   synchronized   void init_dummy_fast_thread(GameModel model)
{
	 this.model = model;
	//global_dummy_fast_thread_x=0;
	//global_dummy_fast_thread_y=0;
	//global_dummy_fast_thread_first_x=0;
	//global_dummy_fast_thread_first_y=0;
    
//	global_dummy_fast_thread_imgData = new ImageColor(GameModel.im.cols,GameModel.im.rows);
//    for (int y = 0; y < GameModel.im.rows; y++) {
//        for (int x = 0; x < GameModel.im.cols; x++) {
//                    
//                Color t = GameModel.im.get(x,y);
//                global_dummy_fast_thread_imgData.set(x,y,t);
//            }
//        }
        
	global_dummy_fast_thread_in_cluster = new ArrayList<Cell>();
	global_dummy_fast_thread_border_cluster =  new ArrayList<Cell>();
	global_dummy_fast_thread_color = null;
	global_dummy_fast_thread_arr2_all= new ArrayList<Cell>();
    
	global_dummy_fast_thread_radius=200;
	global_dummy_fast_thread_radius_counter=0;
	global_removed_x_y_obj = new HashMap<String, Integer>();
}

public   synchronized   int dummy_fast_thread ( ) throws Exception
{
	if(global_dummy_fast_thread_arr2_all.size() == 0)
	{ 
		//callback();
		return 3;
	}
	
	//global_dummy_fast_thread_radius_counter++;
	
			//int M =  MainGraphics.getRandomInt(0,global_dummy_fast_thread_arr2_all.size());
            //ImagePointColor xy = global_dummy_fast_thread_arr2_all.get(M);
            Cell xy = global_dummy_fast_thread_arr2_all.get(0);
            int x=xy.x;
            int y=xy.y;
			
		//	if( global_dummy_fast_thread_radius_counter > global_dummy_fast_thread_radius )
		//	{ 
            //System.out.println("5here "+global_dummy_fast_thread_radius_counter);
            //System.out.println("5here "+global_dummy_fast_thread_radius);
				//callback();
			//	return 2;
			//}
			//else 
            {
				//System.out.println("7here "  + global_dummy_fast_thread_color.toString());
                String key = new String(""+x+"_"+y);
                 
                if( !global_removed_x_y_obj.containsKey(key) )
                {
                    
                    //ArrayList list = MainGraphics.getSameColorNeighbors0( global_dummy_fast_thread_imgData, global_dummy_fast_thread_color, x, y, 1, 1 );
                    //ArrayList<ImagePointColor> arr = (ArrayList<ImagePointColor>) list.get(0);
                    ArrayList<Cell> arr = model.defineMdfSameNeigh(x, y, global_dummy_fast_thread_color);
            //        System.out.println(arr.size());
                    for(int i=0;i<arr.size();i++) 
                    {
                        
                        Cell x1y1 = arr.get(i);
                        int x1 = x1y1.x;
                        int y1 = x1y1.y;
                        
                        global_dummy_fast_thread_arr2_all.add(new Cell(x1,y1,x1y1.getMyColor()));
                    }
                    
                    if(model.defineNeighNeigh(x, y, global_dummy_fast_thread_color).size()<8) {
                    	global_dummy_fast_thread_border_cluster.add(new Cell(x,y,global_dummy_fast_thread_color )); 	
                    }
                    else  global_dummy_fast_thread_in_cluster.add(new Cell(x,y,global_dummy_fast_thread_color));
                    
                    global_removed_x_y_obj.put( key, 1 );
                   
                    
                   
              
                }
			
			}
			
			//global_dummy_fast_thread_arr2_all.remove(M);
			global_dummy_fast_thread_arr2_all.remove(0);
            //global_dummy_fast_thread_imgData =  fillRectangleFast(global_dummy_fast_thread_imgData,x,y,1,1,[255,255,255,255]);
			// global_dummy_fast_thread_imgData.set(x,y,Color.BLUE);
            // // /////////
            // try{
             // GameModel.setImageColor(global_dummy_fast_thread_imgData);
             // }
             // catch(Exception ex) {
             // }
			if(global_dummy_fast_thread_arr2_all.size()==0) {
                
                //callback();
                
                return 1;
                
                }
		
			else 
			{
				// var canvas7 = document.getElementById("canvas0");
				// var context7 = canvas7.getContext("2d");
				
				// context7.putImageData(global_dummy_fast_thread_imgData,0,0);
				
				// refresh_map();
				
				//setTimeout( function(){  dummy_fast_thread( callback ) }, 5 );
                
                return 5;
		
			}
	
}




public   synchronized ModDummyFast getAreaArrays(GameModel model, Cell cell) throws Exception {
    
	init_dummy_fast_thread(this.model);
					
	 global_dummy_fast_thread_arr2_all.add( new Cell(cell) );
	 global_dummy_fast_thread_color = cell.myColor;
   
   

       
   
				 int res = 0;
                do {  
                        res = dummy_fast_thread ( );
                        try {
                        Thread.sleep(20);
                        }
                        catch(InterruptedException ex) {
                        }
                } 
                while(res == 5);
				return this;
               
              //  System.exit(1);
}

public   synchronized void getClusterFromCells(ArrayList<Cell> cells, Cell cell) {
	 
	global_dummy_fast_thread_in_cluster = new ArrayList<Cell>();
	global_dummy_fast_thread_border_cluster =  new ArrayList<Cell>();
	global_dummy_fast_thread_color = null;
	global_dummy_fast_thread_arr2_all= new ArrayList<Cell>();
    
	global_dummy_fast_thread_radius=200;
	global_dummy_fast_thread_radius_counter=0;
	global_removed_x_y_obj = new HashMap<String, Integer>();
	 global_dummy_fast_thread_arr2_all.add( new Cell(cell) );
	 global_dummy_fast_thread_color = cell.myColor;
  
  

      
  
				 int res = 0;
               do {  
                       res = dummy_fast_thread_cells ( cells );
                       try {
                       Thread.sleep(20);
                       }
                       catch(InterruptedException ex) {
                       }
               } 
               while(res == 5);
				 
              
	
}

private   synchronized int dummy_fast_thread_cells(ArrayList<Cell> cells) {
	if(global_dummy_fast_thread_arr2_all.size() == 0)
	{ 
		//callback();
		return 3;
	}
	
	//global_dummy_fast_thread_radius_counter++;
	
			//int M =  MainGraphics.getRandomInt(0,global_dummy_fast_thread_arr2_all.size());
            //ImagePointColor xy = global_dummy_fast_thread_arr2_all.get(M);
            Cell xy = global_dummy_fast_thread_arr2_all.get(0);
            int x=xy.x;
            int y=xy.y;
			
		//	if( global_dummy_fast_thread_radius_counter > global_dummy_fast_thread_radius )
		//	{ 
            //System.out.println("5here "+global_dummy_fast_thread_radius_counter);
            //System.out.println("5here "+global_dummy_fast_thread_radius);
				//callback();
			//	return 2;
			//}
			//else 
            {
				//System.out.println("7here "  + global_dummy_fast_thread_color.toString());
                String key = new String(""+x+"_"+y);
                 
                if( !global_removed_x_y_obj.containsKey(key) )
                {
                    
                    //ArrayList list = MainGraphics.getSameColorNeighbors0( global_dummy_fast_thread_imgData, global_dummy_fast_thread_color, x, y, 1, 1 );
                    //ArrayList<ImagePointColor> arr = (ArrayList<ImagePointColor>) list.get(0);
                    ArrayList<Cell> arr = defineCellsSameNeigh(cells, x, y, global_dummy_fast_thread_color);
            //        System.out.println(arr.size());
                    for(int i=0;i<arr.size();i++) 
                    {
                        
                        Cell x1y1 = arr.get(i);
                        int x1 = x1y1.x;
                        int y1 = x1y1.y;
                        
                        global_dummy_fast_thread_arr2_all.add(new Cell(x1,y1,x1y1.getMyColor()));
                    }
                    
                    if(defineCellsNeighNeigh(cells,x, y, global_dummy_fast_thread_color).size()<8) {
                    	global_dummy_fast_thread_border_cluster.add(new Cell(x,y,global_dummy_fast_thread_color )); 	
                    }
                    else  global_dummy_fast_thread_in_cluster.add(new Cell(x,y,global_dummy_fast_thread_color));
                    
                    global_removed_x_y_obj.put( key, 1 );
                   
                    
                   
              
                }
			
			}
			
			//global_dummy_fast_thread_arr2_all.remove(M);
			global_dummy_fast_thread_arr2_all.remove(0);
            //global_dummy_fast_thread_imgData =  fillRectangleFast(global_dummy_fast_thread_imgData,x,y,1,1,[255,255,255,255]);
			// global_dummy_fast_thread_imgData.set(x,y,Color.BLUE);
            // // /////////
            // try{
             // GameModel.setImageColor(global_dummy_fast_thread_imgData);
             // }
             // catch(Exception ex) {
             // }
			if(global_dummy_fast_thread_arr2_all.size()==0) {
                
                //callback();
                
                return 1;
                
                }
		
			else 
			{
				// var canvas7 = document.getElementById("canvas0");
				// var context7 = canvas7.getContext("2d");
				
				// context7.putImageData(global_dummy_fast_thread_imgData,0,0);
				
				// refresh_map();
				
				//setTimeout( function(){  dummy_fast_thread( callback ) }, 5 );
                
                return 5;
		
			}
	
}


public   synchronized Cell getCellXY(ArrayList<Cell> cells, int i, int j) {
	for (Cell cell : cells) {
		if((cell.x == i) && (cell.y==j)) return cell;
	}
	return null;
}

private   synchronized ArrayList<Cell> defineCellsSameNeigh(ArrayList<Cell> cells, int i, int j, int[] color) {
	    
	     ArrayList<Cell> list = new ArrayList<Cell>();
	     if(i<0) return list;
	     if(j<0) return list;
	    
	     
	         
	         int n=0;
	         int[] color0 = getCellsColorXY(cells,i-1,j-1);
	         int[] color1 = getCellsColorXY(cells,i,j-1);
	         int[] color2 = getCellsColorXY(cells,i+1,j-1);
	         int[] color3 = getCellsColorXY(cells,i-1,j);
	         int[] color4 = getCellsColorXY(cells,i,j);
	         int[] color5 = getCellsColorXY(cells,i+1,j);
	         int[] color6 = getCellsColorXY(cells,i-1,j+1);
	         int[] color7 = getCellsColorXY(cells,i,j+1);
	         int[] color8 = getCellsColorXY(cells,i+1,j+1);
	         
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

private   synchronized int[] getCellsColorXY(ArrayList<Cell> cells, int i, int j) {
	for (Cell cell : cells) {
		if((cell.x == i) && (cell.y==j)) return cell.getMyColor();
	}
	return null;
}   

public  synchronized ArrayList<Cell> defineCellsNeighNeigh(ArrayList<Cell> cells, int i, int j, int[] color)   {
    
    ArrayList<Cell> list = new ArrayList<Cell>();
    if(i<0) return list;
    if(j<0) return list;
   
    
        
        int n=0;
        int[] color0 = getCellsColorXY(cells, i-1,j-1);
        int[] color1 = getCellsColorXY(cells, i,j-1);
        int[] color2 = getCellsColorXY(cells, i+1,j-1);
        int[] color3 = getCellsColorXY(cells, i-1,j);
        int[] color4 = getCellsColorXY(cells, i,j);
        int[] color5 = getCellsColorXY(cells, i+1,j);
        int[] color6 = getCellsColorXY(cells, i-1,j+1);
        int[] color7 = getCellsColorXY(cells, i,j+1);
        int[] color8 = getCellsColorXY(cells, i+1,j+1);
      
        
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














} 
























