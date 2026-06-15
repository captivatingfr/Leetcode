class Solution {
    public boolean check(int[] nums) {
        int t = 0;
            for(int i = 0; i < nums.length-1 ; i++){
                if(nums[i]> nums[i+1]){
                    t++;
                }
               
            }
             if(nums[nums.length - 1] > nums[0]) {
                    t++;
                }
                
        if(t <= 1){
            return true;
        }

        return false;
    }
}