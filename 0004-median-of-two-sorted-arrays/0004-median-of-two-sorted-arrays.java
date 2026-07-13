class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        for(int i = 0; i < nums1.length; i++){
            ans[i] = nums1[i];
        }
        int j = 0;
        for(int i = nums1.length ; i < ans.length; i++){
            ans[i] = nums2[j];
            j++;
        }
        Arrays.sort(ans);
        int mid = ans.length / 2;
        if(ans.length % 2 == 0){
            return((ans[mid - 1] + ans[mid]) / 2.0 );
        }
        else{
            return ans[mid];
        }
    }
}