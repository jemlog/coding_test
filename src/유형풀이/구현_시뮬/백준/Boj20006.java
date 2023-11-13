package 유형풀이.구현_시뮬.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj20006 {

    static int player;
    static int roomCount;
    static int roomSize;
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        player = Integer.parseInt(st.nextToken());
        roomSize = Integer.parseInt(st.nextToken());
        roomCount = 0;

        for(int i =0; i < player; i++)
        {
            st = new StringTokenizer(br.readLine());
            Player newPlayer = new Player(Integer.parseInt(st.nextToken()), st.nextToken());

            // 들어갈 수 있는 방이 있는지 찾기
            List<Room> possible = rooms.stream().filter(room ->
                    (newPlayer.level >= room.lowLevel) &&
                            (newPlayer.level <= room.highLevel) &&
                            (room.players.size() < roomSize)
            ).sorted(Comparator.comparingInt(o -> o.roomCount)).collect(Collectors.toList());

            if(possible.isEmpty())
            {
                Room room = new Room(newPlayer.level - 10, newPlayer.level + 10, ++roomCount);
                room.players.add(newPlayer);
                rooms.add(room);
            }
            else{
                Room room = possible.get(0);
                room.players.add(newPlayer);
            }


        }

        rooms.stream().forEach(room -> {

            List<Player> collect = room.players.stream().sorted(Comparator.comparing(Player::getNickname)).collect(Collectors.toList());

            if(room.players.size() == roomSize)
            {
                sb.append("Started!");
                sb.append("\n");
                for(int j =0; j < roomSize; j++)
                {
                    sb.append(collect.get(j).level + " " + collect.get(j).nickname);
                    sb.append("\n");
                }
            }
            else{
                sb.append("Waiting!");
                sb.append("\n");
                for(int j =0; j < collect.size(); j++)
                {
                    sb.append(collect.get(j).level + " " + collect.get(j).nickname);
                    sb.append("\n");
                }
            }
        });

        System.out.println(sb.toString());
    }
}

class Player{

    int level;
    String nickname;

    public Player(int level, String nickname)
    {
        this.level = level;
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
}

class Room{

    int lowLevel;

    int highLevel;

    int roomCount;

    ArrayList<Player> players = new ArrayList<>();

    public Room(int lowLevel, int highLevel, int roomCount)
    {
        this.lowLevel = lowLevel;
        this.highLevel = highLevel;
        this.roomCount = roomCount;
    }
}
