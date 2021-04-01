package programmers.level1.unfinishedRunner.after;

import java.util.HashMap;

/**
 * 완주하지 못한 선수
 * ==============================================
 * @author BJH
 * @history 작성일            작성자     변경내용
 * @history 2021-04-01         BJH      최초작성
 * ==============================================
 */
public class Solution {

    public static String solution(String[] participant, String[] completion) {
        HashMap map = new HashMap<>();
        for (int i=0; i<participant.length; i++) {
            map.compute(participant[i], (k, v) -> v != null ? null : 1);
            if (i<completion.length) map.compute(completion[i], (k, v) -> v != null ? null : 1);
        }
        return (String) map.keySet().iterator().next();
    }

}
