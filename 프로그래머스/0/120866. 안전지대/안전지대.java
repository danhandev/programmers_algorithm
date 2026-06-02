class Solution {
    public int solution(int[][] board) {
        int[][] map = new int[board.length][board.length];
        int safeZoneCount = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    setDangerousZone(map, i, j);
                }
            }
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) safeZoneCount++;
            }
        }
        
        return safeZoneCount;
    }
    
    private void setDangerousZone(int[][] map, int i, int j) {
        int[] dx = {0, 0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {0, 1, 1, 0, -1, -1, -1, 0, 1};
        
        for (int x : dx) {
            if (i + x < 0 || i + x > map.length - 1) continue;
            for (int y : dy) {
                if (j + y < 0 || j + y > map.length - 1) continue;
                map[i + x][j + y] = 1;
            }
        }
    }
}