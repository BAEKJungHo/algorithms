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

## Separate Chaining

Separate Chaining 은 JDK 내부에서도 사용하고 있는 충돌 처리 방식인데, `Linked List 와 Tree(Red-Black Tree)` 를 이용하는 방식이다.
두 개를 사용하는 기준은 data 가 6개 이하이면 linked list 를 사용하고 8개 이상이면 tree 를 사용한다.
(왜 7개가 아니냐 의문이 들 수 있다. 만약 7개일 때, 데이터를 삭제하게 되면 linked list 로 바꿔야 하고 만약 추가되면 tree 로 바꿔야한다. 이때 바꾸는데 오버헤드가 있기 때문에 기준이 6, 8이다.)

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
