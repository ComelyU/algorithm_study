import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // 계산 편의성을 위해 항상 A가 짧은 배열로
            if(N > M) {
                int[] tempArr = A;
                A = B;
                B = tempArr;

                int tempLen = N;
                N  = M;
                M = tempLen;
            }

            int maxValue = Integer.MIN_VALUE;

            // 짧은 배열을 긴 배열 위에서 한 칸씩 슬라이딩하며 계산
            for(int i = 0; i < M - N + 1; i++) {
                int currentSum = 0;
                for(int j = 0; j < N; j++) {
                    currentSum += A[j] * B[i + j];
                }
                maxValue = Math.max(currentSum, maxValue);
            }

            sb.append("#").append(testCase).append(" ").append(maxValue).append("\n");
        }
        System.out.println(sb.toString());
    }

}
