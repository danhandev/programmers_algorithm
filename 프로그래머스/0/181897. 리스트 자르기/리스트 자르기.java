import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        int[] slice_list = switch (n) {
            case 1 -> Arrays.copyOfRange(num_list, 0, b + 1);
            case 2 -> Arrays.copyOfRange(num_list, a, num_list.length);
            case 3 -> Arrays.copyOfRange(num_list, a, b + 1);
            case 4 -> {
                List<Integer> list = new ArrayList<>();
                for (int i = a; i <= b; i += c) {
                    list.add(num_list[i]);
                }
                yield list.stream().mapToInt(i -> i).toArray();
            }
            default -> num_list;
        };
        
        return slice_list;
    }
}