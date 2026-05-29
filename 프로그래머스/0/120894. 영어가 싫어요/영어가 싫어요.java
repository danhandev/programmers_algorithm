class Solution {
    public long solution(String numbers) {
        StringBuilder sb = new StringBuilder(); // result 담을 sb
        int currentIndex = 0; // numbers 자를 위치
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        String slicedNumber = numbers; // 자르고 남은 numbers 문자열
        
        while (currentIndex < numbers.length() - 1) {
            for (int i = 0; i < 10; i++) {
                if (slicedNumber.indexOf(number[i]) == 0) {
                    currentIndex += number[i].length();
                    slicedNumber = numbers.substring(currentIndex);
                    sb.append(i);
                    // System.out.println(currentIndex + " " + slicedNumber);
                } 
            }
        }
        
        return Long.parseLong(sb.toString());
    }
}