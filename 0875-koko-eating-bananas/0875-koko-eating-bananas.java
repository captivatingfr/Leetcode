class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long time = 0;
            for (int pile : piles) {
                time += (pile + mid - 1) / mid;
            }
            if (time <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}