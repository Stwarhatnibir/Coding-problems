import java.util.*;

public class Leetcode1807 {

    static class Solution {

        public String evaluate(String s, List<List<String>> knowledge) {

            Map<String, String> map = new HashMap<>();

            // Store key -> value
            for (List<String> pair : knowledge) {
                map.put(pair.get(0), pair.get(1));
            }

            StringBuilder result = new StringBuilder();

            int i = 0;

            while (i < s.length()) {

                if (s.charAt(i) == '(') {

                    int j = i + 1;

                    // Find closing ')'
                    while (s.charAt(j) != ')') {
                        j++;
                    }

                    String key = s.substring(i + 1, j);

                    if (map.containsKey(key)) {
                        result.append(map.get(key));
                    } else {
                        result.append('?');
                    }

                    i = j + 1;

                } else {

                    result.append(s.charAt(i));
                    i++;
                }
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "My name is (name) and I am (age).";

        List<List<String>> knowledge = new ArrayList<>();

        knowledge.add(Arrays.asList("name", "bob"));
        knowledge.add(Arrays.asList("age", "20"));

        String result = solution.evaluate(s, knowledge);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}