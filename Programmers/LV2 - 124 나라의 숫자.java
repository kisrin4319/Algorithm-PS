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