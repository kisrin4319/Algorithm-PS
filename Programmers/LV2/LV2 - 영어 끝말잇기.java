import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> hs = new HashSet<>();
        
        int loop = words.length;
        
        int member = 1;
        int cycle  = 1;
        
        String prevKey = "";
        String key = "";
        
        boolean init = true;
        
        for(int idx = 0; idx<loop;idx++)
        {
            key = words[idx];
            
            if(idx>0)
            {
                prevKey = words[idx-1];
                
                char pk = prevKey.charAt(prevKey.length()-1); // 이전 단어 끝자리
                char k  = key.charAt(0);                      // 현재 단어 앞자리
                
                // 다를 경우 잘못 말한거니 탈락
                if(pk!=k)
                {
                    init = false;
                    break;
                }
            }
            // 이전에 말한 단어면 탈락
            if(hs.contains(key)){
                init = false;
                break;
            }
            else{
                hs.add(key);
            }
            
            member = member == n ? 1 : member+1;
            cycle++;
        }
        
        //탈락자가 발생하지 않으면
        if(init){
            answer[0] = 0;
            answer[1] = 0;
        }
        //탈락자 발생인 경우
        else{
            answer[0] = member;
            answer[1] = cycle % n == 0 ? cycle/n : cycle/n+1;
        }
        return answer;
    }
}