package solution;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class DontLikeSameNumbers_12906 {
    public static void main(String[] args) {
        DontLikeSameNumbers_12906 s = new DontLikeSameNumbers_12906();
        //연속적으로
        int [] arr = {1,1,3,3,0,1,1};
        //[1,3,0,1]

        System.out.println(Arrays.toString(s.solution(arr)));
    }

    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                stack.push(arr[i]);
            } else if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        int idx = stack.size()-1;
        while (!stack.isEmpty()) {
            answer[idx] = stack.pop();
            idx--;
        }

        return answer;
    }

}
