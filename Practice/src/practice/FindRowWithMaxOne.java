package practice;

public class FindRowWithMaxOne {
	
	private int findcolumn(int row[], int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		
		if(row[mid] == 1 && (mid == 0 || row[mid-1] == 0))
			return mid;
		else if(row[mid] == 0)
			return findcolumn(row, mid+1, end);
		else
			return findcolumn(row, start, mid-1);
	}
	
	public int find(int matrix[][]){
		int index = findcolumn(matrix[0], 0, matrix[0].length-1);
		if(index == -1)
			index = matrix[0].length-1;
		int max = 0;
		
		for(int i = 1; i < matrix.length; i++){
			if(index == -1)
				break;
			if(matrix[i][index] == 1){
				while(index >= 0 && matrix[i][index] == 1){
					index--;
					max = i;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int matrix[][] = new int[][]{
			{0,0,0,0},
			{1,1,1,1},
			{0,0,0,1},
			{0,0,0,0}
		};
		
		FindRowWithMaxOne fr = new FindRowWithMaxOne();
		int row = fr.find(matrix);
		System.out.println("max row: "+row);

	}

}
