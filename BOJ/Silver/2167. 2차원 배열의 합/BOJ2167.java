import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2167 {

    private static int N, M;
    private static int[][] arr, prefixSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        prefixSum = new int[N + 1][M + 1]; // prefixSum[x][y]는 arr[0][0]부터 arr[x - 1][y - 1]까지의 합

        // 주어진 배열 만들기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적 합 배열 구하기
        getPrefixSum();

        // 결과 구하기
        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i =  Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 구간 누적 합 = 전체 누적 합 - 왼쪽 누적 합 - 위쪽 누적 합 + 교집합 누적합
            int result = prefixSum[x][y] - prefixSum[x][j - 1] - prefixSum[i - 1][y] + prefixSum[i - 1][j - 1];

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void getPrefixSum() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                // prefixSum[i][j] = 배열값 + 왼쪽 누적 합 + 위쪽 누적 합 - 교집합 누적 합
                prefixSum[i][j] = arr[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
            }
        }
    }
}
