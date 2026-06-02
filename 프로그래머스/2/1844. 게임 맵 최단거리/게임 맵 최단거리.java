import java.util.*;

class Solution {
    // 상, 하, 좌, 우 방향을 나타내는 배열 (행: r, 열: c 구조로 통일)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            
            if (r == n - 1 && c == m - 1) {
                return maps[r][c];
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (maps[nr][nc] == 1) {
                        maps[nr][nc] = maps[r][c] + 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return -1;
    }
}