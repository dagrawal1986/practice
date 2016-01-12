package practice;

public class BTreeToLinkedList {
	
	private static class Node{
		int value;
		Node left;
		Node right;
		
		Node(int v){
			value = v;
			left = right = null;
		}
	}
	
	private static class prevNode{
		Node prev;
		
		prevNode(){
			prev = null;
		}
	}
	
	//private Node prev = null;
	
	private void fix(Node node, prevNode prev){
		if(node == null)
			return;
		
		fix(node.left, prev);
		node.left = prev.prev;
		if(prev.prev != null)
			prev.prev.right = node;
		prev.prev = node;
		fix(node.right, prev);
	}
	
	private Node gethead(Node node){
		if(node == null)
			return node;
		while(node.left != null)
			node = node.left;
		return node;
	}
	
	public Node convert(Node node){
		if(node == null)
			return node;
		
		if(node.left == null && node.right == null)
			return node;
		
		prevNode prev = new prevNode();
		
		fix(node, prev);
		node = gethead(node);
		return node;
	}
	
	public void printlist(Node node){
		if(node == null){
			System.out.println("empty list");
			return;
		}
		
		while(node != null){
			System.out.print(node.value +  " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		root.left.left = new Node(2);
		root.left.right = new Node(8);
		
		BTreeToLinkedList btll = new BTreeToLinkedList();
		root = btll.convert(root);
		btll.printlist(root);

	}

}
