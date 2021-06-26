import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> st = new Stack<>();
        
        int loop = number.length()-k;
        
        for(int idx = 0; idx<number.length();idx++)
        {
			char c = number.charAt(idx);
			
			while(!st.isEmpty() && st.peek() < c && k-- > 0){
				st.pop();
			}
			st.push(c);
        }		
        
		for(int idx = 0; idx<loop; idx++){
		sb.append(st.get(idx));
		}
		answer = sb.toString();
		
        return answer;
    }
}