class Solution {
    public int solution(int n) {
        int x = 0; // 3x 마을의 숫자
        
        // 10진법 숫자를 1부터 n까지 차례대로 매칭시킵니다.
        for (int ten = 1; ten <= n; ten++) {
            x++; // 일단 3x 마을 숫자를 1 올립니다.
            
            // 💡 핵심: 3의 배수이거나 '3'을 포함하고 있다면, 조건이 충족될 때까지 무한 'or' 검사로 건너뜁니다!
            while (x % 3 == 0 || String.valueOf(x).contains("3")) {
                x++;
            }
        }
        
        return x;
    }
}