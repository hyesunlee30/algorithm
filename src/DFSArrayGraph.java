public class DFSArrayGraph {
    static  boolean[] visited;
    static int[][] static_graph;
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}};

        static_graph = graph;
        //순열조합이랑 다르다.
        //for문을 돌리되 첫번째 배열을 돌려서 1이 나오면 바로 재귀 그 다음 for문 돌려야 한다.
        //양방향으로 갈 수 있으니까 다 가는데
        //단반향이면 다를 수도 있다는 걸 이해해야한다.
        visited = new boolean[graph.length];
        dfs(0);
    }
    static void dfs(int start) {
        System.out.print(start+", ");
        visited[start]=true;
        for(int i = 0; i <static_graph[start].length; i++) {
            if(visited[i]==false && static_graph[start][i]==1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
