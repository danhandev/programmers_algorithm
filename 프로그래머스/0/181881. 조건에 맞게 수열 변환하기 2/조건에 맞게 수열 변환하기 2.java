import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int x = 0;
        
        while (true) {
            boolean changed = false; // 이번 턴에 값이 변했는지 체크
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    changed = true; // 값이 변했음을 기록
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                    changed = true; // 값이 변했음을 기록
                }
            }
            
            // 만약 한 번도 값이 변하지 않았다면?
            // arr(x) == arr(x+1) 인 상태이므로 종료!
            if (!changed) {
                return x;
            }
            
            // 값이 변했다면 다음 x로 넘어감
            x++;
        }
    }
}