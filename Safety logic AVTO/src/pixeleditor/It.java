package pixeleditor;

public class It {
    
    private String id = HelperMD5.md5(HelperRandom.getRandomString(32)); 
    
    private ImagePoint ip = new ImagePoint();
    
    private ItemType itemType = null;
	

	public void setIp(ImagePoint ip) {
		this.ip = ip;
	}

    
    public It(ItemType itemType, ImagePoint ip) {
        this.itemType = new ItemType(itemType);
        this.ip = new ImagePoint(ip);
      
    }
    
    public It(It t) {
    	this.itemType = new ItemType(t.getItemType()); 
        this.ip = new ImagePoint(t.getIp());
       
    }
    
    
	public It(ItemType t) {
		this.id =  HelperMD5.md5(HelperRandom.getRandomString(32)); 
	    this.ip = null;
	    this.itemType = new ItemType(t);  
	   
	}

	public String getId() {
        return this.id;
    }
    
    public ImagePoint getIp() {
        return this.ip;
    }
    
//    public boolean typeOf(String t) {
//		if(t.equals("It")) return true;
//		return false;
//	}
    
    public String toString() {
        return "[ id: "+ this.getId() + " enLocaleName: "+
    this.getEnLocaleName() + ", firstLocaleName: "+ this.getFirstLocaleName() + ", ip=" + this.getIp()
     + ", rgb= " + this.getColorPoint() + " ]"; 
    }
    
    public boolean equalsXY(It f) {
        return (ip.getX() == f.ip.getX() &&   f.ip.getY() == ip.getY() );
    }

	public String getFirstLocaleName() {
		return this.getItemType().getFirstLocaleName();
	}
	
	public String getEnLocaleName() {
		return this.getItemType().getEnLocaleName();
	}

	public ColorPoint getColorPoint() {
		
		return this.getItemType().getColorPoint();
	}


	public void setIp(int rx, int ry) {
		this.ip = new ImagePoint(rx,ry);
		
	}

	public void setColorPoint(ColorPoint colorPoint) {
		this.getItemType().setColorPoint(colorPoint);
		
	}

	public ItemType getItemType() {
		return itemType;
	}


	public void setId(String id) {
		this.id = id;
		
	}



	//public void setColorPoint(ColorPoint colorPoint) {
	//	
	//	
	//}
 

//	public void setFirstLocaleName(String first_locale_name) {
//		this.firstLocaleName = new String(first_locale_name);
//		
//	}
//
//	public void setEnLocaleName(String enLocaleName) {
//		this.enLocaleName = enLocaleName;
//	}
}