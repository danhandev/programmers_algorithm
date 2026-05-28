class Solution {
    public int[] solution(String[] strlist) {
        int[] strLength = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {
            strLength[i] = strlist[i].length();
        }
        return strLength;
    }
}