package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {

    public int solution (int n, int m, int[]arr){
        int answer = 0;

        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;

        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid] == m) {
                //index라서 0부터 시작해서 1 더해줘야함 번째는
                answer = mid+1;
                return answer;
            }

            if (arr[mid] > m) {
                rt = mid-1;

            } else {
                lt= mid+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        //이분 검색은 일단 정렬되어 있어야 한다.

        BinarySearch T = new BinarySearch();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        System.out.println(T.solution(n,m,arr));

        // 8 32
        //23 87 65 12 57 32 99 81

    }
}
