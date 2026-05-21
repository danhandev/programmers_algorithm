class Solution {
    public int solution(int price) {
        int totalPrice = price;
        
        if (price >= 500000) {
            totalPrice = (int) (price * 0.8);
        } else if (price >= 300000) {
            totalPrice = (int) (price * 0.9);
        } else if (price >= 100000) {
            totalPrice = (int) (price * 0.95);
        }
        
        return totalPrice;
    }
}