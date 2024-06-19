package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TravelRoot_43164 {

    static boolean[] visited;
    static ArrayList<String> result;

    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/43164
        // 문제
        // 시작은 언제나 ICN
        //모든 공항은 알파벳 대문자 3글자로 이루어집니다.
        //주어진 공항 수는 3개 이상 10,000개 이하입니다.
        //tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
        //주어진 항공권은 모두 사용해야 합니다.
        //만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
        //모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

        TravelRoot_43164 T = new TravelRoot_43164();

        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        //["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        for (String ticket : T.solution(tickets)) {

            System.out.println(ticket);
        }

    }

   public void DFS(int idx, String start, String path, String[][] tickets) {

        if(idx == tickets.length){
            System.out.println(path);
            result.add(path);
        } else {
            for(int i=0; i<tickets.length; i++){

                if(tickets[i][0].equals(start) && !visited[i]){
                    visited[i] = true;
                    DFS(idx+1, tickets[i][1], path+" "+tickets[i][1],tickets);
                    visited[i] = false;
                }



            }
        }

    }



    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        DFS(0, "ICN", "ICN",tickets);
        result.sort(null);
        String[] answer = result.get(0).split(" ");

        return answer;
    }
}
