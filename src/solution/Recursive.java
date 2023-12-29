package solution;

import java.util.Stack;

public class Recursive {
    static int[] combi;
    static int n;
    static int m;
    static Stack<Integer> stack = new Stack<>();
    public void DFS(int L, int s) {

        if(L==m){
            for(int x: combi) {
                System.out.println(x+" ");
            }
            System.out.println();
        } else {
            for(int i=s; i<=n; i++) {
                stack.push(i);
                System.out.println("stack push "+stack);
                combi[L] = i;
                DFS(L+1, i+1);

                System.out.println("stack pop "+stack.pop());
            }
        }
    }

    public static void main(String[] args) {

        Recursive r = new Recursive();
        n = 4; // 4개 중에
        m = 3; // 2번 뽑는다
        combi = new int[m];

        r.DFS(0, 1); // 첫번째노드 호출, 첫번째 가지 탐색

    }
}
