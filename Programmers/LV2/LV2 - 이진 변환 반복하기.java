import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zerocnt = 0;
        int cycle = 0;
        StringBuilder sb;
        
        while(!s.equals("1"))
        {
            sb =  new StringBuilder();
            for(int idx = 0; idx<s.length();idx++)
            {
                if(s.charAt(idx) == '1'){
                    sb.append("1");
                }
                else{
                    zerocnt++;
                }
            }
            cycle++;
            
            s = Integer.toBinaryString(sb.length());
            
        }
        answer[0] = cycle;
        answer[1] = zerocnt;
        return answer;
    }
}
