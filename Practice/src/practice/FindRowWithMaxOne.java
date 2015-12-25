package practice;

public class FindRowWithMaxOne {
	
	private int findcolumn(int row[], int start, int end){
		return 0;
	}
	
	public int find(int matrix[][]){
		int i = findcolumn(matrix[0], 0, matrix[0].length);
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int matrix[][] = new int[][]{
			{0,0,1,1},
			{0,1,0,1},
			{1,0,0,1},
			{0,0,0,0}
		};
		
		FindRowWithMaxOne fr = new FindRowWithMaxOne();
		fr.find(matrix);

	}

}
