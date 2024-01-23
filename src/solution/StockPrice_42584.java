package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice_42584 {
    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42584
        //가격이 떨어지지 않은 기간

        //1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
        //2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
        //3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
        //4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
        //5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
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
        while (!queue.isEmpty()) {
            int nowPrice = queue.poll();
            int cnt = 0;
            int nextIdx =0;
            for (Integer nextQueue : queue) {
                nextIdx++;
                int left = nowPrice - nextQueue;
                if(left <= 0) {
                    cnt++;

                }
                if(left > 0 && nextIdx == queue.size()) {
                    cnt++;
                }
                System.out.println("nowPrice "+nowPrice+" nextQueue "+nextQueue+" cnt "+cnt+" left "+left);

            }
            answer[idx] = cnt;

            idx++;
        }

        return answer;
    }

}
