import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> hs = new HashMap<String,Integer>();
        
        for(int cursor=0; cursor<clothes.length;cursor++)
        {
        	hs.put(clothes[cursor][1], hs.getOrDefault(clothes[cursor][1], 0)+1);
        }
        
        for(String key : hs.keySet()) {
        	answer*= (hs.get(key) +1); //아무것도 입지 않은 경우를 +1 하여 계산해준다
        }
        answer--; // 조합하여 입은 옷 중에 아무것도 입지 않은 경우를 -1 해줘야 한다
        
        return answer;
    }
}
