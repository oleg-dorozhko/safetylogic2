package pixeleditor;

import java.util.Comparator;

public class MdfClusterComparator implements Comparator<MdfCluster> {

	    @Override
	    public int compare(MdfCluster o1, MdfCluster o2) {
	        // write comparison logic here like below , it's just a sample
	        return o1.num - o2.num;
	    }
}

