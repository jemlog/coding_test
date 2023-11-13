package 유형풀이.그래프.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj14621_나만안되는연애 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // ===========

        Node[] nodes = new Node[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i =1; i <= N; i++)
        {
            nodes[i] = new Node(st.nextToken());
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i =0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(edges, Comparator.comparingLong(edge -> edge.distance));

        long totalCount = 0;
        int cnt = 0;
        for (Edge edge : edges) {

            Node node1 = nodes[edge.e];
            Node node2 = nodes[edge.v];

            if(node1.isConnected(node2) || node1.gender.equals(node2.gender)) continue;

            node1.merge(node2);
            totalCount += edge.distance;
            cnt +=1;
        }

        if(cnt != N-1)
        {
            System.out.println(-1);
            return;
        }

        System.out.println(totalCount);
    }

    private static class Edge{

        int e;
        int v;
        long distance;

        public Edge(int e, int v, long distance)
        {
            this.e = e;
            this.v = v;
            this.distance = distance;
        }
    }

    private static class Node{

        int depth = 1;
        Node parent = null;
        String gender;

        public Node(String gender)
        {
            this.gender = gender;
        }

        boolean isConnected(Node o)
        {
            return root() == o.root();
        }

        Node root()
        {
            if(parent == null) return this;

            return parent.root();
        }

        void merge(Node o)
        {
            if(isConnected(o)) return;

            Node node1 = root();
            Node node2 = o.root();

            if(node1.depth > node2.depth)
            {
                node2.parent = node1;
            }
            else if(node1.depth < node2.depth)
            {
                node1.parent = node2;
            }
            else{
                node2.parent = node1;
                node1.depth +=1;
            }
        }
    }
}

