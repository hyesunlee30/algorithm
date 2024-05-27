package solution;

import java.util.*;

public class GameMapShortestDistance1844 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/1844

    static int n, m;
    static int answer = -1;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

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

        visited=new boolean[n][m];

        return BFS(0,0,maps);

    }

    public int BFS(int x, int y, int[][] maps) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y,1});

        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int[] temp = queue.poll();
            x = temp[0];
            y = temp[1];
            int count = temp[2];

            //마지막일때 끝

            if(x == n-1 && y == m-1){
                answer = count;
                break;
            }


            //동서남북

            for (int i = 0; i<4; i++) {

                int nx = x+dx[i];
                int ny = y+dy[i];

                //경계값 벗어나면 조건 안 타게
                if(nx < 0 || nx >= n  || ny< 0 || ny >= m){
                    continue;
                }
                //
                if(maps[nx][ny] == 0){
                    continue;

                }
                //방문한 적 없고, 동서남북 중에 갈 수 있는 길일때
                // 방문 true
                //queue에 count+1 넣는다
                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,count+1});
                }

            }


        }

        return answer;
    }

}
