package pixeleditor;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import pixeleditor.Logger;

public class MdfBufferStorage {

	private MdfCluster[][] storage;
	private GameModel model;

	public MdfBufferStorage(GameModel model) throws Exception {
		
//		Logger.lo("Storage initialising in process");
		this.model = model;
//		this.storage = new MdfCluster[GameModel.windowWidth][GameModel.windowHeight];
//		
//		ArrayList<Cell> cells = new ArrayList<Cell>();
//		 int cw = GameModel.cellWidth;
//	       int ch = GameModel.cellHeight;
//	       	
//	       	for(int i=0;i<GameModel.windowWidth;i++) {
//	       		for(int j=0;j<GameModel.windowHeight;j++) {
//	       		
//	       			cells.add(new Cell(model.getCellXY(i, j)));
//	       		
//	       		}
//	       	}
//	       	int counter=0;
//	       	while(true) {
//	       		
//	       		boolean f = false;
//	       		Cell fcell = null;
//	       		ArrayList<Cell> tcells = null;
//	       		for(Cell tcell: cells) {
//	       			f=true;
//	       			
//	       			ModDummyFast mdf = getAreaArrays(tcell);
//	    			//Cell tcell = mdf.global_dummy_fast_thread_border_cluster.get(0);
//	       			//log("in cluster:");
//	    			//for(Cell t2cell: mdf.global_dummy_fast_thread_in_cluster) {
//	    			//	cells.remove(ch)//log(""+tcell);
//	    			//}
//	    			//log("border cluster:");
//	    			//for(Cell t2cell: mdf.global_dummy_fast_thread_border_cluster) {
//	    				//log(""+tcell);
//	    			//}
//	    			tcells = (ArrayList<Cell>) joinLists(mdf.global_dummy_fast_thread_in_cluster, mdf.global_dummy_fast_thread_border_cluster);
//	    			this.storage[tcell.x][tcell.y] = new MdfCluster(counter++, tcells); 
//	    			fcell = tcell;
//	    			break;
//	       			
//	       		}
//	       		
//	       		if(fcell != null) {
//	       			
//	       				for(Cell ffcell: tcells) {
//	       					
//		       				Cell fffCell = null;
//			       			for(Cell f4cell: cells) {
//			       				if(ffcell.compare(f4cell)) {
//			       					fffCell = f4cell;
//			       					break;
//			       				}
//			       			}
//			       			if(fffCell!=null) cells.remove(fffCell);
//	       				}
//	       			
//	       		}
//	       		
//	       		if(cells.size()==0) break;
//	       		
//	       	}
//	       	
//	       	Logger.lo("Storage initialising finished");
		
		reinitialization();
	       	
	}
	
	
	  public  ModDummyFast getAreaArrays(Cell cell) throws Exception {
		    
		     ModDummyFast mdf = new ModDummyFast();
		     mdf.init_dummy_fast_thread(this.model);
							
			 mdf.global_dummy_fast_thread_arr2_all.add( new Cell(cell) );
			 mdf.global_dummy_fast_thread_color = cell.myColor;
		    
		    
		 
		        
		    
						 int res = 0;
		                 do {  
		                         res = mdf.dummy_fast_thread ( );
		                         try {
		                         Thread.sleep(20);
		                         }
		                         catch(InterruptedException ex) {
		                         }
		                 } 
		                 while(res == 5);
						return mdf;
		                
		               //  System.exit(1);
		 } 
	  
	
	
	
	
	
	
	
	
	
	//https://ru.stackoverflow.com/questions/444074/
	public static List<Cell> joinLists(List<Cell> a, List<Cell> b) {
	    if ((a == null) || (a.isEmpty() && (b != null))) return b;
	    if ((b == null) || b.isEmpty()) return a;
	    int aSize = a.size();
	    int bSize = b.size();
	    // «акладываем размер достаточный дл€ всех элементов
	    ArrayList<Cell> result = new ArrayList(aSize + bSize); 
	    // ≈сли списки обеспечивают быстрый доступ к своим элементам, например ArrayList
	    if ((a instanceof RandomAccess) && (b instanceof RandomAccess)) { 
	        for (int i = 0; i < aSize; i++) result.add(a.get(i));
	        for (int i = 0; i < bSize; i++) result.add(b.get(i));
	    } else { 
	    // ј если это какие-то кресть€нские списки, то копируем по-кресть€нски 
	        result.addAll(a);
	        result.addAll(b);
	    }
	    return result;
	}

