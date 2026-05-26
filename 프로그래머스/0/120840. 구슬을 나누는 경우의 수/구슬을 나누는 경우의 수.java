class Solution {
    public int solution(int balls, int share) {
        int[][] triangle = new int[balls + 1][share + 1];
        
        for (int i = 0; i <= balls; i++) {
            for (int j = 0; j <= Math.min(i, share); j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }
        
        return triangle[balls][share];
    }
}