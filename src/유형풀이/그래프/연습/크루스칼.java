package 유형풀이.그래프.연습;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 크루스칼 {



        public static void main(String[] args) throws IOException {

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            Edge[] arr = new Edge[E];

            for(int i =0; i < E; i++)
            {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                arr[i] = new Edge(u,e,cost);
            }

            Edge[] edges = Arrays.stream(arr)
                    .sorted(Comparator.comparingInt(each -> each.cost))
                    .toArray(Edge[]::new);

            Node[] nodes = new Node[V+1];

            for(int i =0; i < V+1; i++)
            {
                nodes[i] = new Node();
            }

            int totalCost = 0;

            // 각각의 엣지들을 순회하면서
            for(Edge edge : edges)
            {
                // 엣지의 시작에 있는 노드와 끝에 있는 노드를 구한다
                Node node1 = nodes[edge.e];
                Node node2 = nodes[edge.u];

                // 둘이 연결이 되어 있으면
                if(node1.isConnected(node2)) continue;

                // 만약 연결 안되있으면 합치고
                node1.merge(node2);
                // 비용 더하기
                totalCost += edge.cost;
            }


            System.out.println(totalCost);
        }

        private static class Node{

            private int depth = 1; // 처음에는 깊이가 모두 1
            private Node parent = null; // 처음에는 모두가 root

            public boolean isConnected(Node o)
            {
                return root() == o.root(); // 서로의 조상이 같으면 결국 연결되어있음
            }

            public Node root()
            {
                if(parent == null)
                {
                    return this;
                }

                return parent.root();
            }

            public void merge(Node o)
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
                else{
                    root2.parent = root1;
                    root1.depth +=1;
                }
            }

        }

        private static class Edge{

            public final int u;
            public final int e;
            public final int cost;

            public Edge(int u, int e, int cost)
            {
                this.u = u;
                this.e = e;
                this.cost = cost;
            }

        }
    }

