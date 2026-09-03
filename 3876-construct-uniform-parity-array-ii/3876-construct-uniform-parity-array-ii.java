class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        Arrays.sort(nums1);
        boolean even=true;
        boolean odd=true;
        boolean io=false;
        for(int i=0;i<n;i++){
            int par=Math.abs(nums1[i]%2);
             if(par==1 && !io){
                even=false;
            }
            if(par==0 && !io){
                odd=false;
            }
            if(par==1){
                io=true;
            }
        }
        return even || odd;
    }
}