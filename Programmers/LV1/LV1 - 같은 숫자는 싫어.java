import java.util.Stack;

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