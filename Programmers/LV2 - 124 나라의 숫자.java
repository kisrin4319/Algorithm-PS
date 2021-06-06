//3개로 규칙이 돌아가겠다고는 예상 했는데 찾지 못하고 다른 분들 소스 참조 해서 해결..
//다들 이런거 어떻게 생각 해내지..
    
import java.util.*;
import java.io.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        
        int[] num = {4,1,2};
        
        StringBuilder sb = new StringBuilder();
        
        while(n>0)
        {
            int remain = n%3;
            n/=3;
            sb.append(num[remain]);
            
            if(remain == 0){
                n--;
            }
        }
        answer = sb.reverse().toString();
        return answer;
    }
}
