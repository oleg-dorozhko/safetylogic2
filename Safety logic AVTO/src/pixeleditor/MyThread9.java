package pixeleditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyThread9 implements Runnable {
	
	private Cell cell=null;
	private Cell cell2=null;
	
	private GameModel model=null;
	private ArrayList<Cell> cells;
	private ArrayList<Cell> filteredCells;
	private Cell cellW;
	private Cell cellM;
	private Cell rndNeigh;
	private boolean mode2=true;
	private ArrayList<Cell> cloneCells;
	
	private MdfBufferStorage mbs = null;
	


	public MyThread9(GameModel model, MdfBufferStorage mbs,  Cell c1) throws Exception {
		this.model = model;
		this.cells = model.cells;
		this.cell = new Cell(c1);
		this.mbs = mbs;
		//this.cell2 = new Cell(c2);
		
//		prepare2(); 
				
//		this.cell = maxFrom(this.cell);
//		if(cell2==null) {
//				
//				throw new Exception("err: #1 cell2==null");
//		}
//		
//		////////////////////////////////////////////////////
		
		
		
// 		this.filteredCells = filterFromPro( c , 0);
// 		if( this.filteredCells.size() == 0 ) {
// 			this.filteredCells = filterFromPro( c , 1);
// 			if( this.filteredCells.size() == 0 ) {
// 				this.filteredCells = filterFromPro( c , 1);
// 				if( this.filteredCells.size() == 0 ) 
// 				throw new Exception("err: #2 this.filteredCells.size()==0");
// 			}
// 			
// 		}
		
	}
	
//	
//	public void prepare2() throws Exception {
//
//		this.cell = maxFromPro(this.cell);
//		this.cell2 = minExclude(this.cell);
//
//		ArrayList<Cell> neighs = model.defineNeigh(this.cell.x, this.cell.y, this.cell.getMyColor());
//		
//		ArrayList<Cell> maxneighs = new ArrayList<Cell>(); 
//		int max=0;
//		for(Cell c45: neighs) {
//			ArrayList<Cell> neighs45 = model.defineNeighNeigh(c45.x, c45.y, c45.getMyColor());
//			if(max<neighs45.size()) {
//				max = neighs45.size();
//				maxneighs.add(c45);
//			}
//			//System.out.println(c45);
//		}
//		
//		if( maxneighs.size()==0) { 
//			
//			ArrayList<Cell> maxneighs2 = new ArrayList<Cell>(); 
//			int max2=-1;
//			for(Cell c45: neighs) {
//				ArrayList<Cell> neighs45 = model.defineNeighNeigh(c45.x, c45.y, c45.getMyColor());
//				if(max2<neighs45.size()) {
//					max2 = neighs45.size();
//					maxneighs2.add(c45);
//				}
//				//System.out.println(c45);
//			}
//			
//			if( maxneighs2.size()==0) { 
//				this.cell = null;
//			}
//			else this.cell = maxneighs2.get(0);
//	
//			
//		}
//			else {
//				if( maxneighs.size()==0) { 
//					this.cell = null;
//				}
//				else this.cell = maxneighs.get(0);
//			}
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//	public void prepare3() throws Exception {
//
//		this.cell = maxFromPro(this.cell);
//		
//		ArrayList<Cell> neighs = model.defineNeigh(this.cell.x, this.cell.y, this.cell.getMyColor());
//		
//		ArrayList<Cell> maxneighs = new ArrayList<Cell>(); 
//		int max=0;
//		for(Cell c45: neighs) {
//			ArrayList<Cell> neighs45 = model.defineNeighNeigh(c45.x, c45.y, c45.getMyColor());
//			if(max<neighs45.size()) {
//				max = neighs45.size();
//				maxneighs.add(c45);
//			}
//			//System.out.println(c45);
//		}
//		
//		if( maxneighs.size()==0) { 
//			
//			ArrayList<Cell> maxneighs2 = new ArrayList<Cell>(); 
//			int max2=-1;
//			for(Cell c45: neighs) {
//				ArrayList<Cell> neighs45 = model.defineNeighNeigh(c45.x, c45.y, c45.getMyColor());
//				if(max2<neighs45.size()) {
//					max2 = neighs45.size();
//					maxneighs2.add(c45);
//				}
//				//System.out.println(c45);
//			}
//			
//			if( maxneighs2.size()==0) { 
//				this.cell = null;
//			}
//			else this.cell = maxneighs2.get(0);
//	
//			
//		}
//			else {
//				if( maxneighs.size()==0) { 
//					this.cell = null;
//				}
//				else this.cell = maxneighs.get(0);
//			}
//		
//		
//	}
//	
//	
//	
//	
//	
//	
	
	
//	
//	public MyThread9(GameModel model,  Cell c1, Cell c2) throws Exception {
//		this.model = model;
//		this.cells = model.cells;
//		this.cell = new Cell(c1);
//		this.cell2 = new Cell(c2);
//		
//		this.cell = maxFromPro(this.cell);
//		this.cell2 = minExclude(this.cell);
//		
////		this.cell = maxFrom(this.cell);
////		if(cell2==null) {
////				
////				throw new Exception("err: #1 cell2==null");
////		}
////		
////		////////////////////////////////////////////////////
//		
//		
//		
//// 		this.filteredCells = filterFromPro( c , 0);
//// 		if( this.filteredCells.size() == 0 ) {
//// 			this.filteredCells = filterFromPro( c , 1);
//// 			if( this.filteredCells.size() == 0 ) {
//// 				this.filteredCells = filterFromPro( c , 1);
//// 				if( this.filteredCells.size() == 0 ) 
//// 				throw new Exception("err: #2 this.filteredCells.size()==0");
//// 			}
//// 			
//// 		}
//		
//	}

	public MyThread9(GameModel gameModel, MdfBufferStorage mbs2, Cell c1, Cell c2) {
		this.model = gameModel;
		this.cells = model.cells;
		this.cell = new Cell(c1);
		this.cell2 = new Cell(c2);
		
		//this.cell = maxFromPro(this.cell);
		//this.cell2 = minExclude(this.cell);
	}

//
//	private void prepare(GameModel model) throws Exception {
////		this.filteredCells = filterFrom(this.cell);
//		
//		
//		ArrayList<Cell> neighs = model.defineNeigh(this.cell.x, this.cell.y, this.cell.getMyColor());
//		this.rndNeigh =  neighs.get(HelperRandom.getRandomInt(0,neighs.size()));
//		if(neighs.size()==0) return;
//		
//boolean found=false;
//
//this.cellW = null;
//this.cellM = null;
//
//		//for(Cell tcell: this.filteredCells)
//		{
//			
//			Cell tcell = cell2;
//			ArrayList<Cell> neighsW = model.defineNeigh(tcell.x, tcell.y, tcell.getMyColor());
//			for(Cell oneW: neighsW) {
//				if(Cell.compare(oneW.getMyColor(), rndNeigh.getMyColor() ) ) {
//					found=true;
//					this.cellW = new Cell(oneW);
//					this.cellM = new Cell(tcell);
//					break;
//				}
//			}
//			//if(found) break;
//			
//		}
//		
//		
//		
//		System.out.println("cellN="+this.cell+"             cellM="+this.cellM);
//		System.out.println("cellF="+this.rndNeigh+"             cellW="+this.cellW);
//	}
	
	 public void run()
     {
		 try
		 {
			
			int counter=0;
			
			while( (!Thread.currentThread().isInterrupted())  )
			{

				model.app.redrawCanvases();
		 		
				if(this.cell == null) 					this.cell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight)));
				if( this.cell2 == null) 					this.cell2 = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight)));
				if(Cell.compare(this.cell.myColor, this.cell2.myColor)==true) {
					this.cell = null;
			 		this.cell2 = null;
					continue;
				}
				
				// break;
				
				
				//				if(!preparePro2()) {
