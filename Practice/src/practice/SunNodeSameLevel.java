package practice;

import java.util.HashMap;
import java.util.Map;

public class SunNodeSameLevel {
	
	Map<Integer, Integer> map;
	SunNodeSameLevel(){
		map = new HashMap<Integer, Integer>();
	}
	
	public int getsum(TNode node){
		sum(node, 0);
		int result = 1;
		for(Integer i : map.values())
			result *= i;
		return result;
	}
	
	private boolean isLeaf(TNode node){
		if(node.left ==  null && node.right == null)
			return true;
		return false;
	}
	
	private void sum(TNode node, int level){
		if(node == null)
			return;
		
		if(isLeaf(node)){
			if(map.containsKey(level))
				map.put(level, map.get(level)+node.value);
			else
				map.put(level, node.value);
		}
		
		sum(node.left, level+1);
		sum(node.right, level+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TNode root = new TNode(10);
		root.left = new TNode(5);
		root.right = new TNode(20);
		root.right.right = new TNode(25);
		root.left.left = new TNode(2);
		root.left.right = new TNode(7);
		root.left.right.left = new TNode(6);
		
		SunNodeSameLevel snsl = new SunNodeSameLevel();
		System.out.println(snsl.getsum(root));
	}

}
