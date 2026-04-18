import java.util.*;

public class PGM42587 {
//    // ArrayList 사용 풀이
//    public int solution(int[] priorities, int location) {
//        int answer = 0;
//
//        ArrayList<Integer> processList = new ArrayList<>();
//        for(int process : priorities) {
//            processList.add(process);
//        }
//
//        while(location >= 0) {
//            int max = Collections.max(processList);
//            int tempProcess = processList.get(0);
//
//            if(tempProcess >= max) {
//                processList.remove(0);
//                location--;
//                answer++;
//            } else {
//                processList.remove(0);
//                processList.add(tempProcess);
//                location--;
//
//                if(location < 0) {
//                    location = processList.size() - 1;
//                }
//            }
//        }
//
//        return answer;
//    }

    // PriorityQueue 사용 풀이
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 우선순위 큐를 최대 힙으로 사용(우선순위가 높은 순서대로 프로세스를 꺼내기 위함)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int process : priorities) {
            pq.offer(process);
        }

//        boolean findFlag = false;
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                // 현재 프로세스가 가장 높은 우선순위인 경우
                if(pq.peek() != null && priorities[i] == pq.peek()) {
                    pq.poll(); // 프로세스 실행을 위해 꺼냄
                    answer++; // 실행된 프로세스 수 증가

                    if(i == location) { // 실행된 프로세스가 타겟 프로세스이면
//                        findFlag = true;
//                        break;
                        return answer;
                    }
                }
            }

//            if(findFlag) {
//                break;
//            }
        }

        return answer;
    }

}
