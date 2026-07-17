class Solution {
    public String reverseWords(String s) {
       StringBuilder ans = new StringBuilder();
       int n = s.length();
       int i = 0;
       while(i < n){
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if (i >= n) {
            break;
        }
        int j = i+1;
        while(j < n && s.charAt(j) != ' '){
            j++;
        }
        String w = s.substring(i,j);
        ans.insert(0,w + " ");
        i = j;
        
       }
       return ans.toString().trim();
    }
}