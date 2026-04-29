public class PGM43165 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int targetNumber, int nodeDepth, int sum) {
        if(nodeDepth == numbers.length) {
            return sum == targetNumber ? 1 : 0;
        }

        return dfs(numbers, targetNumber, nodeDepth + 1, sum + numbers[nodeDepth])
            + dfs(numbers, targetNumber, nodeDepth + 1, sum - numbers[nodeDepth]);
    }
}
