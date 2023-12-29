package solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class que_stack_solution {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solutionDeque("()()"));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        Queue<Character> q1 = new LinkedList<>();
        char[] arr =s.toCharArray(); //.toCharArray();
        for (int i = 0; i <arr.length; i++) {
            char str =arr[i];
            if(q1.isEmpty()) {
                if(str == ')') {
                    answer = false;
                    break;
                }
                q1.add(str);
            }else if (q1.peek()==('(')&& str== ')') {
                q1.poll();
            } else {
                q1.add(str);
            }
        }
        if(!q1.isEmpty()) {
            answer = false;
        }

        return answer;
    }

    //연거 다음에 ) 가 있어 그럼 빼야함 ( ( ) -> (
    //
    public static boolean solutionDeque(String s) {
        boolean answer = true;

        Deque<Character> myDeque = new ArrayDeque<>();
        for (int i = 0; i< s.length(); i++) {
            if(myDeque.isEmpty()) {
                myDeque.addLast(s.charAt(i));
                if(s.charAt(i) == ')') {
                    answer = false;
                    break;
                }
            } else {
                if(myDeque.peekLast()=='(' && s.charAt(i)==')') {
                    myDeque.pollLast();
                } else {
                    myDeque.addLast(s.charAt(i));
                }
            }
        }
        if(!myDeque.isEmpty()) {
            answer = false;
        }
        return answer;
    }

}
