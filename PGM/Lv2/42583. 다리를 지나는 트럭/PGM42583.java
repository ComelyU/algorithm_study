import java.util.*;

public class PGM42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 시간
        int bridgeTruckWeight = 0; // 다리 위의 트럭 무게

        ArrayDeque<Integer> waitingTruckQueue = new ArrayDeque<>(); // 대기하고 있는 트럭의 큐
        for(int truckWeight : truck_weights) {
            waitingTruckQueue.offer(truckWeight);
//            waitingTruckQueue.addLast(truckWeight);
        }
        ArrayDeque<Integer> bridgeQueue = new ArrayDeque<>(bridge_length); // 다리 길이만큼 다리 생성
        for(int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
//            bridgeQueue.addLast(0);
        }


        while(!waitingTruckQueue.isEmpty() || bridgeTruckWeight > 0) { // 대기하는 트럭이 있거나 다리 위에 이동 중인 트럭이 있는 동안
            if(!bridgeQueue.isEmpty()) {
                int completeTruckWeight = bridgeQueue.poll();
//                int completeTruckWeight = bridgeQueue.pollFirst();
                bridgeTruckWeight -= completeTruckWeight;
            }

            if(!waitingTruckQueue.isEmpty() && bridgeTruckWeight + waitingTruckQueue.peek() <= weight) { // 새 트럭이 다리 위에 올라오는게 가능한 경우
//            if(!waitingTruckQueue.isEmpty() && bridgeTruckWeight + waitingTruckQueue.peekFirst() <= weight) {
                int newTruckWeight = waitingTruckQueue.poll();
//                int newTruckWeight = waitingTruckQueue.pollFirst();
                bridgeTruckWeight += newTruckWeight;
                bridgeQueue.offer(newTruckWeight);
//                bridgeQueue.addLast(newTruckWeight);
            } else { // 새 트럭이 다리 위에 올라오는게 불가능한 경우
                bridgeQueue.offer(0); // 다리 길이 유지
//                bridgeQueue.addLast(0);
            }

            time++;
        }

        return time;
    }
}
