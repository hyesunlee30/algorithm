package solution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeNavigation {

    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer;
    static int n = 7;

    public void DFS (int x, int y) {

        if(x >= 7 && y >=7) {
            answer++;
        } else {
            for (int i =0; i <4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 1 && nx <=7 && ny >=1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx,ny);
                    board[nx][ny] = 0;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        //10. 미로탐색(DFS)
        //7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요
        //출발점 격자의 (1,1), 탈출 도착점은 (7,7) 좌표이다.
        // 격자판의 1은 벽이고, 0은 통로이다. 격자판의 움직움은 상하좌우로만 움직인다.

        MazeNavigation T = new MazeNavigation();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(answer);

    }
}
