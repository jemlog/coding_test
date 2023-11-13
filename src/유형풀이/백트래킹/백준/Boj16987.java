package 유형풀이.백트래킹.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16987 {

    static int N;
    static int max;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        max = Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        eggs = new Egg[N];

        for(int i =0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int durable = Integer.parseInt(st.nextToken());
            int weigth = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durable,weigth);
        }

        dfs(0, eggs, 0);

        System.out.println(max);

    }

    private static void dfs(int index, Egg[] eggs, int count)
    {
        // 현재 인덱스가 마지막이라면
        if(index == eggs.length-1)
        {
            max = Math.max(max,count);
            // 종료하기
            return;
        }


        // 전체를 다 돌면서
        for(int i =0; i < eggs.length; i++)
        {
            Egg[] copyEggArray = copyEggs();

            // 만약 자기 자신이면 무시
            if(i == index)
            {
                continue;
            }

            if(isCrashEnable(index,i,copyEggArray))
            {
                int crash = crash(index, i, copyEggArray);
                dfs(index+1,copyEggArray,count + crash);
            }

        }

        /*
        접근법에 문제가 있었다. 이걸 배열 복사로 처리하는게 아니라, recover 메서드를 만들어서 처리해줘야 한다!!!
         */

        dfs(index+1,copyEggs(),count);


    }

    private static int crash(int index, int i, Egg[] eggs)
    {
        Egg currentEgg = eggs[index];
        Egg againstEgg = eggs[i];
        currentEgg.minus(againstEgg.weight);
        againstEgg.minus(currentEgg.weight);

        int temp = 0;

        if(currentEgg.durable <= 0)
        {
            temp++;
        }

        if(againstEgg.durable <= 0)
        {
            temp++;
        }

        return temp;
    }

    private static Egg[] copyEggs() {
        Egg[] newEggs = new Egg[eggs.length];
        for(int j =0; j < eggs.length; j++)
        {
            newEggs[j] = eggs[j];
        }
        return newEggs;
    }

    private static boolean isCrashEnable(int index, int i, Egg[] copyEggArray) {
        return copyEggArray[i].durable > 0 && copyEggArray[index].durable > 0;
    }
}

class Egg{

    int weight;
    int durable;

    public Egg(int durable, int weight)
    {
        this.weight = weight;
        this.durable = durable;
    }

    public void minus(int weight)
    {
        this.durable -= weight;
    }
}
