package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPrimeNumbers {
    static String [] visited;
    static int count;

    public int DFS(String numbers) {
        int castNum = Integer.parseInt(numbers);
        boolean check = isPrime(castNum);
        if(castNum !=0 && castNum !=1 && check) {
            System.out.println(castNum);
        }
        String[] n = numbers.split("");
        StringBuilder temp = new StringBuilder();
        //소수 1과 나 자신외에는 나눠지지 않는 수
        for(int i = 0; i<n.length; i++) {
            if(visited[i] == null) {
                visited[i] = n[i];
                temp.append(n[i]);
                DFS(temp.toString());
                temp.replace(temp.length()-1,temp.length(),"");
                visited[i] = null;
            }
        }

        return 0;
    }

    boolean isPrime(int castNum) {
        boolean res = castNum != 1;
        for (int i = 2; i*i<=castNum; i++) {
            if(castNum % i == 0) {
                res = false;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        count = 0;
        String numbers = "17";
        visited = new String[numbers.length()];
        FindPrimeNumbers f = new FindPrimeNumbers();

        f.DFS(numbers);

    }
}
