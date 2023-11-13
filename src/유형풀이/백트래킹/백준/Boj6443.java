package 유형풀이.백트래킹.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

// 중복 체크 로직만 존재하면 된다
public class Boj6443 {

    static String[] arr;

    static StringBuilder sb;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new String[N];

        for(int i =0; i < N; i++)
        {
            arr[i] = br.readLine();
        }

        for(int i =0; i < N; i++)
        {
            permutation(arr[i], new char[arr[i].length()], new boolean[arr[i].length()], 0, 0, arr[i].length());
        }



    }

    private static void permutation(String str, char[] out, boolean[] visited, int start, int depth, int r)
    {
        if(depth == r)
        {
            sb = new StringBuilder();
            for(char c : out)
            {
                sb.append(c);
            }

            System.out.println(sb.toString());

            return;
        }

        for(int i =0; i < str.length(); i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                out[start] = str.charAt(i);
                permutation(str,out,visited,start+1,depth+1,r);
                visited[i] = false;
            }
        }

    }}

//    /*
//    순열을 구할때 Next Permutation을 사용하면 중복 요소가 있어도 한번만에 뽑아낼 수 있다.
//     */
//    static boolean next_permutation(int n) {
//        int idx = n - 1;
//
//        while(idx > 0 && arr[idx] <= arr[idx - 1])
//            idx--;
//
//        if(idx == 0)
//            return false;
//
//        for(int i=n - 1;i>=idx;i--) {
//            if(arr[idx - 1] < arr[i]) {
//                char temp = arr[i];
//                arr[i] = arr[idx - 1];
//                arr[idx - 1] = temp;
//                break;
//            }
//        }
//
//        Arrays.sort(arr, idx, n);
//        return true;
//    }
//}
//

