package solution;

public class DuplicatePermutations {
    static int[] pm;
    static int n,m;
    public void DFS(int L) { // L로 호출했으니까 0으로 시작
        if(L==m) { // 2번을 뽑아내면 다 뽑은거라 끝.
            for(int x : pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        } else { // 두 가닥이 아니라 n개닥이 뻗기 때문에 for문이 돈다.
            for(int i = 1; i<=n; i++){ //1부터 N까지 번호가 적힌 구슬
                pm[L] = i;
                DFS(L+1); // 3번을 호출한다.
            }
        }
    }
    public static void main(String[] args) {
        //1부터 N까지 번호가 적힌 구슬이 있습니다.
        //이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
        DuplicatePermutations T = new DuplicatePermutations();
        n = 3; // 노드의 수
        m = 2; // M번을 뽑는다.
        pm = new int[m]; //m 크기만큼 뽑아내는 거니까 배열 현재 2
        T.DFS(0); // dfs 호출

    }
}
