package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice_42584 {
    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42584
        //가격이 떨어지지 않은 기간

        //애초에 시작위치에서 그 이후로 한번이라도 떨어졌으면 그 다음에는 계산할 필요가 없습니다.
        StockPrice_42584 c = new StockPrice_42584();
//        int[] prices = {1, 2, 3, 2, 3};
//        //[4, 3, 1, 1, 0]
//        System.out.println(Arrays.toString(c.solution(prices)));
//        int[] prices = {5,4,3,2,5};
//        //1,1,1,1,0
//        System.out.println(Arrays.toString(c.solution(prices)));
        //[5, 8, 6, 2, 4, 1] [3, 1, 1, 2, 1, 0]
//        int[] prices = {5, 8, 6, 2, 4, 1};
//        //3, 1, 1, 2, 1, 0
//        System.out.println(Arrays.toString(c.solution(prices)));
//        int[] prices = {3, 1};
//        //1, 0
//        System.out.println(Arrays.toString(c.solution(prices)));
        int[] prices = {4, 5, 1, 2, 6, 1, 1};
        //2,1,4,2,1,1,0
        System.out.println(Arrays.toString(c.solution(prices)));
    }

    public int[] solution(int[] prices) {

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i< prices.length; i++) {
            queue.offer(prices[i]);
        }
        int[] answer = new int[prices.length];
        int idx = 0;
        int idx2 = 0;

        while (!queue.isEmpty()) {
            int nowPrice = queue.poll();
            int cnt = 0;
            idx++;
            for (int i = idx; i<prices.length; i++) {

                if (nowPrice > prices[i]) {
                    cnt++;
                    break;
                } else if(nowPrice <= prices[i]) {
                    cnt++;
                    System.out.println("nowPrice "+nowPrice+" prices[i] "+prices[i]);
                }
            }

            answer[idx2] = cnt;
            idx2++;

        }

        return answer;
    }

}
