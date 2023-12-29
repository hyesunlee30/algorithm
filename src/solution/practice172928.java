package solution;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class practice172928 {
    public static void main(String[] args) {
        String[] park = {"XOOOO","OOOOO","OOOOO", "OOOOO", "SOOOO"};
        String[] routes = {"N 3"};
        int[] res = solution(park,routes);
        //[1, 0]
        System.out.println("결과  :  "+res[0]+" "+res[1]);
    }
    public static int[] solution(String[] park, String[] routes) {

        int[] answer = new int[2];

        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < park.length; i++) {
            String[] a = park[i].split("");
            for (int j = 0; j < a.length; j++) {
                String address = i+","+j;
                map.put(address, a[j]);
                if(a[j].equals("S")) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

//        for (Map.Entry<String,String> entry : map.entrySet()) {
//            System.out.println(entry.getKey()+ " "+entry.getValue());
//        }

        System.out.println(answer[0]+" "+answer[1]);
        for (int r = 0; r < routes.length; r++) {
            String control = routes[r].split(" ")[0];
            int cnt = Integer.parseInt(routes[r].split(" ")[1]);
            if (control.equals("E")) {

                boolean check = true;
                int temp = answer[1] + cnt;

                for (int t = 1; t < cnt+1; t++) {
                    String a = map.get(answer[0]+","+(answer[1]+t));

                    if(a ==null || a.equals("X") || a.equals("S")) {
                        System.out.println("E "+a);
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer[1] = temp;
                    System.out.println("E 갱신 "+answer[0]+" "+answer[1]);

                }
            } else if (control.equals("S")) {
                System.out.println("S 시작");
                boolean check = true;
                int temp = answer[0] + cnt;

                for (int t = 1; t < cnt+1; t++) {
                    String a = map.get((answer[0]+t)+","+answer[1]);
                    System.out.println("S "+(answer[0]+t)+","+answer[1]);
                    if(a ==null || a.equals("X") || a.equals("S")) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer[0] = temp;
                    System.out.println("S 갱신 "+answer[0]+" "+answer[1]);
                }
            } else if (control.equals("W")) {

                boolean check = true;
                int temp = answer[1] - cnt;

                for (int t = 1; t < cnt+1; t++) {
                    String a = map.get(answer[0]+","+(answer[1]-t));
                    System.out.println("W "+a);
                    if(a ==null || a.equals("X") || a.equals("S")) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer[1] = temp;
                    System.out.println("W 갱신 "+answer[0]+" "+answer[1]);
                }
            } else {

                boolean check = true;
                int temp = answer[0] - cnt;

                for (int t = 1; t < cnt+1; t++) {
                    String a = map.get(answer[0]-t+","+(answer[1]));
                    System.out.println("N "+a);
                    if(a ==null || a.equals("X") || a.equals("S")) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer[0] = temp;
                    System.out.println("N 갱신 "+answer[0]+" "+answer[1]);
                }
            }
        }

        return answer;
    }
}
