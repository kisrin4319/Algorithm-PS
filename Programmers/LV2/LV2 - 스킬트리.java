import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) 
    {
        
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList(skill_trees));
        
        Iterator<String> it = list.iterator();
        
        while(it.hasNext())
        {
            String str = it.next().replaceAll("[^"+skill+"]","");
            if(skill.indexOf(str)!=0){
                it.remove();
            }
        }
        answer = list.size();
        return answer;
    }
}
