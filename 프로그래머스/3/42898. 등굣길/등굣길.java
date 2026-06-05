class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];

        // 물에 잠긴 지역 표시 (편의상 -1)
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1; // 시작 지점

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) { // 물이 있는 곳은 0으로 처리하고 통과
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위쪽 칸에서 오는 경우
                if (i > 1) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                
                // 왼쪽 칸에서 오는 경우
                if (j > 1) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}