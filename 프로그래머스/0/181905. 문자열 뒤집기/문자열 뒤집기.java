class Solution {
    public String solution(String my_string, int s, int e) {
        char[] charArray = my_string.toCharArray();
        
        while ( s < e ) {
            char temp = charArray[s];
            charArray[s++] = charArray[e];
            charArray[e--] = temp;
        }
        return new String(charArray);
    }
}