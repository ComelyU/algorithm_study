import java.util.*;

public class PGM1845 {
    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int num : nums) {
            hashSet.add(num);
        }

        return Math.min(hashSet.size(), nums.length / 2);
    }

}
