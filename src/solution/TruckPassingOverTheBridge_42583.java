package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;
import java.util.*;


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

        Queue<Integer> waitQueue = new LinkedList<>();
        Queue<Point> onBridgeQueue = new LinkedList<>();

        //트럭 들어오세요 주차중
        for (int i = 0; i <truck_weights.length; i++) {
            waitQueue.offer(truck_weights[i]);
        }

        int leftWeight = weight;
        int time = 0;

        while(!waitQueue.isEmpty()) {
            if(leftWeight >= waitQueue.peek()) {
                int truck =waitQueue.poll();
                onBridgeQueue.offer(new Point(truck,time+bridge_length));
                leftWeight -= truck;
            }

            int nextWaitQueue = 0;
            if(!waitQueue.isEmpty()) {
                nextWaitQueue = waitQueue.peek();
            } else {
                nextWaitQueue = weight;
            }

            while(!onBridgeQueue.isEmpty()){
                Point next = onBridgeQueue.peek();
                int x = (int)next.getX();
                int y = (int)next.getY();

                if(leftWeight >= nextWaitQueue) {
                    break;
                } else {
                    time++;

                    if(time >= y ) {
                        onBridgeQueue.poll();
                        leftWeight = leftWeight + x;
                    }
                }
            }
        }


        int answer = time+1;

        return answer;
    }
}
