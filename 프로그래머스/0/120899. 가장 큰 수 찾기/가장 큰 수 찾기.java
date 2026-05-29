class Solution {
    public int[] solution(int[] array) {
        
        int maxNum = array[0];
        int index = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (maxNum < array[i]) {
                maxNum = array[i];
                index = i;
            }
        }
        return new int[] {maxNum, index};
    }
}