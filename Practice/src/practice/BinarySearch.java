package practice;

public class BinarySearch {
	
	public int search(int arr[], int key, int start, int end){
		if(start > end)
			return -1;
		else{
			int mid = (start + end)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] > key)
				return search(arr, key, start, mid-1);
			else
				return search(arr, key, mid+1, end);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{0,1,2,3,4,5,6,7,8,9};
		BinarySearch bs = new BinarySearch();
		int index = bs.search(arr, 2, 0, arr.length-1);
		System.out.println("found at: " + index);
	}

}
