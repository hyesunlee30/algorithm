package solution;

import java.util.*;

public class practice1845 {
    public static void main(String[] args) {


        //해시
        //요구사항
        //총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다
        //중복이 있을 수 있다, 중복을 피해라
        //최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
        //N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
        //N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
        //그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
        //4마리의 폰켓몬 중 2마리를 고르는 방법
        //폰켓몬 종류 수의 최댓값은 2
        //nums.length / 2
        //key 종류, value 코드
        //hash.length / 2 = 최댓값.
        int[] nums = {3,1,2,3};
        //2
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        if(set.size() > answer) {
            answer = set.size();
        }
        return answer;
    }
}
