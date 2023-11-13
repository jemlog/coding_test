package 유형풀이.그래프.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16398_행성연결 {

    /*
    모든 노드를 연결하되, 최단거리로 연결해야 함
    1. MST -> 유니온 파인드, 크루스칼 사용
     */

    public static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];


        for(int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Edge> edges = new ArrayList<>();

        // 이렇게 제공이 된다면, 일단 간선들 다 뽑아내는 방향으로 변경하자
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j<=N; j++)
            {
                edges.add(new Edge(i,j,arr[i][j]));
            }
        }

        Collections.sort(edges,Comparator.comparingLong(edge -> edge.distance));

        Node[] nodes = new Node[N+1];

        for(int i =0; i < nodes.length; i++)
        {
            nodes[i] = new Node();
        }

        long totalCount = 0;

        for(Edge edge : edges)
        {
            Node node1 = nodes[edge.e];
            Node node2 = nodes[edge.v];

            if(node1.isConnected(node2)) continue;

            node1.merge(node2);
            totalCount += edge.distance;

        }
        System.out.println(totalCount);
    }

    private static class Node{

        int depth = 1;
        Node parent = null;

        boolean isConnected(Node o)
        {
            return root() == o.root();
        }

        Node root() {

            // 만약 조상이 없으면 자기 자신을 반환
            if (parent == null) return this;

            return parent.root();
        }

        void merge(Node o)
        {
            if(isConnected(o)) return;

            Node root1 = root();
            Node root2 = o.root();

            if(root1.depth > root2.depth)
            {
                root2.parent = root1;
            }
            else if(root1.depth < root2.depth)
            {
                root1.parent = root2;
            }
            else {
                root2.parent = root1;
                root1.depth +=1;
            }
        }


    }

    private static class Edge{

        int e;
        int v;
        long distance;

        public Edge(int e, int v, long distance)
        {
            this.e= e;
            this.v = v;
            this.distance = distance;
        }
    }
}
