class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int myStringLength = my_string.length();
        
        for (int i = 0; i < myStringLength; i++) {
            sb.append(my_string.charAt(myStringLength - i - 1));
        }
        
        return sb.toString();
    }
}