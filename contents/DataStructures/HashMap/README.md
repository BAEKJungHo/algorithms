# [HashMap](https://github.com/TheAlgorithms/Java/tree/master/DataStructures/HashMap)

- Entry<K,V>의 배열로 저장되며, 배열의 index는 내부 해쉬 함수를 통해 계산된다.
- value 는 중복이 가능하지만, key 는 중복이 불가능 하다.
- 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 변경된다.
- 내부 hash값에 따라서 키순서가 정해지므로 특정 규칙없이 출력된다.
  - __만약, 순서대로 저장하고 싶으면 LinkedHashMap 을 사용해야 한다.__
- HashMap 은 `해싱(Hashing)` 을 사용하여 검색하기 때문에 대용량 데이터 관리에 좋은 성능을 보여준다.
- key와 value에 null값을 허용한다.
- 비동기 처리
- 시간복잡도: O(1)

## hashing

- `key` 를 고정된 길이의 `hash` 로 변경해주는 역할을 한다. 이 과정을 `hashing` 이라고 한다.
-  서로 다른 key 가 같은 hash 값을 갖게 되는 경우 이를 `해시 충돌` 이라고 한다. 해시 충돌 발생 확률이 적을 수록 좋다.
- Java HashMap에서 사용하는 방식은 `Separate Chaining` 이다.

## Java8 의 Separate Chaining

Separate Chaining 은 JDK 내부에서도 사용하고 있는 충돌 처리 방식인데, `Linked List 와 Tree(Red-Black Tree)` 를 이용하는 방식이다.
두 개를 사용하는 기준은 data 가 6개 이하이면 linked list 를 사용하고 8개 이상이면 tree 를 사용한다.

> 7개가 아닌 이유는 만약 7개일 때, 데이터를 삭제하게 되면 linked list 로 바꿔야 하고 만약 추가되면 tree 로 바꿔야한다. 이때 바꾸는데 오버헤드가 있기 때문에 기준이 6, 8이다.

## 추가/삭제

- 추가 
  - put(elements)
- 요소 삭제
  - remove(key)
- 전체 요소 삭제
  - clear()

## 값 출력

- 초기화

```java
Map<Integer, String> map = new HashMap<Integer, String>() {{ // initialize
  put(1,"피자");
  put(2,"치킨");
  put(3,"햄버거");
}};
```

- 일반 출력

```java
// 일반 출력
System.out.println(map); // 전체 출력 : {1=피자, 2=치킨, 3=햄버거}
System.out.println(map.get(1)); // key 값으로 출력 : 피자
```

- entrySet() 활용

```java
for(Entry<Integer, String> entry : map.entrySet()) {
  // entry.getKey(), entry.getValue()
}
```

- keySet() 활용

```java
for(Integer key : map.keySet()) {
  map.get(key);
}
```

- Iterator 활용

```java
// entrySet().iterator()
Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
while(entries.hasNext()) {
  Map.Entry<Integer, String> entry = entries.next();
  // entry.getKey(), entry.getValue()
}

// keySet().iterator()
Iterator<Integer> keys = map.keySet().iterator();
while(keys.hasNest()) {
  int key = keys.next();
  // map.get(key)
}
```

> entrySet() 과 keySet() 중 고민한다면, key 를 이용해 value 를 찾는 과정에서 시간이 많이 소요되므로 많은 양의 데이터를 가져와야 하는 경우에는 entrySet() 이 좋다. 성능은 약 20% ~ 200% 차이가 난다.

## 🔑 기본 문제

### [학급 회장](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/hashmap/classpresident/Main.java)

- Point
  - `getOrDefault(key, defaultValue)` 를 사용

```java
private static final Map<String, Integer> STUDENTS = new HashMap<>();

static {
    STUDENTS.put("A", 0);
    STUDENTS.put("B", 0);
    STUDENTS.put("C", 0);
    STUDENTS.put("D", 0);
    STUDENTS.put("E", 0);
}

public String solution(String s) {
    String[] votes = s.split("");
    for(int i=0; i<votes.length; i++) {
        String key = votes[i];
        Integer value = STUDENTS.get(key);
        STUDENTS.put(key, value+1);
    }
    int max = 0;
    String answer = "";
    for(Map.Entry<String, Integer> entry : STUDENTS.entrySet()) {
        if(max < entry.getValue()) {
            max = entry.getValue();
            answer = entry.getKey();
        }
    }
    return answer;
}

// sol2 : getOrDefault
public char solution2(String s) {
    char answer=' ';
    HashMap<Character, Integer> map=new HashMap<>();
    for(char x : s.toCharArray()){
        map.put(x, map.getOrDefault(x, 0)+1);
    }
    int max=Integer.MIN_VALUE;
    for(char key : map.keySet()){
        if(map.get(key)>max){
            max=map.get(key);
            answer=key;
        }
    }
    return answer;
}
```

### [아나그램(anagram)](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/hashmap/anagram/Main.java)

```java
public String solution(String s1, String s2) {
    String[] arr1 = s1.split("");
    String[] arr2 = s2.split("");

    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();
    for(int i=0; i<arr1.length; i++) {
        map1.put(arr1[i], map1.getOrDefault(arr1[i], 0)+1);
        map2.put(arr2[i], map2.getOrDefault(arr2[i], 0)+1);
    }

    String answer = "YES";
    for(String key : map1.keySet()) {
        if(map2.get(key) != null) {
            if(map1.get(key).intValue() != map2.get(key).intValue()) {
                answer = "NO";
                break;
            }
        }
    }
    return answer;
}

// sol2
public String solution2(String s1, String s2) {
    String answer="YES";
    HashMap<Character, Integer> map=new HashMap<>();
    for(char x : s1.toCharArray()){
        map.put(x, map.getOrDefault(x, 0)+1);
    }
    for(char x : s2.toCharArray()){
        if(!map.containsKey(x) || map.get(x)==0) return "NO";
        map.put(x, map.get(x)-1);
    }
    return answer;
}
```

### [매출액의 종류](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/hashmap/salestype/Main.java)

- Point
  - Sliding Window
  - HashMap

```java
public ArrayList<Integer> solution(int n, int k, int[] arr){
    ArrayList<Integer> answer = new ArrayList<>();
    HashMap<Integer, Integer> HM = new HashMap<>();
    for(int i=0; i<k-1; i++){
        HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
    }
    int lt=0;
    for(int rt=k-1; rt<n; rt++){
        HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
        answer.add(HM.size());
        HM.put(arr[lt], HM.get(arr[lt])-1);
        if(HM.get(arr[lt])==0) HM.remove(arr[lt]);
        lt++;
    }
    return answer;
}
```