//					
//					this.cell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
//					//this.mbs  = new MdfBufferStorage(this.model);
//					//continue;
//					break;
//				}
			
			//this.cell2 = filterFrom(maxCell).get(0);
			
			//Cell cell3 =	getCellWithMaxQtyNeighSameColorNotCellColor(this.cell.myColor);
			
			//this.cell2 = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
			//Cell cell4 =	getCellWithMaxQtyNeighSameColorNotCellColor(this.cell2.myColor);
			
			//if(cell3==null) {
				//System.out.println("cell="+this.cell);
			//	continue;
			//}
			
			//if(cell4==null) {
				//System.out.println("cell2="+this.cell2);
				//continue;
			//}
			
//			if(this.cell == null) break;
//			if(this.cell2 == null) break;
//			
//			try
//	 		{
//	 			Thread.sleep(200);
//	 		}
//	 		 catch (InterruptedException e) {
//		 
//			
//	 			 e.printStackTrace();
//	 		 }
				
				
//			
			Logger.lo("before:");
			Logger.lo("cell: "+this.cell);
			Logger.lo("cell2: "+this.cell2);
			
			MFDFCluster mb = new ModFastDummyFast().getCluster(this.cells, cell);
			Logger.lo("mb: "+mb.toString());
			Logger.lo("mb.size: "+mb.cells.size());
			
			MFDFCluster mb2 = new ModFastDummyFast().getCluster(this.cells, cell2);
			Logger.lo("mb2:" +mb2.toString());
			Logger.lo("mb2.size: "+mb2.cells.size());
			
