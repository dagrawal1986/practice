package practice;

import java.util.HashMap;
import java.util.Map;

//smallest substring in s1 containing all characters in s2
public class Substring {
	
	public void find(String s1, String s2){
		Map<Character, Integer> needtofind = new HashMap<Character, Integer>();
		Map<Character, Integer> foundsofar = new HashMap<Character, Integer>();
		int count = 0, begin = 0, len = Integer.MIN_VALUE;
		for(char c : s2.toCharArray()){
			if(needtofind.containsKey(c))
				needtofind.put(c, needtofind.get(c)+1);
			else
				needtofind.put(c, 1);
		}
		
		for(int i = 0; i < s1.length(); i++){
			char c = s1.charAt(i);
			if(!needtofind.containsKey(c))
				continue;
			if(foundsofar.containsKey(c))
				foundsofar.put(c, foundsofar.get(c)+1);
			else
				foundsofar.put(c, 1);
			
			if(foundsofar.get(c) <= needtofind.get(c))
				count++;
			
			if(count == s2.length()){
				while(true){
					char b = s1.charAt(begin);
					if(!needtofind.containsKey(b))
						begin++;
					else if(foundsofar.containsKey(b) && 
							foundsofar.get(b) > needtofind.get(b)){
						begin++;
						foundsofar.put(b, foundsofar.get(b)-1);
					}
					else
						break;
				}
				
				if(i-begin+1 > len){
					len = i-begin+1;
					System.out.println("i: "+i + " begin: "+begin+ " len: "+len);
				}
			}
		}
		
		System.out.println("len: "+len);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Substring ss = new Substring();
		String s1 = "deepak";
		String s2 = "eke";
		ss.find(s1, s2);
	}

}
