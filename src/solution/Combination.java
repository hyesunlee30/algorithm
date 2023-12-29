package solution;

public class Combination {
    static int[] combi;
    static int n;
    static int m;
    public void DFS(int L, int s) {
        if(L==m) {
            for(int x : combi) {
                System.out.println(x+" ");
            }
            System.out.println();
        } else {
            for(int i =s; i<=n; i++) {
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }

    }
    public static void main(String[] args) {
        //조합구하기
        Combination combination = new Combination();
        n = 4;
        m = 2;
        combi = new int[m]; // 2
        combination.DFS(0,1); // s=1 , 1부터 시갖
    }
}
