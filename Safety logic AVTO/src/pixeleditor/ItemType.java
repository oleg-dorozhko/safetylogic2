package pixeleditor;

import javafx.scene.paint.Color;

public class ItemType {
    
    private String id = null; //HelperMD5.md5(HelperRandom.getRandomString(32)); 
    
    private ColorPoint colorPoint = new ColorPoint();
        
    private String enLocaleName = "new item";
    
    private String firstLocaleName = "новый предмет";
	
    private String imagePath = "data/images/default.png";
    
	private boolean undefined = true;

    
    public ItemType( String id, String enLocaleName, String firstLocaleName, ColorPoint colorPoint) {
        this.id = new String(id);
        this.enLocaleName = new String(enLocaleName);
        this.firstLocaleName  = new String(firstLocaleName);
        this.colorPoint = new ColorPoint(colorPoint);
        this.undefined = false;
    }
    
    public ItemType(ItemType t) {
        this.id = new String(t.id);
        this.enLocaleName = new String(t.getEnLocaleName());
        this.firstLocaleName  = new String(t.firstLocaleName);
        this.colorPoint = new ColorPoint(t.colorPoint);
        this.undefined = t.undefined;
    }
        
	public ItemType() {
		this.id = HelperMD5.md5(HelperRandom.getRandomString(32)); 
		this.enLocaleName = new String("new item");
	    this.firstLocaleName  = new String("новая сущность");
	    this.colorPoint = new ColorPoint(Color.rgb(0, 0, 0),Color.rgb(0, 0, 0));
	    this.undefined = false;
	}

	public String getId() {
        return this.id;
    }
    
    public String toString() {
        return	"[ " 
        		       + "id: " + this.getId() + "," 
        		   	   + "enLocaleName: " + this.getEnLocaleName() + ","  
                       + "firstLocaleName: " + this.getFirstLocaleName() + "," 
                       + "colorPoint: " + this.getColorPoint() + "," 
             + " ]"; 
    }
    
    //public boolean equalsXY(ItemType f) {
    //    return (ip.getX() == f.ip.getX() &&   f.ip.getY() == ip.getY() );
    //}

	public String getFirstLocaleName() {
		return this.firstLocaleName;
	}
	
	public String getEnLocaleName() {
		return this.enLocaleName;
	}

	public ColorPoint getColorPoint() {
		
		return this.colorPoint;
	}

	public boolean isUndefined() {
		return this.undefined;
	}

	public void setColorPoint(ColorPoint colorPoint) {
		this.colorPoint = new ColorPoint(colorPoint);
		
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	//public void setUndefined(boolean undefined) {
	//	this.undefined = undefined;
	//}

	//public void setIp(int rx, int ry) {
	//	this.ip = new ImagePoint(rx,ry);
	//}

//	public void setColorPoint(ColorPoint colorPoint) {
//		this.colorPoint = colorPoint;
//		
//	}
// 
//
//	public void setFirstLocaleName(String first_locale_name) {
//		this.firstLocaleName = new String(first_locale_name);
//		
//	}
//
//	public void setEnLocaleName(String enLocaleName) {
//		this.enLocaleName = enLocaleName;
//	}
}