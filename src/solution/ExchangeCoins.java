package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExchangeCoins {

    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, int[] arr) {

        if(sum > m) { // 거스름돈이 m이기 때문에 sum 금액이 m 보다 크면 무조건 끝 무한 루프 방지
            return;
        }

        if(sum == m) { // sum이 거슬러 줄 동전이 됐을 때 answer와 L (횟수) 중 더 작은 수를 answer
            answer = Math.min(L, answer); //
        } else {
            for (int i =0; i<n; i++) {
                DFS(L+1, sum+arr[i], arr);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        // 다음과 같이 여러 단위의 동전들이 주어져 있을때
        // 거스롬돈을 가장 적은 수의 동전으로 교환해주려면
        // 어떻게 주면 되는가?
        // 각 단위의 동전은 무한정 쓸 수 있다.>
        // 첫 번째 줄 동전의 종류 개수 N(1<=N<=12)
        // 두 번째 줄 N개의 동전의 종류가 주어지고
        // 각 동전의 종류는 100원을 넘지 않는다
        // 중복 순열 문제와 유사하다
        // 3
        // 1 2 5
        // 15
        // 출력예제 3

        ExchangeCoins T = new ExchangeCoins();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        T.DFS(0, 0, arr);

        System.out.println(answer);

    }

}
