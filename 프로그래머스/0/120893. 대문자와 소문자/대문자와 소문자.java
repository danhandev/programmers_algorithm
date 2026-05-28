class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c <= 'Z') { // 대문자
                sb.append((char) (c - 'A' + 'a'));
            } else { // 소문자
                sb.append((char) (c + 'A' - 'a'));
            }
        }
        
        return sb.toString();
    }
}