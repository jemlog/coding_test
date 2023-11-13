package 유형풀이.BFSDFS.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2932 {

    static int N; // 칸 수
    static int M; // 총 몇번 이동할껀가
    static int K; // 숫자
    static int C; // 열
    static int R; // 행

    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));

        board = new int[N][N];

        int cnt = 1;
        for(int i =0; i < board.length; i++)
        {
            for(int j =0; j < board[0].length; j++)
            {
                board[i][j] = cnt++;
            }
        }

        for(int i =0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken(" "));
            C = Integer.parseInt(st.nextToken(" "));
            R = Integer.parseInt(st.nextToken(" "));
        }




    }
}
