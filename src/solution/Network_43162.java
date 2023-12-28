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
        int n = 3;
        int[][] computers = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};


        visited = new boolean[n];

        System.out.println(t.solution(n, computers));
    }
    public static int solution(int n, int[][] computers) {


        adjList = new ArrayList<>();
        for(int i =0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length-1; i++) {
            System.out.print(computers[i][i]);

        }

        DFS(0);

        int answer = (n - count) == 0? 1 : count;
        return answer;
    }



    public static void DFS(int start) {
//        count++;
//        for (int i = 0; i< adjList.size(); i++) {
//            visited[start] = true;
//            if(!visited[i] && adjList.get(start).get(i) == 1) {
//                visited[i] = true;
//                DFS(i);
//            }
//        }
    }
}
