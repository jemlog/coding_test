package 유형풀이.BFSDFS.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206 {

    static int N;
    static int M;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        visited = new int[N+1][M+1];

        for(int i =1; i <= N; i++)
        {
            String temp = br.readLine();
            for(int j =1; j <= M; j++)
            {
                board[i][j] = Character.getNumericValue(temp.charAt(j-1));
            }
        }

        bfs(1,1);

        int answer = visited[N][M];
        if (answer == 0) System.out.println(-1);
        else {
            System.out.println(answer);
        }

    }

    private static void bfs(int start, int end)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,end,0});
        visited[start][end] = 1;

        while (!queue.isEmpty())
        {
            int[] poll = queue.poll();

            for(int i =0; i < 4; i++)
            {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                // 범위를 벗어나는지 체크
                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;

                // 벽에 부딪혔을때 기회를 이미 써버렸다면 진행 불가
                if(board[nx][ny] == 1 && poll[2] == 1) continue;

                // 벽에 부딪혔을때 기회를 아직 쓰지 않았다면
                if(board[nx][ny] == 1 && poll[2] == 0)
                {
                    // 한번 뚫고 기회 반납
                    queue.add(new int[]{nx,ny,1});
                    // 길이 한번 추가
                    visited[nx][ny] = visited[poll[0]][poll[1]] + 1;
                    continue;
                }

                // 만약 방문한 장소라면 접근 불가
                if(visited[nx][ny] != 0) continue;

                queue.add(new int[]{nx,ny,poll[2]});
                visited[nx][ny] = visited[poll[0]][poll[1]] + 1;
            }
        }
    }
}
