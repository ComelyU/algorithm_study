import java.util.*;

public class PGM42584 {
    public int[] solution(int[] prices) {
        int pricesLength = prices.length;
        int[] answer = new int[pricesLength];
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // ArrayDeque로 Stack 사용

        for(int sec = 0; sec < pricesLength; sec++) {
            // 가격이 떨어진 시점 계산
            while(!stack.isEmpty() && prices[stack.peek()] > prices[sec]) {
                int index = stack.pop();
                answer[index] = sec - index;
            }
            stack.push(sec);
        }

        // 끝까지 가격이 떨어지지 않은 경우 계산
        while(!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = pricesLength - 1 - index;
        }

        return answer;
    }
}
