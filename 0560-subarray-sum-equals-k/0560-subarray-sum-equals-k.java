class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currSum = 0;

        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            currSum += nums[i];

            int diff = currSum - k;

            res += prefixSums.getOrDefault(diff, 0);

            prefixSums.put(currSum,
                    prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
}