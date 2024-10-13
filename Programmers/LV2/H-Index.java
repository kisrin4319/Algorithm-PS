import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int cnt = 0;
        int[] h = new int[citations.length];
        
        Arrays.sort(citations);
        
        for(int i=0;i<citations.length;i++){
            h[i] = citations[citations.length-1-i];
        }
        
        for(int i =0; i<h.length;i++){
            if(i>=h[i]){
                answer = i;
                break;
            }
            else{
                answer++;
            }
        }
        return answer;
    }
}
