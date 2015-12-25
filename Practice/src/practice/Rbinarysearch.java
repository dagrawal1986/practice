package practice;

public class Rbinarysearch {
	
	public int search(int arr[], int key, int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(arr[mid] == key)
			return mid;
		if(arr[mid] <= arr[end]){
			if(key >= arr[mid] && key <= arr[end])
				return search(arr, key, mid+1, end);
			return search(arr, key, start, mid-1);
		}
		else{
			if(key >= arr[start] && key <= arr[mid])
				return search(arr, key, start, mid-1);
			return search(arr, key, mid+1, end);
		}
	}
	
	public int findPivot(int arr[], int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(mid > start && arr[mid] < arr[mid-1])
			return mid-1;
		if(mid < end && arr[mid] > arr[mid+1])
			return mid;
		if(arr[mid] >= arr[start])
			return findPivot(arr, mid+1, end);
		return findPivot(arr, start, mid-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{2,3,1};
		Rbinarysearch rbs = new Rbinarysearch();
		int index = rbs.search(arr, 1, 0, arr.length-1);
		System.out.println("found: "+index);
		
		int pivot = rbs.findPivot(arr, 0, arr.length-1);
		System.out.println("pivot: "+pivot);
	}

}
