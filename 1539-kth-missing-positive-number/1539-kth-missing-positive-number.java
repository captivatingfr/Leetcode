class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] ans = new int[k];
        int j = 0;
        int count = 0;
        for(int i = 1; ;i++){
            if(j < arr.length && arr[j] == i ){
                j++;
            }
            else{
                count++;
                if(count == k){
                    return i;
                }
            }
        }

    }
}