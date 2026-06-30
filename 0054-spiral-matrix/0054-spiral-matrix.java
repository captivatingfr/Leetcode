class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        while(left < right && top < bottom){
            //to get every value in the topn row
            for(int i = left; i < right; i++){
                ans.add(matrix[top][i]);
                
            }
            top++;
            //geting every element in the right column
            for(int i = top; i < bottom; i++){
                ans.add(matrix[i][right - 1]);
                
            }
            right--;
            
               
            
            //get every element in bottom row
            if (top < bottom) {
            for(int i = right-1; i > left - 1; i--){
                ans.add(matrix[bottom - 1][i]);
                
            }
            }
            bottom--;
            //for left column
            if (left < right) {
            for(int i = bottom - 1; i > top - 1; i--){
                ans.add(matrix[i][left]);
            }    
            }
            left++;

        }
        return ans;
        
    }
}