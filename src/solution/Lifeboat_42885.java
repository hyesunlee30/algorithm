package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lifeboat_42885 {
    public static void main(String[] args) {
        Lifeboat_42885 m = new Lifeboat_42885();
//        int [] people = {70, 50, 80, 50};
//        int limit = 100;
//        //3
//        System.out.println(m.solution(people,limit));
        int [] people = {70, 80, 50};
        int limit = 100;
        //3
        System.out.println(m.solution(people,limit));
    }
    public int solution(int[] people, int limit) {

        int answer = people.length;
        Arrays.sort(people);

        Queue queue = new LinkedList();
        for (int i = 0; i < people.length; i++) {


            queue.add(people[i]);


        }
        return answer;
    }
}
