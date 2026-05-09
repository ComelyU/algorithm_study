import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA21425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            // 작은 수에 큰 수를 더해야 함.
            int count = 0;
            while(A <= N && B <= N) {
                if(A < B) {
                    A += B;
                } else {
                    B += A;
                }
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

}
