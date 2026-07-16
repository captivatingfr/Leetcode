class Solution {
    public long gcdSum(int[] nums) {
        int[] prefi = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            prefi[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefi);
        long sum = 0;
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            sum += gcd(prefi[left], prefi[right]);
            left++;
            right--;
        }
        return sum;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    } 
}  