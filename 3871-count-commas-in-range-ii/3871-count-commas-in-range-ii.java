class Solution {
    public long countCommas(long n) {
        long ans=0;
        long i=1000;
        long c=1;
        while(i<=n){
            long end=i*1000-1;
            if(end>n){
                end=n;
            }
            ans+=(end-i+1)*c;
            if(i>n/1000){
                break;
            }
            i*=1000;
            c++;
        }

        return ans;
    }
}