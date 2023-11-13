package 유형풀이.그래프.연습;


public class 유니온파인드 {

    // MST 문제 풀때 노드 세팅
    private static class Node{

        // 초기 시작은 깊이 1
        private int depth = 1;
        // 부모는 없는 상태
        private Node parent = null;


        // 부모가 누구인지 찾는 과정
        public Node root()
        {
            if(parent == null)
            {
                return this;
            }

            return parent.root();
        }

        // 서로 연결되어 있는지 체크
        public boolean isConnected(Node o)
        {
            return root() == o.root();
        }

        // 서로 연결하는 과정
        public void merge(Node o)
        {
            // 만약 서로 연결된 상태면 무시
            if(isConnected(o)) return;

            // 서로의 루트 가져오기
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
        public final int v;
        public final int cost;

        private Edge(int u, int v, int cost)
        {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}
