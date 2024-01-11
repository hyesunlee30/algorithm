package solution;

import java.util.*;
import java.util.stream.Collectors;

public class Lifeboat_42885 {
    public static void main(String[] args) {
        Lifeboat_42885 m = new Lifeboat_42885();
//        int [] people = {70, 50, 80, 50};
//        int limit = 100;
//        //3
//        System.out.println(m.solution(people,limit));
//        int [] people = {70, 80, 50};
//        int limit = 100;
//        //3
//        System.out.println(m.solution(people,limit));
        int [] people = {20,30,40,30,70, 80, 50};
        int limit = 100;
        //3
        System.out.println(m.solution(people,limit));

    }
    public int solution(int[] people, int limit) {

        int answer = 0;
//        //오름차순 선착장에 남아 있는 사람
//        Arrays.sort(people);
//        List<Integer> sortedPeople = Arrays.stream(people).boxed().collect(Collectors.toList());
        //내림차순 먼저 태울 사람
        List<Integer> reversSortedPeople = Arrays.stream(people).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<Queue<Integer>> boatList = new ArrayList<>();
        int idx = 0;
        while (!reversSortedPeople.isEmpty()){
            PriorityQueue<Integer> boat = new PriorityQueue<>();
            boat.add(reversSortedPeople.get(idx)); //먼저 태우기
            System.out.println(" "+reversSortedPeople.get(idx));

            int remainLimit = limit - boat.peek(); // 첫번쨰 탑승자 타고 남은 키로
            System.out.println("remainLimit "+remainLimit);
            List<Queue<Integer>> remainarr = new ArrayList<>();

            boolean[] visited = new boolean[reversSortedPeople.size()];
            visited[idx] = true;
            for (int i = 0; i < reversSortedPeople.size(); i++) {
                if(remainLimit >= reversSortedPeople.get(i) && !visited[i]) {
                    visited[i] = true;
                }
            }
            reversSortedPeople.remove(idx); // 0번째 삭제


            boatList.add(boat);
            System.out.println("remainarr "+boatList);
            for (Integer i : boat) {
                reversSortedPeople.remove(i);
            }


        }

        answer = boatList.size();
        return answer;
    }
}
