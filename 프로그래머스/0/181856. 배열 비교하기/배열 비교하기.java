class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        // 길이 비교 -> 합 비교
        if (arr1.length != arr2.length) {
            return (arr1.length > arr2.length) ? 1 : -1;
        } else {
            int arr1Sum = 0;
            int arr2Sum = 0;
            
            for (int n1 : arr1) {
                arr1Sum += n1;
            }
            
            for (int n2 : arr2) {
                arr2Sum += n2;
            }
            
            if (arr1Sum == arr2Sum) {
                return 0;
            } else {
                return (arr1Sum > arr2Sum) ? 1 : -1;
            }
        }
    }
}