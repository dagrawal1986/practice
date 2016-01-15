package practice;

public class ReverseList {
	
	public LNode reverse(LNode node){
		if(node == null || node.next == null)
			return node;
		LNode prev = null;
		while(node != null){
			LNode t = node.next;
			node.next = prev;
			prev = node;
			node = t;
		}
		return prev;
	}
	
	private LNode lhead = null;
	private void rreverse(LNode node, LNode prev){
		if(node == null){
			lhead = prev;
			return;
		}
		
		rreverse(node.next, node);
		node.next = prev;

	}
	
	public LNode recursiveReverse(LNode node){
		rreverse(node, null);
		return lhead;
	}
	
	public void print(LNode node){
		if(node == null){
			System.out.println("Empty List");
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
		LNode head = new LNode(2);
		head.next = new LNode(4);
		head.next.next = new LNode(10);
		//head.next.next.next = new LNode(15);
		
		ReverseList rl = new ReverseList();
		rl.print(head);
		head = rl.reverse(head);
		rl.print(head);
		head = rl.recursiveReverse(head);
		rl.print(head);
		
	}

}
