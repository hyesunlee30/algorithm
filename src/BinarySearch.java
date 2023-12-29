import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        //정렬이 돼 있어야 이분탐색 가능
        Arrays.sort(arr);

        int find = 12;

        int start = 0;

        int end = arr.length -1;
        int index = 0;
        while(true) {
            int middle = (start+end)/2;
            if(start > end) break;
            System.out.println(middle);
            if(arr[middle] == find) {
                index = middle;
                break;
            }
            if(arr[middle] > find) {
                end = middle-1;
            }
            if(arr[middle] < find) {
                start = middle+1;
            }
        }
        System.out.println(index);

    }
}
