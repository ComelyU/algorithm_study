import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ12919 {

    private static String S, T;
    private static int sLength;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
        sLength = S.length();

        System.out.println(recursionSolve(T));
    }

    private static int recursionSolve(String now) {
        if(now.length() == sLength) {
            return now.equals(S) ? 1 : 0;
        }

        int result = 0;

        if(now.charAt(now.length() - 1) == 'A') { // A가 문자열의 맨 뒤인 경우
            result += recursionSolve(now.substring(0, now.length() - 1));
        }
        if(now.charAt(0) == 'B') { // B가 문자열의 맨 앞인 경우
            result += recursionSolve(new StringBuilder(now.substring(1)).reverse().toString());
        }

        return result > 0 ? 1 : 0;
    }

}
