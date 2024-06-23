package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheShortestPathInTheMaze {


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0 , -1};
    static int[][] board;
    static int[][] dis;


    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();

        Q.offer(new Point(x,y));

        board[x][y] = 1;

        while(!Q.isEmpty()){
            Point tmp = Q.poll();

            for(int i =0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx,ny));

                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }

    }

    public static void main(String[] args) {
        //11.미로의 최단거리 통로(BFS)
        TheShortestPathInTheMaze T = new TheShortestPathInTheMaze();

        //7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
        //경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
        //출발점은 격자의 (1,1), 탈출 (7,7) 좌표이다. 격자판은 1은 벽이고 0은 도로이다.
        //상하좌우로만 움직인다.

//0 0 0 0 0 0 0
//0 1 1 1 1 1 0
//0 0 0 1 0 0 0
//1 1 0 1 0 1 1
//1 1 0 1 0 0 0
//1 0 0 0 1 0 0
//1 0 1 0 0 0 0

        Scanner kb = new Scanner(System.in);

        board = new int[8][8];
        dis = new int[8][8];

        for(int i = 1; i<=7; i++){
            for(int j = 1; j<=7; j++){
                board[i][j] = kb.nextInt();
            }
        }

        T.BFS(1,1);

        if(dis[7][7]==0){
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }


}

class Point{
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


