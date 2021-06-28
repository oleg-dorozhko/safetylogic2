package pixeleditor;

import java.util.Stack;

public class ItStack {
	
	private Stack<It> tes;
	
	public ItStack(ItStack itStack) {
		this.tes = (Stack<It>) itStack.cloneStack();
	}

	public ItStack() {
		tes = new Stack<It>();
	}

	private Stack<It> cloneStack() {
		Stack<It> n = new Stack<It>();
		for(int i=0;i<tes.size();i++) {
			n.push(new It(tes.get(i)));
		}
		return n; 
	}

	public Stack<It> getStack() {
		// TODO Auto-generated method stub
		return this.tes;
	}

}
