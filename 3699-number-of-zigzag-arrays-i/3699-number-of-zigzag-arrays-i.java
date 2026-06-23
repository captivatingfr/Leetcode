class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - 1 - i;
        }

        for (int len = 3; len <= n; len++) {
            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            long prefix = 0;

            for (int i = 0; i < m; i++) {
                nextUp[i] = prefix;
                prefix = (prefix + down[i]) % MOD;
            }

            long suffix = 0;

            for (int i = m - 1; i >= 0; i--) {
                nextDown[i] = suffix;
                suffix = (suffix + up[i]) % MOD;
            }

            up = nextUp;
            down = nextDown;
        }

        long answer = 0;

        for (int i = 0; i < m; i++) {
            answer = (answer + up[i] + down[i]) % MOD;
        }

        return (int) answer;
    }
}