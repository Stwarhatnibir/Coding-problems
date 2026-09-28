import java.util.*;

public class Leetcode20 {

    static class Solution {

        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {

                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else {

                    if (stack.isEmpty()) {
                        return false;
                    }

                    char top = stack.pop();

                    if (ch == ')' && top != '(') {
                        return false;
                    }

                    if (ch == ']' && top != '[') {
                        return false;
                    }

                    if (ch == '}' && top != '{') {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "{[]}";

        boolean result = solution.isValid(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}