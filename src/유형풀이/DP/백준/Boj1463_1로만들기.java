package 유형풀이.DP.백준;
import java.io.*;
public class Boj1463_1로만들기 {

        public static void main(String[] args) throws  IOException{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            System.out.println(bottomUp(n));
        }

        static int bottomUp(int num) {

            int[] dp = new int[num+1]; // 전체 케이스 + 1만큼

            // for문을 도는 방식 : Bottom up
            for(int i=2; i<num+1; i++) {

                // 2라는 숫자에 1
                dp[i] = dp[i-1]+1; // -1

                if(i%2==0) {
                    dp[i] = Math.min(dp[i], dp[i/2]+1);
                }
                if(i%3==0) {
                    dp[i] = Math.min(dp[i], dp[i/3]+1);
                }
            }

            return dp[num];
        }

}
