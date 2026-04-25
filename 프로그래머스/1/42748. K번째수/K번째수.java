import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for (int[] command : commands) {
            answer[idx++] = findK(array, command);
        }
        
        return answer;
    }
    
    private int findK(int[] array, int[] command) {
        int i = command[0], j = command[1], k = command[2];
        List<Integer> cuttedArray = new ArrayList<>();
        
        for (int idx = i - 1; idx < j; idx++) {
            cuttedArray.add(array[idx]);
        }
        
        Collections.sort(cuttedArray);
        
        return cuttedArray.get(k - 1);
    }
}