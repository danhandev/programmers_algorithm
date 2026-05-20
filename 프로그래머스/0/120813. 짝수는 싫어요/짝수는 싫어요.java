class Solution {
    public int[] solution(int n) {
        int[] oddArray = new int[(n + 1)/ 2];
        int oddNum = 1;
        
        for (int i = 0; i < (n + 1)/ 2; i++) {
            oddArray[i] = oddNum;
            oddNum += 2;
        }
        return oddArray;
    }
}