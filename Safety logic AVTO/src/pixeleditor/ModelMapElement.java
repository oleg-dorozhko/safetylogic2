package pixeleditor;

public class ModelMapElement {
	
	private int x = 0;
	private int y = 0;
	private String id = null;
	private int qty = 0;
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public boolean isUndefined() {
		return undefined;
	}

	public void setUndefined(boolean undefined) {
		this.undefined = undefined;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getId() {
		return id;
	}

	private boolean undefined;
	
	public ModelMapElement(String id, int x, int y, int qty) {
		
		this.id = new String(id);
		this.x = x;
		this.y = y;
		this.qty = qty;
		this.undefined = false;
		
	}

}
