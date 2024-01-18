package solution;

import java.util.*;

public class FunctionDevelopment_42586 {
    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42586
        FunctionDevelopment_42586 s = new FunctionDevelopment_42586();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        //[2,1]
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
        while (!queue.isEmpty()) {

            int q = queue.poll();
            if(q < queue.peek()) {
                queue.poll();
                cnt++;
                list.add(cnt);
            }

        }

        int[] answer = list.stream().mapToInt(a->a.intValue()).toArray();


        return answer;
    }
}
