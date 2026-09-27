import java.util.*;

public class Leetcode1096 {

    static class Solution {

        private String expression;
        private int index;

        public List<String> braceExpansionII(String expression) {

            this.expression = expression;
            this.index = 0;

            Set<String> result = parseExpression();

            return new ArrayList<>(new TreeSet<>(result));
        }

        // expression = term (',' term)*
        private Set<String> parseExpression() {

            Set<String> result = new HashSet<>(parseTerm());

            while (index < expression.length()
                    && expression.charAt(index) == ',') {

                index++;

                result.addAll(parseTerm());
            }

            return result;
        }

        // term = factor factor factor ...
        private Set<String> parseTerm() {

            Set<String> result = new HashSet<>();
            result.add("");

            while (index < expression.length()) {

                char c = expression.charAt(index);

                if (c == '}' || c == ',') {
                    break;
                }

                Set<String> current = parseFactor();

                result = concatenate(result, current);
            }

            return result;
        }

        // factor = letter | '{' expression '}'
        private Set<String> parseFactor() {

            char c = expression.charAt(index);

            if (c == '{') {

                index++;

                Set<String> result = parseExpression();

                index++; // Skip '}'

                return result;
            }

            index++;

            Set<String> result = new HashSet<>();
            result.add(String.valueOf(c));

            return result;
        }

        // Cartesian product of two sets of strings
        private Set<String> concatenate(
                Set<String> first,
                Set<String> second) {

            Set<String> result = new HashSet<>();

            for (String a : first) {
                for (String b : second) {
                    result.add(a + b);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String expression = "{a,b}{c,{d,e}}";

        List<String> result =
                solution.braceExpansionII(expression);

        System.out.println("Input: " + expression);
        System.out.println("Output: " + result);
    }
}