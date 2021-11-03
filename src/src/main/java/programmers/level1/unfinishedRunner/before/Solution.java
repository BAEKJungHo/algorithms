package programmers.level1.unfinishedRunner.before;

import java.util.HashMap;

public class Solution {

    // ["mislav", "stanko", "mislav", "ana", "mislav"]
    // ["stanko", "ana", "mislav", "mislav"]
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> cp = new HashMap<>();
        for(int i=0; i<completion.length; i++){
            if(cp.containsKey(completion[i])){
                int cnt = cp.get(completion[i]);
                cp.put(completion[i], ++cnt);
            }else{
                cp.put(completion[i], 1);
            }
        }
        for(int i=0; i<participant.length; i++){
            if(!cp.containsKey(participant[i])){
                answer = participant[i];
                break;
            }
            int num = cp.get(participant[i]);
            if(--num<0){
                answer = participant[i];
                break;
            }
            cp.put(participant[i], num);
        }
        return answer;
    }

}
