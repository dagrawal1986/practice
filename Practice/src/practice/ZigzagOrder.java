package practice;

import java.util.Deque;
import java.util.LinkedList;

public class ZigzagOrder {
	
	public void zigzag(TNode node){
		Deque<TNode> stack1 = new LinkedList<TNode>();
		Deque<TNode> stack2 = new LinkedList<TNode>();
		stack1.push(node);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			while(!stack1.isEmpty()){
				TNode t = stack1.pop();
				System.out.print(t.value + " ");
				if(t.left != null)
					stack2.push(t.left);
				if(t.right != null)
					stack2.push(t.right);
			}
			System.out.println();
			while(!stack2.isEmpty()){
				TNode t = stack2.pop();
				System.out.print(t.value + " ");
				if(t.right != null)
					stack1.push(t.right);
				if(t.left != null)
					stack1.push(t.left);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TNode root = new TNode(10);
		root.left = new TNode(5);
		root.right = new TNode(20);
		root.left.left = new TNode(2);
		root.left.right = new TNode(8);
		
		ZigzagOrder zz = new ZigzagOrder();
		zz.zigzag(root);
	}

}
