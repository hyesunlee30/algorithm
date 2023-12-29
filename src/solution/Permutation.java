package solution;

import java.util.Scanner;

public class Permutation {
    static int[] pm; // 순열을 담을 배열
    static int[] ch; // 체크하는 배열
    static int[] arr; // 입력된 배열
    static int n; //N개의 자연수
    static int m; // M개를 뽑음

    public void DFS(int L) {
        if (L==m) {
            for(int x : pm) { // 순열을 담는 배열
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        //10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다
        //중복을 허용하지 않습니다.

        Permutation p = new Permutation();
        n = 3;
        m = 2;
        arr = new int[n]; // 입력된 배열
        arr[0] = 3;
        arr[1] = 6;
        arr[2] = 9;
        ch = new int[n]; // 체크 배열
        pm = new int[m]; //
        p.DFS(0);

    }
}
