package pixeleditor;

import java.util.Collections;

import javafx.scene.input.MouseEvent;

public class GameMouseController {

    private GameModel model = null;
	public static int initial_dx=3;
	public static int initital_dy=3;
	private int last_n=0;
	private int last_m=0;
    
    public GameMouseController(GameModel model) {
        this.model=model;
    }
    
    private int[] get_selected_seed(MouseEvent e)
    {
            
            int x = (int)e.getX();
            int y = (int)e.getY();
            
            int t_widthOfCols = model.app.canvas_width / (GameConstants.WIDTH_OF_WINDOW*2);
        	int t_heightOfRows = model.app.canvas_height / (GameConstants.HEIGHT_OF_WINDOW*2);
           
        	int n1 = ( x / t_widthOfCols ); 
            int m1 = ( y / t_heightOfRows ); 
        //    System.out.println("n1="+n1);
        //    System.out.println("m1="+m1);
            
            int[] nm = decodeXYtoNM(n1,m1); 
            
          
            //last_n=n1;
            //last_m=m1;
            
            //int n1 = ( x / model.getWidthOfCols() );
            //int m1 = ( y / model.getHeightOfRows() );
            
            if(nm[0]>150||nm[0]<25) return null;
            if(nm[1]>150||nm[1]<25) return null;
             
            int res[] = new int[4];
            res[0]=x;
            res[1]=y;
            res[2]=nm[0];
            res[3]=nm[1];
            return res;
            
        
    }
    
    private int[] decodeXYtoNM(int n1, int m1) {
    	  
    	int hx = model.hero.getIp().getX();
          int hy = model.hero.getIp().getY();
      //    System.out.println("hx="+hx);
      //    System.out.println("hy="+hy);
          
          int stepx=0;
          if(n1>GameConstants.WIDTH_OF_WINDOW) stepx=1;
          if(n1<GameConstants.WIDTH_OF_WINDOW) stepx=-1;
          
          int stepy=0;
          if(m1>GameConstants.HEIGHT_OF_WINDOW) stepy=1;
          if(m1<GameConstants.HEIGHT_OF_WINDOW) stepy=-1;
          
          
        int r[] = new int[2];  
        r[0] = hx+stepx;
        r[1] = hy+stepy;
		return r;
	}

	public  void handlePrimaryClick(MouseEvent event) {
        
        int[] point = get_selected_seed(event);
        if(point == null) return;
        try  {
           model.processPrimaryClick(point);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }            
        //GameModel.screen.showAlertWithMessage("["+point[2]+","+point[3]+"]");
 
    }
    
    public  void handleSecondaryClick(MouseEvent event) {
    		
		int[] point = get_selected_seed(event);
        if(point == null) return;
        try {
              model.processSecondaryClick(point);
	    }
        catch(Exception ex) {
            ex.printStackTrace();
        }  
		
					
    }

	public Object handlePrimaryClickCanvas0(MouseEvent event) throws Exception {
		
		  int x = (int)event.getX();
          int y = (int)event.getY();
          
          int n = x/GameModel.cellWidth;
          int m = y/GameModel.cellHeight;
          
          //System.out.println(x/20);
          //System.out.println(y/20);
          //System.out.println(HelperRandom.strColor(model.getCellXY(x/20, y/20).getMyColor()));
          
          model.processPrimaryClickOnCanvas0(new Cell(n, m, model.getCellXY( n, m ).getMyColor()));
           
          
		return null;
	}

	public Object handleSecondaryClickCanvas0(MouseEvent event) throws Exception {
		
		Collections.shuffle(model.cells);
		int n=0;
		for(int i=0;i<GameModel.windowWidth;i++) {
			for(int j=0;j<GameModel.windowHeight;j++) {
				Cell c = model.cells.get(n);
				c.x = i;
				c.y = j;
				n++;
			}	
		}
		model.app.redrawCanvases();
		return null;
//		 int x = (int)event.getX();
//         int y = (int)event.getY();
//         
//          int n = x/GameModel.cellWidth;
//          int m = y/GameModel.cellHeight;
//         
//         //System.out.println(x/20);
//         //System.out.println(y/20);
//         //System.out.println(HelperRandom.strColor( model.getCellXY(x/20, y/20).getMyColor() ));
//         
//         model.processSecondaryClickOnCanvas0(new Cell(n,m,model.getCellXY(n, m).getMyColor()));
//          
//         
//		return null;
	}

