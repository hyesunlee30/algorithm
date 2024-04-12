package solution;

import java.util.ArrayList;

public class RouteSearchAdjacencyList {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v) {
        if(v==n) answer++;
        else{
            for(int nv : graph.get(v)){
                if(ch[nv]==0) {
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        RouteSearchAdjacencyList T = new RouteSearchAdjacencyList();
        graph = new ArrayList<ArrayList<Integer>>();
        n = 5;
        m = 9;
        for (int i =0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //1,2
        //1,3
        //1,4
        //2,1
        //2.3
        //2,5
        //3,4
        //4,2
        //4,5
        // -- 6

        ch=new int[n+1];
        for(int i=0; i<m; i++) {
            int a = 0;
            int b = 0;
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }
}
