package practice;

public class CheckLeafLevel {
	
	private static class Node{
		int value;
		Node left;
		Node right;
		
		Node(int v){
			value = v;
			left = null;
			right = null;
		}
	}
	
	private int leafLevel = 0;
	public boolean check(Node node, int level){
		if(node == null)
			return true;
		if(node.left == null && node.right == null){
			if(leafLevel == 0){
				leafLevel = level;
				return true;
			}
			else if(leafLevel == level)
				return true;
			else 
				return false;
		}
		
		return check(node.left, level+1) && check(node.right, level+1);
			
	}
	
	public int checkLeafLevel(Node node){
		if(node == null)
			return 0;
		int l = 0, r = 0;
		if(node.left != null)
			l = checkLeafLevel(node.left);
		if(node.right != null)
			r = checkLeafLevel(node.right);
		if(l == 0 && r == 0)
			return 1;
		if(l == -1 || r == -1)
			return -1;
		if(l == 0)
			return r+1;
		if(r == 0)
			return l+1;
		if(l == r)
			return l+1;
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		root.right.right = new Node(25);
		root.right.right.right = new Node(30);
		root.left.left = new Node(15);
		root.left.right = new Node(18);
		
		CheckLeafLevel cll = new CheckLeafLevel();
		System.out.println(cll.checkLeafLevel(root));
		System.out.println(cll.check(root, 0));
	}

}
