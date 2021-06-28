package pixeleditor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.paint.Color;

public class GameRegExp {
    
	public static String extr(String s) {
		
		if(s.indexOf("Not found")==0 || s.indexOf("not found")==0) {
			return s;
		}
		 
		return null;
	}

    public static Color getColorFromString(String s) throws Exception
    {
        
        String pattern = "^([0-9]{1,3})[,]([0-9]{1,3})[,]([0-9]{1,3})$";
        Pattern ptrn = Pattern.compile(pattern);
        Matcher matcher = ptrn.matcher(s);
               
        if(matcher.find()) {
            
               //System.out.println("Color: " + matcher.group(0));
               //f2 = new File("images/" + matcher.group(0));
              
                int r = Integer.parseInt(matcher.group(1));
                int g = Integer.parseInt(matcher.group(2));  
                int b = Integer.parseInt(matcher.group(3));                
               
               return Color.rgb(r,g,b);
        }
        
        throw new Exception("Not recognized: "+s);
    }
    
    public static int[] getColsAndRowsFromFileName( String s )  throws Exception
    {
            
        String pattern = "^.*[_]w([0-9]{1,3})xh([0-9]{1,3})[_]cp[.]png";
        Pattern ptrn = Pattern.compile(pattern);
        Matcher matcher = ptrn.matcher(s);
               
        if(matcher.find()) {
        
            System.out.println("File name ok: " + matcher.group(0));
              
            System.out.println("cols: " + matcher.group(1));
            int cols = Integer.parseInt(matcher.group(1));
            System.out.println("rows: " + matcher.group(2));
            int rows = Integer.parseInt(matcher.group(2)); 
            int[] res = new int[2];
            res[0] = cols;
            res[1] = rows;
            return res;
        }    
        
         throw new Exception("Not recognized: "+s);
    }
    
    public static int[] getColsAndRowsAndCWAndCHFromFileName( String s )  throws Exception
    {
            
        String pattern = "^.*[_]w([0-9]{1,3})[_]h([0-9]{1,3})[_]cw([0-9]{1,3})[_]ch([0-9]{1,3})[_]cp[.]png";
        Pattern ptrn = Pattern.compile(pattern);
        Matcher matcher = ptrn.matcher(s);
               
        if(matcher.find()) {
        
            System.out.println("File name ok: " + matcher.group(0));
              
            System.out.println("cols: " + matcher.group(1));
            int cols = Integer.parseInt(matcher.group(1));
            System.out.println("rows: " + matcher.group(2));
            int rows = Integer.parseInt(matcher.group(2)); 
            System.out.println("cell width: " + matcher.group(3));
            int cw = Integer.parseInt(matcher.group(3));
            System.out.println("cell height: " + matcher.group(4));
            int ch = Integer.parseInt(matcher.group(4)); 
            int[] res = new int[4];
            res[0] = cols;
            res[1] = rows;
            res[2] = cw;
            res[3] = ch;
            return res;
        }    
        
         throw new Exception("Not recognized: "+s);
    }
    
    
    
    
    
    
    
    
    
}