class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
         for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }

      
        int result = r;
        while(l <= r){
            int mid = l + (r-l) /2;
            if (canSplit(nums,mid,k)){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid+1;
            }
        }
        return result;
    }
        public boolean canSplit(int[] nums, int largest, int m){
            int subArray = 1;
            int currSum = 0;
            for(int n : nums){
                currSum += n;
                if(currSum > largest){
                    subArray ++;
                    currSum = n;
                }
            }
            return subArray <= m;

        }
    
}