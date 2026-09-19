public class Leetcode1401 {

    static class Solution {

        public boolean checkOverlap(
                int radius,
                int xCenter,
                int yCenter,
                int x1,
                int y1,
                int x2,
                int y2) {

            // Find the closest point of the rectangle
            // to the circle's center
            int closestX = Math.max(x1, Math.min(xCenter, x2));
            int closestY = Math.max(y1, Math.min(yCenter, y2));

            int dx = xCenter - closestX;
            int dy = yCenter - closestY;

            // Compare squared distances
            return dx * dx + dy * dy <= radius * radius;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int radius = 1;
        int xCenter = 0;
        int yCenter = 0;

        int x1 = 1;
        int y1 = -1;
        int x2 = 3;
        int y2 = 1;

        boolean result = solution.checkOverlap(
                radius,
                xCenter,
                yCenter,
                x1,
                y1,
                x2,
                y2
        );

        System.out.println("Output: " + result);
    }
}