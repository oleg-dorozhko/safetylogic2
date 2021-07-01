package pixeleditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyThread5 implements Runnable {
	
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
	


	public MyThread5(GameModel model, MdfBufferStorage mbs,  Cell c1, Cell c2) throws Exception {
		this.model = model;
		this.cells = model.cells;
		this.cell = new Cell(c1);
		this.cell2 = new Cell(c2);
		this.mbs = mbs;
		 
		
	}
	 
	public MyThread5(GameModel model,  Cell c1, Cell c2) throws Exception {
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
			
			while( (!Thread.currentThread().isInterrupted())  )
			{
//	 		this.cell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
			
//				if(!preparePro1()) {
//					
//					this.cell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
//					//this.mbs  = new MdfBufferStorage(this.model);
//					counter++; if(counter>100) break;
//					continue;
//					//break;
//				}
//			 
			
			if(this.cell == null) continue;
			if(this.cell2 == null) continue;
			
			try
	 		{
	 			Thread.sleep(200);
	 		}
	 		 catch (InterruptedException e) {
		 
			
	 			 e.printStackTrace();
	 		 }
			
				swapCellAndCell2();
			
				
	 			
		 		try
		 		{
		 			Thread.sleep(200);
		 		}
		 		 catch (InterruptedException e) {
			 
				
		 			 e.printStackTrace();
		 		 }
		 		
		 		model.app.redrawCanvases();
		 		
		 		
		 		break;
		 
			}
			
			
			
			
		 } 
		 
		
		 
		 catch (Exception e) 
		 {
				
				e.printStackTrace();
		 }
	 		
     }
	 
	 private boolean preparePro1() throws Exception {
		 
		    Cell rndCell = this.cell;
		 //new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
		    Logger.lo("============================");
		    Logger.lo("rnd cell="+rndCell);
		    
		    MdfCluster maxc = null;
			int max=0;
			for(Cell tcell: cells) {
			
				if(Cell.compare(rndCell.myColor, tcell.getMyColor())) {
					MdfCluster c = mbs.getCluster(tcell);
					if(c.cells.size()>max) {
						max = c.cells.size();
						maxc=c;
					}
				}
			
			}
			
			if(maxc==null) {
				Logger.lo("not found maxc");
				return false;
			}
			
			ArrayList<MdfCluster> list = mbs.containInClusters(rndCell);
			//if(list.size()>1) {
				
				for(MdfCluster mdc: list) {
					Logger.lo(". "+mdc.num);
					if( mdc.num == maxc.num ) {
						
						Logger.lo("found maxc, other, not allowed");
						return false;
					}
					
//					if(mdc.cells.size()==maxc.cells.size()) {
//						Logger.lo("found maxc, other, not allowed");
//						return false;
//					}
				}
				
				
				
				//Logger.lo("found maxc, other, not allowed");
				//Logger.lo(""+list);
				//return false;
			//}
			
		    
		    
			
			ArrayList<Cell> neighs = model.defineNeigh(rndCell.x, rndCell.y, rndCell.myColor);
			
			
			this.cell = new Cell(rndCell);
			
			///////////////////////////
			//найдем максимального соседа у ячейки this.cell - то есть ее - этой ячейки - максимальный кластер и затем 
			//поищем цвет этого кластера - минимальный кластер
			//////////
			
			maxc = null;
			max=0;
			for(Cell tcell: neighs) {
			
				MdfCluster c = mbs.getCluster(tcell);
				if(c.cells.size()>max) {
					max = c.cells.size();
					maxc=c;
				}
			
			}
			
			if(maxc==null) {
				Logger.lo("not found maxc");
				return false;
			}
			
			Cell vcell = new Cell(maxc.cells.get(0));
			

			//найти минимальный кластер по цвету
			
			MdfCluster c2 = mbs.getNextClusterSameColorLTQSize(maxc, vcell.myColor);
			
			if(c2==null) {
				Logger.lo("not found minc");
				return false;
			}
			
			this.cell2 = new Cell(c2.cells.get(0));
			
			
			
		//	MdfCluster cluster = mbs.getCluster(this.cell);
		//	Cell tcell = null;
		//	if(cluster != null) tcell = cluster.cells.get(0);
			
//			ArrayList<Cell> neighs = model.defineNeigh(tcell.x, tcell.y, tcell.myColor);
//			
//			if(neighs.size()==0) {
//				return false;
//			}
//			
//			this.cell = new Cell(neighs.get(0));
			Logger.lo("this.cell="+this.cell);
//			
//			this.cell2 = getMinClusterSize(maxCell);
			Logger.lo("this.cell2="+this.cell2);
//			
//			if(this.cell2==null) 
//				
//				return false;
			
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
	
	
	
	
	for(Cell rCell: list) {
		ArrayList<Cell> neighs22 = model.defineNeigh(rCell.x, rCell.y, rCell.myColor);
		if(neighs22.size()==0) {
			Logger.lo("#55 not found neighs other colors");
			return false;
		} 
		else {
			
			for(Cell tcell: neighs22) {
				Logger.lo(""+tcell);
				ArrayList<Cell> neighs44 = model.defineNeighNeigh(tcell.x, tcell.y, tcell.myColor);
				Logger.lo(""+neighs44.size());
				if(neighs44.size()>0) {
					continue;
				}
				
				c = tcell;
				break;
				
			}
			if(c == null)
			{
				Logger.lo("#77 not found neighs other colors with neighs.size()==0");
				return false;
			}
			
		}
	}
	

	
	
	
	this.cell2 = new Cell(list.get(0));
	
	
	return true;
		
	}



	private Cell getMinClusterSize(Cell cell3) throws Exception {
		 
		 
		 ArrayList<Cell> list = filterFrom(cell3.myColor);
		 
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
		 
			ArrayList<Cell> list = filterFrom(cell3.myColor);
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
	// 			this.mbs.commitChanges( this.cell, this.cell2, newCellM, newRndNeigh );
	 			
	 //			this.mbs.reinitialization();
		
		
	}


	private Cell getCellWithMaxQtyNeighSameColorNotCellColor(ArrayList<Cell> vcells, int[] myColor) throws Exception {
		 ArrayList<Cell> fcells = new ArrayList<Cell>();
			int max= -1;
			for(int i=0;i<vcells.size();i++) {
				Cell c = new Cell(vcells.get(i));
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

		private ArrayList<Cell> filterFrom(int[] color) throws Exception {
			
			ArrayList<Cell> fcells = new ArrayList<Cell>();
			
			for(int i=0;i<cells.size();i++) {
				Cell c = cells.get(i);
				if( Cell.compare( c.getMyColor(), color ) ) {
				
						fcells.add(c);
					
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
		
		private Cell maxQtyNeighSameColor(int[] color) throws Exception {
			
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

