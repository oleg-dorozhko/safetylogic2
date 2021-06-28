package pixeleditor;

import javafx.scene.paint.Color;

public class ColorPoint {
	private Color color0 = Color.rgb(0, 0, 0);
	private Color color1 = Color.rgb(0, 0, 0);
	private Color color2 = Color.rgb(0, 0, 0);
	private Color color3 = Color.rgb(0, 0, 0);
	private boolean undefined=true;
	
	public ColorPoint(ColorPoint colorPoint) {
		this.color0 = colorPoint.color0;
		this.color1 = colorPoint.color1;
		this.color2 = colorPoint.color2;
		this.color3 = colorPoint.color3;
		this.undefined=colorPoint.undefined;
	}
	public ColorPoint() {
		this.undefined=true;
	}
	public ColorPoint(Color c1, Color c2) {
		this.color0 = cloneColor(c1);
		this.color1 = cloneColor(c2);
		this.color2 = cloneColor(c1);
		this.color3 = cloneColor(c2);
		this.undefined = false;
	}
	
	 private Color cloneColor(Color c) {
	        return Color.rgb((int)(c.getRed()*255),(int)(c.getGreen()*255),(int)(c.getBlue()*255));
	    }
	 
	 
	    private static Color getTransparent(Color c) {
	    
	        int r = (int)( c.getRed()*255);
	        int g = (int)(c.getGreen()*255);
	        int b =(int)( c.getBlue()*255);
	        int dr = (255-r)/2;
	        int dg = (255-g)/2;
	        int db = (255-b)/2;
	        
	        return Color.rgb(r+dr,g+dg,b+db);
	      
	    }
	 
	public Color getColor0() {
		// TODO Auto-generated method stub
		return color0;
	}
	public Color getColor1() {
		// TODO Auto-generated method stub
		return color1;
	}
	
	public static ColorPoint getTransparentColorPoint(ColorPoint realColor) {
		Color color0 = getTransparent(realColor.getColor0());
		Color color1 = getTransparent(realColor.getColor1());
		return new ColorPoint( color0, color1 );
		
	}
	
	 
    public boolean equals(ColorPoint cp) {
		
		return (this.color0.equals(cp.getColor0()) && this.color1.equals(cp.getColor1()));
	}
    
//	public boolean compare(ColorPoint cp) {
//		return (color0.equals(cp.color0) && color1.equals(cp.color1));
//		 
//	}  
	    

}
