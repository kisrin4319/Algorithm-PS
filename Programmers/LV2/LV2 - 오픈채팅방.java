import java.util.*;
class Solution {
    public String[] solution(String[] record) {
     	    HashMap<String,String> hs = new HashMap<String, String>();
	        ArrayList<String> arr = new ArrayList<String>();
	        String[][] str = new String[record.length][3];
	        
	        for(int cursor =0; cursor<record.length;cursor++) {
	        	str[cursor] = record[cursor].split(" ");
	        }
	        
	        for(int s = 0; s<str.length; s++){
	        	if(str[s][0].equals("Enter") || str[s][0].equals("Change")) {
	        		hs.put(str[s][1], str[s][2]);
	        	}
	        }
	        
	        for(int s =0; s<str.length;s++) {
	        	if(str[s][0].equals("Enter")) {
	        		arr.add(hs.get(str[s][1]) +"님이 들어왔습니다." );
	        	}
	        	else if(str[s][0].equals("Leave")) {
	        		arr.add( hs.get(str[s][1]) +"님이 나갔습니다." );
	        	}
	        }
	        String[] answer = new String[arr.size()];
	        
	        for(int s=0; s<arr.size();s++) {
	        	answer[s] = arr.get(s);
	        }
	        return answer;
    }
}
