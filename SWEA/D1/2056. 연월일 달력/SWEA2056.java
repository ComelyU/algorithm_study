import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2056 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            String date = br.readLine();

//            String yearString = date.substring(0, 4);
//            String monthString = date.substring(4, 6);
//            String dayString = date.substring(6, 8);
//
//            int month = Integer.parseInt(monthString);
//            int day = Integer.parseInt(dayString);
//
//            if(month >= 1 && month <= 12 && day >= 1 && day <= days[month]) {
//                sb.append("#").append(testCase).append(" ")
//                    .append(yearString).append("/")
//                    .append(monthString).append("/")
//                    .append(dayString).append("\n");
//            } else {
//                sb.append("#").append(testCase).append(" -1\n");
//            }

            int month = (date.charAt(4) - '0') * 10 + (date.charAt(5) - '0');
            int day = (date.charAt(6) - '0') * 10 + (date.charAt(7) - '0');

            if(month >= 1 && month <= 12 && day >= 1 && day <= days[month]) {
                sb.append("#").append(testCase).append(" ")
                    .append(date, 0, 4).append("/")
                    .append(date, 4, 6).append("/")
                    .append(date, 6, 8).append("\n");
            } else {
                sb.append("#").append(testCase).append(" -1\n");
            }
        }
        System.out.println(sb.toString());
    }

}
