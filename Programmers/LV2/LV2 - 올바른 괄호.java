import java.util.Stack;

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