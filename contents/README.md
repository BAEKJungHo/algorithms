# 알고리즘과 자료구조

- __알고리즘이란?__
  - 어떤 문제를 풀기 위한 절차/방법
  - 어떤 문제에 대해, 특정한 `입력`을 넣으면 원하는 `출력`을 얻을 수 있도록 만드는 프로그래밍
    - Ex. 현실 세계의 가장 대표적인 알고리즘 - 백종원 레시피
- __자료구조란?__
  - 대량의 데이터를 효율적으로 관리할 수 있는 데이터의 구조를 의미
  - 어떤 데이터 구조를 사용하느냐에 따라, 코드 효율이 달라짐
    - Ex. 현실 세계의 가장 대표적인 자료구조 - 사전
- __자료구조와 알고리즘이 중요한 이유__
  - 어떤 자료구조와 알고리즘을 쓰느냐에 따라, 성능이 천지차!
  - 결국 프로그래밍을 잘 할 수 있는 기술과 역량을 익히고, 검증할 수 있음

## Scanner, Reader, Sort

- [BufferedReader/Scanner, Arrays.sort()/Collections.sort()에 따른 시간복잡도 분석](https://github.com/WeareSoft/algorithm-study/blob/master/contents/180520.md#issue11-bufferedreaderscanner-arrayssortcollectionssort%EC%97%90-%EB%94%B0%EB%A5%B8-%EC%8B%9C%EA%B0%84%EB%B3%B5%EC%9E%A1%EB%8F%84-%EB%B6%84%EC%84%9D)

* BufferedReader / Scanner (100만개 입력 결과)
    * BufferedReader: 0.452(sec)
    * Scanner: 2.441(sec)
    * Scanner가 BufferedReader보다 6배의 시간이 더 걸림
*  Arrays.sort() / Collections.sort() (100만개 정렬 결과)
    * Arrays.sort(): 0.009(sec)
    * Collections.sort(): ArrayList 자료형의 정렬일 때, 0.028(sec)
    * Collections.sort()가 Arrays.sort()보다 3배의 시간이 더 걸림
* 동일 문제에서의 걸린 시간 비교
    1) Scanner, Collections.sort() : 시간 초과
    2) Scanner, Arrays.sort() : 220312 KB / 5068 MS
    3) BufferedReader, Collections.sort() : 564748 KB / 4896 MS
    4) BufferedReader, Arrays.sort() : 478692 KB / 2072 MS

### [Java 언어를 이용하여 정렬할 때 시간초과 문제](https://github.com/WeareSoft/algorithm-study/blob/master/contents/180520.md#issue2-java-%EC%96%B8%EC%96%B4%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-%EC%A0%95%EB%A0%AC%ED%95%A0-%EB%95%8C-%EC%8B%9C%EA%B0%84%EC%B4%88%EA%B3%BC-%EB%AC%B8%EC%A0%9C)

* Scanner 대신에 BufferedReader, BufferedWriter를 사용해야 하는 이유
* Scanner
    * 사용이 간단. 속도가 느림. Buffer 사이즈: 1024 chars
* BufferedReader
    * 사용이 조금 복잡. 속도가 비교적 빠름. Buffer 사이즈: 8192 chars
* 많은 입력이 있다면 성능상 우위에 있는 BufferedReader를 사용한다.
* 기본적으로는 간단한 Scanner를 사용한다. 

## [문자열 분리를 위한 StringTokenizer와 String.spilt의 차이](https://github.com/WeareSoft/algorithm-study/blob/master/contents/180520.md#issue10-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%B6%84%EB%A6%AC%EB%A5%BC-%EC%9C%84%ED%95%9C-stringtokenizer%EC%99%80-stringspilt%EC%9D%98-%EC%B0%A8%EC%9D%B4)

1. StringTokenizer
    * 개념
        * method가 아닌 java.util에 포함되어 있는 자체 class
        * 구분자(delemeter)로 나눈 문자열이 빈 문자열이면 빈 문자열은 포함하지 않고 출력한다.
2. String.split
    * 개념
        * String class의 method로, 추출한 문자를 배열로 저장
        * 구분자(delemeter)로 나눈 문자열이 빈 문자열이면 빈 문자열도 포함해서 출력한다. 
    * 사용법
        *  split의 구분자(delemeter)가 ^, *,| 등의 문자열일 경우 "\\"를 구분자 앞에 추가해주어야 한다.
3. 차이점
    1) 가장 큰 차이점은 구분자 사이에 데이터가 없는 경우, 즉 공백의 데이터가 포함된 경우
        * StringTokenizer: 공백의 문자열을 포함하지 않는다.
        * String.split: 공백의 문자열을 포함한다.
    2) 분해 방법
        * StringTokenizer: 문자열 하나 하나를 분해한다.
        * String.split: 내부적으로 정규 표현식으로 분해한다.
    3) 성능
        * StringTokenizer이 더 좋다.
        * 가급적 대용량 파일이나 데이터를 처리할 때에는 StringTokenizer는 쓰는 것이 더 좋다
        * 하지만 Sun에서는 StringTokenizer는 정규 표현식을 지원하지 않기 때문에 String.split를 권장한다.

### 예제

- __StringTokenizer를 이용한 문자열 분리__

```java
// StringTokenizer를 이용한 문자열 분리
String week = "월 화 수 목 금 토 일";
StringTokenizer st = new StringTokenizer(week, " ");

while( st.hasMoreTokens() ){
    System.out.println(st.nextToken());
}
```

- __String.split를 이용한 문자열 분리__

```java
// String.split를 이용한 문자열 분리
String week = "월 화 수 목 금 토 일";
String[] array = str.split(" ");

for( String word : array ){
    System.out.println(word);
}
```
