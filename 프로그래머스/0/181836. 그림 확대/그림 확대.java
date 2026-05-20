import java.util.stream.*;
import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> pictureMultipleK = new ArrayList<>();
        
        for (int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < picture[i].length(); j++) {
                for (int m = 0; m < k; m++) {
                    sb.append(picture[i].charAt(j));
                }
            }
            
            for (int j = 0; j < k; j++) {
                pictureMultipleK.add(sb.toString());
            }
        }
        
        String[] result = new String[pictureMultipleK.size()];
        for (int i = 0; i < pictureMultipleK.size(); i++) {
            result[i] = pictureMultipleK.get(i);
        }
        
        return result;
    }
}