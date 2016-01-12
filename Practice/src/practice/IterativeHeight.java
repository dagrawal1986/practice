package practice;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeHeight {
	
	public int findHeight(TNode root){
		if(root == null)
			return 0;
		Queue<TNode> queue = new LinkedList<TNode>();
		queue.add(root);
		int height = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			height++;
			while(size > 0){
				TNode n = queue.poll();
				if(n.left != null)
					queue.add(n.left);
				if(n.right != null)
					queue.add(n.right);
				size--;
			}
		}
		return height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TNode root = new TNode(10);
		root.left = new TNode(5);
		root.right = new TNode(20);
		root.left.left = new TNode(2);
		root.left.left.left = new TNode(1);
		
		IterativeHeight ih = new IterativeHeight();
		System.out.println(ih.findHeight(root));
	}

}
