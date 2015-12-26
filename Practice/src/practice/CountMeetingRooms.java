package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meeting{
	int time;
	State state;
}

enum State{
	START,
	END
}

public class CountMeetingRooms {
	
	List<Meeting> meetings;
	public CountMeetingRooms() {
		meetings = new ArrayList<Meeting>();
	}
	
	public void create(){
		int start[] = new int[]{5,0,3,2,6,10};
		int end[] = new int[]{12,25,10,4,15,14};
		
		for(int i = 0; i < start.length; i++){
			Meeting m = new Meeting();
			m.time = start[i];
			m.state = State.START;
			meetings.add(m);
		}
		
		for(int i = 0; i < end.length; i++){
			Meeting m = new Meeting();
			m.time = end[i];
			m.state = State.END;
			meetings.add(m);
		}
	}
	
	public int count(){
		Collections.sort(meetings, new Comparator<Meeting>(){

			public int compare(Meeting o1, Meeting o2) {
				if(o1.time < o2.time)
					return -1;
				else if(o1.time == o2.time){
					if(o1.state == o2.state)
						return 0;
					else if(o1.state == State.START)
						return 1;
					else
						return -1;
				}
				return 1;
			}
		});
		
		int count = 0, maxcount = Integer.MIN_VALUE;
		for(Meeting m : meetings){
			System.out.println("time: "+m.time + " state: "+m.state);
			if(m.state == State.START)
				count++;
			else if(m.state == State.END)
				count--;
			if(count > maxcount)
				maxcount = count;
		}
		return maxcount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountMeetingRooms cmr = new CountMeetingRooms();
		cmr.create();
		int count = cmr.count();
		System.out.println("count: "+count);
	}

}
