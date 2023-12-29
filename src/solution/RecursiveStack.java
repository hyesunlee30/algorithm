package solution;

public class RecursiveStack {
    public static void main(String[] args) {
        //재귀함수를 이용하여 N까지 출력하기
        RecursiveStack rs = new RecursiveStack();
        rs.DFS(3);
        //re.DFS(3)을 호출할 시에 Stack프레임이 하나 생긴다.
        // 거기엔 매개변수와 지역변수, 복귀 주소 현재 18라인
    }

    public void DFS(int n) {

        if(n == 0) {
            return;
        }
        //System.out.println(n);
        DFS(n-1);
        System.out.println(n);
        //System.out.println(n);

    }
}
