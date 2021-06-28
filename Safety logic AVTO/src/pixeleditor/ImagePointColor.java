package pixeleditor;

import javafx.scene.paint.Color;

public class ImagePointColor {
    
    public int x = 0;
    public int y = 0;
    public Color color = null;
    
    public ImagePointColor( int x, int y, Color color ) {
        this.x = x;
        this.y = y;
        this.color = color;
    }  
    
    private String colorToString(Color c) {
     return "["+(int)(c.getRed()*255)+","+(int)(c.getGreen()*255)+","+(int)(c.getBlue()*255)+"]";
    }

    public String toString() {
        if(color==null) return "["+this.x+","+this.y+", null ]";
        return "["+this.x+","+this.y+","+colorToString(color)+"]";
    }        

}