import java.util.*;
class Solution {
    public int solution(String name) {
        
        int answer = 0;        
        char[] ch = name.toCharArray();		
        int len = name.length();
		int cnt = len-1;
        
        for(int idx = 0; idx<ch.length;idx++)
        {
            answer+= Math.min((int)(ch[idx]-'A'),(int)('Z'-ch[idx] +1));
            
            int next = idx+1;
            while(next<name.length() && name.charAt(next) == 'A'){
                next++;
            }
            cnt = Math.min(cnt,idx+len-next+Math.min(idx,len-next));
        }
        answer+= cnt;       
        
        return answer;
    }
}