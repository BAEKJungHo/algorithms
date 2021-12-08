# 최단 경로(Shortest Path)

최단 경로(Shortest Path)는 말 그대로 가장 짧은 경로를 찾는 알고리즘이다. 그래서 `길 찾기` 문제라고도 불린다. 최단 경로 알고리즘에는 다양한 종류가 있는데, 상황에 맞는 효율적인 알고리즘이
이미 정립되어 있다.

컴공 수준에서 사용하는 최단 거리 알고리즘은 다음과 같다.

- 다익스트라
- 플로이드 워셜
- 벨만 포드 

그 중에서 다익스트라와 플로이드 워셜에 관한 최단 경로 문제가 코딩테스트에서 많이 출제된다.

## 다익스트라 알고리즘(Dijkstra algorithm)

![Dijkstra_Animation](https://commons.wikimedia.org/wiki/File:Dijkstra_Animation.gif)