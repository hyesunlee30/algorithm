package solution;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheCalf {
    int[] dis = {1,-1,5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size(); // NODE 뽑기, 레벨마다 노드 수 만큼 들어가 있다.
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j =0; j <3; j++) {
                    int nx = x + dis[j];
                    if(nx==e) {
                        return L+1;
                    }
                    if(nx>=1 && nx <=10000 && ch[nx]==0) {
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        FindTheCalf t = new FindTheCalf();
        int s = 5;
        int e = 14;
        System.out.println(t.BFS(s,e));
    }
}
