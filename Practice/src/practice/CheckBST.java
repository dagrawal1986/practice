package practice;

public class CheckBST {
	
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
	
	Node prev;
	private boolean _check(Node root, int min, int max){
		if(root == null)
			return true;
		if(root.value > max || root.value < min)
			return false;
		return _check(root.left, min, root.value) && 
				_check(root.right, root.value, max);
	}
	
	public boolean check(Node root){
		return _check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean inordercheck(Node root){
		if(root == null)
			return true;
		
		if(inordercheck(root.left) == false)
			return false;
		
		if(prev != null && prev.value > root.value)
			return false;
		prev = root;
		
		return inordercheck(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		root.left.left = new Node(2);
		root.left.right = new Node(8);
		
		CheckBST cbst = new CheckBST();
		System.out.println(cbst.check(root));
		System.out.println(cbst.inordercheck(root));

	}

}