	public MdfCluster getCluster(Cell cell) throws Exception { ///? i=cell.x ??
		int cw = GameModel.cellWidth;
	    int ch = GameModel.cellHeight;
	       	
//	    for(int i=0;i<GameModel.windowWidth;i++) {
//	    	for(int j=0;j<GameModel.windowHeight;j++) {
	    		 MdfCluster cluster = this.storage[cell.x][cell.y];
	    		 if(cluster==null) 
	    			 return this.redefineCluster(GameModel.windowWidth*cell.x+cell.y, cell);//continue;
//	    		 for(Cell tcell: cluster.cells) {
//	    			 if(tcell.compare(cell)) return cluster;
//	    		 }
//	       		
//	    	}
//	    }
	    
	    		 else return cluster;
	}

	public ArrayList<MdfCluster> containInClusters(Cell cell) throws Exception { ///? i=cell.x ??
		   	
		ArrayList<MdfCluster> cls = new ArrayList<MdfCluster>(); 
	    for(int i=0;i<GameModel.windowWidth;i++) {
	    	for(int j=0;j<GameModel.windowHeight;j++) {
	    		
	    		 MdfCluster cluster = this.storage[i][j];
	    		 if(cluster==null) continue; 
	    		//return this.redefineCluster(GameModel.windowWidth*cell.x+cell.y, cell);//continue;
	    		 
	    		 
	    		 boolean found=false;
	    		 for(Cell tcell: cluster.cells) {
	    			 if(tcell.compare(cell)) {
	    				 found=true;
	    			 }
	    		 }
				 if(found) cls.add(cluster);
	       		
	    	}
	    }
	    
	    return cls;
	}


	public void commitChanges(Cell cell, Cell cell2, Cell newCellM, Cell newRndNeigh) throws Exception {
		
		MdfCluster c = getCluster(cell);
		MdfCluster c2 = getCluster(cell2);
		if(c2==null) {
			Logger.log(""+44);
		}
		c2.removeCell(cell2);
		c.removeCell(cell);
		c2.addCell(newRndNeigh);
		c.addCell(newCellM);
		
		
		
//		MdfCluster c3 = redefineCluster(c.num, newCellM);
//		MdfCluster c4 = redefineCluster(c2.num, newRndNeigh);
//		 
//		for(int i=0;i<GameModel.windowWidth;i++) {
//		    	for(int j=0;j<GameModel.windowHeight;j++) {
//		    		 
//		    		MdfCluster cluster = this.storage[i][j];
//		    		 if(cluster==null) continue;
//		    		
//		    		 if(cluster.num==c.num) {
//		    			 cluster = c3;
//		    		 } else if( cluster.num == c2.num) {
//		    			 cluster = c4;
//		    		 }
//		    		 
//		    		 //for(Cell tcell: cluster.cells) {
//		    			 //if(tcell.compare(cell)) return cluster;
//		    		 //}
//		       		
//		    	}
//		    }
	}

