import java.util.Arrays;

public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1,5,10,25}; //
        int amount = 99;
        //최소 동전의 개수 산출
        Arrays.sort(coins);
        int answer = 0;
        for (int i = coins.length-1; i >= 0; i--) {
            int temp = amount / coins[i];
            answer += temp;
            amount -= temp * coins[i];

        }
        System.out.println(answer);
    }
}
