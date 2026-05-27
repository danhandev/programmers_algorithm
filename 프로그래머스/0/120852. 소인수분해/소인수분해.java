import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> insuList = new ArrayList<>();
        int current = n;
        
        for (int i = 2; i <= n; i++) {
            if (!isPrime(i)) {
                continue;
            }
            if (current <= 1) {
                break;
            }
            
            boolean isInsu = false;
            while (current % i == 0) {
                current /= i;
                isInsu = true;
            }
            if (isInsu) {
                insuList.add(i);
            }
        }
        
        int[] insuArray = new int[insuList.size()];
        for (int i = 0; i < insuArray.length; i++) {
            insuArray[i] = insuList.get(i);
        }
        
        return insuArray;
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            
            }
        }
        
        return true;
    }
}