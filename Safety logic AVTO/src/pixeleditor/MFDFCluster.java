package pixeleditor;

import java.util.ArrayList;

public class MFDFCluster {
	
	public int num = 0;
	public ArrayList<Cell> cells=null;
	public int[] color; 
	

	public MFDFCluster(ArrayList<Cell> tcells, int[] color) {
		
		this.cells = tcells; 
		this.color = color; 
	}
	
	
	public void addCell(Cell cell) {
		this.cells.add(cell);
	}
	
	public void removeCell(Cell cell) {
		
		while(true) {
			Cell found=null;
			for(Cell tcell: this.cells) {
				if(tcell.compare(cell)) {
					found = tcell;
					break;
				}
			}
			if(found!=null) this.cells.remove(found);
			else break;
		}
	}
	
	public String toString() {
		return cellsToString();
	}


	private String cellsToString() {
		StringBuilder sb = new StringBuilder();
		for(Cell tcell: this.cells) {
			sb.append("" +tcell.toString() + ",");
				
		}
		
		return sb.toString();
	}

}
