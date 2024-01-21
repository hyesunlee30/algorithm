package solution;

public class TruckPassingOverTheBridge_42583 {
    public static void main(String[] args) {
        TruckPassingOverTheBridge_42583 c = new TruckPassingOverTheBridge_42583();

        // 다리에 올라갈 수 있는 트럭 수
        int bridge_length = 2;
        //다리가 견딜 수 있는 무게
        int weight = 10;
        //트럭 별 무게
        int[] truck_weights = {7,4,5,6};
        //8
        System.out.println(c.solution(bridge_length,weight, truck_weights));

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
    }


}
