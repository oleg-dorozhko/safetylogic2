package pixeleditor;

import java.util.ArrayList;

public class MdfCluster {
	
	public int num = 0;
	public ArrayList<Cell> cells=null; 
	
	public MdfCluster(int num, ArrayList<Cell> tcells) {
		this.num = num;
		this.cells = new ArrayList<Cell>(); 
		this.cells = tcells; 
	}
	
	public void addCell(Cell cell) {
		this.cells.add(cell);
	}
	
	public void removeCell(Cell cell) {
		Cell found=null;
		for(Cell tcell: this.cells) {
			if(tcell.compare(cell)) {
				found = tcell;
				break;
			}
		}
		if(found!=null) this.cells.remove(found);
	}
	
	

}
