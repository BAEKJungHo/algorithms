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
