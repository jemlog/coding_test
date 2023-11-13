package 유형풀이.DP.백준;

import java.util.Scanner;

public class Boj11726_2n타일링2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[3] = 3;

        // 핵심 - 이전에 계산한 값을 그대로 재활용 한다! 계산 결과 다시 쓰기!
        for(int i = 3; i <=n ; i++)
        {
            dp[i] = (dp[i-1] + 2* dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
