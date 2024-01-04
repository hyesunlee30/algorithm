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
        int n = 6;
        int[] times = {7, 10};

        //28
        System.out.println(p.solution(n, times));

    }

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        int start = 1;
        int end = n * times[times.length-1];
        int middle = (start+ end) / 2;
        int count = 0;
        for(int i = start; i <= end; i++) {
            for(int j = 0; j<times.length; j++) {
                if(i%times[j] == 0) {
                    count++;
                    System.out.println("times[j] "+times[j]+" i "+i);
                }
            }
            if( count == n ) {
                answer = Long.valueOf(i);
                break;
            }
        }

        return answer;
    }
}