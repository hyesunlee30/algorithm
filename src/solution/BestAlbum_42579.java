package solution;

import jdk.jshell.spi.SPIResolutionException;

import java.util.*;

public class BestAlbum_42579 {
    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42579
        //속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        BestAlbum_42579 c = new BestAlbum_42579();
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays ={500, 600, 150, 800, 2500};
        String[] genres = { "balrade","pop", "balrade","classic", "classic", "pop","pop","classic"};
        int[] plays ={100,100, 100, 100,100, 100,100,200};
        //=> [3, 2, 4, 1]
        System.out.println(Arrays.toString(c.solution(genres, plays)));
    }
    public int[] solution(String[] genres, int[] plays) {

        HashMap<Integer, Album> db = new HashMap<>();
        HashMap<String, Integer> chart = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            chart.put(genres[i], chart.getOrDefault(genres[i],0)+plays[i]);
            db.put(i,new Album(i,genres[i], plays[i]));
        }

        List<String> keySet = new ArrayList<>(chart.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return chart.get(o2) - chart.get(o1);
            }
        });


        List<Map.Entry<Integer, Album>> entryList = new ArrayList<>(db.entrySet());
        for (int i = 0; i < keySet.size(); i++) {
            for (Map.Entry<Integer, Album> entry : db.entrySet()) {
                if(keySet.get(i).equals(entry.getValue().getGenres())) {// 클래식 0 == 클래식, 팝 1
                    entry.getValue().setGenresDepth(i);
                    System.out.println(entry.getKey()+" "+entry.getValue().getGenresDepth()+" "+entry.getValue().getPlays()+" "+entry.getValue().getGenres());
                }
            }
        }

        //정렬이라는게 음수가 양수
        entryList.sort(new Comparator<Map.Entry<Integer, Album>>() {
            @Override
            public int compare(Map.Entry<Integer, Album> o1, Map.Entry<Integer, Album> o2) {
                int res = Integer.compare(o2.getValue().getGenresDepth(), o1.getValue().getGenresDepth());
                //장르 우선순위 클래식이나 팝이냐
                if (res == 0) {
                    res = Integer.compare(o2.getValue().getPlays(), o1.getValue().getPlays());
                    if (res == 0) {
                        res = Integer.compare(o1.getValue().getId(), o2.getValue().getId());
                    }
                }
                return res;
            }
        });


        List<Integer> arr2 = new ArrayList<>();
        for (String genre : keySet) {
            int count = 0;
            for (Map.Entry<Integer, Album> entry : entryList) {
                if (genre.equals(entry.getValue().getGenres())) {
                    arr2.add(entry.getValue().getId());
                    count++;
                    if (count >= 2) {
                        break;
                    }
                }
            }
        }


        int[] answer = new int[arr2.size()];
        for(int i = 0; i<arr2.size(); i++) {
            answer[i] = arr2.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}

class Album {
    int id;
    String genres;
    int plays;

    int genresDepth; // 장르우선순위


    public Album(int id, String genres, int plays) {
        this.id = id;
        this.genres = genres;
        this.plays = plays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public int getGenresDepth() {
        return genresDepth;
    }

    public void setGenresDepth(int genresDepth) {
        this.genresDepth = genresDepth;
    }
}