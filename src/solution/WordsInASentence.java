package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordsInASentence {
    public static void main(String[] args) {
        //한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
        //문장속의 각 단어는 공백으로 구분됩니다.
        //it is time to study ztudy
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(" ");

        System.out.println(Arrays.stream(lines).max((a, b) -> a.length() - b.length()).get());
    }
}
