# 문자열

## indexOf() 를 사용한 문제

### 중복 문자열 제거

- 입력 : ksekkset
- 출력 : kset

- String class 의 indexOf()
  - 처음 발견되는 문자열 위치를 반환한다.
  - 중복된 문자열이 존재해도 무조건 처음 발견되는 문자열 위치를 반환한다.
  - `핵심 코드 : str.indexOf(str.charAt(i)) == i`
    - 반복문 i 변수의 값과 i 번째 문자가 발견되는 값이 같으면 StringBuilder 에 추가

```java
// indexOf : 처음 발견되는 문자열 위치를 반환
public String solution2(String str) {
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=0; i<str.length(); i++) {
        if(str.indexOf(str.charAt(i)) == i) {
            stringBuilder.append(str.charAt(i));
        }
    }
    return stringBuilder.toString();
}
```

## replaceAll() 을 사용한 문제 : 정규식 문제

### 숫자만 추출하기

- 입력 : g0en2T0s8eSoft
- 출력 : 208

```java
// Solv1. replaceAll 이용
public int solution(String str) {
    str = str.replaceAll("[^0-9]", "");
    return Integer.parseInt(str);
}

// Solv2. 문자열을 문자로 쪼갠 다음, Character 클래스의 isDigit 이용
public int solution2(String str) {
    String answer = "";
    for(char x : str.toCharArray()) {
        if(Character.isDigit(x)) {
            answer += x;
        }
    }
    return Integer.parseInt(answer);
}
```

### 유효한 팰린드롬

- Point
  - replaceAll() 이용
  - StringBuilder 의 reverse() 

```
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 한다.
문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * 예시 입력 1
 * found7, time: study; Yduts; emit, 7Dnuof
 *
 * 예시 출력 1
 * YES
```

```java
// Tip. 알파벳 이외의 문자들의 무시합니다. -> 특정 문자를 제외한 문자를 무시한다 -> 정규식 replaceAll 이용 가능성이 큼.
// replaceAll 정규식 이용
public String solution(String str) {
    str = str.toUpperCase().replaceAll("[^A-Z]", "");
    String reversedStr = new StringBuilder(str).reverse().toString();
    if(str.equals(reversedStr)) {
        return "YES";
    }
    return "NO";
}
```