//			
////			if(notEqualSizesOfSelectedClustersBeforeAndAfter()) {
////				this.cell = null;
////		 		this.cell2 = null;
////				continue;
////			}
//			
			
			 if(mb.cells.size()>2) {
			    	model.cells =  this.cloneCells(cloneCells);
					this.cell = null;
			 		this.cell2 = null;
					Logger.lo("3 WALL");
			 		//break;
					continue;
			    }
			    	
			    if(mb2.cells.size()>2) {
			    	model.cells =  this.cloneCells(cloneCells);
					this.cell = null;
			 		this.cell2 = null;
					Logger.lo("4 WALL");
			 		//break;
					continue;
			    }
			
			
			
			cloneCells = this.cloneCells(cells);
			
			exchangeColors(this.cell,this.cell2);


			Logger.lo("after:");
			Logger.lo("cell: "+this.cell);
			Logger.lo("cell2: "+this.cell2);
			
			MFDFCluster mb3 = new ModFastDummyFast().getCluster(this.cells, cell);
			Logger.lo("mb: "+mb3.toString());
			Logger.lo("mb.size: "+mb3.cells.size());
			
			MFDFCluster mb4 = new ModFastDummyFast().getCluster(this.cells, cell2);
			Logger.lo("mb2:" +mb4.toString());
			Logger.lo("mb2.size: "+mb4.cells.size());
		   
		    	
		    	
			if(mb.cells.size()>1) {
				MFDFCluster mb111 = new ModFastDummyFast().getCluster(this.cells, mb.cells.get(1));
				Logger.lo("mb111: "+mb111.toString());
				Logger.lo("mb111.size: "+mb111.cells.size());
				if(mb.cells.size()>mb111.cells.size()) {
					model.cells =  this.cloneCells(cloneCells);
					this.cell = null;
			 		this.cell2 = null;
					Logger.lo("FIRST WALL");
			 		//break;
					continue;
				}
			}
			
			if(mb2.cells.size()>1) {
				MFDFCluster mb222 = new ModFastDummyFast().getCluster(this.cells, mb2.cells.get(1));
				Logger.lo("mb222: "+mb222.toString());
				Logger.lo("mb222.size: "+mb222.cells.size());
				if(mb2.cells.size()>mb222.cells.size()) {
					model.cells =  this.cloneCells(cloneCells);
					this.cell = null;
			 		this.cell2 = null;
			 		Logger.lo("SECOND WALL");
					//break;
			 		continue;
				}
			}
			
