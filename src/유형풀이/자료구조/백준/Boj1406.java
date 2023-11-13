package 유형풀이.자료구조.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1406 {

    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // Team을 Map에 넣어서 관리를 편하게 만든다.
        HashMap<Integer, Team> map = new HashMap<>();
        map.put(1, new Team(0, 0));
        map.put(2, new Team(0, 0));

        // 다섯번 돈다고 생각하자
        for(int i =0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int number = Integer.parseInt(st.nextToken()); // 어떤 팀이 골을 넣었는지 체크한다.
            int time = transferToSecond(st.nextToken()); // 초 단위로 환산한다.






        }
    }

    // 쉬운 비교를 위해서 10:00 형태의 문자열을 분 단위로 변환해야 한다.
    private static int transferToSecond(String time)
    {
         String[] parse = time.split(":");
         int minute = Integer.parseInt(parse[0]);
         int second = Integer.parseInt(parse[1]);
         return 60 * minute + second;
    }
}

class Record{

    int number;
    int time;

    public Record(int number, int time)
    {
        this.number = number;
        this.time = time;
    }
}

class Team{

    int winningTime;
    int score;

    public Team(int winningTime, int score)
    {
        this.winningTime = winningTime;
        this.score = score;
    }
}
