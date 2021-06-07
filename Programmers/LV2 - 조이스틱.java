//다른 분들의 소스 참조해서 해결
// cnt = Math.min(cnt,idx+len-next+Math.min(idx,len-next)); 부분이 핵심이다.
import java.util.*;
class Solution {
    public int solution(String name) {
        
        int answer = 0;        
        char[] ch = name.toCharArray();		
        int len = name.length();
	int cnt = len-1;  //정방향으로 쭉 변경하면서 가는 경우
        
        for(int idx = 0; idx<ch.length;idx++)
        {
            answer+= Math.min((int)(ch[idx]-'A'),(int)('Z'-ch[idx] +1));
            
	    //1. 정방향 , 2. 역방향 , 3. 정방향 후 다시 역방향
            int next = idx+1; // 다음 위치
            while(next<name.length() && name.charAt(next) == 'A'){
                next++;
            }
            cnt = Math.min(cnt,idx+len-next+Math.min(idx,len-next));
        }
        answer+= cnt;       
        
        return answer;
    }
}
