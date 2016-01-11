package practice;

public class ListMergeSort {
	
	private static class Node{
		int value;
		Node next;
		
		Node(int v){
			value = v;
			next = null;
		}
	}
	
	private Node split(Node node){
		if(node == null || node.next == null)
			return null;
		Node slow = node;
		Node fast = node.next;
		while(fast != null){
			fast = fast.next;
			if(fast != null){
				slow = slow.next;
				fast = fast.next;
			}
		}
		fast = slow.next;
		slow.next = null;
		return fast;
	}
	
	private Node merge(Node l1, Node l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		Node head = null;
		if(l1.value <= l2.value){
			head = l1;
			head.next = merge(l1.next, l2);
		}
		else{
			head = l2;
			head.next = merge(l1, l2.next);
		}
		return head;
	}
	
	public Node sort(Node node){
		if(node == null || node.next == null)
			return node;
		Node list1 = node;
		Node list2 = split(node);
		list1 = sort(list1);
		list2 = sort(list2);
		
		node = merge(list1, list2);
		return node;
	}
	
	public void print(Node node){
		if(node == null){
			System.out.println("List is empty");
			return;
		}
		while( node != null){
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Node head = null;
		Node head = new Node(10);
		head.next = new Node(3);
		head.next.next = new Node(8);
		head.next.next.next = new Node(5);
		
		ListMergeSort lms = new ListMergeSort();
		lms.print(head);
		head = lms.sort(head);
		lms.print(head);
	}

}
