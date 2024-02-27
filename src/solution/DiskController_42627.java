package solution;

import java.util.PriorityQueue;

public class DiskController_42627 {
    public static void main(String[] args) {
        //heap
        //https://school.programmers.co.kr/learn/courses/30/lessons/42627
        //이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
        //
        //각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
        // 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록
        // solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
        //0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
        //1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
        //2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
        DiskController_42627 c = new DiskController_42627();
        int[][] jobs ={{0, 3}, {1, 9}, {2, 6}};
        System.out.println(c.solution(jobs));
    }

    public int solution(int[][] jobs) {

        PriorityQueue<Job> pq = new PriorityQueue<>();
        for (int i = 0; i< jobs.length; i++) {
            Job job = new Job(jobs[i][0],jobs[i][1]);
            pq.offer(job);
        }


        while (!pq.isEmpty()){

            Job nowJobPeek = pq.peek();
            Job nowJobPoll = pq.peek();
            System.out.println(" >> "+nowJobPeek);


        }

        int answer = 0;
        return answer;
    }

}

class Job implements Comparable<Job>{
    int start;
    int time;

    Job(int start, int time){
        this.start = start;
        this.time = time;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int compareTo(Job o) {
        return Integer.compare(this.getTime(), o.getTime());
    }

    @Override
    public String toString() {
        return "Job{" +
                "start=" + start +
                ", time=" + time +
                '}';
    }
}
