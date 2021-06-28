package pixeleditor;

import java.util.ArrayList;

public class CellStats {

	private ArrayList<Cell> empties;
	private ArrayList<Cell> other;
	private ArrayList<Cell> same;

	public CellStats(ArrayList<Cell> diff, ArrayList<Cell> neighs, ArrayList<Cell> same) {
		this.empties = diff;
		this.other = neighs;
		this.same = same;
	}

}
