package solution;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("hello");
        System.out.println(myList); //주소값만 가지고 있음 내부에서 toString이 구현되어 있어서 출력

        int a = 10;
        test2(a); //cal by value
        test3(myList); //call by reference
    }

    //cal by value
    static void test2(int a) {
        a+=10;
    }
    //call by reference
    static void test3(List<String> myList) {
        myList.add("hello3");
    }
}
