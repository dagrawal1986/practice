package practice;

public class CountOccurrence {
	
	private int firstOccurrence(int arr[], int key, int start, int end){
		
		if(start > end)
			return -1;
		if(start == end){
			if(arr[start] == key)
				return start;
			return -1;
		}
		int mid = (start + end)/2;
		if(arr[mid] == key && (mid == 0 || arr[mid-1] != key))
			return mid;
		if(arr[mid] >= key)
			return firstOccurrence(arr, key, start, mid-1);
		return firstOccurrence(arr, key, mid+1, end);
	}
	
	private int lastOccurrence(int arr[], int key, int start, int end){
		if(start > end)
			return -1;
		if(start == end){
			if(arr[start] == key)
				return start;
			return -1;
		}
		int mid = (start + end)/2;
		if(arr[mid] == key && (mid == arr.length-1 || arr[mid+1] != key))
			return mid;
		if(arr[mid] <= key)
			return lastOccurrence(arr, key, mid+1, end);
		return lastOccurrence(arr, key, start, mid-1);
	}
	
	public int count(int arr[], int key, int start, int end){
		
		int first = firstOccurrence(arr, key, start, end);
		int last = lastOccurrence(arr, key, start, end);
		//System.out.println("fist: "+first+ " last: "+last);
		if(first == -1 || last == -1)
			return -1;
		return last-first+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{1,2,2,2,3,3,4,4,4,4,4,4,4,4,5};
		CountOccurrence co = new CountOccurrence();
		int c = co.count(arr, 2, 0, arr.length-1);
		System.out.println("count: " + c);
	}

}
