package solution;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Permutation {


    static int n, m;
    static int[] arr, pm, ch;

    public void DFS(int L) {

        if(L == m) {
            for(int i = 0; i<pm.length; i++) {
                System.out.print(pm[i]+" ");
            }
            System.out.println();
        } else {
            for(int i = 0; i<arr.length; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        //10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다
        //중복을 허용하지 않습니다.

        Permutation T = new Permutation();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        ch = new int[n];
        pm = new int[m];

        T.DFS(0);

    }
}
