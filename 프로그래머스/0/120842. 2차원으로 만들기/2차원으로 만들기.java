class Solution {
    public int[][] solution(int[] num_list, int n) {
        int num_list_row = (num_list.length + n - 1) / n;
        int[][] answer = new int[num_list_row][n];
        int num = 0;
        
        for (int i = 0; i < num_list_row; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[num++];
            }
        }
        return answer;
    }
}