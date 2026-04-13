import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1837 {

    static boolean[] isPrime = new boolean[1000001]; // K (2 ≤ K ≤ 10^6)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger P = new BigInteger(st.nextToken()); // P(4 ≤ P ≤ 10^100)
        int K = Integer.parseInt(st.nextToken()); // K (2 ≤ K ≤ 10^6)

        checkPrime();

        int result = checkPassword(P, K);
        if (result == -1) {
            sb.append("GOOD").append("\n");
        } else {
            sb.append("BAD ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    // 소수 판별
    private static void checkPrime() {
        Arrays.fill(isPrime, true);
        int isPrimeLength = isPrime.length; // isPrime.length == 1000001
        double sqrt = Math.sqrt(isPrimeLength);

        // 에라토스테네스의 체 이용
        for(int i = 2; i < sqrt; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < isPrimeLength; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // 비밀번호 GOOD/BAD 판별(GOOD인 경우 -1, BAD인 경우 작은 소수를 반환)
    private static int checkPassword(BigInteger p, int k) {
        for(int i = 2; i < k; i++) {
            if(isPrime[i] && p.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                return i;
            }
        }
        return -1;
    }
}
