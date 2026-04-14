import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4435 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 간달프 : 호빗(1), 인간(2), 엘프(3), 드워프(3), 독수리(4), 마법사(10)
        // 사우론 : 오크(1), 인간(2), 워그(2), 고블린(2), 우럭하이(3), 트롤(5), 마법사(10)
        // 전투의 개수 T개가 주어짐. 간달프 - 사우론 / 간달프 - 사우론 순서로
        int[] goods = {1, 2, 3, 3, 4, 10};
        int[] evils = {1, 2, 2, 2, 3, 5, 10};
        int T = Integer.parseInt(br.readLine());
        for(int battle = 1; battle <= T; battle++) {
            int goodScore = 0, evilScore = 0; // 각 점수의 합은 32비트 정수 제한을 넘기지 않는다고 함
            String answer = "";

            // 간달프 군대 점수 계산
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 6; i++) {
                goodScore += Integer.parseInt(st.nextToken()) * goods[i];
            }

            // 사우론 군대 점수 계산
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 7; i++) {
                evilScore += Integer.parseInt(st.nextToken()) * evils[i];
            }

            // 점수에 따른 결과 판별
            if(goodScore > evilScore) {
                answer = "Good triumphs over Evil";
            } else if(goodScore < evilScore) {
                answer = "Evil eradicates all trace of Good";
            } else {
                answer = "No victor on this battle field";
            }
            sb.append("Battle ").append(battle).append(": ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

}
