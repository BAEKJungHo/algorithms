# 최단 경로(Shortest Path)

최단 경로(Shortest Path)는 말 그대로 가장 짧은 경로를 찾는 알고리즘이다. 그래서 `길 찾기` 문제라고도 불린다. 최단 경로 알고리즘에는 다양한 종류가 있는데, 상황에 맞는 효율적인 알고리즘이
이미 정립되어 있다.

컴공 수준에서 사용하는 최단 거리 알고리즘은 다음과 같다.

- 다익스트라
- 플로이드 워셜
- 벨만 포드 

그 중에서 다익스트라와 플로이드 워셜에 관한 최단 경로 문제가 코딩테스트에서 많이 출제된다.

## 다익스트라 알고리즘(Dijkstra algorithm)

<img src="./images/Dijkstra_Animation.gif" width="300"> 

a와 b 사이의 최단 경로를 찾는 데이크스트라의 알고리즘이다. 가장 낮은 값을 가진 방문하지 않은 꼭짓점을 선택하고, 방문하지 않은 각 인접 노드와의 거리를 계산하고, 작을 경우 인접 거리를 업데이트한다. 이 그림에서는 꼭짓점에 도착하면 빨간색으로 표시했다.

> 위와 같은 그래프를 방향과 가중치가 있다고 해서 `가중치 방향 그래프`라고도 한다.

다익스트라의 원래 알고리즘은 두 꼭짓점 간의 가장 짧은 경로를 찾는 알고리즘이지만, 더 일반적인 변형은 한 꼭짓점을 `"소스"` 꼭짓점으로 고정하고 그래프의 다른 모든 꼭짓점까지의 최단경로를 찾는 알고리즘으로 최단 경로 트리를 만드는 것이다. 그래프에서 주어진 소스 꼭짓점에 대해서, 데이크스트라 알고리즘은 그 노드와 다른 모든 꼭짓점 간의 가장 짧은 경로를 찾는다. 이 알고리즘은 어떤 한 꼭짓점에서 다른 한 도착점까지 가는 경로를 찾을 때, 그 도착점까지 가는 가장 짧은 경로가 결정되면 멈추는 식으로 사용할 수 있다. 

예를 들어 어떤 그래프에서, 꼭짓점들이 각각 도시를 나타내고, 변들이 도시 사이를 연결하는 도로의 길이를 나타낸다면, 데이크스트라 알고리즘을 통하여 두 도시 사이의 최단 경로를 찾을 수 있다. 따라서 최단 경로 알고리즘은 네트워크 라우팅 프로토콜에서 널리 이용되며, 특히 IS-IS(Intermediate System to Intermediate System)와 OSPF(Open Shortest Path First)에서 주로 사용된다.

다익스트라는 음의 간선(0보다 작은 값을 가지는 간선)이 없을때 정상적으로 동작한다. 현실 세계의 길(간선)은 음의 간선으로 표현되지 않으므로 GPS 소프트웨어의 기본 알고리즘으로 채택되곤 한다.
다익스트라 알고리즘은 매번 `가장 비용이 적은 노드`를 선택해서 임의의 과정을 반복하기 때문에 `그리디 알고리즘`으로 분류된다.

- __동작 과정__
  1. 출발 노드를 설정한다.
  2. 최단 거리 테이블을 초기화한다.
  3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
  4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
  5. 3번과 4번을 반복한다. 

다익스트라 알고리즘은 최단 경로를 구하는 과정에서 `각 노드에 대한 현재까지의 최단 거리` 정보를 항상 1차원 리스트에 저장하며 리스트를 계속 갱신한다는 특징이 있다. 이러한 1차원 리스트를 `최단 거리 테이블`이라고 한다. 매번 현재 처리하고 있는 노드를 기준으로 주변 간선을 확인한다.

