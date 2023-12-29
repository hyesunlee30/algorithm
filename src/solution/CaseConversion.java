package solution;

import java.util.Arrays;
import java.util.Scanner;

public class CaseConversion {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char[] a = in.next().toCharArray();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if(Character.isUpperCase(a[i])) {
                answer.append(String.valueOf(a[i]).toLowerCase());
            } else {
                answer.append(String.valueOf(a[i]).toUpperCase());
            }
        }
        System.out.println(answer.toString());
    }
}
