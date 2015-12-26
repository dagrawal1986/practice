package practice;

public class CanBeReached {
	
	public int numOfSteps(int src, int steps, int dest){
		if(Math.abs(src) > dest)
			return Integer.MAX_VALUE;
		if(src == dest)
			return steps;
		
		int pos = numOfSteps(src+steps+1, steps+1, dest);
		int neg = numOfSteps(src-steps-1, steps+1, dest);
		
		return Math.min(pos, neg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CanBeReached cbr = new CanBeReached();
		int steps = cbr.numOfSteps(0, 0, 5);
		System.out.println("steps: "+steps);
	}

}
