package pixeleditor;
 
 

public class ImagePoint {
    
    private int x = 0;
    private int y = 0;
    private boolean undefined = true;
    
    public ImagePoint() {
        this.x = 0;
        this.y = 0;
        this.undefined=true;
    }
    
    public ImagePoint(int x,int y) {
        this.x = x;
        this.y = y;
        this.undefined=false;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int x) {
        this.x = x;
        this.undefined=false;
    }
    
    public void setY(int y) {
        this.y = y;
        this.undefined=false;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
        this.undefined=false;
    }
    
    public ImagePoint(ImagePoint ip) {
        this.x = ip.x;
        this.y = ip.y;
        this.undefined=ip.undefined;
    }

    public boolean equals(ImagePoint ip) {
    	return (this.x==ip.x && this.y==ip.y);
    }

    public String toString() {
        return this.x +", "+ this.y; 
    }

	public static ImagePoint fromString(String ips) {
		if(ips.matches("^[0-9]{1,3}[,][0-9]{1,3}")) {
			String[] arr = ips.split(",");
			return new ImagePoint(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
		}
		return null;
	}        

}