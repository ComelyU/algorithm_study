import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA25695 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T =  Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());

            // X = max(A, B), Y = max(B, C), Z = max(C, A)를 만족시키는 세 정수 A, B, C가 존재하려면
            // X, Y, Z 중 가장 큰 값이 2개 이상 존재해야 함.
//            int maxValue = Math.max(X, Math.max(Y, Z));
            int maxValue = X;
            maxValue = Y > maxValue ? Y : maxValue;
            maxValue = Z > maxValue ? Z : maxValue;

            int count = 0;
            if(X == maxValue) {
                count++;
            }
            if(Y == maxValue) {
                count++;
            }
            if(Z == maxValue) {
                count++;
            }

            if(count < 2) {
                sb.append("-1 -1 -1\n");
            } else {
//                int A = Math.min(X, Z); // A는 X, Z 보다 클 수 없음.
//                int B = Math.min(X, Y); // B는 X, Y 보다 클 수 없음.
//                int C = Math.min(Y, Z); // C는 Y, Z 보다 클 수 없음.
                int A = X < Z ? X : Z;
                int B = X < Y ? X : Y;
                int C = Y < Z ? Y : Z;

                sb.append(A).append(" ").append(B).append(" ").append(C).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}
