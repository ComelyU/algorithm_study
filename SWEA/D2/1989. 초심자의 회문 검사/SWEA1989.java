import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            String originString = br.readLine();
            String reverseString = new StringBuilder(originString).reverse().toString();

            sb.append("#").append(testCase).append(" ").append(originString.equalsIgnoreCase(reverseString) ? 1 : 0).append("\n");
//            String word = br.readLine().toLowerCase();
//            int left = 0;
//            int right = word.length() - 1;
//            boolean isPalindrome = true;
//
//            while(left < right) {
//                if(word.charAt(left) != word.charAt(right)) { // 회문 아님
//                    isPalindrome = false;
//                    break;
//                }
//                left++;
//                right--;
//            }
//
//            sb.append("#").append(testCase).append(" ").append(isPalindrome ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());
    }

}
