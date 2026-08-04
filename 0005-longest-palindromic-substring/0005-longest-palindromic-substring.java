class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        int resIdx = 0;
        for(int i = 0; i < s.length(); i++){
            int right = i;
            int left = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                 if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    resIdx = left;
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                 if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    resIdx = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
}