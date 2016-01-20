package list;

public class KReverseList {
	
	private static class Node{
		int value;
		Node next;
		
		Node(int v){
			value = v;
			next = null;
		}
	}
	
	private static class Nodes{
		Node head;
		Node next;
		Nodes(Node h, Node n){
			head = h;
			next = n;
		}
	}
	
	private Nodes reverse(Node node, int k){
		if(node == null || node.next == null)
			return new Nodes(node, null);
		int i = 1;
		Node prev = null, next = null;
		while(node != null && i <= k){
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}
		return new Nodes(prev, next);		
	}
	
	public Node kreverse(Node node, int k){
		if(node == null || node.next == null)
			return node;
		//System.out.println("processing: " + node.value);
		Nodes r = reverse(node, k);
		node.next = kreverse(r.next, k);
		return r.head;
	}
	
	public void print(Node node){
		if(node == null){
			System.out.println("empty list");
			return;
		}
		while(node != null){
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		
		KReverseList kr = new KReverseList();
		kr.print(head);
		head = kr.kreverse(head, 5);
		kr.print(head);
	}

}
