package solution;

import java.util.ArrayList;
import java.util.HashMap;

public class WordConversion_43163 {

    static int answer;
    static boolean stop = false;
    static boolean[] visited;

    public static void main(String[] args) {
        //1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
        //2. words에 있는 단어로만 변환할 수 있습니다.
        //https://school.programmers.co.kr/learn/courses/30/lessons/43163

        WordConversion_43163 w = new WordConversion_43163();
//        String begin = "hit";
//        String target = "cog";
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        // "hit" -> "hot" -> "dot" -> "dog"

//        String begin = "hit";
//        String target = "wow";
//        String[] words = {"hot", "dog", "dot", "wow"};
//
//        String begin =  "aab";
//        String target = "aba";
//        String[] words = {"abb", "aba"};

        String begin = "hit";
        String target = "hot";
        String[] words = {"hot"};

        //0
//        String begin =  "abc";
//        String target = "cde";
//        String[] words = {"abx", "acx", "cdx", "cde"};

        //String[] words = {"hot", "dot", "dog", "lot", "log"};
        //4
        System.out.println(w.solution(begin,target, words));

    }
    public void DFS(int depth, String[]words, String temp, String target) {

        if(depth == words.length){

        } else {

            for(int i = 0; i< words.length; i++){

                String word = words[i];

                if(!visited[i] && !stop ){
                    visited[i] = true;
                    int res = confirm(temp, word, target);

                    if(res == 3){
                        stop = true;
                    }


                    if(res == 1){
                        temp = word;
                        answer++;
                    }

                    if(res == 2){
                        answer++;
                        stop = true;
                    }


                    DFS(i+1, words,temp,target);

                    visited[i] = false;
                }
            }


        }

    }
    public int solution(String begin, String target, String[] words) {

        answer = 1;
        visited = new boolean[words.length];


        ArrayList<String> arr = new ArrayList<>();
        for (String word : words) {
            arr.add(word);
        }

        if(!arr.contains(target) ){
            return 0;
        }


        DFS(0, words, begin, target);


        if(!stop ){
            return 0;
        }


        return answer;
    }

    public int confirm (String temp, String current, String target) {

        int res = 0;


        String[] tempArr = temp.split("");
        String[] currentArr = current.split("");
        String[] targetArr = target.split("");

        int count = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i = 0; i<tempArr.length; i++){

            String t1 = tempArr[i];
            String c = currentArr[i];
            String t2 = targetArr[i];

            if(t1.equals(t2)){
                count3++;
            }

            if(t1.equals(c)){
                count++;
            }

            if(t2.equals(c)){
                count2++;
            }

        }

        if(count == target.length()-1){
            res = 1;
        }

        if(count==2 && count2 == target.length()-1){
            res = 2;
        }

        if(count3 == target.length()-1){
            res = 3;
        }

        return res;
    }


}
