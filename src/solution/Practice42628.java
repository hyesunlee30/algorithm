package solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class Practice42628 {
    public static void main(String[] args) {
        //I 삽입
        //D 1 최댓값 삭제
        //D -1 최솟값 삭제
        Practice42628 p = new Practice42628();
        //[0,0]
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(p.solution(operations)));
    }

    public int[] solution(String[] operations) {

        //treemap으로 풀어보기.

        int [] answer = new int[2];


        return answer;
    }

    public int[] solution1(String[] operations) {

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<operations.length; i++) {

            String[] arr = operations[i].split(" ");
            String method = arr[0];
            String value = arr[1];

            if(Objects.equals(method, "I")) {
                pq1.add(Integer.valueOf(value));
                pq2.add(Integer.valueOf(value));
            } else if(method.equals("D") && value.equals("-1")) {
                Integer min = pq1.poll();
                pq2.remove(min);
            } else {
                Integer max = pq2.poll();
                pq1.remove(max);
            }
        }
        int [] answer = new int[2];
        if(!pq1.isEmpty()) {
            answer[0] = pq2.poll();
            answer[1] = pq1.poll();
        }

        return answer;
    }
}