//			
//				Cell[] cel = swapCellAndCell2();

				//				Logger.lo("cell: "+cel[0]);
//				Logger.lo("cell2: "+cel[1]);

				//				
//				if(someOfRulesBreaking(cel)==true) {
//					
//					model.cells =  this.cloneCells(cloneCells);
//					this.cell = null;
//			 		this.cell2 = null;
//					continue;
//				}
//				
//				
//				
//				
//				//this.cell = new Cell(cel[0]);
//				//this.cell2 = new Cell(cel[1]);
//			//	Logger.lo("after:");
//
//				
//				
//				
//				
//				
//				//				if( notEqualSizesOfSelectedClustersBeforeAndAfter()) {
////					this.cell = new Cell(cel[0]);
////				this.cell2 = new Cell(cel[1]);
////					continue;	
////			}
				
		 		try
		 		{
		 			Thread.sleep(200);
		 		}
		 		 catch (InterruptedException e) {
			 
				
		 			 e.printStackTrace();
		 		 }
		 		
		 		
		 		this.cell = null;
		 		this.cell2 = null;
		 		
		 		model.app.redrawCanvases();
		 		
		 		
		 		//break;
		 
			}
			
			
			
			
		 } 
		 
		
		 
		 catch (Exception e) 
		 {
				
				e.printStackTrace();
		 }
	 		
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
	 private synchronized void exchangeColors(Cell cell, Cell cell2) {
		 
		 removeCell(this.model.cells, cell);
		 removeCell(this.model.cells, cell2);
		 
		 int[] tcolor = cell.cloneColor(cell.myColor);
		 cell.setColor(cell2.cloneColor(cell2.myColor));
		 cell2.setColor(tcolor);
		 
		 this.model.cells.add(new Cell(this.cell));
		 this.model.cells.add(new Cell(this.cell2));
	
	 }

	private boolean someOfRulesBreaking(Cell[] cel) {
		 
		 
		 ModDummyFast beforeSwapFirstCellClusterSize = new ModDummyFast();
		 beforeSwapFirstCellClusterSize.getClusterFromCells(this.cloneCells, this.cell);
 		 int sz = beforeSwapFirstCellClusterSize.global_dummy_fast_thread_border_cluster.size();
		Logger.lo("before.cluster.first.cell.size = "+sz);
		
		 ModDummyFast beforeSwapSecondCellClusterSize = new ModDummyFast();
		 beforeSwapSecondCellClusterSize.getClusterFromCells(this.cloneCells, this.cell2);
 		 int sz2 = beforeSwapSecondCellClusterSize.global_dummy_fast_thread_border_cluster.size();
		Logger.lo("before.cluster.second.cell.size = "+sz2);
		
		 ModDummyFast afterSwapFirstCellClusterSize = new ModDummyFast();
		 afterSwapFirstCellClusterSize.getClusterFromCells(this.cells, cel[0]);
 		 int sz3 = afterSwapFirstCellClusterSize.global_dummy_fast_thread_border_cluster.size();
		Logger.lo("after.cluster.first.cell.size = "+sz3);
		
		 ModDummyFast afterSwapSecondCellClusterSize = new ModDummyFast();
		 afterSwapSecondCellClusterSize.getClusterFromCells(this.cells, cel[1]);
 		 int sz4 = afterSwapSecondCellClusterSize.global_dummy_fast_thread_border_cluster.size();
		Logger.lo("after.cluster.second.cell.size = "+sz4);
		
		if(sz==1 && sz2==1 && sz3>=1 && sz4>=1) return true;
		//if(sz2>=sz3 && sz>=sz4) return true;
		return false;
	}


	public ArrayList<Cell> cloneCells(ArrayList<Cell> cells) {
		 ArrayList<Cell> res = new ArrayList<Cell>();
		 for(Cell cell: cells) {
			 res.add(new Cell(cell));
		 }
		 return res;
	 }
	 
