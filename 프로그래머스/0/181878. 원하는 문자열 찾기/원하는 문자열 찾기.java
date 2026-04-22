class Solution {
    public int solution(String myString, String pat) {
        boolean isExist = false;
        int patLength = pat.length();
            
        String upperMyString = myString.toUpperCase();
        String upperPat = pat.toUpperCase();
        
        for (int i = 0; i < myString.length() - patLength + 1; i++) {
            if (upperPat.equals(upperMyString.substring(i, i + patLength))) {
                return 1;
            }
        }
                           
        return 0;
    }
}