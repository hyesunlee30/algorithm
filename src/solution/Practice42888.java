package solution;

import java.util.*;

public class Practice42888 {

    public static void main(String[] args) {
        Practice42888 p = new Practice42888();
//        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//        p.solution(record);

        //gimoi 입장
        //pordo 입장
        //gimoi 퇴장
        //OhYeah 입장
        String[] record = {"Enter uid0606 Gimoi", "Enter uid4567 Prodo", "Leave uid0606", "Enter uid1234 Prodo", "Change uid1234 OhYeah"};

        System.out.println(Arrays.toString(p.solution(record)));
    }

    public String[] solution(String[] record) {

        List<String> log = new ArrayList<>();
        Map<String, User> userMap = new HashMap<>();
        for(int i = 0; i < record.length; i++) {
            String[] arr =record[i].split(" ");
            String method = arr[0];
            String userId = arr[1];
            if(method.equals("Enter")) {
                String nickname = arr[2];
                User newUser = userMap.getOrDefault(userId, new User(userId, nickname));
                newUser.setNickname(nickname);
                userMap.put(userId, newUser);
                log.add(userId+">님이 들어왔습니다.");
            } else if (method.equals("Leave")){
                log.add(userId+">님이 나갔습니다.");
            } else {
                String nickname = arr[2];
                userMap.get(userId).setNickname(nickname);
            }
        }

        String[] answer = new String[log.size()];

        for (int i = 0; i<log.size(); i++) {
            String[] splitLog = log.get(i).split(">");
            String userId = splitLog[0];
            String nickname = userMap.get(userId).getNickname();
            String text = nickname+splitLog[1];
            answer[i] = text;
        }
        return answer;
    }


}

class User {
    String userId;
    String nickname;



    public User(String userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}




