class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for (String b : babbling) {
            b = b.replace("aya", " ");
            b = b.replace("ye", " ");
            b = b.replace("woo", " ");
            b = b.replace("ma", " ");
            b = b.replace(" ", "");
            if (b.isEmpty()) count++;
            System.out.println(b);
        }
        return count;
    }
}