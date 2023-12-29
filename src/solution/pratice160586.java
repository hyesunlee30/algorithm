package solution;

import java.util.*;

public class pratice160586 {
    public static void main(String[] args) {
        pratice160586 p = new pratice160586();
        //요구사항
        //1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과
        //입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때,
        //각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아
        //단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        System.out.println(Arrays.toString(p.solution(keymap, targets)));
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int count2 = 0;

        HashMap<String,Integer> map = new HashMap();
        for (int i = 0; i < targets.length; i++) {
            String[] t = targets[i].split("");
            for (int j = 0; j < t.length; j++) {

                map.put(t[i], i);
            }
        }

        return answer;
    }
}
