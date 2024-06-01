package solution;

import java.util.*;

public class MineralMining_172927 {


    public static void main(String[] args) {
        MineralMining_172927 T = new MineralMining_172927();
        //https://school.programmers.co.kr/learn/courses/30/lessons/172927

        //다이아몬트 1 dia
        //철 5, 1, 1 iron
        //돌 25, 5, 1 stone

        // 사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
        // 한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
        // 광물은 주어진 순서대로만 캘 수 있습니다.
        // 광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.

        //사용할 수 있는 곡갱이 중에 하나 선택해서 광물 5개를 연속으로 캐고, 다음 곡갱이를 선택해서 5개를 연속으로 반복
        //picks 곡객이의 개수
        //minerals 광물들의 순서
        //최소한의 피로도


        //picks[0] = 다이아몬드 곡갱이 갯수, picks[1] = 철 곡갱이 갯수, picks[2] = 돌 곡갱이 갯수.
        //12
//        int[] picks = {1,3,2};
//        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        //50
//        int[] picks = {0, 1, 1};
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};


        //기댓값 〉	14
        int[] picks = {1, 1, 0};
        String[] minerals = {"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"};

        System.out.println("답 "+T.solution(picks,minerals));

    }

    public int solution(int[] picks, String[] minerals) {

        int answer = 0;


        for (int i = 0; i< minerals.length; i++) {
            
        }



        return answer;
    }



}

