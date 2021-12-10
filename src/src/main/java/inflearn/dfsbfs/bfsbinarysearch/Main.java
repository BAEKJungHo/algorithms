package inflearn.dfsbfs.bfsbinarysearch;

import java.util.LinkedList;
import java.util.Queue;

class Node {

    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main{

    Node root;

    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        int L = 0; // level (root 노드의 level 은 0)
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) { // 현재 레벨에 대한 원소들 반복복
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.add(cur.lt);
                if (cur.rt != null) Q.add(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Main tree=new Main();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.BFS(tree.root);
    }
}