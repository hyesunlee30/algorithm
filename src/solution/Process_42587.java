package solution;

import java.util.*;

public class Process_42587 {
    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42587

        Process_42587 s = new Process_42587();


        // 4개 [0, 1, 2, 3] 서대로 행 대기 큐에 들어있고, 우선순위가 [2, 1, 3, 2]라면 [2, 3, 0, 1] 순으로 실행하게 됩니다.
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2 ;
//        //2
//        System.out.println(s.solution(priorities,location));


//
//        int[] priorities = { 1, 1, 9, 1, 1, 1};
//        int location = 0;
//
//        //5
//        System.out.println("답 "+s.solution(priorities,location));

//        int[] priorities = {2, 1, 2, 1, 2, 1, 2, 1, 2};
//        int location = 1;
//
//        //6
//        System.out.println("답 "+s.solution(priorities,location));

        int[] priorities = {5, 4, 3, 2, 1};
        int location = 4;

        //5
        System.out.println("답 "+s.solution(priorities,location));

    }

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        Queue<Process> processes = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Process pro = new Process(i, priorities[i]);
            processes.offer(pro);
            priorityQueue.offer(priorities[i]);
        }

        int max = priorityQueue.poll();
        int answer = 0;
        while (!processes.isEmpty()) {

            //실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
            Process now = processes.poll();

            System.out.println("현제 process ");
            System.out.println(processes.toString());
            if(max > now.getPriority()) {
                //큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
                processes.offer(now);
            } else if(max == now.getPriority()) {

                //큐에 대기중인 프로세스 중 우선순위가 같으면, 실행하고 프로세스에 넣지 않습니다.
                //max 값을 바꾸고 시작합니다.
                //max 값이 있을 경우에면 뽑습니다.
                if(!priorityQueue.isEmpty()) {
                    max = priorityQueue.poll();
                }

                answer++;

                if(now.name == location) {
                    break;
                }

                System.out.println("우선순위 max "+max);
                System.out.println("answer "+answer);
            }

        }


        return answer;
    }
}
class Process {
    int name;
    int priorities;

    Process(int name, int priorities) {
        this.name = name;
        this.priorities = priorities;
    }

    int getName(){
        return this.name;
    }

    int getPriority(){
        return this.priorities;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name=" + name +
                ", priorities=" + priorities +
                '}';
    }
}