class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        for(int i = 1; i <= 2*n ; i++){
            sumOdd += i;
            i++;
            sumEven += i;
        }
        int i = sumEven;
        while(i > 1){
            if(sumOdd/i == 0 && sumEven/i == 0){
                return i;
            }
            else{
                i--;
            }
        }
        return n;
    }
}