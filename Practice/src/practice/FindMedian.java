package practice;

public class FindMedian {
	
	private int findmedian(int arr[], int s, int e){
		int l = e-s+1;
		int middle = (s+e)/2;
		if(l % 2 == 1)
			return arr[middle];
		return (arr[middle] + arr[middle+1])/2;
	}
	
	private int _median(int arr1[], int s1, int e1, int arr2[], int s2, int e2){
		System.out.println(s1+ " " + e1 + " " + s2+ " " + e2);
		if(e1 == s1){
			return (arr1[s1]+arr2[s2])/2;
		}
		if(e1-s1 == 1){
			return (Math.max(arr1[s1], arr2[s2]) + Math.min(arr1[e1], arr2[e2]))/2;
		}
		
		int m1 = findmedian(arr1, s1, e1);
		int m2 = findmedian(arr2, s2, e2);
		int middle1 = (s1+e1)/2;
		int middle2 = (s2+e2)/2;
		if(m1 == m2)
			return m1;
		else if(m1 < m2){
			if((e1-s1+1) % 2 == 0)
				return _median(arr1, middle1+1, e1, arr2, s2, middle2);
			else
				return _median(arr1, middle1, e1, arr2, s2, middle2);
		}
		else{
			if((e1-s1+1) % 2 == 0)
				return _median(arr1, s1, middle1, arr2, middle2+1, e2);
			else
				return _median(arr1, s1, middle1, arr2, middle2, e2);
		}
	}
	
	public int median(int arr1[], int arr2[]){
		return _median(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = new int[]{2,5,7};
		int arr2[] = new int[]{1,4,6};
		FindMedian fm = new FindMedian();
		int median = fm.median(arr1, arr2);
		System.out.println("median: "+median);
	}

}
