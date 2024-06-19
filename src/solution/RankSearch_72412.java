package solution;

import javax.management.StandardEmitterMBean;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class RankSearch_72412 {

    public static void main(String[] args) {

        //코딩테스트 개발언어
        //지원 직군
        //지원 경력구분
        //소울푸드
        //
        //조건을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가
        //
        //score를 정렬할 때 문자열 상태로 정렬하여 정렬이 안되는 경우
        //딕셔너리에 key가 존재하지 않을 경우 답에 0을 추가하지 않은 경우
        //경우의수를 만들때 '-'기호가 없는 경우를 추가하지 않은 경우

        RankSearch_72412 T = new RankSearch_72412();

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] a = T.solution(info, query);

        for (int i : a) {
            System.out.print(i+" ");
        }


    }
    //https://school.programmers.co.kr/learn/courses/30/lessons/72412
    public int[] solution(String[] info, String[] query) {
        // 1. info를 기반으로 hashMap 만들기
        HashMap<String,ArrayList<Integer>> hashMap = new HashMap<>();

        for (String i : info) {
            String[]data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1],"-"};
            String[] ranks = {data[2], "-"};
            String[] foods = {data[3], "-"};
            int value = Integer.parseInt(data[4]);

            for (String language : languages) {
                for (String job : jobs) {
                    for (String rank : ranks) {
                        for (String food : foods) {
                            String key = language+" "+job+" "+rank+" "+food;
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());
                            arr.add(value);
                            hashMap.put(key,arr);
                        }
                    }
                }
            }
        }



        // 2. 각 hashMap의 value를 오름차순 정렬하기

        for (ArrayList<Integer> value : hashMap.values()) {
            value.sort(null);
        }


        // 3. query 조건에 맞는 지원자를 가져오기
        int[] answer = new int[query.length];

        int i = 0;
        for (String s : query) {

            String[]data = s.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ",data);
            if(hashMap.containsKey(key)){
                // 4. lower-bound/하한선 찾기 index(몇 개 있는 지) 밑으로 자꾸 내려간다. 작은 수 찾으러
                ArrayList<Integer> list = hashMap.get(key);
                int left = 0;
                int right = list.size(); // 총 몇개 있는가

                while(left < right){

                    int mid = (left+right) / 2; // 평균 몇 개 인지
                    //mid index로 list의 값을 찾아 target 값 이상인지 비교
                    int listValue = list.get(mid);
                    if(listValue >= target){
                        right = mid;
                    } else {
                        left = mid+1;
                    }
                }
                answer[i] = list.size() - left;
            }

            i++;

        }






        return answer;
    }

}


