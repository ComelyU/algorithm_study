import java.util.*;

public class PGM12909 {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c  == '(') {
                stack.push(c);
            } else if(!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
