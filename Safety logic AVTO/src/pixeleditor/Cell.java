package pixeleditor;

import javafx.scene.paint.Color;

public class Cell {
	
	int[] myColor = null;
	
	int x=0;
	int y=0;
	
	public Cell(int x, int y, int[] color)  {
	
		this.x=x;
		this.y=y;
		
		this.myColor = new int[4];
		this.myColor[0] = color[0];//(int) Math.round(color.getRed()*255.0);
		this.myColor[1] = color[1];//(int) Math.round(color.getGreen()*255.0);
		this.myColor[2] = color[2];//(int) Math.round(color.getBlue()*255.0);
		this.myColor[3] = color[3];
		
		//if(color.getOpacity()==1.0) this.myColor[3] = 255;
		//else throw new Exception("Alpha not allowed");
			
	}
	
	public Cell(Cell cell) {
		this.x = cell.x;
		this.y = cell.y;
		this.myColor =  cloneMyColor(cell.getMyColor());
	}
	
	public Cell(int x2, int y2) {
		this.x=x;
		this.y=y;
		
		this.myColor = new int[4];
		this.myColor[0] = 13;//(int) Math.round(color.getRed()*255.0);
		this.myColor[1] = 13;//(int) Math.round(color.getGreen()*255.0);
		this.myColor[2] = 13;//(int) Math.round(color.getBlue()*255.0);
		this.myColor[3] = 255;
	}

	public int[] getMyColor() {
		return this.myColor;
	}
	
	public static int[] cloneMyColor(int[] color) {
		int[] color2 = new int[4];
		color2[0] = color[0];//(int) Math.round(color.getRed()*255.0);
		color2[1] = color[1];//(int) Math.round(color.getGreen()*255.0);
		color2[2] = color[2];//(int) Math.round(color.getBlue()*255.0);
		color2[3] = color[3];
		return color2;
	}
	
	private Color cloneColor(Color color2) {
		// TODO Auto-generated method stub
		return new Color(color2.getRed(),color2.getGreen(),color2.getBlue(), color2.getOpacity());
	}
//	public Cell(int x2, int y2, Color color0) {
//		this.x=x2;
//		this.y=y2;
//		//this.bColor = new int[3];
//		//byte[] colr = HelperRandom.conv(color0);
//		this.bColor[0] = colr[0];
//		this.bColor[1] = colr[1];
//		this.bColor[2] = colr[2];
//	}
//	
//	public int[] getBColor() {
//		// TODO Auto-generated method stub
//		return this.bColor;
//	}
	
//	public void setBColor(int[] bColor2) {
//		this.bColor[0] = bColor2[0];
//		this.bColor[1] = bColor2[1];
//		this.bColor[2] = bColor2[2];
//	}
	
//	public Color getColor() {
//		return this.color;
////		return HelperRandom.aconv(this.bColor);
//		
//	}

	public boolean compare(Cell c) {
		
		if(c.x!=this.x) return false;
		if(c.y!=this.y) return false;
		
		if(this.myColor[0] != c.myColor[0]) return false;
		if(this.myColor[1] != c.myColor[1]) return false;
		if(this.myColor[2] != c.myColor[2]) return false;
		if(this.myColor[3] != c.myColor[3]) return false;
		
		return true;
	}

	public static boolean compare(int[] color, int[] color2) {
		if(color==null) return false;
		if(color2==null) return false;
		if(color[0] != color2[0]) return false;
		if(color[1] != color2[1]) return false;
		if(color[2] != color2[2]) return false;
		if(color[3] != color2[3]) return false;
		return true;
	}
	
	public String toString() {
		return "["+this.x+","+this.y+"] "+this.myColor[0]+","+this.myColor[1]+","+this.myColor[2];
	}

	public int[] cloneColor(int[] color) {
		int[] color2 = new int[4];
		color2[0] = color[0];//(int) Math.round(color.getRed()*255.0);
		color2[1] = color[1];//(int) Math.round(color.getGreen()*255.0);
		color2[2] = color[2];//(int) Math.round(color.getBlue()*255.0);
		color2[3] = color[3];
		return color2;
	}

	public void setColor(int[] color) {
		this.myColor = cloneColor(color);
	}

	public boolean compareColor(int[] color) {
		//if(color==null) return false;
		//if(this.myColor==null) return false;
		if(color[0] != this.myColor[0]) return false;
		if(color[1] != this.myColor[1]) return false;
		if(color[2] != this.myColor[2]) return false;
		if(color[3] != this.myColor[3]) return false;
		return true;
	}
	
	
}
