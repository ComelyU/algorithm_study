import java.util.*;

public class PGM42577 {
    // HashMap(해시맵)
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 전화번호를 HashMap에 저장
        for(int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], i);
        }

        // 각 전화번호의 일정 부분을 접두사로 가정하고 해당 부분이 HashMap에 존재한는지 확인
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                if(hashMap.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

//    // Sort(정렬)
//    public boolean solution(String[] phone_book) {
//        // 사전순으로 전화번호 정렬
//        Arrays.sort(phone_book);
//
//        for(int i = 0; i < phone_book.length - 1; i++) {
//            // 뒷 번호가 앞 번호로 시작하는지 확인
//            if(phone_book[i + 1].startsWith(phone_book[i])) {
//                return false;
//            }
//        }
//        return true;
//    }

}
