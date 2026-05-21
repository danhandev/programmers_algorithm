import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] reverseList = new int[num_list.length];
        
        for (int i = 0; i < num_list.length; i++) {
            reverseList[i] = num_list[num_list.length - i - 1];
        }
        return reverseList;
    }
}