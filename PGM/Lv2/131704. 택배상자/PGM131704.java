import java.util.*;

public class PGM131704 {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0; // order 배열을 통해 현재 실어야 하는 상자 확인용 인덱스.
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트를 의미하는 스택.

        for(int i = 1; i <= order.length; i++) { // 컨테이너 벨트에 1번 상자 ~ N번 상자가 놓여 있음.
            if(order[idx] == i) { // 컨테이너 벨트의 상자가 현재 실어야 하는 상자인 경우.
                answer++;
                idx++;
            } else { // 컨테이너 벨트의 상자가 현재 실어야 하는 상자가 아닌 경우.
                stack.push(i);
            }

            while(!stack.isEmpty() && stack.peek() == order[idx]) { // 보조 컨테이너 벨트를 확인
                stack.pop();
                answer++;
                idx++;
            }
        }

        return answer;
    }
}
