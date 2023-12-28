import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        int[] arr = {7,6,5,8,3,5,9,1,6};
        int start = arr.length/2-1; //index

//        for (int i = start; i >=0 ; i--) {
//            HeapSort.heapify(arr,i);
//            System.out.println(i);
//            System.out.println(Arrays.toString(arr));
//        }
        int n = arr.length;
        for (int i=n; i>0; i--) {
            int temp = arr[0];
            arr[0]= arr[n-1];
            arr[n-1]=temp;
            n--;
            heapify(arr,n ,0);
        }
        System.out.println(Arrays.toString(arr));



    }
    static void heapify(int[] arr, int n, int root) {             //change가 발생한 부모 index
        int max_index=root;
        int left = root*2+1;
        int right = root * 2 + 2;

        if(left<n && arr[max_index]<arr[left]){
            max_index=left;
        }
        if(right<n && arr[max_index]<arr[right]){
            max_index=right;
        }
        if(max_index!=root){
            int temp= arr[root];
            arr[root]=arr[max_index];
            arr[max_index]=temp;
            heapify(arr,n,max_index);
        }
    }

    //최초 힙구성 이후에
    //root 노드와 마지막 노드 change
    //힙정렬
    //최대힙정렬, 가장 큰 값과 마지막 자리랑 변경
    //또 가장 큰 값이랑 마지막 자리 -1 자리랑 변경
    //또 가장 큰 값이랑 마지막 자리 -2 자리랑 변경

    static void heapifySort(int[]arr, int rootIdx, int cnt) {
        if(rootIdx*2+1 < arr.length && rootIdx*2+2 < arr.length) {
            int left = arr[rootIdx*2+1];
            int right = arr[rootIdx*2+2];
            int root = arr[rootIdx];
            int maxIdx = rootIdx;

            if (root < left && rootIdx!=cnt) {
                maxIdx = rootIdx*2+1;
                System.out.println(root);
                System.out.println(left);

            }
            if (root < right && rootIdx!=cnt) {
                maxIdx = rootIdx*2+2;
                System.out.println(root);
                System.out.println(right);
                System.out.println(Arrays.toString(arr));
            }
            if(maxIdx != rootIdx) {

                int temp = arr[rootIdx];
                arr[rootIdx] = arr[maxIdx];
                arr[maxIdx] = temp;
                heapifySort(arr,maxIdx,0);

            }
        }
    }
}
