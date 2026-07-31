class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            char nextch = ' ';
            if (i < s.length() - 1) {
                nextch = s.charAt(i + 1);
            }
            if(ch == 'I'){
                if(nextch == 'V' || nextch == 'X'){
                    sum -= 1;
                }
                else{
                    sum++;
                }
            }
            else if(ch == 'V'){
                sum += 5;
            }
            else if(ch == 'X'){
                if(nextch == 'L' || nextch == 'C'){
                    sum -= 10;
                }
                else{
                    sum += 10;
                }
            }
            else if(ch == 'L'){
                sum += 50;
            }
            else if(ch == 'C'){
                if(nextch == 'D' || nextch == 'M'){
                    sum -= 100;
                }
                else{
                    sum += 100;
                }
            }
            else if(ch == 'D'){
                sum += 500;
            }
            else if(ch == 'M'){
                sum += 1000;
            }
        }
        return sum;
    }
}