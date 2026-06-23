class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i = 0;
        int j = 1;

        int[] result = new int[nums.length];
        for(int k = 0; k < nums.length; k++){
            if(nums[k] > 0){
                result[i] = nums[k];
                i +=2;
            }
            else{
                result[j] = nums[k];
                j += 2;
            }
        }
        return result;
    }
}