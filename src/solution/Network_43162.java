package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Network_43162 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int count;


    public static void main(String[] args) {
        Network_43162 t = new Network_43162();
//        int n = 3;
//        //2
//        int[][] computers = {
//        {1, 1, 0},
//        {1, 1, 0},
//        {0, 0, 1}};
        //1
        //int[][] computers = {
        // {1, 1, 0},
        // {1, 1, 1},
        // {0, 1, 1}};

        //1
//        int n = 4;
//        int[][] computers = {
//        {1, 0, 0, 1},
//        {0, 1, 1, 0},
//        {0, 1, 1, 0},
//        {1, 1, 0, 1}};
        int n = 2;
        int[][] computers = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};

        System.out.println(t.solution(n, computers));
    }
    public static int solution(int n, int[][] computers) {
        int start = 0;
        adjList = new ArrayList<>();
        visited = new boolean[n];
        for(int i =0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                adjList.get(i).add(computers[i][j]);
            }
        }


        DFS(start); // ????? 헐 전체 노드를 먼저 체크해봐야 한다.
        //간선개수 센다. 전체노드 - 간선
        int answer = (n - count) == 0? 1 : count;
        return answer;
    }



    public static void DFS(int start) {
        count++;
        for (int i = 0; i< adjList.size(); i++) {
            visited[start] = true;
            if(!visited[i] && adjList.get(start).get(i) == 1) {
                visited[i] = true;
                DFS(i);
            }
        }
    }
}
