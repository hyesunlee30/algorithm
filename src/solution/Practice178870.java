package solution;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Practice178870 {
    public static void main(String[] args) {
        //비내림차순으로 정렬된 수열

        //슬라이딩 윈도우(Sliding Window)
        //길이가 짧은 수열
        Practice178870 p = new Practice178870();

//        int[] sequence = {1, 2, 3, 4, 5};
//        int k = 7;
//        //[2, 3]
//
//        System.out.println(Arrays.toString(p.solution(sequence, k)));

//        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
//        int k = 5;
//        //[6, 6]
//        //p.solution(sequence, k);
//        System.out.println(Arrays.toString(p.solution(sequence, k)));

        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        //[0, 2]
        //p.solution(sequence, k);
        System.out.println(Arrays.toString(p.solution0(sequence, k)));
    }

    public int[] solution0(int[] sequence, int k) {

        int start = 0;
        int end = 0;
        int sum = sequence[start] + sequence[end];
        int cnt = 0;

        while (end < sequence.length) {

            //[start, end] → [start, end+1] → [start+1, end+1]

            if(sum == k) {
                cnt++;
            } else if (sum < k) {
                sum = sequence[start] + sequence[end+1];
            } else {
                sum = sequence[start+1] + sequence[end];
            }

            System.out.println("start "+start);
            System.out.println("end "+end);
        }

        int[] answer = new int[2];


//        answer[0] = answer1.get(0);
//        answer[1] = answer1.get(answer1.size()-1);

        return answer;
    }

    public int[] solution1(int[] sequence, int k) {

        List<List<Integer>> answer0 = new ArrayList<>();

        for(int i = 0; i<sequence.length; i++) {
            int temp = sequence[i];
            List<Integer> answer1 = new ArrayList<>();
            answer1.add(i);
            if(temp == k) {
                answer1.add(i);
                answer0.add(answer1);
            }

            for(int j = i+1; j<sequence.length; j++) {
                temp= temp + sequence[j];

                if(temp == k) {
                    answer1.add(j);
                    answer0.add(answer1);
                }
                //System.out.println("answer0 "+answer0+"temp "+temp);
            }
        }

        int min = 10000;
        for(int i = 0; i< answer0.size(); i++) {
            int temp = answer0.get(i).get(1) - answer0.get(i).get(0);
            if (min > temp) {
                min = temp;
            }
        }
        int[] answer = new int[2];

        int count = 0 ;
        for(int i = 0; i<answer0.size(); i++) {
            int temp = answer0.get(i).get(1) - answer0.get(i).get(0);
            if(min == temp) {
                if(count > 0) {
                    break;
                }
                answer[0] = answer0.get(i).get(0);
                answer[1] = answer0.get(i).get(1);
                count++;
            }

        }


//
//        answer[0] = answer1.get(0);
//        answer[1] = answer1.get(answer1.size()-1);

        return answer;
    }
}
