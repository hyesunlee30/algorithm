package solution;

import java.util.Arrays;

public class Practice43105 {
    public static void main(String[] args) {
        Practice43105 p = new Practice43105();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        //30
        System.out.println(p.solution(triangle));
    }

    public int solution(int[][] triangle) {

        int[][] arr = new int [triangle.length][triangle.length];

        int temp = triangle[0][0];
        for (int i = 0; i < triangle.length; i++) {

            for(int j = 0; j < triangle[i].length; i++) {
                temp += triangle[i][j];

            }
        }

        int answer = 0;
        return answer;
    }
}
