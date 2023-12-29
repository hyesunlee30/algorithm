package solution;

public class RecursiveBinary {

    public void DFS (int n) {
        if(n==0) {
            return;
        }
        DFS(n/2); // 몫을 계속 나눠 들어가야하고
        System.out.println(n%2); // 나머지가 변환된 이진수
    }

    public static void main(String[] args) {
        RecursiveBinary rb = new RecursiveBinary();
        rb.DFS(11);
    }
}
