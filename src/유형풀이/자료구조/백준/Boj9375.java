package 유형풀이.자료구조.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj9375 {

    /*
    조합 문제다
    왜 시간 초과가 뜨는지 분석 필요
     */

    static Map<String, Integer> map;
    static int count;
    static int T, N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i =0; i < T; i++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());


            map = new HashMap<>();

            for(int j =0; j < N; j++)
            {
                st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                String type = st.nextToken();

                if(!map.containsKey(type))
                {
                    map.put(type,1);
                }
                else{
                    map.replace(type, map.get(type)+1);
                }
            }

            count = 0;

            // 조합 수행하기 위한 리스트
            ArrayList<String> arr = new ArrayList<>();

            Set<String> type = map.keySet();

            for(String each: type)
            {
                arr.add(each); // [headgear, eyewear]
            }

            // 2c1 , 2c2 작업
            for(int j =1; j <= type.size(); j++)
            {
                boolean[] visited = new boolean[type.size()];
                String[] out = new String[j];
                combination(arr, out, visited, 0, 0, j);
            }

            System.out.println(count);
            count = 0;
            map.clear();
        }


    }

    private static void combination(ArrayList<String> arr, String[] out, boolean[] visited, int start, int depth, int r)
    {
        if(depth == r)
        {
            int temp = 1;

            for(int i =0; i < visited.length; i++)
            {
               if(visited[i])
               {
                   Integer cnt = map.get(arr.get(i));
                   temp *= cnt;
               }
            }
            count += temp;
            return;
        }

        for(int i = start; i < arr.size(); i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                combination(arr, out, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }


}
