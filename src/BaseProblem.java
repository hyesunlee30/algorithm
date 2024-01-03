public class BaseProblem {
    public static void main(String[] args) {
        int n = 125;
        int answer = 0;

        String temp = "";
        while (n>0) {
            temp += Integer.toString(n%3);
            n /= 3;
        }


        System.out.println(temp);

        //꺼꾸로해보기
        int temp_length = temp.length()-1;
        for (int i = 0; i<temp_length; i++) {
            System.out.println(temp_length);
            answer += Integer.parseInt(String.valueOf(temp.charAt(i)))* (int)Math.pow(3, temp_length);
            temp_length--;
        }
//        for (int i = temp.length() - 1, j = 0; i >= 0; i--, j++) {
//            int a = temp.charAt(i) - '0';
//            answer += (int) (a * (Math.pow(3, j)));
//        }

        System.out.println(answer);
        //System.out.println(Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3));

    }
}
