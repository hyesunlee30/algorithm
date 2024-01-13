package solution;

import java.util.*;
import java.util.stream.Collectors;


public class Lifeboat_42885 {
    public static void main(String[] args) {
        Lifeboat_42885 m = new Lifeboat_42885();

        //100 - 큰값 빼고 남은 값을 서칭해야한다
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
        int answer = 0;

        Arrays.sort(people);


        int start = 0;
        int end = people.length-1;
        int boatCount = 0;
        for (int i =0; i < people.length; i++) {
            if(start <= end) {
                if (limit >= people[start]+people[end]) {
                    start++;
                }
                end--;
                boatCount++;
            } else {
                break;

            }

        }


        return boatCount;
    }
}
