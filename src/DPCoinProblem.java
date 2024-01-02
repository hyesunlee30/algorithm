import java.util.Arrays;

public class DPCoinProblem {
    public static void main(String[] args) {
        //f(n) = f(n-1) + f(n-2) 피보나치
        //f(n) = n-1 + n-2 , 계단 오르기의 경우의 수 한 번에 1칸이나 2칸을 갈 수 있다.
        // 경우의 수를 다담으면 되는데, 중복이 발생함.
        // 배열을 칸의 수로 만들어 놓고
        //1,2,3,5,8,13



        //1, 4, 5 동전이 있을때
        //13원이 되게 하는 최소의 동전의 개수
        //탐욕법 5개
        //DP 3개
        //12원이 되게 하는 동전수 , 9원 동전수, 8원 동전수
        //최종답 3개
        // 식 f(n) = min(f(n-a): for a in coins) +1
        //일반 for문 : 메모제이션 : new int[amount+1]

        int[] coins = {1,4,5};
        int amount = 13;
        //최소동전의 개수 산출
        int answer = 0;
        int[] arr = new int [amount+1];
        arr[1] = 1;
        for(int i = 2; i <=amount; i++) {
            int min = amount;
            for(int c : coins) {
                if(i-c<0) { // 0을 제끼고 가면 문제가 된다. 코인이 일단 0이다라는 가정으로 시작.
                    continue;
                }
                if(min > arr[i-c]) {
                    min = arr[i-c];
                }
            }
            arr[i] = min +1;
        }
        System.out.println(arr[13]);

    }
}
