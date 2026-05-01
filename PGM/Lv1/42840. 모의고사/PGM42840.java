import java.util.*;

public class PGM42840 {
    public int[] solution(int[] answers) {
        // 수포자의 수는 3명 고정. 확장 가능한 2차원 배열이 아닌 수포자별 패턴 배열.
        int[] firstPattern = {1, 2, 3, 4, 5};
        int[] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstPatternLength = firstPattern.length;
        int secondPatternLength = secondPattern.length;
        int thirdPatternLength = thirdPattern.length;

        int[] scores = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == firstPattern[i % firstPatternLength]) {
                scores[0]++;
            }
            if(answers[i] == secondPattern[i % secondPatternLength]) {
                scores[1]++;
            }
            if(answers[i] == thirdPattern[i % thirdPatternLength]) {
                scores[2]++;
            }
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1],  scores[2]));

        int count = 0;
        for(int score : scores) {
            if(score == maxScore) {
                count++;
            }
        }

        int[] answer = new int[count];
        int idx = 0;
        for(int i = 0; i < 3; i++) {
            if(scores[i] == maxScore) {
                answer[idx++] = i + 1;
            }
        }

        return answer;

//        ArrayList<Integer> answerList = new ArrayList<>();
//        for(int i = 0; i < 3; i++) {
//            if(maxScore == scores[i]) {
//                answerList.add(i + 1);
//            }
//        }
//
//        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

}
