class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if((long) m*k > n){
            return -1;
        }

        int low = bloomDay[0];
        int high = bloomDay[0];

        for(int day : bloomDay){
            low = Math.min(low,day);
            high = Math.max(high,day);

        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(possible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;

            }
        }
        return ans;
    }
        public boolean possible(int[] arr, int day,int m ,int k){
            int count = 0;
            int noB = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] <= day){
                    count++;
                }
                else{
                    noB += count/k;
                    count = 0;
                }
            }
                noB += count/k;
                return noB >= m;

            
        }
    
}