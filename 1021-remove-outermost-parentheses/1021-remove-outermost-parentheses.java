class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count++;

                // Don't add the outermost '('
                if (count > 1) {
                    result.append('(');
                }

            } else {
                count--;

                // Don't add the outermost ')'
                if (count > 0) {
                    result.append(')');
                }
            }
        }

        return result.toString();
    }
}