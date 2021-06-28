package pixeleditor;

import javafx.scene.paint.Color;
import java.util.*;

public class MainGraphics {
    
    
    
    
  
  
    // public static void setHero( ImageColor im, int x, int y ) {
        
        // ImageColorElement t =  im.get( x, y );
        // //ColorColor t_meta = new ColorColor(t.meta);    
        // t.meta = new Hero(); //pruzhinit //progibaetsya pod izmenchiviy mir
        // GameModel.heroPositionX = x;
        // GameModel.heroPositionY = y;
         
        
    // }   
    
     

   
    
    public static void swap(ImageColor im, int[] point, int[] old_point2 )
    {
 
       
        
    } 
    
    
    
    
   
     
    //////////////////////////////////////////
    
    
    
    public  static byte[] fillRectangleFastEven(byte[] pixels, int x, int y, int width, int n, int m, byte[] col )
    {
        
        for(int j=y;j<y+m;j+=1)
        {
            for(int i=x;i<x+n;i+=2)
            {
                int ind = j * width * 3 + i * 3; //var idx2 = (imgData2.width * j + i ) << 2;
                pixels[ind] =col[0];
                pixels[ind +1]=col[1];
                pixels[ind +2]=col[2];
                //imgData2.data[idx2+3]=col[3]; //alpha
                
            }
        }
        
        return pixels;
    }	
    
    public  static byte[] fillRectangleFastOdd(byte[] pixels, int x, int y, int width, int n, int m, byte[] col )
    {
        for(int i=x+1;i<x+n;i+=2)
        {
                
            for(int j=y;j<y+m;j+=1)
            {
            
                int ind = j * width * 3 + i * 3; //var idx2 = (imgData2.width * j + i ) << 2;
                pixels[ind] =col[0];
                pixels[ind +1]=col[1];
                pixels[ind +2]=col[2];
                //imgData2.data[idx2+3]=col[3]; //alpha
                
            }
        }
        
        return pixels;
    }	
     
    public  static byte[] fillRectangleFast(byte[] pixels, int x, int y, int width, int n, int m, byte[] col )
    {
        
        for(int j=y;j<y+m;j++)
        {
            for(int i=x;i<x+n;i++)
            {
                int ind = j * width * 3 + i * 3; //var idx2 = (imgData2.width * j + i ) << 2;
                pixels[ind] =col[0];
                pixels[ind +1]=col[1];
                pixels[ind +2]=col[2];
                //imgData2.data[idx2+3]=col[3]; //alpha
                
            }
        }
        
        return pixels;
    }

	public static ArrayList<ImagePointColor> pointNearWith(ImageColor global_dummy_fast_thread_imgData, int x, int y,
			Color global_dummy_fast_thread_color) {
		// TODO Auto-generated method stub
		return null;
	}






	public static int[] ave(int[] color) {
		int t = 256/2;
		int m = color[0]/t;
		color[0]=  (t*m);
		int m1 = color[1]/t;
		color[1]=   (t*m1);
		int m2 = color[2]/t;
		color[2]=  (t*m2);
		//int m3 = color[3]/t;
		color[3]= 255;
		
		if( (color[0]==0) && (color[1]==0) && (color[2]==0)) {	color[0]=(byte) 255;color[1]=(byte) 255;color[2]=(byte) 255;	}
		
		if( color[0]==0) color[0]=(byte) 255;
		//if (color[1]==0) color[1]=(byte) 100;
		//if (color[2]==0) {	color[2]=(byte) 50;	}
		
		return color;
	}

    
    
    
    
    

// // // // // public static  ArrayList<ImagePointColor> pointNearWith(ImageColor im, int i, int j, Color color) {
    
    // // // // // ArrayList<ImagePointColor> list = new ArrayList<ImagePointColor>();
    // // // // // if(i<0) return list;
    // // // // // if(j<0) return list;
    
    // // // // // if((i<im.cols) && (j<im.rows)) {
    
         
        // // // // // int n=0;
        // // // // // Color color0 = im.get(i-1,j-1);
        // // // // // Color color1 = im.get(i,j-1);
        // // // // // Color color2 = im.get(i+1,j-1);
        // // // // // Color color3 = im.get(i-1,j);
        // // // // // Color color4 = im.get(i,j);
        // // // // // Color color5 = im.get(i+1,j);
        // // // // // Color color6 = im.get(i-1,j+1);
        // // // // // Color color7 = im.get(i,j+1);
        // // // // // Color color8 = im.get(i+1,j+1);
        
        // // // // // if(color0.equals(color)  ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i-1,j-1,color));
        // // // // // } 
        
         // // // // // if(color1.equals(color) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i,j-1,color));
        // // // // // } 
        
         // // // // // if(color2.equals(  color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i+1,j-1,color));
        // // // // // } 
        
         // // // // // if(color3.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i-1,j,color));
        // // // // // } 
        
        // // // // // if(color5.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i+1,j,color));
        // // // // // } 
        
        // // // // // if(color6.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i-1,j+1,color));
        // // // // // } 
        
        // // // // // if(color7.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i,j+1,color));
        // // // // // } 
        
        // // // // // if(color8.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i+1,j+1,color));
        // // // // // } 
        
        
             
    // // // // // }
    
    // // // // // return list;
    
// // // // // }    

// // // // // public static  ArrayList<ImagePointColor> pointNearNotWith(ImageColor im, int i, int j, Color color) {
    
    // // // // // ArrayList<ImagePointColor> list = new ArrayList<ImagePointColor>();
    // // // // // if(i<0) return list;
    // // // // // if(j<0) return list;
    