//	 private synchronized boolean notEqualSizesOfSelectedClustersBeforeAndAfter() throws Exception {
//		
//		 ModDummyFast beforeCellColorSize = new ModDummyFast();
// 		 beforeCellColorSize.getClusterFromCells(model.cells, this.cell);
// 		 int sz = beforeCellColorSize.global_dummy_fast_thread_border_cluster.size();
//		Logger.lo("cluster.cell = "+sz);
//		 ModDummyFast beforeCell2ColorSize = new ModDummyFast();
// 		 beforeCell2ColorSize.getClusterFromCells(model.cells, this.cell2);
// 		 int sz2 = beforeCell2ColorSize.global_dummy_fast_thread_border_cluster.size();
//		Logger.lo("cluster.cell2 = "+sz2);
//		 if(sz>sz2) return true;
//		return false;
//	}
//
//
//	private boolean preparePro1() throws Exception {
//		 
//		 Cell rndCell = this.cell;//new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
//			Logger.lo("rnd cell="+rndCell);
//			
//			this.cell = new Cell(rndCell);
//			Cell maxCell = getMaxClusterSize(rndCell);
//			
//			this.cell = new Cell(maxCell);
//			Logger.lo("max cell="+this.cell);
//			
//			
//			MdfCluster cluster = mbs.getCluster(this.cell);
//			Cell tcell = null;
//			if(cluster != null) tcell = cluster.cells.get(0);
//			
//			ArrayList<Cell> neighs = model.defineNeigh(tcell.x, tcell.y, tcell.myColor);
//			
//			if(neighs.size()==0) {
//				return false;
//			}
//			
//			this.cell = new Cell(neighs.get(0));
//			Logger.lo("neigh cell="+this.cell);
//			
//			this.cell2 = getMinClusterSize(maxCell);
//			Logger.lo("min cell2="+this.cell2);
//			
//			if(this.cell2==null) return false;
//			
//			return true;
//		
//	}
//	 
// private boolean preparePro2() throws Exception {
//		 
//	 
//	 
//	Cell rndCell = new Cell(this.cell); //
//	//Cell rndCell = new Cell(model.getCellXY(HelperRandom.getRandomInt(0, GameModel.windowWidth),HelperRandom.getRandomInt(0, GameModel.windowHeight))); 
//	Logger.lo("rnd cell="+rndCell);
//	ArrayList<Cell> neighs = model.defineNeigh(rndCell.x, rndCell.y, rndCell.myColor);
//	if(neighs.size()==0) {
//		Logger.lo("not found neighs other colors");
//		return false;
//	}
//	
//	this.cell = new Cell(rndCell);
//	
//	MdfCluster c = mbs.getCluster(this.cell);
//	if(c==null) {
//		Logger.lo("not found cluster for "+this.cell);
//		MdfCluster cd = mbs.getCluster(this.cell);
//		return false;
//	}
//	
//	MdfCluster c2 = mbs.getNextClusterSameColorLTQSize(c, this.cell.getMyColor());
//	if(c2==null) {
//		Logger.lo("not found other cluster for "+this.cell);
//		return false;
//	}
//	////////	от с2 оторвать цвет который this.cell.myColor
//	Cell addon = new Cell( c2.cells.get(0));
//	
//	///// найти самого немаксимального соседа кластера с 
//	
//	ArrayList<MdfCluster> maxNeighs = new ArrayList<MdfCluster>();
//	int max = -1;
//	
//	//for( Cell tcell: c.cells ) {
//		neighs = model.defineNeigh(this.cell.x, this.cell.y, this.cell.myColor);
//		Logger.lo("neighs="+neighs);
//		for( Cell t2cell: neighs ) {
//			MdfCluster c3 = mbs.getCluster(t2cell);
//			if(c3==null) continue;
//			 
//			if(c3.cells.size()==1)	maxNeighs.add(c3);
//			//break; 
//		}
//		
//	//}
//	
//	//Collections.sort(maxNeighs, (MdfCluster r1, MdfCluster r2) -> (r1.cells.size() - r2.cells.size()));
//	
//	//Logger.lo(""+maxNeighs);
//	if(maxNeighs.size()==0) {
//		Logger.lo(""+max);
//		Logger.lo(""+c.cells);
//		Logger.lo("not found cluster.size()==1");
//		return false;
//		//throw new Exception("error: #447, exit");
//	}
//	
//	//Logger.lo(""+maxNeighs.get(0));
//	Logger.lo("maxNeighs.get(0).cells= "+maxNeighs.get(0).cells);
//	//Logger.lo(""+maxNeighs.get(0).cells.get(0));
//	
//	
//	Cell nonMaxNeigh = new Cell( maxNeighs.get(0).cells.get(0));
//	
//	this.cell = addon;
//	this.cell2 = nonMaxNeigh;
//	Logger.lo("cell="+addon);
//	Logger.lo("cell2="+nonMaxNeigh);
//	
////	
////	
////	Cell maxCell = c.cells.get(0); //getMaxClusterSize(rndCell);
////			
////			this.cell = new Cell(maxCell);
////			Logger.lo("max cell="+this.cell);
////			
////			
////			//MdfCluster cluster = mbs.getCluster(this.cell);
////			Cell tcell = null;
////			if(c2 != null) tcell = c2.cells.get(0);
////			
////			ArrayList<Cell> neighs = model.defineNeigh(tcell.x, tcell.y, tcell.myColor);
////			
////			if(neighs.size()==0) {
////				return false;
////			}
////			
////			this.cell = new Cell(neighs.get(0));
////			Logger.lo("neigh cell="+this.cell);
////			
////			this.cell2 = getMinClusterSize(maxCell);
////			Logger.lo("min cell2="+this.cell2);
////			
////			if(this.cell2==null) return false;
////			
//			return true;
////		
//	}
//
//
//
//	private Cell getMinClusterSize(Cell cell3) throws Exception {
//		 
//		 
//		 ArrayList<Cell> list = filterFrom(cell3);
//		 
//		 MdfCluster cluster = mbs.getCluster(cell3);
//			//Cell tcell = null;
//			//if(cluster != null) tcell = cluster.cells.get(0);
//		 
////		 ModDummyFast mdf0 = model.getAreaArrays(cell3);
////			Logger.log("in cluster:");
////			for(Cell tcell: mdf0.global_dummy_fast_thread_in_cluster) {
////				Logger.log(""+tcell);
////			}
////			Logger.log("border cluster:");
////			for(Cell tcell: mdf0.global_dummy_fast_thread_border_cluster) {
////				Logger.log(""+tcell);
////			}
////		 
//		 
//			int max=0;
//			Cell maxCell = null;
//			 
//			ArrayList<Cell> min = new  ArrayList<Cell>();
//			 
//			for(Cell t2cell: list) {
//				
//				if(containCell(cluster.cells,t2cell)) continue;
//				
//				Logger.log("t2cell="+t2cell);
//				
//				//ModDummyFast mdf = model.getAreaArrays(t2cell);
//				MdfCluster cluster2 = mbs.getCluster(t2cell);
//				//Logger.log("in cluster:");
//				//for(Cell tcell: mdf.global_dummy_fast_thread_in_cluster) {
//				//	Logger.log(""+tcell);
//				//}
//				//Logger.log("border cluster:");
//				//for(Cell tcell: mdf.global_dummy_fast_thread_border_cluster) {
//				//	Logger.log(""+tcell);
//				//}
//				
//				
//				int cs = cluster2.cells.size();
//				Logger.log("Common size = "+ cs);
//				//Logger.log("Expected size = " + mdf.global_dummy_fast_thread_arr2_all.size()); 
//				
//				if(max < cs ) {
//					max=cs;
//					min.add( new Cell(t2cell));
//				}
//				
//			}
//			if(min.size()==0) return null;
//			maxCell = min.get(0);
//			Logger.log(""+maxCell);
//			Logger.log(""+max);
//			return maxCell;
//	}
//
//
//	 private boolean containCell(ArrayList<Cell> list, Cell cell) {
//		for(Cell tcell: list) {
//			if(tcell.compare(cell)) return true;
//		}
//		return false;
//	}