- __다익스트라 알고리즘을 구현하는 방법__
  - `구현하기 쉽지만 느리게 동작하는 코드`
    - 간단한 다익스트라 알고리즘의 시간 복잡도 : O(V^2), V : 노드의 개수
    - 처음에 각 노드에 대한 최단 거리를 담는 1차원 리스트 선언
    - 이후에 단계마다 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택하기 위해 매 단계마다 1차원 리스트의 모든 원소를 확인(순차 탐색)한다.
  - `구현하기에 조금 까다롭지만 빠르게 동작하는 코드`
    - 개선된 다익스트라 알고리즘의 시간 복잡도 : O(ElogV)
      - E: 간선의 개수, V: 노드의 개수
      - 힙(Heap) 자료구조 사용
      - 힙(Heap) 자료구조는 우선순위 큐(Priority Queue)를 구현하기 위해 사용하는 자료구조 중 하나이다.
        - 우선순위 큐(Priority Queue)는 우선순위가 가장 높은 데이터를 가장 먼저 삭제한다. 즉, `데이터를 우선순위에 따라 처리하고 싶을 때 사용`한다.
        - Ex. 여러개의 물건을 자료구조에 넣고, 가치가 가장 높은 물건부터 꺼내야 하는 경우
      - 우선순위 큐를 구현할 때는 내부적으로 `최소 힙(Min Heap)` 또는 `최대 힙(Max Heap)`을 이용한다. 최소 힙을 이용하는 경우 값이 가장 낮은 데이터가 먼저 삭제되며, 최대 힙은 값이 큰 데이터가 가장 먼저 삭제된다.
      - 최소 힙을 최대 힙처럼 쓰기위해, 자료구조에 음수 부호(-)를 붙여 넣었다가, 큐에서 꺼낸다음 다시 음수 부호(-)를 븉여서 원래의 값으로 돌리는 방식을 사용할 수 있다.
      - 개선된 다익스트라 알고리즘에서 우선순위 큐는 `현재 가장 가까운 노드를 저장하기 위한 목적으로만 이용`한다.

다익스트라 알고리즘은 `한 단계당 하나의 노드에 대한 최단 거리를 확실히 찾는다.` 즉, 실제로 한 번 선택된 노드는 최단 거리가 감소하지 않는다.

## 간단한 다익스트라 알고리즘 구현

```java
class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    public static boolean[] visited = new boolean[100001];
    // 최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}
```

## 개선된 다익스트라 알고리즘 구현

```java
class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정 or Integer.MAX_VALUE 도 가능
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); // 현재 노드까지의 비용 
            int now = node.getIndex(); // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}
```

## Example

![IMAGES](./images/dijkstrasol.JPG)

```java
class Edge implements Comparable<Edge> {
    public int vex;
	  public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

class Main {

	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
  
	public void solution(int v){
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0));
		dis[v]=0;
		while(!pQ.isEmpty()){
			Edge tmp=pQ.poll();
			int now=tmp.vex;
			int nowCost=tmp.cost;
			if(nowCost>dis[now]) continue;
			for(Edge ob : graph.get(now)){
				if(dis[ob.vex]>nowCost+ob.cost){
					dis[ob.vex]=nowCost+ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
				}
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Edge>());
		}
    
		dis=new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
    
		for(int i=0; i<m; i++){
			int a=kb.nextInt();
			int b=kb.nextInt();
			int c=kb.nextInt();
			graph.get(a).add(new Edge(b, c));
		}
    
		T.solution(1);
    
		for(int i=2; i<=n; i++){
			if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
			else System.out.println(i+" : impossible");
		}
	}
}
```

- `dis[i]` : 문제에서 1번 정점에서 시작하니까, 1번 정점에서 i 번째 정점까지 가는데 최소비용을 저장하겠다라는 의미

## References

> https://ko.wikipedia.org/wiki/%EB%8D%B0%EC%9D%B4%ED%81%AC%EC%8A%A4%ED%8A%B8%EB%9D%BC_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
