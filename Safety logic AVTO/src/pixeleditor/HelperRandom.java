package pixeleditor;

import java.util.Random;

import javafx.scene.paint.Color;

public class HelperRandom {

	// m - exclusive, n - offset from 0 position
	public static int getRandomInt(int n, int m) {
	    
	    return new Random().nextInt(m)+n;
	    
	}

	 
	static Color getRndColor()   {
	    
	    int r = getRandomInt(0, 256);
	    int g = getRandomInt(0, 256);
	    int b = getRandomInt(0, 256);
	    return Color.rgb(r,g,b);        
	
	}


	public static int[] getRndIntColor() {
		int r = getRandomInt(0, 256);
	    int g = getRandomInt(0, 256);
	    int b = getRandomInt(0, 256);
	    int a = 255;
		int[] color = new int[4];
		color[0] = r;
		color[1] = g;
		color[2] = b;
		color[3] = a;
	    return color;
	}	
	
	public static  int[] convInt(Color c) {
		
	    int red = (int) (c.getRed() * 255);
	    int green = (int) (c.getGreen() * 255);
	    int blue = (int) (c.getBlue() * 255);
	    int alpha = (int) (c.getOpacity() * 255);            
	    
	    int[] col = new int[3];
	    
	    
	    col[0]=red;
	    col[1]=green;
	    col[2]=blue;
	    
	    return col;
	}

	public static byte[] conv(Color c) {
	
	    int red = (int) (c.getRed() * 255);
	    int green = (int) (c.getGreen() * 255);
	    int blue = (int) (c.getBlue() * 255);
	    //int alpha = (int) (c.getAlpha() * 255);            
	    byte[] col = new byte[3];
	    col[0]=(byte)red;
	    col[1]=(byte)green;
	    col[2]=(byte)blue;
	    //col[3]=(byte)alpha;
	    return col;
	}
	
	public static int[] iconv(Color c) {
		
	    int red = (int) (c.getRed() * 255);
	    int green = (int) (c.getGreen() * 255);
	    int blue = (int) (c.getBlue() * 255);
	    //int alpha = (int) (c.getAlpha() * 255);            
	    int[] col = new int[4];
	    col[0]=red;
	    col[1]=green;
	    col[2]=blue;
	    col[3]=255;
	    return col;
	}
	
	public static  Color aconv(int[] color) {
//		
//	    int red = (int) (c.getRed() * 255);
//	    int green = (int) (c.getGreen() * 255);
//	    int blue = (int) (c.getBlue() * 255);
//	    //int alpha = (int) (c.getAlpha() * 255);            
//	    byte[] col = new byte[3];
//	    col[0]=(byte)red;
//	    col[1]=(byte)green;
//	    col[2]=(byte)blue;
//	    //col[3]=(byte)alpha;
	    return Color.rgb(color[0],color[1],color[2]);
	}

	public static String getRandomString(int lim) {
		 
		  StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < lim/2; i++) {
	          sb.append(Integer.toHexString( getRandomInt(0,16) ));
	       }
	        
	        return sb.toString();
	}


	public static ColorPoint getRandomColorPoint() {
		Color color1 = HelperRandom.getRndColor(); 
		Color color2 = HelperRandom.getRndColor();
		
		return new ColorPoint(color1,color2);
	}

	public static String strColor(Color color0) {
		int[] ints = convInt(color0);
		return ""+ints[0]+","+ints[1]+","+ints[2];
	}


	public static String generateId() {
		
		return HelperMD5.md5(HelperRandom.getRandomString(32));
	}


    
    
}
