class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int level = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(level > 0)ans.append(ch);
                level++;
            }
            else{
                level --;
                if(level > 0)ans.append(ch);
        }
        }
        return ans.toString();
    }
}