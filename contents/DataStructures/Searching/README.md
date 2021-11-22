# 이분 검색

Point. __이분 검색은 말 그대로 반으로 쪼개서 찾고자 하는 값이 해당되지 않는 범위는 날리고, 다시 쪼개진 반에서 이분 검색을 실시한다. 이분 검색을 실시하기전에 오름차순 정렬이 되어있어야 한다.__

## [이분 검색](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/sorting/binarysearch/Main.java)

```java
/**
 * # 이분 검색(Binary Search)
 *
 * 설명
 * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
 *
 * 입력
 * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
 * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
 *
 * 출력
 * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
 *
 * 예시 입력 1
 * 8 32
 * 23 87 65 12 57 32 99 81
 *
 * 예시 출력 1
 * 3
 */
 ```

```java
// Binary Search
public int solution(int n, int m, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    int lt = 0, rt = n-1;
    while(lt <= rt){
        int mid = (lt + rt) / 2;
        if(arr[mid] == m) {
            answer = mid + 1;
            break;
        }
        if(arr[mid] > m) rt = mid - 1; // 찾고자하는 값이 더 작은 쪽에 있다면 검색범위 큰 쪽을 아예 날린다. = mid - 1;
        else lt = mid + 1; // 찾고자하는 값이 더 큰 쪽에 있다면 검색범위 작은 쪽을 아예 날린다.
    }
    return answer;
}
```

# 결정 알고리즘

## [뮤직비디오(결정알고리즘)](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/searching/musicvideo/Main.java)

```
 * 설명
 * 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
 * DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
 * 순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
 * 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
 * 지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
 * 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
 * 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
```

- 입력
  - 첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
  - 다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
  - 부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.
  - Ex. 1 2 3 4 5 6 7 8 9
- 출력 : 첫 번째 줄 부터 DVD 의 최소 용량 크기를 출력하세요.

결정(Decision) 알고리즘은 `이분 검색(Binary Search)`을 사용하는데, `<-lt---------------rt->` 범위 안에 정답이 있는 경우에 사용한다. 위 문제에서 요구하는 정답은 `DVD 의 최소 용량 크기`이다.

lt 가 1 이고 rt 가 10000 이라고 할 때 이분검색을 하면 중앙은 5000 이 된다. 5000 이라는 값안에 DVD 의 최소 용량 크기가 무조건 포함된다. 물론 5000 은 답에 비해 너무 큰 값이지만 어쨋든 포함이 된다는 것이 중요하다.

위 문제 입력 예시 `1 2 3 4 5 6 7 8 9` 기준으로 lt, rt 값을 정하면 lt 는 9가 되며, rt 는 45가된다.

```java
// 두 말의 최대 거리(dist)를 기준으로 배치할 수 있는 말의 마리 수
public int count(int[] arr, int dist){
    int cnt=1;
    int endPosition=arr[0];
    for(int i=1; i<arr.length; i++){
        if(arr[i]-endPosition>=dist){
            cnt++;
            endPosition=arr[i];
        }
    }
    return cnt; // 배치한 말의 마리 수
}

/**
 * @param n 배열 크기
 * @param c 배치하고싶은 말의 마리 수
 * @param arr 마구간 좌표
 */
public int solution(int n, int c, int[] arr){
    int answer=0;
    Arrays.sort(arr); // 마구간 좌표 오름차순 정렬
    int lt=1;
    int rt=arr[n-1]; // 마지막 인덱스 값
    while(lt<=rt){
        int mid=(lt+rt)/2; // 두 말의 최대 거리
        if(count(arr, mid)>=c){ // 배치한 말의 마리수 >= 배치 하고 싶은 말의 마리 수
            answer=mid;
            lt=mid+1;
        }
        else rt=mid-1;
    }
    return answer;
}
```

## [마구간 정하기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/searching/decisionstable/Main.java)

```java
// 두 말의 최대 거리(dist)를 기준으로 배치할 수 있는 말의 마리 수
public int count(int[] arr, int dist){
    int cnt=1;
    int endPosition=arr[0];
    for(int i=1; i<arr.length; i++){
        if(arr[i]-endPosition>=dist){
            cnt++;
            endPosition=arr[i];
        }
    }
    return cnt; // 배치한 말의 마리 수
}

/**
 * @param n 배열 크기
 * @param c 배치하고싶은 말의 마리 수
 * @param arr 마구간 좌표
 */
public int solution(int n, int c, int[] arr){
    int answer=0;
    Arrays.sort(arr); // 마구간 좌표 오름차순 정렬
    int lt=1;
    int rt=arr[n-1]; // 마지막 인덱스 값
    while(lt<=rt){
        int mid=(lt+rt)/2; // 두 말의 최대 거리
        if(count(arr, mid)>=c){ // 배치한 말의 마리수 >= 배치 하고 싶은 말의 마리 수
            answer=mid;
            lt=mid+1;
        }
        else rt=mid-1;
    }
    return answer;
}
```
