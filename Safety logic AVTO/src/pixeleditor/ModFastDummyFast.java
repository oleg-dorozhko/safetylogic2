package pixeleditor;

import java.util.ArrayList;

public class ModFastDummyFast {

	public synchronized MFDFCluster getCluster(ArrayList<Cell> cells, Cell cell) {
		
		ArrayList<Cell> clonedCells = cloneCells(cells);
		ArrayList<Cell> work = new ArrayList<Cell>();
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		work.add(new Cell(cell));
		
		while(work.size()>0) {
			Cell c = work.get(0);
			ArrayList<Cell> neighboursSameColor = getNeighboursSameColor(clonedCells,c);
			result.add(new Cell(c));
			removeCell(clonedCells,c);
			removeCell(work,c);
			work.addAll(neighboursSameColor);
		}
		
		return new MFDFCluster(result, Cell.cloneMyColor(cell.myColor));
	
	}
	
	private synchronized  void removeCell(ArrayList<Cell> work, Cell c) {
			
			while(true) {
				Cell found=null;
				for(Cell tcell: work) {
					if(tcell.compare(c)) {
						found = tcell;
						break;
					}
				}
				if(found!=null) work.remove(found);
				else break;
			}
		
		
	}

		private   synchronized int[] getCellsColorXY(ArrayList<Cell> cells, int i, int j) {
			for (Cell cell : cells) {
				if((cell.x == i) && (cell.y==j)) return cell.getMyColor();
			}
			return null;
		}   
		
	synchronized  ArrayList<Cell> getNeighboursSameColor(ArrayList<Cell> cells, Cell cell) {
		
			int i = cell.x;
			int j = cell.y;
			int[] color = cell.myColor;
		    
		    ArrayList<Cell> list = new ArrayList<Cell>();
		    if(i<0) return list;
		    if(j<0) return list;
		   
		    
		        
		        int n=0;
		        int[] color0 = getCellsColorXY(cells, i-1,j-1);
		        int[] color1 = getCellsColorXY(cells, i,j-1);
		        int[] color2 = getCellsColorXY(cells, i+1,j-1);
		        int[] color3 = getCellsColorXY(cells, i-1,j);
		        int[] color4 = getCellsColorXY(cells, i,j);
		        int[] color5 = getCellsColorXY(cells, i+1,j);
		        int[] color6 = getCellsColorXY(cells, i-1,j+1);
		        int[] color7 = getCellsColorXY(cells, i,j+1);
		        int[] color8 = getCellsColorXY(cells, i+1,j+1);
		      
		        
		        if(Cell.compare(color,color0) ) {
		            n++;
		            list.add(new Cell(i-1,j-1,color0));
		        } 
		       
		         if( Cell.compare(color,color1)  ) {
		            n++;
		            list.add(new Cell(i,j-1,color1));
		        } 
		       
		         if(Cell.compare(color,color2)  ) {
		            n++;
		            list.add(new Cell(i+1,j-1,color2));
		        } 
		       
		        if(Cell.compare(color,color3) ) {
		            n++;
		            list.add(new Cell(i-1,j,color3));
		        } 
		       
		        if(Cell.compare(color,color5)) {
		            n++;
		            list.add(new Cell(i+1,j,color5));
		        } 
		       
		        if(Cell.compare(color,color6) ) {
		            n++;
		            list.add(new Cell(i-1,j+1,color6));
		        } 
		       
		        if(Cell.compare(color,color7) ) {
		            n++;
		            list.add(new Cell(i,j+1,color7));
		        } 
		       
		        if(Cell.compare(color,color8)) {
		            n++;
		            list.add(new Cell(i+1,j+1,color8));
		        } 
		              
		    
		   
			return list;
		   		
	}

	public  synchronized ArrayList<Cell> cloneCells(ArrayList<Cell> cells) {
		 ArrayList<Cell> res = new ArrayList<Cell>();
		 for(Cell cell: cells) {
			 res.add(new Cell(cell));
		 }
		 return res;
	 }
	
}
