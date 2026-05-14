import java.util.*;

public class PGM42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 참여 선수 등록(이름, 횟수)
        for(String player : participant) {
            hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        }

        // 완주한 선수 처리
        for(String player : completion) {
            hashMap.put(player, hashMap.getOrDefault(player, 0) - 1);
        }

        // value(횟수)가 0, 즉 완주하지 못한 key(선수) 찾기
        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

}
