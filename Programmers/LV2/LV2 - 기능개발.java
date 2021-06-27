import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
   	int loopcnt = 0;
    	int index = 0;
    	int loop = 0;
    	int totcnt =0;
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	
    	while(true)
    	{
    		
    		if(totcnt== progresses.length) {
    			break;
    		}
    		
    		loop = index;
    		
    		for(int i =loop;i<progresses.length;i++) {
    			progresses[i]+=speeds[i];
    		}
    		    		
    		
    		for(int i=loop;i<progresses.length;i++) {
    			if(progresses[i]>=100) {
    				index++;
    				loopcnt++;
    				totcnt++;
    			}
    			else {
    				break;
    			}
    		}
    		
    		if(loopcnt>0) {
    			arr.add(loopcnt);
    			loopcnt = 0;
    		}
    	}
    	
    	int[] answer = new int[arr.size()];
    	
    	for(int i =0; i<arr.size();i++) {
    		//System.out.println(arr.get(i));
    		answer[i] = arr.get(i);
    	}        
       
        return answer;
    }
}
