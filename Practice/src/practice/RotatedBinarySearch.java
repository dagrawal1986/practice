package practice;

public class RotatedBinarySearch {
	
	private int binarysearch(int arr[], int key, int start, int end){
		if(start > end)
			return -1;
		else{
			int mid = (start + end)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] > key)
				return binarysearch(arr, key, start, mid-1);
			else
				return binarysearch(arr, key, mid+1, end);
		}
	}
	
	public int search(int arr[], int key, int start, int end){
		if(start > end)
			return -1;
		else{
			int mid = (start + end)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] <= arr[end]){
				if(arr[mid] <= key && key <= arr[end])
					return search(arr, key, mid+1, end);
				else 
					return search(arr, key, start, mid-1);		
			}
			else{
				if(arr[mid] >= key && key >= arr[start])
					return search(arr, key, start, mid-1);
				else
					return search(arr, key, mid+1, end);
			}
		}
	}
	
	public int findPivot(int arr[], int start, int end){
		if(start > end)
			return -1;
		
		//if(start == end)
		//	return start;
		
		int mid = (start + end)/2;
		if(mid < end && arr[mid] > arr[mid+1])
			return mid;
		if(mid > start && arr[mid] < arr[mid-1])
			return mid-1;
		if(arr[mid] < arr[end])
			return findPivot(arr, start, mid-1);
		return findPivot(arr, mid+1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = new int[]{7,8,9,0,1,2,3,4,5,6};
		//int arr[] = new int[]{1,2,3,4,5,6,7};
		int arr[] = new int[]{2,2,2,3,2};
		RotatedBinarySearch rbs = new RotatedBinarySearch();
		int index = rbs.search(arr, 7, 0, arr.length-1);
		int pivot = rbs.findPivot(arr, 0, arr.length-1);
		System.out.println("fount at : "+index);
		System.out.println("pivot: "+pivot);
	}

}
