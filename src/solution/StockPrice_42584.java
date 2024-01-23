package solution;

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
        int[] prices = {1, 2, 3, 2, 3};
        c.solution(prices);
    }

    public int[] solution(int[] prices) {


        int[] answer = {};

        return answer;
    }

}
