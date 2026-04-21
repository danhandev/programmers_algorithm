import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int length = 0;
        
        for (int[] size : sizes) {
            int longer = (size[0] > size[1]) ? size[0] : size[1];
            int shorter = (size[0] <= size[1]) ? size[0] : size[1];
            
            if (longer > width) {
                width = longer;
            }
            
            if (shorter > length) {
                length = shorter;
            }
        }
        
        return width * length;
    }
}