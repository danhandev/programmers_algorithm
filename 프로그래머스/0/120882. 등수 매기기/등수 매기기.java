import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[][] indexAndAverage = new int[score.length][3];
        for (int i = 0; i < score.length; i++) {
            indexAndAverage[i] = new int[] {i, score[i][0] + score[i][1], 0};
            // System.out.println(indexAndAverage[i][0] + " " +  indexAndAverage[i][1]);
        }
        
        Arrays.sort(indexAndAverage, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });
        
        int rank = 1;
        int current = 1;
        int currentAverage = indexAndAverage[0][1];
        for (int[] i : indexAndAverage) {
            if (i[1] == currentAverage) {
                i[2] = rank;
            } else {
                rank = current;
                currentAverage = i[1];
                i[2] = current;
            }
            current++;
        }
        
        Arrays.sort(indexAndAverage, (a, b) -> {
            return a[0] - b[0];
        });
        
        int[] result = new int[indexAndAverage.length];
        for (int i = 0; i < indexAndAverage.length; i++) {
            result[i] = indexAndAverage[i][2];
        }
        
        return result;
    }
}