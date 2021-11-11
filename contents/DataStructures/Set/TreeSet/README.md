# TreeSet

- 데이터가 정렬된 상태로 저장되는 이진 탐색 트리(binary search tree)의 형태로 요소를 저장한다.
- 이진 탐색 트리 중에 성능을 향상시킨 `레드-블랙 트리(Red-Black tree)`로 구현되어 있다.
- 객체를 중복해서 저장할 수 없고 저장 순서가 유지되지 않는다는 Set의 성질을 그대로 가지고 있다.
- 이진 탐색 트리는 `추가, 삭제`에는 시간이 조금 더 걸리지만 `정렬, 검색`에 높은 성능을 보이는 자료구조이다. 그렇기에 HashSet 보다 데이터의 추가와 삭제는 시간이 더 걸리지만 검색과 정렬에는 유리하다.
- TreeSet은 데이터를 저장할 시 이진탐색트리(BinarySearchTree)의 형태로 데이터를 저장하기에 기본적으로 `natural ordering` 를 지원하며 `생성자의 매개변수로 Comparator 객체`를 입력하여 정렬 방법을 임의로 지정해 줄 수도 있다.

> TreeSet 은 HashSet 보다 정렬 검색에 이점을 보이기 때문에, `중복된 원소를 제거하고, 정렬하여 특정한 값을 출력`해야 한다고 할 때 주로 사용한다.

## Natural Ordering

자연 순서(natural ordering)는 쉽게 말해 작은 수에서 큰 수, 알파벳 순, 가나다 순서대로 정렬하는 것을 의미합니다.

## 레드-블랙 트리

TreeSet 은 이진탐색트리 중에서도 성능을 향상시킨 `레드-블랙 트리(Red-Black Tree)`로 구현되어 있습니다. 일반적인 이진 탐색 트리는 트리의 높이만큼 시간이 걸립니다. 데이터의 값이 트리에 잘 분산되어 있다면 효율성에 큰 문제가 없으나 데이터가 들어올 때 값이 편향되게 들어올 경우 한쪽으로 크게 치우쳐진 트리가 되어 굉장히 비효율적인 퍼포먼스를 냅니다. 이 문제를 보완하기 위해 레드 블랙 트리가 등장하였습니다. 레드 블랙 트리는 부모노드보다 작은 값을 가지는 노드는 왼쪽 자식으로, 큰 값을 가지는 노드는 오른쪽 자식으로 배치하여 데이터의 추가나 삭제 시 트리가 한쪽으로 치우쳐지지 않도록 균형을 맞추어줍니다.

## TreeSet 사용 방법

- 선언

```java
TreeSet<Integer> set1 = new TreeSet<>();
TreeSet<Integer> set2 = new TreeSet<Integer>(set1); // set1의 모든 값을 가진 TreeSet 생성
TreeSet<Integer> set3 = new TreeSet<Integer>(Arrays.asList(1,2,3)); // 초기값 지정
```

- 값 추가

```java
set.add(8);
...
```

- 값 삭제

```java
set.remove(1); // 값 1 제거
set.clear(); // 모든 값 제거
```

- 값 출력

```java
TreeSet<Integer> set = new TreeSet<Integer>(Arrays.asList(4,2,3)); // 초기값 지정
System.out.println(set); // 전체출력 [2,3,4]
System.out.println(set.first()); // 최소값 출력
System.out.println(set.last()); // 최대값 출력
System.out.println(set.higher(3)); // 입력값보다 큰 데이터중 최소값 출력 없으면 null
System.out.println(set.lower(3)); // 입력값보다 작은 데이터중 최대값 출력 없으면 null

/*
 * 해당 객체가 존재하면 그 객체를 리턴, 
 * 해당객체가 없으면 바로 아래 객체를 리턴
 * 
 * ceiling()은 그 반대
 */
System.out.println(treeSet.floor(76)); // (=75)
System.out.println(treeSet.ceiling(76)); // (=90)

// 제일 낮은 객체를 꺼내고 컬렉션에서 제거함 : 컬렉션에 값이 없으면 null 반환
treeSet.pollFirst(); 

// 제일 높은 객체를 꺼내고 컬렉션에서 제거함 : 컬렉션에 값이 없으면 null 반환
treeSet.pollLast();

Iterator iter = set.iterator();	// Iterator 사용
while(iter.hasNext()) { // 값이 있으면 true 없으면 false
    System.out.println(iter.next());
}
```

- TreeSet 을 이용한 정렬
	- 기본 정렬 : natural ordering 오름차순 정렬이 기본이다.

```java
TreeSet<Integer> set = new TreeSet<>(Comparator.comparing(Integer::intValue).reversed()); // 내림차순 정렬
TreeSet<Integer> set1 = new TreeSet<>(); // 오름차순 정렬
```

## 🔑 기본 문제

### [K 번째 큰 수](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/treeset/kmax/Main.java)

```java
public int solution(int n, int m, int[] arr) {
	int answer = -1;
	TreeSet<Integer> set = new TreeSet<>(Comparator.comparing(Integer::intValue).reversed());
	// TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
	for(int i=0; i<n; i++) {
	    for(int k=i+1; k<n; k++) {
		for(int p=k+1; p<n; p++) {
		    set.add(arr[i] + arr[k] + arr[p]);
		}
	    }
	}
	for(int i=0; i<m; i++) {
	    if(i == m-1) {
		Integer top = set.pollFirst();
		if(top != null) {
		    return top;
		} else {
		    return -1;
		}
	    } else {
		set.pollFirst();
	    }
	}
	return answer;
}
```

## References

- https://coding-factory.tistory.com/555
