class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build the complete number
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // Add the number
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }

            // Subtract the number
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }

            // Start a new expression inside parentheses
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }

            // Finish expression inside parentheses
            else if (ch == ')') {
                result += sign * number;
                number = 0;

                int previousSign = stack.pop();
                int previousResult = stack.pop();

                result = previousResult + previousSign * result;
            }
        }

        // Add the last number
        result += sign * number;

        return result;
    }
}