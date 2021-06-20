import java.util.*;
class Solution {
    
    static HashMap<String,Integer> hm = new HashMap<String,Integer>();
    static int[] menulen;
    public String[] solution(String[] orders, int[] course) {
        
        
        StringBuilder sb = new StringBuilder();
        
        ArrayList<String> list = new ArrayList<String>();
        menulen = new int[11];
        
        for(int idx = 0; idx<orders.length;idx++)
        {
            String order = ConvertString(orders[idx]);
            for(int idx2 = 0; idx2< course.length;idx2++)
            {
                int cr = course[idx2];
                MenuAll(order,cr,sb,0);                
            }
        }
           
        for(String key : hm.keySet())
        {
            int keylen = key.length();
            if(menulen[keylen] == hm.get(key) && hm.get(key) >=2)
            {
                    list.add(key);
            }
        }        
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        
        
        for(int sz = 0; sz<list.size();sz++){
            answer[sz] = list.get(sz);
        }
        
        return answer;
    }
    
    public void MenuAll(String order,int course,StringBuilder sb,int idx)
    {
        int len = sb.length();
        if(course == len){            
            String key = sb.toString();
            hm.put(key,hm.getOrDefault(key,0)+1);
            menulen[len] = Math.max(menulen[len],hm.get(key));
            return;
        }
        
        for(int i = idx;i<order.length();i++)
        {
            sb.append(order.charAt(i));
            MenuAll(order,course,sb,i+1);
            sb.setLength(sb.length() - 1);
        }
    }
        
    public String ConvertString(String str)
    {
       StringBuilder sb2 = new StringBuilder();
       PriorityQueue<Character> pq = new PriorityQueue<Character>();
        
        for(int idx = 0; idx<str.length();idx++)
        {
            pq.add(str.charAt(idx));
        }
        
        while(!pq.isEmpty()){
            sb2.append(pq.poll());
        }
        
        return sb2.toString();
        
    }
}