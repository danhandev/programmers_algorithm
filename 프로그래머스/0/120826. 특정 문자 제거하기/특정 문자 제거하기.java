class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        
        int letterIndex = my_string.indexOf(letter);
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if (c != letter.charAt(0)) {
                sb.append(c);
            }
        }
            
        return sb.toString();
    }
}