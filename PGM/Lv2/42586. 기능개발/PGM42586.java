import java.util.*;

public class PGM42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> deplocyCountList = new ArrayList<>();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            int remainProgress = 100 - progresses[i];
            int speed = speeds[i];
            queue.offer((remainProgress + speed - 1) / speed);
//            queue.addLast((remainProgress + speed - 1) / speed);
        }

        while(!queue.isEmpty()) {
            int completeDay = queue.poll();
//            int completeDay = queue.pollFirst();
            int deployCount = 1;

            while(!queue.isEmpty() && completeDay >= queue.peek()) {
//            while(!queue.isEmpty() && completeDay >= queue.peekFirst()) {
                queue.poll();
//                queue.pollFirst();
                deployCount++;
            }

            deplocyCountList.add(deployCount);
        }

        int[] answer = new int[deplocyCountList.size()];
        for(int i = 0; i < deplocyCountList.size(); i++) {
            answer[i] = deplocyCountList.get(i);
        }

        return answer;

//        return deplocyCountList.stream().mapToInt(Integer::intValue).toArray();
    }

}
