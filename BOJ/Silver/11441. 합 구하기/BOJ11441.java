import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11441 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            // 누적 합 = 배열 값 + 이전 누적 합
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        int M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[j] - prefixSum[i - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }


}
