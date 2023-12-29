package solution;

import java.util.Arrays;
import java.util.Comparator;

public class practice42746 {
    public static void main(String[] args) {

        int[] numbers = {3, 30, 34, 5, 9};
        //"9534330"
        practice42746 p = new practice42746();

        System.out.println(p.solution(numbers));

    }
    public String solution(int[] numbers) {
        String answer = "";

        // 1. 입력 데이터를 문자열 배열로 초기화 후 변환.
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i<strNumbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 2. Comparator 인터페이스로 정렬 기준을 설정.
        // 예제 입력1에서 6과 10을 생각해보면 o2가 6, o1이 10이 된다. 이를 지속해서 반복.
        Arrays.sort(strNumbers, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        // 3. 모든 문자열을 연결한다.
        answer = String.join("",strNumbers);

        // 4. 입력 데이터가 모두 0인 경우 예외 처리.
        if(strNumbers[0].equals("0")) answer = "0";

        return answer;
    }
}

