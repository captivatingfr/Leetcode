class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++){
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                        if(freq[k]==0) continue;
                        
                        maxi = Math.max(maxi, freq[k]);
                        mini = Math.min(mini , freq[k]);
                    }
                    sum += maxi - mini;
            }
        }
        return sum;
    }
}