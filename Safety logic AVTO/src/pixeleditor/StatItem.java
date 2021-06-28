package pixeleditor;

public class StatItem {
	
	private String id = null;///  HelperMD5.md5(HelperRandom.getRandomString(32)); 
	private String first_locale_name = "unknown";
	private int qty = 0;
	
	private boolean undefined=true;
	
	public StatItem(String id, String fln, int qty) {
		this.id = new String(id);
		this.first_locale_name= new String(fln);
		this.qty = qty;
		this.undefined=false;
	}
	
	public StatItem(StatItem si) {
		this.id = new String(si.id);
		this.first_locale_name = new String(si.first_locale_name);
		this.qty = si.qty;
		this.undefined= si.undefined;
	}
	
	//public boolean likeAlt(String key) {
	//	// TODO Auto-generated method stub
	//	String[] keys = key.split(":");
	//	return (keys[0].equals(alt));
	//	
	//}

	public String getView() {
		return this.first_locale_name +": "+this.qty;
		
	}
	
	public String toString(){
		return " ["+this.id + "] " + this.first_locale_name +": "+this.qty;
	}

	public void changeStatItem(int diff) {
		int res = this.qty+diff;
		if(res<0) res=0;
		this.qty=res; 
		
	}

	public String getId() {
		return this.id;
	}

}
