package practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Node{
	int node;
	int dist;
	
	Node(int n, int d){
		node = n;
		dist = d;
	}
}

public class SnakeLadder {
	private Map<Integer, Integer> snake_ladder;
	private int numOfCells;
	
	SnakeLadder(){
		snake_ladder = new HashMap<Integer, Integer>();
		numOfCells = 100;
	}
	
	private void addToMap(int u, int v){
		snake_ladder.put(u, v);
	}
	
	public void addSnake(int u, int v){
		addToMap(u, v);
	}
	
	public void addLadder(int u, int v){
		addToMap(u, v);
	}
	
	public int getMapValue(int u){
		if(snake_ladder.containsKey(u))
			return snake_ladder.get(u);
		return -1;
	}
	
	public int numOfJumps(){
		Queue<Node> queue = new PriorityQueue<Node>(numOfCells, new Comparator<Node>(){
			public int compare(Node o1, Node o2) {
				if(o1.dist < o2.dist)
					return -1;
				else if(o1.dist == o2.dist)
					return 0;
				return 1;
			}	
		});
		
		boolean visited[] = new boolean[numOfCells+1];
		Node nodes[] = new Node[numOfCells+1];
		int jumps[] = new int[numOfCells+1]; 
		for(int i = 1; i <= numOfCells; i++){
			visited[i] = false;
			jumps[i] = Integer.MAX_VALUE;
			nodes[i] = new Node(i, Integer.MAX_VALUE);
			queue.add(nodes[i]);
		}
		
		jumps[1] = 0;
		queue.remove(nodes[1]);
		nodes[1].dist = 0;
		queue.offer(nodes[1]);
		
		
		while(!queue.isEmpty()){
			Node un = queue.poll();
			int u = un.node;
			
			for(int I = 1; I <= 6; I++){
				int newu = u + I;
				if( newu <= numOfCells){
					if(queue.contains(nodes[newu])){
						int nnu = getMapValue(newu);
						if(nnu == -1){
							if(jumps[u] != Integer.MAX_VALUE && jumps[newu] > jumps[u] + 1){
								queue.remove(nodes[newu]);
								jumps[newu] = jumps[u] + 1;
								nodes[newu].dist = jumps[newu];
								queue.offer(nodes[newu]);
							}
						}
						else{
							if(jumps[u] != Integer.MAX_VALUE && jumps[nnu] > jumps[u] + 1){
								queue.remove(nodes[nnu]);
								jumps[nnu] = jumps[u] + 1;
								nodes[nnu].dist = jumps[nnu];
								queue.offer(nodes[nnu]);
							}
						}
					}
				}
			}
		}
		for(int i = 1; i <= numOfCells; i++)
			System.out.print(jumps[i] + " ");
		System.out.println();
		return jumps[100];
	}
	
	private int findMinNode(int dist[], boolean visited[]){
		int mindist = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 1; i <= numOfCells; i++){
			if(dist[i] != Integer.MAX_VALUE && dist[i] < mindist && !visited[i]){
				mindist = dist[i];
				index = i;
			}
		}
		return index;
	}
	
	public int count(){
		boolean visited[] = new boolean[numOfCells+1];
		int dist[] = new int[numOfCells+1];
		
		for(int i = 1; i <= numOfCells; i++){
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[1] = 0;
		for(int i = 1; i <= numOfCells; i++){
			int u = findMinNode(dist, visited);
			if(u == -1)
				break;
			visited[u] = true;
			for(int I = 1; I <= 6; I++){
				if(u + I <= numOfCells){
					int nnu = getMapValue(u+I);
					if(nnu == -1){
						if(dist[u] != Integer.MAX_VALUE && dist[u+I] > dist[u] + 1)
							dist[u+I] = dist[u] + 1;
					}
					else{
						if(dist[u] != Integer.MAX_VALUE && dist[nnu] > dist[u] + 1)
							dist[nnu] = dist[u] + 1;
					}
				}
			}
		}
		for(int i = 1; i <= numOfCells; i++)
			System.out.print(dist[i]+ " ");
		System.out.println();
		return dist[100];
	}
	
	public static void main(String[] args) {
		SnakeLadder sl = new SnakeLadder();
		sl.addLadder(10, 50);
		sl.addLadder(51, 90);
		int j = sl.numOfJumps();
		System.out.println("jumps: "+j);
		
		int k = sl.count();
		System.out.println("jumps: "+k);
	}
}
