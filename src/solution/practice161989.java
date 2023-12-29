package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice161989 {
    public static void main(String[] args) {

        //덧칠하기
        //greedy
        //요구사항
//        int n = 20; // 벽 길이
//        int m = 4; // 롤러의 길이
//        int[] section = {2, 3, 6,19}; // 벗겨져서 칠해야 하는 곳
//        int n = 100; // 벽 길이
//        int m = 4; // 롤러의 길이
//        int[] section = {2, 3, 55,99}; // 벗겨져서 칠해야 하는 곳
        //3
//
//        int n = 8; // 벽 길이
//        int m = 4; // 롤러의 길이
//        int[] section = {2, 3, 6}; // 벗겨져서 칠해야 하는 곳
//
//        int n = 5;
//        int m = 5;
//        int[] section = {3};
//        //1

        int n = 5;
        int m = 2;
        int[] section = {1,4,5};
        //2
        solution(n, m, section);
        //System.out.println(solution(n, m, section));


    }
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = 0;
        int end = 0;
        List<int[]> line = new ArrayList<>();

        for(int i = 0; i < section.length; i++) {
            System.out.println(section[i]);
            int[] se = new int[2];
            if(i == 0) {
                start = section[i];
                end = start+m-1;
                se[0] = start;
                se[1] = end;
                System.out.println("start "+end+" section "+section[i]);
                System.out.println("end "+end+" section "+section[i]);
                line.add(se);
            } else if (end < section[i]) {
                System.out.println("end "+end+" section "+section[i]);
                start = section[i];
                end = start+m-1;
                se[0] = section[i];
                se[1] = section[i]+m;

                line.add(se);
            }


        }

        for (int[] a : line) {
            System.out.println(Arrays.toString(a));
        }

        return answer;
    }

}
