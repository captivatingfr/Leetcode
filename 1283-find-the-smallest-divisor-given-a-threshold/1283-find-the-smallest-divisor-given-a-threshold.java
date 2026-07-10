class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;

        for(int num : nums){
            max = Math.max(max, num);
        }
        int low = 1;
        int high = max;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int sum = 0;
            for(int i = 0; i<nums.length; i++){
                sum += (nums[i] + mid - 1) / mid;
            }
            if(sum <= threshold ){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid +1;
            }

        }
        return ans;
    }
}