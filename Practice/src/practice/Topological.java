package practice;

import java.util.Deque;
import java.util.LinkedList;

public class Topological {
	
	static class Graph{
		
		private LinkedList<Integer> adj[];
		private int V;
		
		Graph(int V){
			this.V = V;
			adj = new LinkedList[V];
			for(int i = 0; i < V; i++)
				adj[i] = new LinkedList<Integer>();
		}
		
		public void addEdge(int u, int v){
			adj[u].add(v);
		}
		
		private void _topological(int v, boolean visited[], Deque<Integer> stack){
			visited[v] = true;
			//System.out.println(v);
			for(int u : adj[v]){
				if(!visited[u])
					_topological(u, visited, stack);
			}
			stack.push(v);
		}
		
		public void topological(){
			boolean visited[] = new boolean[V];
			for(int i = 0; i < V; i++)
				visited[i] = false;
			Deque<Integer> stack = new LinkedList<Integer>();
			
			for(int i = 0; i < V; i++){
				if(!visited[i])
					_topological(i, visited, stack);
			}
			
			while(!stack.isEmpty()){
				System.out.print(stack.pop() + " ");
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = Graph.getInstance();
		graph.topological();
	}

}
