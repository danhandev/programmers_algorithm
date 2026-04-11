class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int length = overwrite_string.length();
        
        for (int i = 0; i < my_string.length(); i++) {
            if (i < s) {
                sb.append(my_string.charAt(i));
            } else if (i < s + length) {
                sb.append(overwrite_string.charAt(i - s)); 
            } else {
                sb.append(my_string.charAt(i));
            }
        }
        
        return sb.toString();
    }
}