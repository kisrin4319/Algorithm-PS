import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        //홀수면 올바른 괄호를 만들 수 없기 때문에
        if(s.length()%2 == 1){
            return answer;
        }
        for(int idx = 0; idx<s.length()-1;idx++){
            answer+=rotate(s,idx);
        }
        return answer;
    }

    public int rotate(String s, int start){

        int len = s.length();
        int loop = len+start;
        char[] c = new char[len];

        int index=0;

        for(int idx = start;idx<loop;idx++)
        {
            int i = idx%len;
            c[index] = s.charAt(i);
            index++;
        }

        return isCorrect(c) ? 1 : 0;
    }

    public boolean isCorrect(char[] c){
        Stack<Character> st = new Stack<>();

        for(int idx = 0; idx<c.length;idx++)
        {
            if(!st.isEmpty())
            {
                char peek = st.peek();

                if( peek == '{' && c[idx] == '}' || peek == '(' && c[idx] == ')' || peek == '[' && c[idx] == ']'){
                    st.pop();
                } else {
                    st.push(c[idx]);
                }
            }
            else{
                st.push(c[idx]);
            }
        }
        return st.isEmpty();
    }
}
