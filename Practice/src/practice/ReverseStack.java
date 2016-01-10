package practice;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseStack {
	
	private void insertAtBottom(Deque<Integer> stack, int e){
		if(stack.isEmpty()){
			stack.push(e);
			return;
		}
		int v = stack.pop();
		insertAtBottom(stack, e);
		stack.push(v);
	}
	
	public void reverse(Deque<Integer> stack){
		if(stack.isEmpty())
			return;
		int v = stack.pop();
		reverse(stack);
		insertAtBottom(stack, v);
	}
	
	public void print(Deque<Integer> stack){
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		ReverseStack rs = new ReverseStack();
		rs.reverse(stack);
		rs.print(stack);
	}

}
