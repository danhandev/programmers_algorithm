import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        int patLength = pat.length();
        
        for (int i = 0; i < patLength; i++) {
            sb.append((pat.charAt(i) == 'A') ? "B" : "A");
        }
        
        String inversedPat = sb.toString();
        
        for (int i = 0; i <= myString.length() - patLength; i++) {
            if (myString.substring(i, i + patLength).equals(inversedPat)) {
                return 1;
            }
        }
        
        return 0;
    }
}