//
//	private Cell getMaxClusterSize(Cell cell3) throws Exception {
//		 
//			ArrayList<Cell> list = filterFrom(cell3);
//			int max=0;
//			Cell maxCell = null;
//			for(Cell t2cell: list) {
//				
//				Logger.log("t2cell="+t2cell);
//				
//				MdfCluster cluster = mbs.getCluster(t2cell);
//				//ModDummyFast mdf = model.getAreaArrays(t2cell);
//				//Logger.log("in cluster:");
//				//for(Cell tcell: mdf.global_dummy_fast_thread_in_cluster) {
//				//	Logger.log(""+tcell);
//				//}
//				//Logger.log("border cluster:");
//				//for(Cell tcell: mdf.global_dummy_fast_thread_border_cluster) {
//				//	Logger.log(""+tcell);
//				//}
//				
//				//int cs = (mdf.global_dummy_fast_thread_in_cluster.size()+mdf.global_dummy_fast_thread_border_cluster.size());
//				int cs = cluster.cells.size();
//				Logger.log("Common size = "+ cs);
//				//Logger.log("Expected size = " + mdf.global_dummy_fast_thread_arr2_all.size()); 
//				
//				if(max < cs ) {
//					max=cs;
//					maxCell = new Cell(t2cell);
//				}
//				
//			}
//			
//			Logger.log(""+maxCell);
//			Logger.log(""+max);
//			return maxCell;
//	}
//
//


	private Cell[] swapCellAndCell2() throws Exception {
		 
		Cell[] cel = new Cell[2];
		
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
	 			
	 			cel[0] = model.getCellXY(newCellM.x,newCellM.y);
	 			cel[1] = model.getCellXY(newRndNeigh.x,newRndNeigh.y);
				return cel;
			
	 			
	 	//		this.mbs  = new MdfBufferStorage(this.model);
	 			
	 			
	 			// new Objects or link to old objects ??
	 		//	this.mbs.commitChanges( this.cell, this.cell2, newCellM, newRndNeigh );
		
		
	}

