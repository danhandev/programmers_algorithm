class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        for (int n = i; n <= j; n++) {
            int current = n;
            while (current >= 1) {
                if (current % 10 == k) {
                    count++;
                }
                current /= 10;
                // System.out.println(n + "반복" + current);
            }
        }
        return count;
    }
}