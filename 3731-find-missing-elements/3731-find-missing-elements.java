class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            int num = nums[i - 1] + 1;
            while(num < nums[i]){
                ans.add(num);
                num++;
            }
        }
        return ans;
    }
}