import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int testCase = 1; testCase <= 10; testCase++) {
            int dump = Integer.parseInt(br.readLine());
            int width = 100; // 가로의 길이는 항상 100
            // 상자의 높이는 1이상 100이하.
            int maxHeight = 1;
            int minHeight = 100;
            int[] heightCountArr = new int[101];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < width; i++) {
                int height = Integer.parseInt(st.nextToken());
                heightCountArr[height]++;

                if(height < minHeight) {
                    minHeight = height;
                }
                if(height > maxHeight) {
                    maxHeight = height;
                }
            }

            // 카운팅 정렬(카운팅 배열 사용) + 투 포인터를 이용한 평탄화 작업
            while(dump-- > 0 && minHeight < maxHeight) {
                // 최소 높이 상자의 높이를 1 올리고, 최대 높이 상자의 높이를 1 낮춤
                heightCountArr[minHeight]--;
                heightCountArr[minHeight + 1]++;
                heightCountArr[maxHeight]--;
                heightCountArr[maxHeight - 1]++;

                // 최소 높이 상자와 최대 높이 상자의 수가 각각 0개가 되면 포인터 이동
                if(heightCountArr[minHeight] == 0) {
                    minHeight++;
                }
                if(heightCountArr[maxHeight] == 0) {
                    maxHeight--;
                }
            }

            sb.append("#").append(testCase).append(" ").append(maxHeight - minHeight).append("\n");
        }

        System.out.println(sb.toString());
    }

//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        for(int testCase = 1; testCase <= 10; testCase++) {
//            int dump = Integer.parseInt(br.readLine());
//            int width = 100; // 가로 길이는 항상 100
//            int[] boxHeightArr = new int[width];
//
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int i = 0; i < width; i++) {
//                boxHeightArr[i] = Integer.parseInt(st.nextToken());
//            }
//
//            // 평탄화 작업
//            int lastIdx = boxHeightArr.length - 1;
//            for(int i = 0; i < dump; i++) {
//                Arrays.sort(boxHeightArr);
//                boxHeightArr[0] += 1;
//                boxHeightArr[lastIdx] -= 1;
//            }
//            Arrays.sort(boxHeightArr);
//
//            sb.append("#").append(testCase).append(" ").append(boxHeightArr[lastIdx] - boxHeightArr[0]).append("\n");
//        }
//
//        System.out.println(sb.toString());
//    }

}
