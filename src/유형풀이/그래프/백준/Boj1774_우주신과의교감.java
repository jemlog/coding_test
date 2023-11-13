package 유형풀이.그래프.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1774_우주신과의교감 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 노드 초기화 완료
        Node[][] nodes = new Node[N+1][N+1];

        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                nodes[i][j] = new Node();
            }
        }

        ArrayList<int[]> arr = new ArrayList<>();

        for(int i =0; i < N; i++)
        {
             st = new StringTokenizer(br.readLine());
             int[] temp = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
             arr.add(temp);
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());



        ArrayList<Edge> edges = new ArrayList<>();

        for(int i =0; i < N; i++)
        {
            for(int j =0; j < N; j++)
            {
                Edge edge = new Edge(arr.get(i),arr.get(j), (arr.get(i)[0] - arr.get(j)[0]) * (arr.get(i)[0] - arr.get(j)[0]) + (arr.get(i)[1] - arr.get(j)[1]) * (arr.get(i)[1] - arr.get(j)[1]) );
                edges.add(edge);
            }
        }

        Collections.sort(edges, Comparator.comparingLong(edge -> edge.distance));
        long total = 0;



        for (Edge edge : edges) {

            Node node1 = nodes[edge.e[0]][edge.e[1]];
            Node node2 = nodes[edge.v[0]][edge.v[1]];

            if(node1.isConnected(node2)) continue;

            node1.merge(node2);
            total += edge.distance;


        }
        System.out.println(total);
    }

    private static class Node{

        int depth = 1;
        Node parent = null;

        public boolean isConnected(Node o)
        {
            return root() == o.root();
        }

        public Node root()
        {
            if(parent == null) return this;

            return parent.root();
        }

        public void merge(Node o)
        {
            if(isConnected(o)) return;

            Node node1 = root();
            Node node2 = o.root();

            if(node1.depth > node2.depth)
            {
                node2.parent = node1;
            } else if (node1.depth < node2.depth) {
                node1.parent = node2;
            }
            else{
                node2.parent = node1;
                node1.depth += 1;
            }
        }
    }

    private static class Edge{

        int[] e;
        int[] v;
        long distance;

        Edge(int[] e, int[] v, long distance)
        {
            this.e = e;
            this.v = v;
            this.distance = distance;
        }
    }
}
