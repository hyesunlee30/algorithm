package solution;

import java.security.PublicKey;
import java.util.Arrays;

public class Fibonacci {
    static int[] memo;
    public int DFS(int n) {
        if(n==1) { //첫번째 항이면 1 return;
            return 1;
        } else if(n==2) {
            return 1; //두번째 항이면 1 return
        } else {
            return DFS(n-2) + DFS(n-1);
        }

    }
    public int DFSWithMemo(int n) {
        // 0은 초기화된 값으로 0이상이면 이미 구한수
        // 메모리제이션 이미 구한 값은 기억
        if(memo[n] >0) {
            return memo[n];
        }
        if(n==1){
            return memo[n] = 1;
        } else if (n==2) {
            return memo[n] = 1;
        } else {
            return memo[n] = DFSWithMemo(n-2)+DFSWithMemo(n-1);
        }
    }
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int n = 45; //몇 번째 항.
//        System.out.println(f.DFS(n+1));

        memo = new int[n+1];
        f.DFSWithMemo(n);
        System.out.println(Arrays.toString(memo));
    }
}
