package solution;

import java.util.*;

public class GameMapShortestDistance1844 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/1844

    public static int n, m;
    public static int answer = -1;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean visited[][];

    public static void main(String[] args) {
        GameMapShortestDistance1844 t = new GameMapShortestDistance1844();
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}};


        System.out.println(t.solution(maps));
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];

        return bfs(0, 0, maps);
    }


    public int bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,1}); //x,y,count

        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int temp[] = queue.poll(); // 첫번째 경로 나옴
            x = temp[0];
            y = temp[1];
            int count = temp[2];

            //마지막일때 끝
            if(x == n-1 && y == m-1) {
                answer = count;
                break;
            }

            //동서남북
            for (int i = 0; i <4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if(maps[nx][ny] == 0) {
                    continue;
                }
                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count+1});
                }

            }


        }


        return answer;
    }
}
