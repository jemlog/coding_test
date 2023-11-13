package 기출문제.카카오;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 압축 {

    public static void main(String[] args) {
          solution("KAKAO");
    }

    public static int[] solution(String msg) {

            // 단어를 저장할 수 있는 사전을 만든다.
            Map<String, Integer> dict = new HashMap<>();
            ArrayList<Integer> answer = new ArrayList<>();

            // A ~ Z 까지 사전 초기화
            // 돌지말고 문자를 잘라내자
            for(int i =0; i < 26; i++)
            {
                dict.put(String.valueOf((char) ('A' + i)), i+1);
            }

            while(msg.length() != 0)
            {
                if(msg.length() == 1)
                {
                    answer.add(dict.get(msg));
                    msg = "";
                    break;
                }

                String recent = "";

                for(int i =0; i < msg.length(); i++)
                {
                    // 문자를 하나 골라서
                    String each = msg.substring(0,i+1);

                    // 만약 key를 포함하고 있다면
                    if(dict.containsKey(each))
                    {
                        // 마지막 값 저장
                        if(each.length() == msg.length())
                        {
                            answer.add(dict.get(each));
                            msg = "";
                            break;
                        }
                        recent = each;
                        continue;
                    }

                    // 만약 값이 없다면, 정답에는 최근꺼 넣기
                    answer.add(dict.get(recent));
                    msg = msg.substring(recent.length());
                    dict.put(each, dict.size() + 1);
                    break;
                }

            }

            return answer.stream()
                    .mapToInt(i -> i)
                    .toArray();
        }

}
