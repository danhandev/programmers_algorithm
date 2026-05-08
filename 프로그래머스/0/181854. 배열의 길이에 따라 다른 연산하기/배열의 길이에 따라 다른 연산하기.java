class Solution {
    public int[] solution(int[] arr, int n) {
        int arrLength = arr.length;
        int[] result = new int[arrLength];
        int aliasIndex = (arrLength % 2 == 0) ? 1 : 0;
        
        for (int i = 0; i < arrLength; i ++) {
            if ((i + aliasIndex) % 2 == 0) {
                result[i] = arr[i] + n;
            } else {
                result[i] = arr[i];
            }
        }
        
        return result;
    }
}