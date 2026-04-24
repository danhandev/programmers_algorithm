import java.util.*;

class Solution {
    public String solution(String myString, String pat) {
        int latestIndex = 0;
        int patLength = pat.length();
        
        for (int i = 0; i <= myString.length() - patLength; i++) {
            if (pat.equals(myString.substring(i, i + patLength))) {
                latestIndex = i + patLength;
            }
        }
        
        return myString.substring(0, latestIndex);
    }
}