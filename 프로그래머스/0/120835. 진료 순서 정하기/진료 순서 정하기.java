import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        List<int[]> rankList = new ArrayList<>();
        
        for (int i = 0; i < emergency.length; i++) {
            rankList.add(new int[]{emergency[i], i});
        }
        
        rankList.sort((a, b) -> b[0] - a[0]);
        
        int[] result = new int[rankList.size()];
        for (int rank = 1; rank <= rankList.size(); rank++) {
            int originalIndex = rankList.get(rank - 1)[1];
            result[originalIndex] = rank;
        }
        
        return result;
    }
}