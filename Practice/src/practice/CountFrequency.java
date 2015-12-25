package practice;

//same as countoccurrence, doing for practice
public class CountFrequency {
	
	private int first(int arr[], int key, int start, int end){
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		if(arr[mid] == key && (mid == 0 || arr[mid-1] != key))
			return mid;
		if(arr[mid] >= key)
			return first(arr, key, start, mid-1);
		return first(arr, key, mid+1, end);
	}
	
	private int last(int arr[], int key, int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(arr[mid] == key && (mid == arr.length-1 || arr[mid+1] != key))
			return mid;
		if(arr[mid] <= key)
			return last(arr, key, mid+1, end);
		return last(arr, key, start, mid-1);
	}
	
	public int count(int arr[], int key, int start, int end){
		if(start > end)
			return 0;
		int f = first(arr, key, start, end);
		if(f == -1)
			return 0;
		int l = last(arr, key, start, end);
		System.out.println("first: "+f+ " last: "+l);
		return l-f+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{2,4,4,4,7,7,7,7,7,9};
		CountFrequency cf = new CountFrequency();
		int c = cf.count(arr, 8, 0, arr.length-1);
		System.out.println("count: "+c);
	}

}
