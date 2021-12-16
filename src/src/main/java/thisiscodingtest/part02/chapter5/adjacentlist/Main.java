package thisiscodingtest.part02.chapter5.adjacentlist;

import java.util.ArrayList;
import java.util.List;

class Graph {
    private int node;
    private int edge;

    public Graph(int node, int edge) {
        this.node = node;
        this.edge = edge;
    }

    public void show() {
        System.out.print("(" + this.node + "," + this.edge + ") ");
    }
}

// 인접 리스트 방식
public class Main {

    private static List<List<Graph>> graphs = new ArrayList<>();

    public static void main(String[] args) {
        // 그래프 초기화
        for(int i=0; i<3; i++) {
            graphs.add(new ArrayList<>());
        }

        // 노드 0에 연결된 노드 정보 (노드, 간선)
        graphs.get(0).add(new Graph(1, 7));
        graphs.get(0).add(new Graph(2, 5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 간선)
        graphs.get(1).add(new Graph(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 간선)
        graphs.get(2).add(new Graph(0, 5));

        // 그래프 출력
        for (int i=0; i<3; i++) {
            for (int k=0; k<graphs.get(i).size(); k++) {
                graphs.get(i).get(k).show();
            }
            System.out.println();
        }
    }
}
