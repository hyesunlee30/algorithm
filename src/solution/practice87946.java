package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice87946 {
    static int answer;

    public static void main(String[] args) {
        practice87946 p = new practice87946();
        int k = 80; // 현재 피로도
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        //순열
        System.out.println(p.solution(k,dungeons));
    }
    public int solution(int k, int[][] dungeons) {

        //Dnf(dungeons, dnfvisit, k, 0);
        //System.out.println(answerd);

        boolean[] visited = new boolean[dungeons.length];
        DFS(k,dungeons,visited,0);
        return answer;
    }

    //i 포문 o 시작. visited[i] - true  j 포문 다 돌고
    // j포문이 끝나고 i for문 1부터 다시 시작 그래서 visited[i] = false;
    // 최대 갯수를 찾는.
    static void DFS(int k, int[][] dungeons, boolean[] visited,int L) {
        if (L > answer) {
            answer = L;
        }
        for (int i =0; i < dungeons.length; i++) {

            if (!visited[i] && dungeons[i][0]<=k) {
                visited[i] = true; // 방문 체크
                k -= dungeons[i][1];
                DFS(k,dungeons,visited, L+1);
                k +=dungeons[i][1];
                visited[i] = false;

            }
        }

    }
}