	public Object handlePrimaryClickCanvas1(MouseEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object handleSecondaryClickCanvas1(MouseEvent event) {
		// TODO Auto-generated method stub
		return null;
	}
    
//function f_doLeftClick(x,y,callback) in mod_base.js

	
// public static void f_pixelsPro_whenClickedOnLabirint(int x, int y)
// {
    // Color color =  getColorArrayFromImageData(GameModel.im, x, y)
	
	// if(is_stone(x,y,color))
	// {
		// f_pixelsPro_whenRightClickedOnLabirint(x,y);
		// return;
	// } 
	
	// //get_neighbours(x,y);
			
	
	// // var params = 'md5='+glob_session_id+'&x='+x+'&y='+y;		
		// var post = {}
	// post["md5"]=glob_session_id;
	// post["x"]=glob_x_left_top;
	// post["y"]=glob_y_left_top;
	// var im =  s_pixels(post);	

		// // //send to server
		// // var xhr = new XMLHttpRequest();
		// // xhr.open('POST', global_url_to_glab+'/pixels', true);
		// // xhr.responseType = "blob";
		// // xhr.onload = function() {  
			
			// // if (xhr.readyState != 4) return;

			// // if (xhr.status != 200) {  var error = xhr.status + ': ' + xhr.statusText+': '+xhr.response; onerror(error); return; }
			
			// // var newImg = document.createElement("img");
							
			// // var urlCreator = window.URL || window.webkitURL;
			
			// // var imageUrl = urlCreator.createObjectURL(xhr.response);
				
			// // newImg.onload = function() {	
				
				// var canvas = document.getElementById("pixels");
				// if(canvas == null) throw new Error("Canvas pixels not found");
					// canvas.width = im.width;
				// canvas.height = im.height;
				// var ctx = canvas.getContext("2d");
				// ctx.putImageData(im,0,0);
				// //ctx.drawImage(newImg, 0, 0,canvas.width,canvas.height);
				
				
			// //	var params = 'x='+x+'&y='+y;		
	// var params = 'md5='+glob_session_id;
		// //send to server
		// // var xhr4 = new XMLHttpRequest();
		// // xhr4.open('POST', global_url_to_glab+'/get_error_message', true);
		// // xhr4.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		// // xhr4.responseType = "text";
		// // xhr4.onload = function() {  
			
			// // if (xhr4.readyState != 4) return;

			// // if (xhr4.status != 200) {  var error = xhr4.status + ': ' + xhr4.statusText+': '+xhr4.response; onerror(error); return; }
			
		// var	xhr4={}
		// xhr4.responseText = get_error_message(glob_session_id);	
			
		// //	console.log(''+xhr4.responseText);
			
			// if((xhr4.responseText=='6.1.27 stone_neighbours_of not ok')||(xhr4.responseText=='6.1.25 labirint not ok')||(xhr4.responseText=='none'))
			
				// //if(comparePrevStateAndNowState(newImg)==0)
				// {
					// if(is_exist_collected_stones_in_pocket())
					// {
						// f_pixelsPro_whenRightClickedOnLabirint(x,y);
						// return;
					// }
					
					
				// }
				
				
				
				
				
				
					
	// var params = 'md5='+glob_session_id+'&x='+glob_x_left_top+'&y='+glob_y_left_top;		
	
		// //send to server
		// // var xhr = new XMLHttpRequest();
		// // xhr.open('POST', global_url_to_glab+'/set_xy_labirint', true);
		// // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		// // xhr.responseType = "blob";
		// // xhr.onload = function() {  
			
			// // if (xhr.readyState != 4) return;

			// // if (xhr.status != 200) {  var error = xhr.status + ': ' + xhr.statusText+': '+xhr.response; onerror(error); return; }
			
				
				 // s_set_xy_labirint(glob_session_id,glob_x_left_top,glob_y_left_top);
				
				
				
				
				
			
							 // f_getChaosedLabirint( function()	 {
										
				
				// refresh_map();
				
				
							// //	if(glob_little_belly_pressed)
								// {
							// //		glob_little_belly_pressed=false;
							// //		btn_pixels_clean();
								
								// }
								
								// //glob_x_left_top=x;
								// //glob_y_left_top=y;
								
				// // here Jerard
				// f_samson();
				
							// });
			
			// // }
		// // xhr.send(params);	
			
			
		// // }
		// // xhr4.send(params);		
				
			
				
				// // getChaosedLabirint(function(){
					
					
					
					
				
				
				// // var xhr = new XMLHttpRequest();
				// // xhr.open('GET', global_url_to_glab+'/get_xy_labirint', true);
				// // xhr.onload = function(e) {  
			
					// // if (xhr.readyState != 4) return;
				
					// // if (xhr.status != 200) {  var error = xhr.status + ': ' + xhr.statusText+': '+xhr.response; onerror(error); throw new Error(error);  }
					
					// // var obj = JSON.parse(xhr.responseText);
					// // glob_x_left_top=Number(obj.x);
					// // glob_y_left_top=Number(obj.y);
					// // document.getElementById('selected_x_y').innerHTML = ""+glob_x_left_top+", "+glob_y_left_top;
				// // }
				// // xhr.send();
				
					
				// // });
				
				
				
			// // }
						
			// // newImg.src = imageUrl;			
			
		// // }
		
		// // xhr.send(params);

		
// }

}