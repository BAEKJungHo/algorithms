# Stack

- 한 쪽 끝에서만 자료를 넣고 뺄 수 있는 자료구조
- `public class Stack<E> extends Vector<E>`
- 마지막에 넣은 것이 가장 먼저 나오기 때문에 LIFO(Last In First Out)

## 스택(Stack)의 사용 예제

- 웹 브라우저 방문기록 (뒤로가기)
- 실행취소 (undo)
- 역순 문자열 만들기
- 수식의 괄호 검사 (연산자 우선순위 표현을 위한 괄호 검사)
- 후위표기법 계산

## 스택(Stack) 관련 메서드

* `push(E item)`
  * 해당 item을 Stack의 top에 삽입
  * Vector의 addElement(item)과 동일
* `pop()`
  * Stack의 top에 있는 item을 삭제하고 해당 item을 반환
* `peek()`
  * Stack의 top에 있는 item을 삭제하지않고 해당 item을 반환
* `empty()`
  * Stack이 비어있으면 true를 반환 그렇지않으면 false를 반환 
* `search(Object o)`
  * 해당 Object의 위치를 반환
  * Stack의 top 위치는 1, 해당 Object가 없으면 -1을 반환

## 🔑 기본 문제

### [올바른 괄호 문자열 (VPS, Valid Parenthesis String) 판단하기]()

```java
/* 1. '(' ')'의 개수가 동일, 2. '('의 개수가 더 많으면 안됨 */
int cnt = 0;
for (int i=0; i<string.length(); i++){
    if(string.charAt(i) == '('){
        cnt++;
    } else {
        cnt--;
        if (cnt == -1)
            break;
    }
}
System.out.println(cnt == 0 ? "YES" : "NO");
```
