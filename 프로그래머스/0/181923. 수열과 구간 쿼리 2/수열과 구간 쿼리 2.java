import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;

        for (int[] query : queries) {
            int min = Integer.MAX_VALUE;
            
            for (int i = query[0]; i <= query[1]; i++) {
                if (arr[i] > query[2] && arr[i] < min) {
                    min = arr[i];
                }
            }
            
            answer[idx++] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return answer;
    }
}