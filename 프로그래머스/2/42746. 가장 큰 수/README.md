# 학습 내용 정리
### PriorityQueue(우선순위 큐) 사용 시점
- 가장 큰/작은 값을 반복해서 꺼내야 할 때 <- 내부적으로 Heap(힙) 구조 사용 → 삽입/삭제 O(log n)
- 실시간 데이터 처리 / 스트림 입력
- 딱 한 번 정렬할 때는 Array.sort()가 빠름 -> 이 문제에선 Array.sort()가 더 적합
```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 핵심: 두 수 a, b의 순서는 (b+a) ? (a+b) 로 결정
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 모든 값이 0이면 "0"
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
```
### 정렬 기준 커스터마이징 Comparator
- Comparator를 익명 클래스 대신 람다식으로 간결하게 작성 가능
- Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
### int → String 변환: String.valueOf()
- String s = String.valueOf(num);
### 예외 케이스 정의 : 모든 입력이 0일 경우 처리
- if (arr[0].equals("0")) return "0";
- [0, 0, 0] → 정렬 후 "000" 이 됨 -> 실제 의미는 "0"이므로 한 번만 출력하도록 예외 처리해야 함.
### 문자열 합칠 때 StringBuilder 사용
- String은 불변(immutable) 객체 → + 연산마다 새로운 문자열 생성 → O(n²) 성능 저하
- StringBuilder는 내부 버퍼에 append 하므로 효율적 (O(n))
- StringBuilder → String 변환: toString()

# [level 2] 가장 큰 수 - 42746 


[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42746) 

### 성능 요약

메모리: 151 MB, 시간: 269.18 ms

### 구분

코딩테스트 연습 > 정렬

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 10월 21일 12:45:03

### 문제 설명

<p>0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.</p>

<p>예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.</p>

<p>0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한 사항</h5>

<ul>
<li>numbers의 길이는 1 이상 100,000 이하입니다.</li>
<li>numbers의 원소는 0 이상 1,000 이하입니다.</li>
<li>정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>numbers</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>[6, 10, 2]</td>
<td>"6210"</td>
</tr>
<tr>
<td>[3, 30, 34, 5, 9]</td>
<td>"9534330"</td>
</tr>
</tbody>
      </table>
<hr>

<p>※ 공지 - 2021년 10월 20일 테스트케이스가 추가되었습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