    // // // // // if((i<im.cols) && (j<im.rows)) {
    
         
        // // // // // int n=0;
        // // // // // Color color0 = im.get(i-1,j-1);
        // // // // // Color color1 = im.get(i,j-1);
        // // // // // Color color2 = im.get(i+1,j-1);
        // // // // // Color color3 = im.get(i-1,j);
        // // // // // Color color4 = im.get(i,j);
        // // // // // Color color5 = im.get(i+1,j);
        // // // // // Color color6 = im.get(i-1,j+1);
        // // // // // Color color7 = im.get(i,j+1);
        // // // // // Color color8 = im.get(i+1,j+1);
        
        // // // // // if(!color0.equals(color)  ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i-1,j-1,color0));
        // // // // // } 
        
         // // // // // if(!color1.equals(color) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i,j-1,color1));
        // // // // // } 
        
         // // // // // if(!color2.equals(  color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i+1,j-1,color2));
        // // // // // } 
        
         // // // // // if(!color3.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i-1,j,color3));
        // // // // // } 
        
        // // // // // if(!color5.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i+1,j,color5));
        // // // // // } 
        
        // // // // // if(!color6.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i-1,j+1,color6));
        // // // // // } 
        
        // // // // // if(!color7.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i,j+1,color7));
        // // // // // } 
        
        // // // // // if(!color8.equals( color ) ) {
            // // // // // n++;
            // // // // // list.add(new ImagePointColor(i+1,j+1,color8));
        // // // // // } 
               
    // // // // // }
    
    // // // // // return list;
    
// // // // // }   

// // // // // public static Color getMaxColor(ArrayList<ImagePointColor> list) {
    
    // // // // // HashMap<Color, Integer>  colors = null;

    // // // // // for(int i=0;i<list.size();i++) {
        // // // // // ImagePointColor ip = list.get(i);
        // // // // // Integer f = new Integer(1);
        // // // // // if(colors.containsKey(ip.color)) {
            // // // // // f  = new Integer(colors.get(ip.color).intValue()+1);
            // // // // // colors.remove(ip.color);
            
        // // // // // }
        // // // // // colors.put(ip.color,f);
    // // // // // }
     // // // // // for(Map.Entry<Color, Integer> entry: colors.entrySet())
            // // // // // System.out.println(entry.getKey() + " - " + entry.getValue());
            
            // // // // // System.exit(1);
            
            // // // // // return null;
    
// // // // // }

// // // // // public static ArrayList<ImagePointColor> pointColorsNear( ImageColor im, int i, int j ) {
    
    
    // // // // // ArrayList<ImagePointColor> li = new ArrayList<ImagePointColor> ();
    // // // // // if(i<0) return li;
    // // // // // if(j<0) return li;
    
    // // // // // if((i<im.cols) && (j<im.rows)) {
    
         
       
       // // // // // li.add(new ImagePointColor(i-1,j-1,im.get(i-1,j-1)));
       // // // // // li.add(new ImagePointColor(i,j-1,im.get(i,j-1)));
       // // // // // li.add(new ImagePointColor(i+1,j-1,im.get(i+1,j-1)));
       // // // // // li.add(new ImagePointColor(i-1,j,im.get(i-1,j)));
        // // // // // //Color color4 = li.add(new ImagePointColor(im.get(i,j)));
       // // // // // li.add(new ImagePointColor(i+1,j,im.get(i+1,j)));
        // // // // // li.add(new ImagePointColor(i-1,j+1,im.get(i-1,j+1)));
       // // // // // li.add(new ImagePointColor(i,j+1,im.get(i,j+1)));
       // // // // // li.add(new ImagePointColor(i+1,j+1,im.get(i+1,j+1)));
        
          
    // // // // // }
    
    // // // // // return li;
    
// // // // // }
// // // // // public static int countNear(ImageColor im, int i, int j, Color color) {
    
    
    // // // // // if(i<0) return 0;
    // // // // // if(j<0) return 0;
    
    // // // // // if((i<im.cols) && (j<im.rows)) {
    
         
        // // // // // int n=0;
        // // // // // Color color0 = im.get(i-1,j-1);
        // // // // // Color color1 = im.get(i,j-1);
        // // // // // Color color2 = im.get(i+1,j-1);
        // // // // // Color color3 = im.get(i-1,j);
        // // // // // Color color4 = im.get(i,j);
        // // // // // Color color5 = im.get(i+1,j);
        // // // // // Color color6 = im.get(i-1,j+1);
        // // // // // Color color7 = im.get(i,j+1);
        // // // // // Color color8 = im.get(i+1,j+1);
        
        // // // // // if(color0.equals(color)  ) {
            // // // // // n++;
        // // // // // } 
        
         // // // // // if(color1.equals(color) ) {
            // // // // // n++;
        // // // // // } 
        
         // // // // // if(color2.equals(  color ) ) {
            // // // // // n++;
        // // // // // } 
        
         // // // // // if(color3.equals( color ) ) {
            // // // // // n++;
        // // // // // } 
        
        // // // // // if(color5.equals( color ) ) {
            // // // // // n++;
        // // // // // } 
        
        // // // // // if(color6.equals( color ) ) {
            // // // // // n++;
        // // // // // } 
        
        // // // // // if(color7.equals( color ) ) {
            // // // // // n++;
        // // // // // } 
        
        // // // // // if(color8.equals( color ) ) {
            // // // // // n++;
        // // // // // } 
        
        
        // // // // // return n;       
    // // // // // }
    
    // // // // // return 0;
    
// // // // // }
	
}
    
    
