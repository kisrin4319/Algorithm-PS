import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width;
        int height;
        int term;
        
        term = (int)Math.sqrt((int)Math.pow((brown+4),2) /4 - 4 * (brown + yellow));
        width = ((brown + 4) / 2 + term) / 2;
        height = ((brown + 4) / 2 - term) / 2;
            
        answer[0] = width;
        answer[1] = height;
        return answer;
    }
}