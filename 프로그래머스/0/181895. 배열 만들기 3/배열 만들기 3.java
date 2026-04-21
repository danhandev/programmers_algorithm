import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int a1 = intervals[0][0], b1 = intervals[0][1];
        int a2 = intervals[1][0], b2 = intervals[1][1];
        
        List<Integer> combine_arr = new ArrayList<>();
        
        for (int i = a1; i <= b1; i++) {
            combine_arr.add(arr[i]);
        }
        
        for (int i = a2; i <= b2; i++) {
            combine_arr.add(arr[i]);
        }
        
        return combine_arr.stream().mapToInt(i -> i).toArray();
    }
}