//
//	private Cell getCellWithMaxQtyNeighSameColorNotCellColor(int[] myColor) throws Exception {
//		 ArrayList<Cell> fcells = new ArrayList<Cell>();
//			int max= -1;
//			for(int i=0;i<cells.size();i++) {
//				Cell c = new Cell(cells.get(i));
//				//(c2.compare(c)==true) continue;
//				if( Cell.compare( c.getMyColor(), myColor ) ) {
//					int n = model.defineNeigh(c.x, c.y, c.getMyColor()).size();
//					if(n==8) continue;
//					if(n>max) {
//						max = n;
//						fcells.add(c);
//					}
//				}
//			}
//			if(fcells.size()==0) return null;
//			//return fcells.get(0);
//			return fcells.get(fcells.size()-1);//  HelperRandom.getRandomInt(0, fcells.size()));
//			//return null;
//	}
//
//
//	private Cell getCorrelationPoint() throws Exception {
//		 for(Cell cell3: this.filteredCells) {
//			 Cell tc = notCorrelationBetween( cell3, cell);
//			 if(tc!=null)	 return tc;
//		 }
//		 
//		return null;
//	}
//
//	private Cell notCorrelationBetween(Cell cell3, Cell rndNeigh) throws Exception {
//		 
//		 ArrayList<Cell> list = model.defineNeigh(cell3.x, cell3.y, cell3.getMyColor());
//		 ArrayList<Cell> list2 = model.defineNeigh(rndNeigh.x, rndNeigh.y, rndNeigh.getMyColor());
//		 int corrs = 0;
//		 for(Cell cell4: list) {
//			 
//			 for(Cell cell42: list2) {
//				 if(Cell.compare( cell4.getMyColor(), cell42.getMyColor())) {
//					 
//					 int difx = Math.abs(cell4.x-cell42.x);
//					 int dify = Math.abs(cell4.y-cell42.y);
//					 if(difx<3 && dify<3) continue; 
//					 //corrs++;
//						 
//						 return cell42;
//						 
//				 }
//			 }
//			 
//		 }
//		 	 
//		return null;
//	}
//
//	private ArrayList<Cell> filterFromPro(Cell c2, int m) throws Exception {
//		
//		 ArrayList<Cell> fcells = new ArrayList<Cell>();
//		 //if(m>3) return fcells;
//		 
//			for(int i=0;i<cells.size();i++) {
//				Cell c = cells.get(i);
//				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
//					
//					if(c2.compare(c)==true) continue;
//					
//					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
//					if(n<=m) 
//					{
//						 
//						fcells.add(c);
//					}
//				}
//			}
//			//if(fcells.size()==0) return filterFromPro(c2, m++); 
//			//else 
//			return fcells;
//		}   
//
//		private ArrayList<Cell> filterFrom(Cell c2) throws Exception {
//			
//			ArrayList<Cell> fcells = new ArrayList<Cell>();
//			
//			for(int i=0;i<cells.size();i++) {
//				Cell c = cells.get(i);
//				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
//					
//					//if(c2.compare(c)==true) continue;
//					
//				//	int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
//					//if(n==0) 
//					{
//						fcells.add(c);
//					}
//				}
//			}
//			return fcells;
//		}   
//		
//
//		private Cell maxFrom(Cell c2) throws Exception {
//			ArrayList<Cell> fcells = new ArrayList<Cell>();
//			int max= -1;
//			for(int i=0;i<cells.size();i++) {
//				Cell c = new Cell(cells.get(i));
//				//(c2.compare(c)==true) continue;
//				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
//					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
//					if(n==8) continue;
//					if(n>max) {
//						max = n;
//						fcells.add(c);
//					}
//				}
//			}
//			if(fcells.size()==0) return null;
//			return fcells.get(0);//  HelperRandom.getRandomInt(0, fcells.size()));
//		} 
//
//
//		private Cell maxFromPro(Cell c2) throws Exception {
//			ArrayList<Cell> fcells = new ArrayList<Cell>();
//			int max= -1;
//			for(int i=0;i<cells.size();i++) {
//				Cell c = new Cell(cells.get(i));
//				//(c2.compare(c)==true) continue;
//				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
//					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
//					if(n==8) continue;
//					if(n>max) {
//						max = n;
//						fcells.add(c);
//					}
//				}
//			}
//			if(fcells.size()==0) return null;
//			return fcells.get(fcells.size()-1);//  HelperRandom.getRandomInt(0, fcells.size()));
//		} 
//		
//		private Cell minQtyNeighSameColor(int[] color) throws Exception {
//			
//			for(int i=0;i<cells.size();i++) {
//				Cell c = new Cell(cells.get(i));
//				if( Cell.compare( c.getMyColor(), color ) ) {
//					int sz = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size(); 
//					if( sz < 3 ) {
//						return c;
//					}
//					
//				}
//			}
//			return null;
//			
//		} 
//
//		private Cell minExclude(Cell c2) throws Exception {
//			ArrayList<Cell> fcells = new ArrayList<Cell>();
//			int max= -1;
//			for(int i=0;i<cells.size();i++) {
//				Cell c = new Cell(cells.get(i));
//				//(c2.compare(c)==true) continue;
//				if( Cell.compare( c.getMyColor(), c2.getMyColor() ) ) {
//					int n = model.defineNeighNeigh(c.x, c.y, c.getMyColor()).size();
//					if(n==8) continue;
//					if(n>max) {
//						max = n;
//						fcells.add(c);
//					}
//				}
//			}
//			if(fcells.size()==0) return null;
//			return fcells.get(0);//  HelperRandom.getRandomInt(0, fcells.size()));
//		} 
//
//		



}
