class Solution {
    public String solution(String n_str) {
        int strStartIndex = -1;
        
        for (int i = 0; i < n_str.length(); i++) {
            if ('0' != n_str.charAt(i)) {
                strStartIndex = i;
                break;
            }
        }
        
        return n_str.substring(strStartIndex);
    }
}