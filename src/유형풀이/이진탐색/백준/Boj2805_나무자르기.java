package 유형풀이.이진탐색.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2805_나무자르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 나무에 대한 정보를 모두 받아온다
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        binarySearch(arr, M, 0, arr[arr.length - 1]);


    }

    // arr이 나무다, start는 0 end는 나무중 가장 큰 길이
    public static void binarySearch(long[] arr, long target, long start, long end) {

        // 여기는 오히려 같으면 끝나지 않는다
        while (start < end) {

            long sum = 0;
            // 중간 길이
            long mid = (start + end) / 2;

            // 싹다 더해준다
            for (long tree : arr) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            // 만약에 내가 원하는 값보다 합이 작으면,
            if (sum < target) end = mid;
            else start = mid + 1;
        }

        System.out.println(start -1);
    }
}

