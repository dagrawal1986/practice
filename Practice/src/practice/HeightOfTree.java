package practice;

public class HeightOfTree {
	
	public void fill(int parent[], int i, int h[]){
		
		if(h[i] != 0)
			return;
		
		if(parent[i] == -1){
			h[i] = 1;
			return;
		}
		
		if(h[parent[i]] == 0)
			fill(parent, parent[i], h);
		
		h[i] = h[parent[i]] + 1;
	}
	
	public int height(int parent[]){
		
		int h[] = new int[parent.length];
		for(int i = 0; i < parent.length; i++)
			h[i] = 0;
		
		for(int i = 0; i < parent.length; i++)
			fill(parent, i, h);
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < parent.length; i++){
			if(h[i] > max)
				max = h[i];
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
		int parent[] = {1, 5, 5, 2, 2, -1, 3};
		HeightOfTree ht = new HeightOfTree();
		System.out.println(ht.height(parent));

	}

}
