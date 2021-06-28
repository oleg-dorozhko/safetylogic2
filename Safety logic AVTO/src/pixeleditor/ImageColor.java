package pixeleditor;

//import javafx.scene.paint.Color;
//import java.util.*;

public class ImageColor {
    
    public int cols = 0;
    public int rows = 0;
    public ItStack[][] _colors_array = null;
    
    public ImageColor( int cols, int rows ) {
        this.cols = cols;
        this.rows = rows;
        this._colors_array = new ItStack[cols][rows];
        for(int j=0;j<rows;j++)
        {
            for(int i=0;i<cols;i++)
            {
                _colors_array[i][j] = new ItStack();
            }
        }
    }
    
    public ImageColor(int cols,int rows, ItStack[][] colors_array) {
        this.cols = cols;
        this.rows = rows;
        this._colors_array = colors_array;
    }
    
    
    
    public ImagePoint getCenterPoint()
    {
        int w = this.cols;
        int h = this.rows;
        int x =(w/2|0);
        int y =(h/2|0);
                
        return new ImagePoint(x,y);
    }
	

    
    public ItStack get(int col, int row) {
        
       if(col<0) return new ItStack (); 
       if(row<0) return new ItStack (); 
       if(col>=cols) return   new ItStack ();
       if(row>=rows) return new ItStack ();
       
       return    this._colors_array[col][row] ;
    
    }
    
    // public ImageColorElement clone(int col, int row) {
        
       // if(col<0) return new EmptyImageColorElement (); 
       // if(row<0) return new EmptyImageColorElement (); 
       // if(col>=cols) return   new EmptyImageColorElement ();
       // if(row>=rows) return new EmptyImageColorElement ();
      
       // return  ImageColor._cloneImageColorElement(this._colors_array[col][row]);
    
    // }
    
    // public ImagePointColor getc(int col, int row) {
        
       
        // return new ImagePointColor(col,row, ImageColor._cloneColor(this._colors_array[col][row]));
    // }
    
    public void set(int col, int row, ItStack elem) {
        
        this._colors_array[col][row] = new  ItStack(elem);
    }
    
   
    
}