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

> 괄호와 관련된 문제가 나오면 대부분 스택(Stack) 문제일 가능성이 높다.

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

### [올바른 괄호 문자열 (VPS, Valid Parenthesis String) 판단하기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/stack/vps/Main.java)

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

```java
public String solution2(String str) {
    String answer="YES";
    Stack<Character> stack=new Stack<>();
    for(char x : str.toCharArray()){
        if(x=='(') stack.push(x); // 여는 괄호를 만나면 stack 에 push
        else{
            if(stack.isEmpty()) return "NO";
            stack.pop(); // 닫는 괄호를 만나면 stack 에 pop
        }
    }
    if(!stack.isEmpty()) return "NO";
    return answer;
}
```

### [괄호 문자 제거](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/stack/removeparenthesis/Main.java)

```java
private static final char OPEN = '(';
private static final char CLOSE = ')';

// 문자들을 넣고 닫는 괄호를 만나면, 여는 괄호까지만 제거
public String solution(String s) {
    String answer="";
    Stack<Character> stack=new Stack<>();
    for(char x : s.toCharArray()){
        if(x == CLOSE){
            while(stack.pop() != OPEN); // 핵심 point
        }
        else stack.push(x);
    }
    for(int i=0; i<stack.size(); i++) answer+=stack.get(i);
    return answer;
}
```

### [카카오 크레인 뽑기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/stack/kakaocrain/Main.java)

```java
public int solution(int[][] board, int[] moves){
    int answer=0;
    Stack<Integer> stack = new Stack<>();
    for(int pos : moves){
        for(int i=0; i<board.length; i++){
            if(board[i][pos-1]!=0){
                int tmp=board[i][pos-1];
                board[i][pos-1]=0;
                if(!stack.isEmpty() && tmp==stack.peek()){
                    answer+=2;
                    stack.pop();
                }
                else stack.push(tmp);
                break;
            }
        }
    }
    return answer;
}
```

### [후위식 연산(postfix)](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/stack/postfix/Main.java)

- Point
  - 피연산자를 만나면 스택에 넣는다.
  - 연산자를 만나면 연산식을 만들기 위해 스택에서 피연산자 두 개를 꺼내어 계산 후 그 결과를 스택에 넣는다.

```java
private static final String PLUS = "+";
private static final String MINUS = "-";
private static final String DIVIDE = "/";
private static final String MULTIPLY = "*";

// 1. 피연산자(숫자)를 만나면 STACK 에 PUSH
// 2. 연산자를 만나면 STACK 에서 POP (연산식이 될 때 까지)
        // 연산식은 피연산자가 2개 필요
// 3. 연산 결과를 다시 STACK 에 PUSH
public int solution(String postfix) {
    Stack<Integer> stack = new Stack<>();
    for(String x : postfix.split("")) {
        if(PLUS.equals(x)) {
            stack.push(stack.pop() + stack.pop());
        } else if(MINUS.equals(x)) {
            int first = stack.pop();
            int second = stack.pop();
            stack.push(second - first);
        } else if(DIVIDE.equals(x)) {
            int first = stack.pop();
            int second = stack.pop();
            stack.push(second / first);
        } else if(MULTIPLY.equals(x)) {
            stack.push(stack.pop() * stack.pop());
        } else {
            stack.push(Integer.parseInt(x));
        }
    }
    return stack.pop();
}
```

### [쇠막대기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/stack/ironstick/Main.java)

```java
// 여는 괄호를 만나면 스택에 넣는다.
// 닫는 괄호를 만나면 레이저의 여는 괄호 하나를 POP 한다.
    // 그리고 바로 앞 인덱스를 확인해서 여는 괄호이면 '레이저' 이다.
    // 만약 바로 앞 인덱스가 닫는 괄호이면 막대기의 끝을 의미한다.
        // 막대기의 끝 한 조각을 더한다.
public int solution(String str){
    int cnt = 0;
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<str.length(); i++){
        if(str.charAt(i)=='(') stack.push('(');
        else {
            stack.pop();
            if(str.charAt(i-1)=='(') cnt+=stack.size(); // 레이저 인 경우, stack.size() 는 레이저로 잘린 조각을 의미한다.
            else cnt++;
        }
    }
    return cnt;
}
```
