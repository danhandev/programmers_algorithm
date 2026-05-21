import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int maxLength = arr[0].length;
        
        for (int[] a : arr) {
            if (a.length > maxLength) {
                maxLength = a.length;
            }
        }
        
        if (arr.length > maxLength) {
            maxLength = arr.length;
        }
        
        int[][] copyArray = new int[maxLength][maxLength];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                copyArray[i][j] = arr[i][j];
            }
           
        }
        
        return copyArray;
    }
}