import java.util.Arrays;

class Leetcode14 {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] V = { "flower", "flow", "flight" };

        System.out.println(s.longestCommonPrefix(V));
    }
}

class Solution {
    public String longestCommonPrefix(String[] V) {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(V);

        String first = V[0];
        String last = V[V.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }

            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}