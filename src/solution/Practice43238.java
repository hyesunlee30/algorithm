package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice43238 {
    public static void main(String[] args) {
        //이진검색은 대상을 어떤 것으로 잡을 것인가 생각해봐야한다.
        // 시간테이블을 놓고 푸는 거다.
        // 가장 오래 걸릴 시간대가 마지막.
        // 절반의 시간에 들어가서 다 처리할 수 있는지 확인,
        // 더 짧아 하면 또 짤라 들어가는 거다.

        Practice43238 p = new Practice43238();
//        int n = 6;
//        int[] times = {7, 10};
//
//        //28
//        System.out.println(p.solution(n, times));

//        int n = 59;
//        int [] times={1,1};
//        //30
//        System.out.println(p.solution(n, times));

        //solution(6, [6,10]) : 24
//        int n = 6;
//        int[] times = {6,10};
//        System.out.println(p.solution(n, times));

        //solution(6, [8,10]) : 30
//        int n = 6;
//        int[] times = {8,10};
//
//        System.out.println(p.solution(n, times));

        //solution(6, [4,10]) : 20
//        int n = 6;
//        int[] times = {4,10};
//        System.out.println(p.solution(n, times));

        //solution(11, [3,4,10]) : 18
//        int n = 11;
//        int[] times = {3,4,10};
//        System.out.println(p.solution(n, times));

        //solution(5, [1,1,10]) : 3
//        int n = 5;
//        int[] times = {1,1,10};
//        System.out.println(p.solution(n, times));

        int n = 7;
        int[] times = {10,10};
        System.out.println(p.solution(n, times));

    }

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = (long)times[times.length-1] * (long)n;
        long middle;

        while (true) {
            long count = 0;
            if(start > end) {
                break;
            }
            middle = (start+ end) / 2;

            for(int j = 0; j <times.length; j++) {
                count += middle/(long)times[j];
            }

            if(count >= n) {
                end = middle-1;
                answer = middle;

            }else if(count < n) {
                start = middle+1;
            }

        }
        return answer;
    }
}
