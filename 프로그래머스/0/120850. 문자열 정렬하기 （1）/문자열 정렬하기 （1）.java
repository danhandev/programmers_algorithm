import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> numList = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            char num = my_string.charAt(i);
            
            if (num >= '0' && num <= '9') {
                numList.add(num - '0');
            }
        }
        
        int[] numArray = new int[numList.size()];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = numList.get(i);
        }
        Arrays.sort(numArray);
        
        return numArray;
    }
}