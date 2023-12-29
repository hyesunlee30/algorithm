package solution;

import java.util.*;

public class array {
    public static void main(String[] args) {
        String [] park = {"OSO","OOO","OXO","OOO"};
        String [] routes = {"E 2","S 3","W 1"};

        int[] answer = solution(park, routes);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(String[] park, String[] routes) {

        int[] answer = new int[2];

        String[][] p = new String[park.length][park.length];
        for (int i = 0; i < park.length; i++) {
            String a = park[i];
            for (int j = 0; j<a.length(); j++) {
                p[i][j] = Character.toString(a.charAt(j));
                if(p[i][j].equals("S")) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        int i = answer[0];
        int j = answer[1];

//        //s 시작지점
//        //o 이동 가능한 통로
//        //x 장애물
//        // n + i, s i-, w j-, e j+
//
//        if (nswe.equals("N")) {
//            boolean check = true;
//            int temp = i-count;
//            if (temp < 0 ) {
//                continue;
//            }
//            for (int d = i; d < count; d++) {
//                if(p[i-d][j]==null||p[i-d][j].equals("X")) {
//                    check = false;
//                }
//            }
//
//            if(check) {
//                i = temp;
//            }
//        }
//        else if (nswe.equals("S")) {
//            int temp1 = i + count;
//
//            boolean check = true;
//            if (temp1 < 0 ) {
//                continue;
//            }
//
//            if(check) {
//                i = temp1;
//            }
//
//        }
//        else if (nswe.equals("W")) {
//            int temp2 = j-count;
//
//            if (temp2 < 0 ) {
//                continue;
//            }
//            if(p[i][temp2]!= null && p[i][temp2].equals("O")) {
//
//                j = temp2;
//            }
//
//        }
//        else {
//            int temp3 = j + count;
//
//            if (temp3 < 0 ) {
//                continue;
//            }
//            if (p[i][temp3] != null && p[i][temp3].equals("O")) {
//
//                j = temp3;
//            }
//
//        }
//
//        System.out.println("nswe "+nswe+" i "+i+" j "+j);


        answer[0] = i;
        answer[1] = j;

        return answer;
    }
}
