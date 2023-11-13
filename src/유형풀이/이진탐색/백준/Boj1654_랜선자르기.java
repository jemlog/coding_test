package 유형풀이.이진탐색.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1654_랜선자르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long arr[] = new long[N];

        for(int i =0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        binarySearch(arr, M, 0, arr[arr.length -1]+1);
    }

    private static void binarySearch(long[] arr, long target, long min, long max)
    {
        while(min < max)
        {
            long mid = (min + max) / 2;
            long sum = 0;

            for(long tree: arr)
            {
                if(tree >= mid)
                {
                    sum += (tree / mid);
                }
            }


            if(sum < target) max = mid;
            else min = mid + 1;
        }

        System.out.println(min -1);
    }
}
