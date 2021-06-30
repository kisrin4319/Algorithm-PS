import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        
        if(s.length()%2 == 1){
            return 0;
        }
        
        for(int idx = 0;idx<s.length();idx++)
        {
            char c = s.charAt(idx);
            
            if(!st.isEmpty())
            {
                char top = st.peek();
                if(c == top){
                    st.pop();
                }
                else {
                    st.push(c);
                }
            }
            else{
                st.push(c);
            }
        }
        
        return st.isEmpty() ? 1 : 0;
        
    }
}