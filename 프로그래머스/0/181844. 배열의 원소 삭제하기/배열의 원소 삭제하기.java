import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> deleted_arr = new ArrayList<>();
        
        for (int n : arr) {
            boolean exist = false;
            for (int m : delete_list) {
                if (n == m) {
                    exist = true;
                }
            }
            
            if (!exist) {
                deleted_arr.add(n);
            }
        }
        
        // int[] deleted_list = new int[deleted_arr.length];
        // for (int n : deleted_list) {
        //     deleted_list.add(n);
        // }
        
        // return deleted_list;
        return deleted_arr.stream().mapToInt(i -> i).toArray();
    }
}