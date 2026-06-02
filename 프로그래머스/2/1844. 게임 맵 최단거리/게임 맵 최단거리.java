import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
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