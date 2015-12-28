package practice;

import java.util.Arrays;

//next integer with same set of digits
public class NextInteger {
	
	public void nextint(String num){
		char numarr[] = num.toCharArray();
		int index = -1;
		for(int i = num.length()-1; i > 0; i--){
			if(numarr[i-1] < numarr[i]){
				index = i-1;
				break;
			}
		}
		if(index == -1){
			System.out.println("Next big integer with same digit not possible");
			return;
		}
		
		int minindex = index+1;
		for(int i = index+2; i < numarr.length; i++){
			if(numarr[i] > numarr[index] && numarr[i] < numarr[minindex]){
				minindex = i;
			}
		}
		
		char tmp = numarr[index];
		numarr[index] = numarr[minindex];
		numarr[minindex] = tmp;
		Arrays.sort(numarr, index+1, numarr.length);
		System.out.println("next int is: "+String.valueOf(numarr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextInteger ni = new NextInteger();
		ni.nextint("1234");
		ni.nextint("896");
		ni.nextint("534976");
		ni.nextint("218765");
		ni.nextint("4321");
	}

}
