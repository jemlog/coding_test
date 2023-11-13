package 유형풀이.BFSDFS.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
부모, 자식관계 - 1촌
DFS로 풀어야 한다 -> 깊이를 구하기 위해 쭉 들어가야 함
 */
public class Boj2644_촌수계산 {

	static ArrayList<Integer>[] list;
	static int N,M,start,end, answer;
	static boolean[] visited;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N+1];
        visited = new boolean[N+1];

		for(int i =0; i < list.length; i++){
			list[i] = new ArrayList<>();
		}

		for(int i =0; i < M; i++){
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list[s].add(e);
			list[e].add(s);
		}

		dfs(start, end, 0);

		if (answer == 0){
			answer = -1;
		}
		System.out.println(answer);
	}

	private static void dfs(int start, int end, int cnt){

		if(start == end){
			answer = cnt;
			return;
		}

		visited[start] = true; // 방문 체크

		for(int each: list[start]){

			if(!visited[each]){
				dfs(each, end, cnt+1);
			}
		}
	}
}

