package pixeleditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyThread2 implements Runnable {
	
	private Cell cell=null;
	private Cell cell2=null;
	
	private GameModel model=null;
	private ArrayList<Cell> cells;
	private ArrayList<Cell> filteredCells;
	private Cell cellW;
	private Cell cellM;
	private Cell rndNeigh;
	private boolean mode2=true;
	
	private MdfBufferStorage mbs = null;
	


	public MyThread2(GameModel model, MdfBufferStorage mbs,  Cell c1) throws Exception {
		this.model = model;
		this.cells = model.cells;
		this.cell = new Cell(c1);
		this.mbs = mbs;
		 
		
	}
	 
	public MyThread2(GameModel model,  Cell c1, Cell c2) throws Exception {
		this.model = model;
		this.cells = model.cells;
		this.cell = new Cell(c1);
		this.cell2 = new Cell(c2);
		
		this.cell = maxFromPro(this.cell);
		this.cell2 = minExclude(this.cell);
 
		
	}
  
		 
	 public void run()
     {
		 try
		 {
			
			int counter=0;
			this.cell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
			
			while( (!Thread.currentThread().isInterrupted())  )
			{
	 		
				if(!preparePro2()) {
					
					this.cell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
					//this.mbs  = new MdfBufferStorage(this.model);
					continue;
					//break;
				}
			 
			
			if(this.cell == null) continue;
			if(this.cell2 == null) continue;
			
			try
	 		{
	 			Thread.sleep(100);
	 		}
	 		 catch (InterruptedException e) {
		 
			
	 			 e.printStackTrace();
	 		 }
			
				swapCellAndCell2();
			
				
	 			
		 		try
		 		{
		 			Thread.sleep(100);
		 		}
		 		 catch (InterruptedException e) {
			 
				
		 			 e.printStackTrace();
		 		 }
		 		
		 		model.app.redrawCanvases();
		 		
		 		
		 		
		 
			}
			
			
			
			
		 } 
		 
		
		 
		 catch (Exception e) 
		 {
				
				e.printStackTrace();
		 }
	 		
     }
	 
	 private boolean preparePro1() throws Exception {
		 
		 Cell rndCell = this.cell;//new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
			Logger.lo("rnd cell="+rndCell);
			
			this.cell = new Cell(rndCell);
			Cell maxCell = getMaxClusterSize(rndCell);
			
			this.cell = new Cell(maxCell);
			Logger.lo("max cell="+this.cell);
			
			
			MdfCluster cluster = mbs.getCluster(this.cell);
			Cell tcell = null;
			if(cluster != null) tcell = cluster.cells.get(0);
			
			ArrayList<Cell> neighs = model.defineNeigh(tcell.x, tcell.y, tcell.myColor);
			
			if(neighs.size()==0) {
				return false;
			}
			
			this.cell = new Cell(neighs.get(0));
			Logger.lo("neigh cell="+this.cell);
			
			this.cell2 = getMinClusterSize(maxCell);
			Logger.lo("min cell2="+this.cell2);
			
			if(this.cell2==null) return false;
			
			return true;
		
	}
	 
 private boolean preparePro2() throws Exception {
	 
	Cell rndCell = new Cell(this.cell); //
	//Cell rndCell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
	Logger.lo("rnd cell="+rndCell);
	
	Cell c = null;
	
	
	ArrayList<Cell> neighs = model.defineNeigh(rndCell.x, rndCell.y, rndCell.myColor);
	if(neighs.size()==0) {
		Logger.lo("not found neighs other colors");
		return false;
	} 
	else {
		
		for(Cell tcell: neighs) {
			Logger.lo(""+tcell);
			ArrayList<Cell> neighs2 = model.defineNeighNeigh(tcell.x, tcell.y, tcell.myColor);
			Logger.lo(""+neighs2.size());
			if(neighs2.size()>0) {
				continue;
			}
			
			c = tcell;
			break;
			
		}
		if(c == null)
		{
			Logger.lo("not found neighs other colors with neighs.size()==0");
			return false;
		}
		
	}
	
	this.cell = new Cell(rndCell);
	
	//Logger.lo("celo= "+this.cell);

	//найти зеленый того же цвета но не принадлежащий тому же кластеру
	
	
	ArrayList<Cell> list = filterFromCluster(mbs.getCluster(rndCell).cells);
	for(Cell tcell: list) {
 		Logger.lo(""+tcell);
 	}
	
	this.cell = new Cell(c);
	if(list.size()==0) return false;
	this.cell2 = new Cell(list.get(0));
	
	
	return true;
		
	}



	private Cell getMinClusterSize(Cell cell3) throws Exception {
		 
		 
		 ArrayList<Cell> list = filterFrom(cell3);
		 
		 MdfCluster cluster = mbs.getCluster(cell3);
			//Cell tcell = null;
			//if(cluster != null) tcell = cluster.cells.get(0);
		 
//		 ModDummyFast mdf0 = model.getAreaArrays(cell3);
//			Logger.log("in cluster:");
//			for(Cell tcell: mdf0.global_dummy_fast_thread_in_cluster) {
//				Logger.log(""+tcell);
//			}
//			Logger.log("border cluster:");
//			for(Cell tcell: mdf0.global_dummy_fast_thread_border_cluster) {
//				Logger.log(""+tcell);
//			}
//		 
		 
			int max=0;
			Cell maxCell = null;
			 
			ArrayList<Cell> min = new  ArrayList<Cell>();
			 
			for(Cell t2cell: list) {
				
				if(containCell(cluster.cells,t2cell)) continue;
				
				Logger.log("t2cell="+t2cell);
				
				//ModDummyFast mdf = model.getAreaArrays(t2cell);
				MdfCluster cluster2 = mbs.getCluster(t2cell);
				//Logger.log("in cluster:");
				//for(Cell tcell: mdf.global_dummy_fast_thread_in_cluster) {
				//	Logger.log(""+tcell);
				//}
				//Logger.log("border cluster:");
				//for(Cell tcell: mdf.global_dummy_fast_thread_border_cluster) {
				//	Logger.log(""+tcell);
				//}
				
				
				int cs = cluster2.cells.size();
				Logger.log("Common size = "+ cs);
				//Logger.log("Expected size = " + mdf.global_dummy_fast_thread_arr2_all.size()); 
				
				if(max < cs ) {
					max=cs;
					min.add( new Cell(t2cell));
				}
				
			}
			if(min.size()==0) return null;
			maxCell = min.get(0);
			Logger.log(""+maxCell);
			Logger.log(""+max);
			return maxCell;
	}


	 private boolean containCell(ArrayList<Cell> list, Cell cell) {
		for(Cell tcell: list) {
			if(tcell.compare(cell)) return true;
		}
		return false;
	}


	private Cell getMaxClusterSize(Cell cell3) throws Exception {
		 
			ArrayList<Cell> list = filterFrom(cell3);
			int max=0;
			Cell maxCell = null;
			for(Cell t2cell: list) {
				
				Logger.log("t2cell="+t2cell);
				
				MdfCluster cluster = mbs.getCluster(t2cell);
				//ModDummyFast mdf = model.getAreaArrays(t2cell);
				//Logger.log("in cluster:");
				//for(Cell tcell: mdf.global_dummy_fast_thread_in_cluster) {
				//	Logger.log(""+tcell);
				//}
				//Logger.log("border cluster:");
				//for(Cell tcell: mdf.global_dummy_fast_thread_border_cluster) {
				//	Logger.log(""+tcell);
				//}
				
				//int cs = (mdf.global_dummy_fast_thread_in_cluster.size()+mdf.global_dummy_fast_thread_border_cluster.size());
				int cs = cluster.cells.size();
				Logger.log("Common size = "+ cs);
				//Logger.log("Expected size = " + mdf.global_dummy_fast_thread_arr2_all.size()); 
				
				if(max < cs ) {
					max=cs;
					maxCell = new Cell(t2cell);
				}
				
			}
			
			Logger.log(""+maxCell);
			Logger.log(""+max);
			return maxCell;
	}




	private void swapCellAndCell2() throws Exception {
		 
			this.cellM = new Cell(this.cell);
			this.rndNeigh = new Cell(this.cell2);
			 
			 // T <-- N
			 Cell t = new Cell(this.cellM);
			 
		    // N <-- M
			 
			 this.cellM.myColor = Cell.cloneMyColor(rndNeigh.myColor);
			 
			 // M <--- T
			 
			 this.rndNeigh.myColor = Cell.cloneMyColor(t.myColor);
			 
		//		System.out.println("cellN="+this.cell+"             cellM="+this.cellM);
		//		System.out.println("cellF="+this.rndNeigh+"             cellW="+this.cellW);
			
			 
			 Cell newCellM = new Cell(this.cellM);
			 Cell newRndNeigh = new Cell(this.rndNeigh);
			 
			 Cell linkCellM = model.getCellXY(this.cellM.x,this.cellM.y);
			 Cell linkRndNeigh = model.getCellXY(this.rndNeigh.x,this.rndNeigh.y);		 
					 
	 			model.cells.add(newCellM);
	 			model.cells.add(newRndNeigh);
	 			
	 			model.cells.remove(linkCellM);
	 			model.cells.remove(linkRndNeigh);
			
	 			
	 	//		this.mbs  = new MdfBufferStorage(this.model);
	 			
	 			
	 			// new Objects or link to old objects ??
	 			this.mbs.commitChanges( this.cell, this.cell2, newCellM, newRndNeigh );
		
		
	}


	private Cell getCellWithMaxQtyNeighSameColorNotCellColor(int[] myColor) throws Exception {
		 ArrayList<Cell> fcells = new ArrayList<Cell>();
			int max= -1;
			for(int i=0;i<cells.size();i++) {
				Cell c = new Cell(cells.get(i));
				//(c2.compare(c)==true) continue;
				if( Cell.compare( c.getMyColor(), myColor ) ) {
					int n = model.defineNeigh(c.x, c.y, c.getMyColor()).size();
					if(n==8) continue;
					if(n>max) {
						max = n;
						fcells.add(c);
					}
				}
			}
			if(fcells.size()==0) return null;
			//return fcells.get(0);
			return fcells.get(fcells.size()-1);//  HelperRandom.getRandomInt(0, fcells.size()));
			//return null;
	}


	private Cell getCorrelationPoint() throws Exception {
		 for(Cell cell3: this.filteredCells) {
			 Cell tc = notCorrelationBetween( cell3, cell);
			 if(tc!=null)	 return tc;
		 }
		 
		return null;
	}

	private Cell notCorrelationBetween(Cell cell3, Cell rndNeigh) throws Exception {
		 
		 ArrayList<Cell> list = model.defineNeigh(cell3.x, cell3.y, cell3.getMyColor());
		 ArrayList<Cell> list2 = model.defineNeigh(rndNeigh.x, rndNeigh.y, rndNeigh.getMyColor());
		 int corrs = 0;
		 for(Cell cell4: list) {
			 
			 for(Cell cell42: list2) {
				 if(Cell.compare( cell4.getMyColor(), cell42.getMyColor())) {
					 
					 int difx = Math.abs(cell4.x-cell42.x);
					 int dify = Math.abs(cell4.y-cell42.y);
					 if(difx<3 && dify<3) continue; 
					 //corrs++;
						 
						 return cell42;
						 
				 }
			 }
			 
		 }
		 	 
		return null;
	}

	private ArrayList<Cell> filterFromPro(Cell c2, int m) throws Exception {
		
		 ArrayList<Cell> fcells = new ArrayList<Cell>();
		 //if(m>3) return fcells;
		 
			for(int i=0;i<cells.size();i++) {
				Cell c = cells.get(i);
				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
					
					if(c2.compare(c)==true) continue;
					
					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
					if(n<=m) 
					{
						 
						fcells.add(c);
					}
				}
			}
			//if(fcells.size()==0) return filterFromPro(c2, m++); 
			//else 
			return fcells;
		}  
	
	
	private ArrayList<Cell> filterFromCluster( ArrayList<Cell> list) throws Exception {
		
		int[] color = list.get(0).myColor;
		ArrayList<Cell> fcells = new ArrayList<Cell>();
		
		for(int i=0;i<cells.size();i++) {
			Cell c = cells.get(i);
			if( Cell.compare( c.getMyColor(), color ) ) {
				
				
				for(Cell c2: list) {
					if(c.compare(c2)) {
						c = null;
						break;
					}
				}
				if(c!=null) fcells.add(c);
			}
		}
		
		return fcells;
	}   

		private ArrayList<Cell> filterFrom(Cell c2) throws Exception {
			
			ArrayList<Cell> fcells = new ArrayList<Cell>();
			
			for(int i=0;i<cells.size();i++) {
				Cell c = cells.get(i);
				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
					
					//if(c2.compare(c)==true) continue;
					
				//	int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
					//if(n==0) 
					{
						fcells.add(c);
					}
				}
			}
			return fcells;
		}   
		

		private Cell maxFrom(Cell c2) throws Exception {
			ArrayList<Cell> fcells = new ArrayList<Cell>();
			int max= -1;
			for(int i=0;i<cells.size();i++) {
				Cell c = new Cell(cells.get(i));
				//(c2.compare(c)==true) continue;
				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
					if(n==8) continue;
					if(n>max) {
						max = n;
						fcells.add(c);
					}
				}
			}
			if(fcells.size()==0) return null;
			return fcells.get(0);//  HelperRandom.getRandomInt(0, fcells.size()));
		} 


		private Cell maxFromPro(Cell c2) throws Exception {
			ArrayList<Cell> fcells = new ArrayList<Cell>();
			int max= -1;
			for(int i=0;i<cells.size();i++) {
				Cell c = new Cell(cells.get(i));
				//(c2.compare(c)==true) continue;
				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
					if(n==8) continue;
					if(n>max) {
						max = n;
						fcells.add(c);
					}
				}
			}
			if(fcells.size()==0) return null;
			return fcells.get(fcells.size()-1);//  HelperRandom.getRandomInt(0, fcells.size()));
		} 
		
		private Cell minQtyNeighSameColor(int[] color) throws Exception {
			
			for(int i=0;i<cells.size();i++) {
				Cell c = new Cell(cells.get(i));
				if( Cell.compare( c.getMyColor(), color ) ) {
					int sz = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size(); 
					if( sz < 3 ) {
						return c;
					}
					
				}
			}
			return null;
			
		} 

		private Cell minExclude(Cell c2) throws Exception {
			ArrayList<Cell> fcells = new ArrayList<Cell>();
			int max= -1;
			for(int i=0;i<cells.size();i++) {
				Cell c = new Cell(cells.get(i));
				//(c2.compare(c)==true) continue;
				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
					if(n==8) continue;
					if(n>max) {
						max = n;
						fcells.add(c);
					}
				}
			}
			if(fcells.size()==0) return null;
			return fcells.get(0);//  HelperRandom.getRandomInt(0, fcells.size()));
		} 

		



}
