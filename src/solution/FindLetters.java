package solution;

import java.util.Scanner;

public class FindLetters {
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        String str = in.next();
        String str1 = in.next().toUpperCase();
        String[] strArr = str.split("");
        int count = 0;
        for (int i = 0; i<strArr.length; i++) {
            if(str1.equals(strArr[i])) {
                count++;
            }
        }
        System.out.println(count);
    }
}
