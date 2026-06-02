class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] points = {0, 0};
        
        for (String key : keyinput) {
            switch (key) {
                case "left" -> {
                    if (points[0] - 1 >= - board[0] / 2) {
                        points[0]--;
                    }
                }
                case "right" -> {
                    if (points[0] + 1 <= board[0] / 2) {
                        points[0]++;
                    }
                }
                case "up" -> {
                    if (points[1] + 1 <= board[1] / 2) {
                        points[1]++;
                    }
                }
                case "down" -> {
                    if (points[1] - 1 >= - board[1] / 2) {
                        points[1]--;
                    }
                }
            }
        }
        return points;
    }
}