	public void reinitialization() throws Exception {
		
		Logger.lo("Storage initialising in process");
		 
		this.storage = new MdfCluster[GameModel.windowWidth][GameModel.windowHeight];
		
		ArrayList<Cell> cells = new ArrayList<Cell>();
		  
	       	
	       	for(int i=0;i<GameModel.windowWidth;i++) {
	       		for(int j=0;j<GameModel.windowHeight;j++) {
	       		
	       			cells.add(new Cell(model.getCellXY(i, j)));
	       		
	       		}
	       	}
	       	int counter=0;
	       	while(true) {
	       		
	       		Cell fcell = null;
	       		ArrayList<Cell> tcells = null;
	       		for(Cell tcell: cells) {
	       			ModDummyFast mdf = getAreaArrays(tcell);
	    			//Cell tcell = mdf.global_dummy_fast_thread_border_cluster.get(0);
	       			//log("in cluster:");
	    			//for(Cell t2cell: mdf.global_dummy_fast_thread_in_cluster) {
	    			//	cells.remove(ch)//log(""+tcell);
	    			//}
	    			//log("border cluster:");
	    			//for(Cell t2cell: mdf.global_dummy_fast_thread_border_cluster) {
	    				//log(""+tcell);
	    			//}
	    			tcells = (ArrayList<Cell>) joinLists(mdf.global_dummy_fast_thread_in_cluster, mdf.global_dummy_fast_thread_border_cluster);
	    			this.storage[tcell.x][tcell.y] = new MdfCluster(counter++, tcells); 
	    			fcell = tcell;
	    			break;
	       			
	       		}
	       		
	       		if(fcell != null) {
	       			
	       				for(Cell ffcell: tcells) {
	       					
		       				Cell fffCell = null;
			       			for(Cell f4cell: cells) {
			       				if(ffcell.compare(f4cell)) {
			       					fffCell = f4cell;
			       					break;
			       				}
			       			}
			       			if(fffCell!=null) 
			       				cells.remove(fffCell);
	       				}
	       			
	       		}
	       		
	       		if(cells.size()==0) break;
	       		
	       	}
	       	
	       	
	       	Logger.lo("Storage links clusters");
	       	for(int i=0;i<GameModel.windowWidth;i++) {
	       		for(int j=0;j<GameModel.windowHeight;j++) {
	       		
	       			 if(this.storage[i][j]!=null) {
	       				 ArrayList<Cell> tcells = this.storage[i][j].cells;
	       				 for(Cell tcell: tcells) {
	       					 	for(int ii=0;ii<GameModel.windowWidth;ii++) {
	       				       		for(int jj=0;jj<GameModel.windowHeight;jj++) {
	       				       			if(tcell.x == ii && tcell.y == jj)
	       				       				this.storage[ii][jj] = this.storage[i][j]; 
	       				       		}
	       				       	}
	       				  }
	       			 }
	       		
	       		}
	       	}
	       	
	       	
	       	Logger.lo("Storage initialising finished");
	}

	private MdfCluster redefineCluster(int num, Cell tcell) throws Exception {
		
			ModDummyFast mdf = getAreaArrays(tcell);
			 
			ArrayList<Cell> tcells = (ArrayList<Cell>) joinLists(mdf.global_dummy_fast_thread_in_cluster, mdf.global_dummy_fast_thread_border_cluster);
			return new MdfCluster(num, tcells); 
	}


	public boolean sameCluster(Cell cell, Cell maxCell) throws Exception {
		MdfCluster c = getCluster(maxCell);
		MdfCluster c2 = getCluster(cell);
		
		return (c.num==c2.num);
	}


	public MdfCluster getNextClusterSameColorLTQSize(MdfCluster c, int[] color) {
		
		  for(int i=0;i<GameModel.windowWidth;i++) {
		    	for(int j=0;j<GameModel.windowHeight;j++) {
		    		 MdfCluster cluster = this.storage[i][j];
		    		 if(cluster==null) continue;
		    		 if(cluster.num == c.num ) continue;
		    		 if(cluster.cells.size() <= c.cells.size()) {
			    		 for(Cell tcell: cluster.cells) {
			    			 if(Cell.compare( tcell.getMyColor(), color)) return cluster;
			    		 }
		    		 }
		       		
		    	}
		    }
		    return null;
	}


	public MdfCluster getNextClusterSameColorNotContainCellAndDefiniteCellSize(Cell vcell, int sz) throws Exception {
		MdfCluster c = getCluster(vcell);
		//return !c;
		 for(int i=0;i<GameModel.windowWidth;i++) {
		    	for(int j=0;j<GameModel.windowHeight;j++) {
		    		 MdfCluster cluster = this.storage[i][j];
		    		 if(cluster==null) continue; //throw new Exception("in storage null");
		    		 if(cluster.num == c.num ) continue;
		    		 if(cluster.cells.size() == sz) { 
			    		 for(Cell tcell: cluster.cells) {
			    			 if(Cell.compare( tcell.getMyColor(), vcell.myColor)) return cluster;
			    		 }
		    		 }
		       		
		    	}
		    }
		    return null;
		
	}

	
}
