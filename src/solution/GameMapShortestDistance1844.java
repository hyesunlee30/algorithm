package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMapShortestDistance1844 {


    static List<List<Integer>> adjList; // 인접리스트
    static boolean[] visited;
    static int[] distance; // 각 노드가 얼마나 떨어져 있는지 담을 것이다.
    public static void main(String[] args) {
        GameMapShortestDistance1844 t = new GameMapShortestDistance1844();
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}};


        t.solution(maps);
    }
    public int solution(int[][] maps) {
        int answer = 0;
        int node_n = maps.length;
        visited = new boolean[node_n]; // node의 갯수만큼 초기화
        adjList = new ArrayList<>();

        for(int i = 0; i<=node_n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        List<XY> xyList = new ArrayList<>();
        for(int i=0; i<node_n; i++){ // 3==(높이길이-행의개수)
            for(int j=0; j<node_n; j++) { //5==(가로길이-열의개수
                if(maps[i][j] == 1) {
                    XY xy = new XY(i,j);
                    xyList.add(xy);
                }
            }
        }
        for (int i = 0; i < xyList.size(); i++) {
            for(int d=0; d<4; d++){
                int target_i = xyList.get(i).x+dx[d];
                int target_j = xyList.get(i).y+dy[d];
                if(target_i>0 && target_i<node_n && target_j>0 && target_j<node_n){
                    List<XY> list = new ArrayList<>();
                    list.add(xyList.get(i));
                    list.add(new XY(target_i,target_j));
                    addEdge(list);
                }
            }
        }

        distance = new int[maps.length];
        //int end = 5;
        //int shortest = bfs(0, end);
        //System.out.println(shortest);
        return answer;
    }

    static void addEdge(List<XY> list) {

//        adjList.get(list.get(0)).add(list.get(1)); // 단방향
//        adjList.get(list.get(1)).add(list.get(0)); // 양방향


    }

}

class XY {
    int x;
    int y;
    XY(int x, int y){
        this.x =x;
        this.y =y;
    }
}
