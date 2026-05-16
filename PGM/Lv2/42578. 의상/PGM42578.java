import java.util.*;

public class PGM42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 옷 종류별 카운팅
        for(String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        for(int count : hashMap.values()) {
            answer *= (count + 1); // 특정 종류의 옷 수 + 해당 종류의 옷을 안 입는 경우
        }
        answer--; // 모든 종류의 옷을 안 입는 경우 제외

        return answer;
    }

}
