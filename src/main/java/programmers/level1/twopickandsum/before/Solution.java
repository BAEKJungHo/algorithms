package programmers.level1.twopickandsum.before;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int[] numbers) {
        Set<Integer> result = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int k=i+1; k< numbers.length; k++) {
                result.add(numbers[i] + numbers[k]);
            }
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

}
