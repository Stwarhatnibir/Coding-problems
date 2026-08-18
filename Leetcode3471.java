class Leetcode3471 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = { 3, 1, 4, 1, 5 };
        int k = 2;

        System.out.println(s.largestInteger(A, k));
    }
}

class Solution {
    public int largestInteger(int[] A, int k) {
        int[] f = new int[51];

        for (int x : A)
            f[x]++;

        int res = -1, n = A.length;

        for (int i = 0; i < n; i++)
            if (k == n || (f[A[i]] == 1 && (k == 1 || i == 0 || i == n - 1)))
                res = Math.max(res, A[i]);

        return res;
    }
}