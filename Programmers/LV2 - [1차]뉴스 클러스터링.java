import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        double multi  = 65536;
        
        HashMap<String,Integer> ha = new HashMap<>();
        HashMap<String,Integer> hb = new HashMap<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        ha = MakeElments(str1);
        hb = MakeElments(str2);
        
        double inter = 0;
        double union = 0;
        
        //교집합 구하기
        for(String key : ha.keySet())
        {                        
            if(hb.containsKey(key)){
                inter+= Math.min(ha.get(key),hb.get(key));
            }
        }
        
        // 합집합 계산 : A집합의 갯수 + B집합의 갯수 - 교집합의 갯수
        union+= UnionCnt(ha) + UnionCnt(hb) - inter;
        
        // 합집합이 0이하 이면 1로 계산 처리 나누기 오류 때문에
        if(union <= 0){
            answer = (int)multi;
        }
        else
        {
            double jacquard = inter/union * multi;
            answer = (int)jacquard;            
        }        
        return answer;
    }
    
    public HashMap<String,Integer> MakeElments(String str)
    {
        HashMap<String,Integer> hs  = new HashMap<>();
        for(int idx = 0; idx<str.length()-1;idx++)
        {
            char cur = str.charAt(idx);
            char next = str.charAt(idx+1);
            if('A' <= cur && cur <='Z' && 'A'<= next && next <='Z'){
                String s = Character.toString(cur)+Character.toString(next);                
                hs.put(s,hs.getOrDefault(s,0)+1);
            }
        }
        return hs;
    }
    public int UnionCnt(HashMap<String,Integer> hs)
    {
        int cnt = 0;
        for(String key : hs.keySet())
        {
            cnt+= hs.get(key);
        }
        return cnt;
    }
}