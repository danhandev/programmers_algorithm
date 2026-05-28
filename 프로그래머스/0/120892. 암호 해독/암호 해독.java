class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        
        if (cipher.length() < code) {
            return "";
        }
        
        for (int i = code - 1; i < cipher.length(); i += code) {
            sb.append(cipher.charAt(i));
        }
        return sb.toString();
    }
}