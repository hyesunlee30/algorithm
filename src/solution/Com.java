package solution;

import java.util.ArrayList;
import java.util.List;

public class Com {
    static int n;
    static int m;
    static List<Integer> check = new ArrayList<>();
    static int answer;

    public void com(int L) {
        if(check.size()==m) {

        } else {
            for (int i=L; i<n; i++) {
                check.add(i);
                answer++;
                com(i+1);
                check.remove(check.size()-1);
            }
        }
    }
    public static void main(String[] args) {

    }
}
