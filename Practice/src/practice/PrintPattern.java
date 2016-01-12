package practice;

public class PrintPattern {
	
	public void print(int n){
		if(n <= 0){
			System.out.println(n);
			return;
		}
		
		System.out.println(n);
		print(n-5);
		System.out.println(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintPattern pp = new PrintPattern();
		pp.print(10);
	}

}
