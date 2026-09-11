class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Check every 3-digit number
        for (int num = 100; num <= 998; num += 2) {

            int ones = num % 10;
            int tens = (num / 10) % 10;
            int hundreds = num / 100;

            // Check if we have enough copies of each digit
            int[] used = new int[10];

            used[ones]++;
            used[tens]++;
            used[hundreds]++;

            boolean possible = true;

            for (int d = 0; d <= 9; d++) {
                if (used[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}