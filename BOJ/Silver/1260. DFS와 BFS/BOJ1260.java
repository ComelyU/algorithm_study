import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> list;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);
        sb.append("\n");

        System.out.println(sb.toString());
    }

    private static void dfs(int v) {
        visited[v] = true;

        sb.append(v).append(" ");

        Collections.sort(list.get(v));
        for(int next : list.get(v)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        sb.append(v);

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            Collections.sort(list.get(curr));
            for(int next : list.get(curr)) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    sb.append(" ").append(next);
                }
            }
        }
    }
}
