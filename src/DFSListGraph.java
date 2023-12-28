import java.util.ArrayList;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> adjList; // 인정리스트
    static boolean[] visited;
    public static void main(String[] args) {
//        //단방향에 대해 생각해보자
//        //dfs 0->1->3->2->4
//        //bfs 0->1->2->3
//        //0,1
//        //0,2
//        //1,3
//        //2,3
//        //2,4
//
//        //이중리스트를 만들어봅시다
//        //0이 갈 수 있는 곳은 1, 2
//        //1이 갈 수 있는 곳은 3
//        //2가 갈 수 있는 곳은 3, 4
//        List<List<Integer>> myList = new ArrayList<>();
//        myList.get(0).add(1);
//        myList.get(0).add(2);
//        myList.get(1).add(3);
//        myList.get(2).add(3);
//        myList.get(2).add(4);
//        //전체노드개수 5 N
//        int N = 5;
//        for(int i = 0; i < N; i++) {
//            myList.add(new ArrayList<>());
//        }
//        //-- 단방향이었는데
//        ///-- 양방향은 이렇게 양방향으로 만들 수 있다.
//        myList.get(0).add(1);
//        myList.get(1).add(0);

        // 배열이 아니라 리스트를 순회하는데
        // 리스트에 일단 다 넣어놓고 순회하면 된다.
        int[][] inputArr = {{0,1},{0,2},{1,3},{2,3},{2,4}};
        int node_n = 5;
        visited = new boolean[node_n];
        adjList = new ArrayList<>();

        for(int i = 0; i<node_n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : inputArr) {
            addEdge(a[0],a[1]);
        }
        dfs(0);
    }

    //양방향으로 만들기 위해 메소드
    //a 출발지
    //b 도착지
    static void addEdge(int a, int b) {
        adjList.get(a).add(b); // 단방향
        adjList.get(b).add(a); // 양방향
    }

    static void dfs(int start) {
        System.out.print(start+", ");
        for (Integer target : adjList.get(start)) {
            visited[start] = true;
            if(visited[target]==false) {
                visited[target] = true;
                dfs(target);
            }
        }

    }
}
