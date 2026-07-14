class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int lowDigit = String.valueOf(low).length();
        int highDigit = (int)Math.log10(high) + 1;
        for(int digits = lowDigit; digits <= highDigit; digits++){
            for(int start = 1; start <= 9; start++ ){
                if(start + digits > 10){
                    break;
                }
                int num = start;
                int prev = start;

                for(int i = 0; i < digits - 1; i++ ){
                    num = num*10;
                    prev++;
                    num += prev;
                }
                if(num >= low && num <= high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}