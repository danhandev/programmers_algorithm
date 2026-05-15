class Solution {
    public String solution(String n_str) {
        // 1. n_str의 길이만큼 순회하며 0이 아닌 문자의 위치를 찾습니다.
        for (int i = 0; i < n_str.length(); i++) {
            // 2. 처음으로 '0'이 아닌 문자가 등장하면
            if (n_str.charAt(i) != '0') {
                // 3. 그 위치(i)부터 끝까지 바로 잘라서 반환합니다.
                // 별도의 변수 저장과 break 없이 바로 return이 가능합니다.
                return n_str.substring(i);
            }
        }
        
        // 제한사항에 의해 도달할 일은 없으나, 컴파일러를 위해 기본 반환값을 둡니다.
        return n_str;
    }
}