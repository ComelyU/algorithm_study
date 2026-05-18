import java.util.*;

public class PGM1844 {
    public int solution(int[][] maps) {
        // 상하좌우 이동
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy =  new int[] {0, 0, -1, 1};

        int n = maps.length;
        int m = maps[0].length;

        int[][] blockCount = new int[n][m];
        for(int[] row : blockCount) {
            Arrays.fill(row, -1);
        }

        // BFS
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {0, 0}); // 시작점
//        queue.addLast(new int[] {0, 0}); // 시작점
        blockCount[0][0] = 1; // 시작점에서의 칸 수는 1

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
//            int[] cur = queue.pollLast();
            int x = cur[0];
            int y = cur[1];

            if(x == n - 1 && y == m - 1) { // 상대 진영 도착
                return blockCount[x][y];
            }

            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) { // 맵 범위 안
                    if(maps[nextX][nextY] == 1 && blockCount[nextX][nextY] == -1) { // 지나치지 않은 갈 수 있는 길
                        blockCount[nextX][nextY] = blockCount[x][y] + 1;
                        queue.offer(new int[] {nextX, nextY});
//                        queue.addLast(new int[] {nextX, nextY});
                    }
                }
            }
        }

        return -1; // 상대 진영 도착 불가
    }

}
