import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] mockArr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution.solution(mockArr)));
    }
}

class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        for(Integer i : arr) {
            if (st.isEmpty() || !st.peek().equals(i)) {
                st.add(i);
            }
        }
        int[] answer = new int[st.size()];

        int index = st.size() - 1;
        while (!st.isEmpty()) {
            answer[index--] = st.pop();
        }
        return answer;
    }
}