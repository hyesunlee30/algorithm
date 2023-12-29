import java.util.*;

public class BFSListGraph {
    static List<List<Integer>> adjList; // 인접리스트
    static boolean[] visited;
    static int[] distance; // 각 노드가 얼마나 떨어져 있는지 담을 것이다.
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

        //BFS 거리문제, 미로, 길찾기 -> list에 담기(노드번호를 생성)
        // 배열이 아니라 리스트를 순회하는데
        // 리스트에 일단 다 넣어놓고 순회하면 된다.
        // queue 를 활용해야한다.

        int[][] inputArr = {{0,1},{0,2},{1,3},{2,3},{2,4}};
        int node_n = 5;
        visited = new boolean[node_n]; // node의 갯수만큼 초기화
        adjList = new ArrayList<>();

        for(int i = 0; i<node_n; i++) {
            adjList.add(new ArrayList<>());
        }
//        int[] dx = {-1,1,0,0};
//        int[] dy = {0,0,-1,1};
//        for (int i = 0; i < inputArr.length; i++) {
//            for (int j = 0; j< inputArr[i].length; j++) {
//                for(int d = 0; d< 4; d++) {
//                    int target_i = i+dx[d];
//                    int target_j = i+dy[d];
//                    if(target_i >= inputArr.length-1 && target_i< 2 && target_j >= inputArr.length-1 && target_j<2) {
//                        addEdge((i)*5+j, (target_i)*5+target_j);
//                    }
//                }
//            }
//        }


        for(int[]a : inputArr) {
            addEdge(a[0], a[1]);
        }



        //가장 먼 곳은 어디인가
        //가장 가까운 곳은 어디인가
        // 거리를 구하는데 있어 유리한지 이해해야한다.

        //이건 너무 쉬운 상황
        //bfs(0);
        // node 의 갯수만큼 초기화 0부터 1씩 증가하는 것임. 직전의 노드를 기준으로 거리를 넣어준다.
        distance = new int[node_n];
        int shortest = bfs(0, 3);
        //System.out.println("distance "+Arrays.toString(distance));
        System.out.println(shortest);

    }

    //방문의 순서가, 노드의 깊이의 순차적으로 이뤄진다는 것이다.
    //그렇게 됐을때 얼마만큼 떨어져 있는지 계산하기에 용이하다.
    //idea
    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 시작하자마자 방금 방문한 노드는 true, 1회성 코드 그 뒤로는 while문에서 논다
        while (!queue.isEmpty()) {
            int next = queue.poll();
            //System.out.println(next+" ");
            for(int target:adjList.get(next)) { // A에서 갈 수 있는 곳들은 꺼낸다.
                if(!visited[target]) { // add 하기 전에 체크한다. 안 하면 큐에 중복으로 담기기 때문이다.
                    queue.add(target); // 어디로 가는지 queue에 add 한다. 방문 예정인 곳드
                    //이부분을 이해해야함 직전의 distance 에다가 +1를 해서 셋팅해야한다.
                    distance[target] = distance[next]+1;
                    visited[target] = true; // 갈 거니까 ture 셋팅
                    if(target == end) {
                        return distance[end];
                    }
                }
            }
        }
        return -1;
    }

    //양방향으로 만들기 위해 메소드
    //a 출발지
    //b 도착지
    static void addEdge(int a, int b) {
        adjList.get(a).add(b); // 단방향
        adjList.get(b).add(a); // 양방향
    }
}


//------------------------------------------------------------------------------------------
//이차원 배열인 상황이 어렵다
////여기에 노드 번호를 어떻게 매길지 어떻게 표현할지
//list.get(2).add(3);
//list.get(2).add(6);
//못 갈 경우 막아야 한다. 동서남북
//문제에 따라 번호를 매겨야 하는데 매번 다르다

//        for(int i) {
//            for(int j) {
//                //노드번호 계산후 addEdge(출발지, 타겟)
//                //print(노드번호) : i-1*열의개수+j
//                //아래 양 옆
//            }
//        }
//
//                int[][] arr = new int[4][6];
//                //arr[i].length 열의 갯수
//        //        for (int i = 0; i < arr.length; i++) {
//        //            for(int j = 0; j < arr[i].length; j++) {
//        //                arr[i][j] = i*arr[i].length+ j + 1;
//        //            }
//        //        }
//                //1,1로 시작하면 편하다
//                for (int i = 1; i <=3; i++) {
//                    for(int j = 1; j <=5; j++) {
//                        //1)번호표현식
//                        //5는  열의 갯수
//                        arr[i][j] = (i-1)*5+ j;
//                        //2)타겟의 번호와 타겟의 유효성(2)
//                        //addEdgE(2,3); -- 시작점과 도착지
//                        //addEdgE(2,7);
//                        //2-1) 타겟의 번호
//                        //(i-1)*5+ j+1; // 오른쪽
//                        //(i-1)*5+ j-1; // 왼쪽
//                        //(i-1-1)*5+ j; // 위
//                        //(i-1+1)*5+ j; // 아래
//                        //2-2) 타겟의 유효성 갈 수 있는지
//                        //좌표 i와 j가 0을 넘어가면 안되고 j가 length를 넘어서면 안됨.
//                        //장애물이 있으면 안됨
//                        //if문 4개 들어가야 한다.
//                        //상하좌우 체크 로직
//                        //위쪽에 유효성체크
//                        //(1,1) 로 시작했을때
//                        if(i-1>= 1) {
//                        }
//                        //아래쪽
//                        if(i+1 <= arr.length) {
//                        }
//                        //왼쪽
//                        if(j-1 >=1) {
//                        }
//                        //오른쪽
//                        if(j+1 <= arr[i].length) {
//                        }
//                        //if문 4개를 줄인 코드
//                        int[] dx = {-1,1,0,0};
//                        int[] dy = {0,0,-1,1};
//                        for(int d = 0; d< 4; d++) {
//                            int target_i = i+dx[d];
//                            int target_j = i+dy[d];
//                            if(target_i >= arr.length && target_i<= arr[i].length && target_j >= arr.length && target_j<=arr[i].length) {
//                                addEdge((i-1)*5+j, (target_i-1)*5+target_j);
//                            }
//                        }
//                    }
//                }
//                 System.out.println(Arrays.deepToString(arr));

