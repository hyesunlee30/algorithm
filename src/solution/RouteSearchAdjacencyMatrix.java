package solution;

public class RouteSearchAdjacencyMatrix {
    static int n,m, answer=0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        if(v == n) {
            answer++;
        } else {
            for(int i =1; i<=n; i++) {
                //1번 정접에서, 갈 수 있는 정접
                if(graph[v][i] == 1 && ch[i]==0) {
                    ch[i] =1; // 체크
                    DFS(i); // 백트레킹
                    ch[i]=0; // 취소
                }
            }
        }

    }

    public static void main(String[] args) {

        //1번 방문한 노드는 다시 방문 안 하는 것
        //방문한 노드를 check 배열을 만들어 표시
        //i는 1부터 5까지
        //D(1)일때는 1은 자기자신으로 이미 체크
        //i를 DFS로 넘기면 D(2)일때는 1,2,3 번 체크
        //D(3) 4번 체크하고
        //D(4) 5번 체크
        //D(5) if(v==n) answer++; 1,2,3,4,5 종료
        //D(4)로 백하면서 5체크 삭제, D(3)로 백하면서 4체크 삭제 D(2)로 백하면서 3체크 삭제
        //D(2)에서는 1,2 가 체크된 상태고 갈 수 있는 곳은 5이며 D(5) 끝이어서 answer++;
        //D(5)에서 5 체크 해제 해주고 D(2)로 가서 체크 해제해주고 D(1)로 가서
        //D(3)으로 갈 수 있느냐 했을 떄 체크 안되어 있고 갈 수 있다.
        //D(3)에서 D(4)

        RouteSearchAdjacencyMatrix T = new RouteSearchAdjacencyMatrix();
        //1번 정점에서 N번 정점으로 가는 모든 경로의 가지수 출력
        //방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요
        n = 5;
        m = 9;
        graph= new int [n+1][n+1]; //정접 번호
        ch = new int[n+1]; // 체크 번호
        //간선 갯수 만큼
        for(int i=0; i<m; i++) {
            int a = 0;
            int b = 0;
            graph[a][b]=1;
        }
        //출발~ 1번 노드 체크
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);

    }


}
