class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int r = 0, c = 0; // 시작 인덱스 (0, 0)
        
        // 0:우, 1:하, 2:좌, 3:상 (시계 방향 회전)
        int mode = 0; 
        
        for (int i = 1; i <= n * n; i++) {
            // [지침 1] 검증된 안전한 위치(r, c)에 먼저 숫자를 채웁니다.
            answer[r][c] = i;
            
            // 마지막 숫자를 다 채웠다면 다음 좌표를 계산하지 않고 종료합니다.
            if (i == n * n) break;
            
            // [지침 2] 다음 칸을 미리 예측하고, 벽에 부딪히면 방향을 꺾습니다.
            switch (mode) {
                case 0 -> { // 오른쪽(Right)으로 이동 중
                    // 다음 칸이 벽을 넘어가거나 이미 숫자가 있다면
                    if (c + 1 >= n || answer[r][c + 1] != 0) {
                        mode = 1; // 아래로 방향 전환
                        r++;      // 아래로 한 칸 이동
                    } else {
                        c++;      // 문제없으면 오른쪽으로 이동
                    }
                }
                case 1 -> { // 아래쪽(Down)으로 이동 중
                    if (r + 1 >= n || answer[r + 1][c] != 0) {
                        mode = 2; // 왼쪽으로 방향 전환
                        c--;      // 왼쪽으로 한 칸 이동
                    } else {
                        r++;      // 문제없으면 아래로 이동
                    }
                }
                case 2 -> { // 왼쪽(Left)으로 이동 중
                    if (c - 1 < 0 || answer[r][c - 1] != 0) {
                        mode = 3; // 위쪽으로 방향 전환
                        r--;      // 위로 한 칸 이동
                    } else {
                        c--;      // 문제없으면 왼쪽으로 이동
                    }
                }
                case 3 -> { // 위쪽(Up)으로 이동 중
                    if (r - 1 < 0 || answer[r - 1][c] != 0) {
                        mode = 0; // 다시 오른쪽으로 방향 전환
                        c++;      // 오른쪽으로 한 칸 이동
                    } else {
                        r--;      // 문제없으면 위로 이동
                    }
                }
            }
        }
        
        return answer;
    }
}