import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String mockString = "(())()";
        System.out.println(solution.solution(mockString));
    }
}

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            boolean empty = stack.isEmpty();
            if (empty) {
                stack.push(aChar);
            } else {
                if (aChar == '(') {
                    stack.push(aChar);
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}