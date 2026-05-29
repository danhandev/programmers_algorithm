import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        System.out.println(commands.length);
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] sliceArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            
            Arrays.sort(sliceArray);
            
            result[i] = sliceArray[command[2] - 1];
        }
        
        return result;
        
    }
}