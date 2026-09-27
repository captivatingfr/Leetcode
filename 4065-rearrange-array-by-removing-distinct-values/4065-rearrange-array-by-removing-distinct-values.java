class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int[] ans =  new int[nums.length];
        int digit = 0;
        while(digit < nums.length){
            for(int num = 1; num <=100;num++){
                if (freq[num] > 0){
                    ans[digit++] = num;
                    freq[num]--;
                }
            }
        }
        return ans;
    }
}