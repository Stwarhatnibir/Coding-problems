import java.util.HashMap;
import java.util.Map;

class Leetcode1386 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int n = 3;

        int[][] reservedSeats = {
            {1, 2},
            {1, 3},
            {1, 8},
            {2, 6}
        };

        int result = s.maxNumberOfFamilies(n, reservedSeats);

        System.out.println("Maximum families = " + result);
    }
}


class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store reserved seats
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {

                int mask = map.getOrDefault(row, 0);

                mask = mask | (1 << col);

                map.put(row, mask);
            }
        }

        // Seats 2,3,4,5
        int left =
                (1 << 2) |
                (1 << 3) |
                (1 << 4) |
                (1 << 5);

        // Seats 6,7,8,9
        int right =
                (1 << 6) |
                (1 << 7) |
                (1 << 8) |
                (1 << 9);

        // Seats 4,5,6,7
        int middle =
                (1 << 4) |
                (1 << 5) |
                (1 << 6) |
                (1 << 7);


        // Rows without any reservations
        int answer = (n - map.size()) * 2;


        // Process rows containing reservations
        for (int mask : map.values()) {

            boolean canLeft = (mask & left) == 0;

            boolean canRight = (mask & right) == 0;

            boolean canMiddle = (mask & middle) == 0;


            if (canLeft && canRight) {

                answer += 2;

            } else if (canLeft || canRight || canMiddle) {

                answer += 1;
            }
        }

        return answer;
    }
}