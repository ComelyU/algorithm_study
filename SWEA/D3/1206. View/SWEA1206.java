import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] buildings = new int[N];
            boolean[] isObtainView = new boolean[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }

            int unitCount = 0;
            for(int i = 2; i < N - 2; i++) { // 맨 왼쪽 두 칸과 맨 오른쪽 두 칸에 건물의 높이는 항상 0
                if(isObtainView[i - 1] || isObtainView[i - 2]) { // 이미 왼쪽 조망권이 없는 경우
                    continue;
                }

                int nowHeight = buildings[i];
                int leftHeight = Math.max(buildings[i - 2], buildings[i - 1]);
                int rightHeight = Math.max(buildings[i + 1], buildings[i +2]);

                if(nowHeight > leftHeight && nowHeight > rightHeight) { // 조망권 확보
                    unitCount += nowHeight - Math.max(leftHeight, rightHeight);
                    isObtainView[i] = true;
                }
            }
            sb.append("#").append(testCase).append(" ").append(unitCount).append("\n");

        }
        System.out.println(sb.toString());
    }

}
