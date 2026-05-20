class Solution {
    public int dominantIndex(int[] nums) {
        int max = nums[0];
        int maxMax = 0;
        int index = 0;
         for(int i = 1;i<nums.length;i++){
             if(nums[i]>max){
                 maxMax = max;
                 max = nums[i];
                 index = i;
             }
             else if(nums[i] > maxMax){
                 maxMax = nums[i];
             }
             
         }
        if(max >= 2*maxMax){
                 return index;
             }
        
        return -1;
    }
}