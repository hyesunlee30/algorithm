package solution;

public class WordConversion_43163 {
    static String[] words;
    static String begin;
    static String target;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) {
        //1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
        //2. words에 있는 단어로만 변환할 수 있습니다.

        WordConversion_43163 w = new WordConversion_43163();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        //4
        System.out.println(w.solution("hit","cog", words));

    }
    public int solution(String begin, String target, String[] words) {
        begin = begin;
        target = target;
        words = words;
        answer = 0;

        visited = new boolean[words.length];
        DFS(0);
        return answer;
    }

    public void DFS(int start) {
        String[] beginArr = begin.split("");
        visited[start] = true;
        for (int i = 1; i < words.length; i++){
            String[] wordsArr = words[i].split("");

            if(visited[i] == false) {
                visited[i] = true;
                DFS(i);
            }

        }
    }
}
