package practice;

import java.util.LinkedList;
import java.util.Queue;

class Graph{
	private int V;
	private LinkedList<Integer> adj[];
	
	Graph(int V){
		this.V = V;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int u, int v){
		adj[u].add(v);
	}
	
	public void bfs(int u){
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[V];
		for(int i = 0; i < V; i++)
			visited[i] = false;
		queue.offer(u);
		visited[u] = true;
		
		while(!queue.isEmpty()){
			int v = queue.poll();
			System.out.print(v + " ");
			for(int w : adj[v]){
				if(!visited[w]){
					queue.offer(w);
					visited[w] = true;
				}
			}
		}
	}
	
	public static Graph getInstance(){
		Graph g = new Graph(6);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		return g;
	}
}

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = Graph.getInstance();
		g.bfs(5);
	}

}
