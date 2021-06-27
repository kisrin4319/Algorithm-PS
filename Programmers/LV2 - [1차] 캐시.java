import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> cache = new LinkedList<>();
        
        if(cacheSize == 0){
            answer = cities.length * 5;
        }
        else{
            
            for(int idx = 0; idx< cities.length; idx++)
            {
                String city = cities[idx].toLowerCase();
                if(cache.contains(city))
                {
                    answer++;
                    cache.remove(city);
                    cache.add(city);                    
                }
                else
                {
                    if(cache.size() >= cacheSize){
                        cache.poll();
                    }
                    cache.add(city);
                    answer+=5;
                }
            }
        }        
        return answer;
    }
}