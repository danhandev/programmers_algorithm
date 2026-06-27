class Solution {
    public int solution(int num) {
        int count = 0;
        long numL = num;
        if (numL == 1) return 0;
        
        while (numL != 1) {
            if (count >= 500) return -1;
            
            if (numL % 2 == 0) {
                numL /= 2;
            } else {
                numL = numL * 3 + 1;
            }
            
            count++;
            System.out.println(count + " " + numL);
        }
        
        return count;
    }
}