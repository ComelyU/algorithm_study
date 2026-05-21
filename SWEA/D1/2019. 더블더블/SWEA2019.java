import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

//        for(int i = 0; i <= num; i++) {
//            sb.append(1 << i).append(" ");
//        }

        int value = 1;
//        sb.append(value).append(" ");
        sb.append(value + " ");
        for(int i = 1; i <= num; i++) {
            value <<= 1;
//            sb.append(value).append(" ");
            sb.append(value + " ");
        }

        System.out.println(sb.toString());
    }

}
