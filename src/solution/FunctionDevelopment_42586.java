package solution;

import java.util.*;

public class FunctionDevelopment_42586 {
    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42586
        FunctionDevelopment_42586 s = new FunctionDevelopment_42586();
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
//        //[2,1]
//        System.out.println(Arrays.toString(s.solution(progresses, speeds)));
//
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
//        //[1, 3, 2]
//        System.out.println(Arrays.toString(s.solution(progresses, speeds)));
//
//        int[] progresses = {90, 98, 97, 96, 98};
//        int[] speeds = {1, 1, 1, 1, 1};
//        //[5]
//        System.out.println(Arrays.toString(s.solution(progresses, speeds)));


        int[] progresses = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] speeds = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //[10]
        System.out.println(Arrays.toString(s.solution(progresses, speeds)));

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int limit = 100;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<progresses.length; i++) {
            int remain = limit - progresses[i];
            double a = (double) remain / (double) speeds[i];
            int day = (int) Math.ceil(a);
            queue.add(day);
        }

        List<Integer> list = new ArrayList<>();

        int cnt = 1;
        int max = 0;
        while (!queue.isEmpty()) {

            int now = queue.poll();
            System.out.println("now "+now);
            if(max <now) {
                max = now;
            }
            System.out.println("max "+max);
            if(queue.isEmpty()) {
                list.add(cnt);
                break;
            }
            int next = queue.peek();
            System.out.println("next "+next);
            System.out.println("cnt "+cnt);
            //뽑은 값이 뒤에 오는 값보다 클때
            if(now <= next && max < next) {
                list.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }

        int[] answer = list.stream().mapToInt(a->a.intValue()).toArray();


        return answer;
    }
}
