package solution;

import java.util.*;

public class Practice49189 {

    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        Practice49189 t = new Practice49189();
        int n = 6;
        int [][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(t.solution(n, edge));
    }

    public int solution(int node, int[][] edge) {

        int m = edge.length;
        int n = edge[0].length;

        visited = new boolean[m*n];
        adjList = new ArrayList<>();
        distance = new int[node+1];

        for(int i=0; i<m*n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] a : edge){
            addEdge(a[0], a[1]);
        }
        bfs(1);
        int max = 0;
        for (int i = 0; i <distance.length; i++) {
            if(max < distance[i]) {
                max = distance[i];
            }
        }
        int answer = 0;
        for (int i = 0; i < distance.length; i++) {
            if(max == distance[i]) {
                answer++;
            }
        }


        return answer;
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int next = queue.poll(); //방문
            for(int taget : adjList.get(next)){
                if(visited[taget] != true){
                    queue.add(taget); //방문예정인 데이터를 큐에 담는것.
                    distance[taget] = distance[next] + 1;
                    visited[taget] = true;
                }
            }
        }
    }

    static void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}
