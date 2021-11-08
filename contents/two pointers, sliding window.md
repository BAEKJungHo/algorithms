# Two Pointers

- 정의
  - Two Pointers 는 1차원 배열에서 두 개의 포인터를 조작하여 원하는 결과를 얻는 알고리즘을 의미한다.
  - 정렬된 배열에서 쌍을 검색하는 데 일반적으로 사용되는 정말 쉽고 효과적인 기술이다.
- 시간 복잡도
  - O(n)

## Sample

```java
// Java Program Illustrating Naive Approach to
// Find if There is a Pair in A[0..N-1] with Given Sum
// Using Two-pointers Technique
 
// Importing all utility classes
import java.io.*;
 
// Main class
class GFG
{
     // Two pointer technique based solution to find
    // if there is a pair in A[0..N-1] with a given sum.
    public static int isPairSum(int A[], int N, int X)
    {
        // represents first pointer
        int i = 0;
 
        // represents second pointer
        int j = N - 1;
 
        while (i < j) {
 
            // If we find a pair
            if (A[i] + A[j] == X)
                return 1;
 
            // If sum of elements at current
            // pointers is less, we move towards
            // higher values by doing i++
            else if (A[i] + A[j] < X)
                i++;
 
            // If sum of elements at current
            // pointers is more, we move towards
            // lower values by doing j--
            else
                j--;
        }
        return 0;
    }
   
    // Driver code
    public static void main(String[] args)
    {
        // array declaration
        int arr[] = { 3, 5, 9, 2, 8, 10, 11 };
         
        // value to search
        int val = 17;
       
        // size of the array
        int arrSize = arr.length;
       
        // Function call
        System.out.println(isPairSum(arr, arrSize, val));
    }
}
```

# Sliding Window

- 정의
  - 마치 창문을 한 쪽으로 밀면서 문제를 푸는 것과 모양이 유사해서 붙여진 이름이다.
  - 투 포인터처럼 구간을 훑으면서 지나간다는 공통점이 있으나, 슬라이딩 윈도우는 어느 순간에도 그 구간의 넓이가 동일하다는 차이점이 있다.
