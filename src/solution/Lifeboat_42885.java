package solution;

import java.util.*;
import java.util.stream.Collectors;


public class Lifeboat_42885 {
    public static void main(String[] args) {
        Lifeboat_42885 m = new Lifeboat_42885();
        //제일 무거운 사람이 제일 가벼운 사람과 타지 못하면
        //혼자 타야함, 2명밖에 못 탄다.
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
//        //오름차순 선착장에 남아 있는 사람
//        Arrays.sort(people);
//        List<Integer> sortedPeople = Arrays.stream(people).boxed().collect(Collectors.toList());
        //내림차순 먼저 태울 무거운 사람
        List<Integer> reversSortedPeople = Arrays.stream(people).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());


        List<List<Integer>> boatList = new ArrayList<>();


        for (int i =0; i< reversSortedPeople.size(); i++) {
            List<Integer> boat = new ArrayList<>();

            int remain = limit - reversSortedPeople.get(i);
            boat.add(reversSortedPeople.get(i));
            reversSortedPeople.remove(i);

            int idx = reversSortedPeople.size()-1;
            int person = reversSortedPeople.get(idx);

            if(remain == person) {
                boat.add(reversSortedPeople.get(idx));
                System.out.println(reversSortedPeople.remove(idx));
            } else if (remain < person && idx == 0) {
                boat.add(reversSortedPeople.get(idx));
            }
            System.out.println(boat);

            boatList.add(boat);
            System.out.println(" ##"+reversSortedPeople);
            System.out.println("person "+person);
        }

        return boatList.size();
    }
}
