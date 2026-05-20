import java.util.*;

public class PGM42628 {
//    // PriorityQueue
//    public int[] solution(String[] operations) {
//        PriorityQueue<Integer> pqMinHeap = new PriorityQueue<>();
//        PriorityQueue<Integer> pqMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//
//        for(String operation : operations) {
//            String[] opSplit = operation.split(" ");
//            String command = opSplit[0];
//            int num = Integer.parseInt(opSplit[1]);
//
//            if (command.equals("I")) {
//                pqMinHeap.add(num);
//                pqMaxHeap.add(num);
//            } else if (pqMinHeap.isEmpty()) {
//                continue;
//            } else if (num == 1) {
//                int max = pqMaxHeap.poll();
//                pqMinHeap.remove(max);
//            } else {
//                int min = pqMinHeap.poll();
//                pqMaxHeap.remove(min);
//            }
//        }
//
//        return pqMinHeap.isEmpty() ? new int[] {0, 0} : new int[] {pqMaxHeap.poll(), pqMinHeap.poll()};
//    }

    // TreeMap
    public int[] solution(String[] operations) {
        // 정렬 상태 유지 이진 검색 트리(key: 숫자, value: 빈도)
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for(String operation : operations) {
            String[] opSplit = operation.split(" ");
            String command = opSplit[0];
            int num = Integer.parseInt(opSplit[1]);

            if(command.equals("I")) {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            } else if(treeMap.isEmpty()) {
                continue;
            } else {
//                int key = (num == 1) ? treeMap.lastKey() : treeMap.firstKey();
//
//                if(treeMap.get(key) == 1) {
//                    treeMap.remove(key);
//                } else {
//                    treeMap.put(key, treeMap.get(key) - 1);
//                }
                treeMap.computeIfPresent(num == 1 ? treeMap.lastKey() : treeMap.firstKey(), (k, v) -> v == 1 ? null : v - 1);
            }
        }

        return treeMap.isEmpty() ? new int[] {0, 0} : new int[] {treeMap.lastKey(), treeMap.firstKey()};
    }
}
