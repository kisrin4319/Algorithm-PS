import java.util.*;
class Solution {
    public int[] solution(String s) {        
        List<Integer> list = new LinkedList<Integer>();
        String[] str = s.split("},");
            
        for(int i=0;i<str.length;i++)
        {
            str[i] = str[i].replace("{","").replace("}","");
        }
        
        Arrays.sort(str, new Comparator<String>(){
          @Override
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        });
        
//         for(String ss : str){
//             System.out.println(ss);
//         }
        
         for(int i=0;i<str.length;i++)
         {
             String[] tuple;
             String tmp = str[i];
            
             tuple = tmp.split(",");
            
             for(int j = 0; j<tuple.length;j++)
             {
                 int num = Integer.parseInt(tuple[j]);
                 if(!list.contains(num)){
                     list.add(num);
                 }
             }
         }
        
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size();i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
