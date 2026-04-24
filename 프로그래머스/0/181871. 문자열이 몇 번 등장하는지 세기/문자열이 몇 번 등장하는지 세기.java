class Solution {
    public int solution(String myString, String pat) {
        int count = 0; // pat이 등장하는 횟수
        int patLength = pat.length();
        
        for (int i = 0; i <= myString.length() - patLength; i++) {
            if (pat.equals(myString.substring(i, i + patLength))) {
                count++;
            }
        }
        return count;
    }
}