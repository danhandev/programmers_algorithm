// https://school.programmers.co.kr/learn/courses/30/lessons/42584
// 유형에 낚여 priority queue를 사용하려 했으나 

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); // 주식의 인덱스(시간)를 저장할 스택

        for (int t = 0; t < prices.length; t++) {
            // 스택이 비어있지 않고, 현재 가격이 스택 최상단 인덱스의 가격보다 떨어졌을 때
            while (!stack.isEmpty() && prices[stack.peek()] > prices[t]) {
                int index = stack.pop(); // 가격이 떨어진 주식의 인덱스를 꺼냄
                result[index] = t - index; // 가격이 유지된 기간(현재 시간 - 구매 시간) 계산
            }
            stack.push(t); // 현재 시간(인덱스)을 스택에 추가
        }

        // 반복문이 끝난 후에도 스택에 남아있는 인덱스들은 끝까지 가격이 떨어지지 않은 주식들임
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = (prices.length - 1) - index; // 전체 운영 기간의 끝(마지막 인덱스)과의 차이 계산
        }

        return result;
    }
}