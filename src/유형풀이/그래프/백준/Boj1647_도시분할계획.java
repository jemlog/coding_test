package 유형풀이.그래프.백준;



// MST를 푸는것도 중요하지만, 하나의 MST 라는 유형 내에서 어떻게 문제가 파생될 수 있는지를 제대로 파악해야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1647_도시분할계획 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];

        for(int i = 1; i <= N; i++)
        {
            nodes[i] = new Node();
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i =0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start,end,dist));
        }

        Collections.sort(edges, Comparator.comparingLong(edge -> edge.distance));

        long totalCount = 0;
        Stack<Long> stack = new Stack<>();

        for (Edge edge : edges) {

            Node node1 = nodes[edge.e];
            Node node2 = nodes[edge.v];

            if(node1.isConnected(node2)) continue;

            node1.merge(node2);
            stack.push(edge.distance);
            totalCount += edge.distance;
        }

        System.out.println(totalCount - stack.pop());
    }

    private static class Edge{

        int e;
        int v;
        long distance;

        public Edge(int e, int v ,long distance)
        {
            this.e = e;
            this.v = v;
            this.distance = distance;
        }
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
            }
            else if(node1.depth < node2.depth)
            {
                node1.parent = node2;
            }
            else{
                node2.parent = node1;
                node1.depth += 1;
            }
        }
    }
}

