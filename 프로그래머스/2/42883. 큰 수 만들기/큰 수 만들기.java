class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        int toPick = n - k;          // 최종적으로 뽑을 자리 수
        StringBuilder ans = new StringBuilder(toPick);

        int start = 0;               // 이번 자리의 탐색 시작 인덱스
        for (int i = 0; i < toPick; i++) {
            int end = k + i;         // 이번 자리에서 볼 수 있는 최대 인덱스(포함)
            char maxDigit = '0';
            int maxIdx = start;

            // [start, end] 구간에서 최댓값 선택 (9면 더 볼 필요 없이 중단)
            for (int j = start; j <= end; j++) {
                char c = number.charAt(j);
                if (c > maxDigit) {
                    maxDigit = c;
                    maxIdx = j;
                    if (maxDigit == '9') break;
                }
            }

            ans.append(maxDigit);
            start = maxIdx + 1;      // 다음 탐색은 방금 뽑은 자리 다음부터
        }
        return ans.toString();
    }
}
