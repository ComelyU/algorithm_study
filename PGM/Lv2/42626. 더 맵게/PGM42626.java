import java.util.*;

public class PGM42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pqMinHeap = new PriorityQueue<>(scoville.length); // 우선순위큐를 최소힙으로
        int mixCount = 0;

        for(int scovilleValue : scoville) {
            pqMinHeap.offer(scovilleValue);
        }

        while(!pqMinHeap.isEmpty() && pqMinHeap.peek() < K) {
            if(pqMinHeap.size() < 2) {
                return -1;
            }

            int min = pqMinHeap.poll();
            int nextMin = pqMinHeap.poll();

            pqMinHeap.offer(min + nextMin * 2);
            mixCount++;
        }

        return mixCount;
    }

}
