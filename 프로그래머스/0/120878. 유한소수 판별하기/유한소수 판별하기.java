class Solution {
    public int solution(int a, int b) {
        int bunmo = b / getGcd(a, b);
        if (bunmo == 1)  return 1;
        System.out.println(getGcd(a,b) + " " + bunmo);
        for (int i = 2; i <= bunmo; i++) {
            if (i % 2 == 0 || i % 5 == 0) continue;
            if (bunmo % i == 0) return 2;
        }
        return 1;
    }
    
    private int getGcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        
        return getGcd(m, n % m);
    }
}