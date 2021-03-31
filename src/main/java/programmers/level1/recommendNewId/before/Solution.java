package programmers.level1.recommendNewId.before;

import java.util.List;

/**
 * 2021 KAKAO BLIND RECRUITMENT
 * 신규 아이디 추천
 * ==============================================
 * @author BJH
 * @history 작성일            작성자     변경내용
 * @history 2021-03-31         BJH      최초작성
 * ==============================================
 */
public class Solution {

    private static final List<String> POSSIBLE_CHARACTERS = List.of(
            "-", "_", ".", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    );
    private static final List<String> UPPER_ALPHABETS = List.of(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    );
    private static final String PERIOD = ".";
    private static final String DOUBLE_PERIOD = "..";

    public String solution(String new_id) {
        String result_id = stage1(new_id);
        result_id = stage2(result_id);
        result_id = stage3(result_id);
        result_id = stage4(result_id);
        result_id = stage5(result_id);
        result_id = stage6(result_id);
        result_id = stage7(result_id);

        return result_id;
    }

    public static String stage1(String new_id) {
        String original_id = new_id;
        boolean hasUpperAlphabet = false;

        for(String alphabet : UPPER_ALPHABETS) {
            if(new_id.contains(alphabet)) {
                hasUpperAlphabet = true;
            }
        }

        if(!hasUpperAlphabet) {
            System.out.println("1단계 변화 없습니다.");
            return new_id;
        }

        new_id = new_id.toLowerCase();
        System.out.println("1단계 " + "\"" + original_id + "\"" + "->" + "\"" + new_id);

        return new_id;
    }

    public static String stage2(String new_id) {
        String original_id = new_id;
        String result_id = "";
        String[] new_id_characters = new_id.split("");
        boolean isChanged = false;

        for(String id_character : new_id_characters) {
            for(String character : POSSIBLE_CHARACTERS) {
                if(id_character.equals(character)) {
                    isChanged = true;
                    result_id += id_character;
                }
            }
        }

        if(!isChanged) {
            System.out.println("2단계 변화 없습니다.");
            return new_id;
        }

        System.out.println("2단계 " + "\"" + original_id + "\"" + "->" + "\"" + result_id);

        return result_id;
    }

    public static String stage3(String new_id) {
        String original_id = new_id;
        boolean isChanged = false;
        if(new_id.contains(DOUBLE_PERIOD)) {
            while(new_id.contains(DOUBLE_PERIOD)) {
                new_id = new_id.replace(DOUBLE_PERIOD, PERIOD);
            }
            isChanged = true;
        }

        if(!isChanged) {
            System.out.println("3단계 변화 없습니다.");
            return new_id;
        }

        System.out.println("3단계 " + "\"" + original_id + "\"" + "->" + "\"" + new_id);

        return new_id;
    }

    public static String stage4(String new_id) {
        String original_id = new_id;
        boolean isChanged = false;
        if(new_id.startsWith(PERIOD)) {
            new_id = new_id.substring(1);
            isChanged = true;
        }
        if(new_id.endsWith(PERIOD)) {
            new_id = new_id.substring(0, new_id.length()-1);
            isChanged = true;
        }

        if(!isChanged) {
            System.out.println("4단계 변화 없습니다.");
            return new_id;
        }

        if(isEmpty(new_id)) {
            System.out.println("4단계 " + "\"" + original_id + "\"" + "->" + "\"" + new_id + "(new id가 빈 문자열이 되었습니다.)");
            return new_id;
        }

        System.out.println("4단계 " + "\"" + original_id + "\"" + "->" + "\"" + new_id);

        return new_id;
    }

    public static String stage5(String new_id) {
        String original_id = new_id;
        boolean isChanged = false;

        if(isEmpty(new_id)) {
            new_id = "a";
            isChanged = true;
        }

        if(!isChanged) {
            System.out.println("5단계 변화 없습니다.");
            return new_id;
        }

        System.out.println("5단계 " + "\"" + original_id + "\"" + "->" + "\"" + new_id);

        return new_id;
    }

    public static String stage6(String new_id) {
        String original_id = new_id;
        boolean isChanged = false;

        String first_changed_id = "";

        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            first_changed_id = new_id;
            isChanged = true;
        }
        if(new_id.endsWith(PERIOD)) {
            while(new_id.endsWith(PERIOD)) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
            isChanged = true;
        }

        if(!isChanged) {
            System.out.println("6단계 변화 없습니다.");
            return new_id;
        }

        if(!isEmpty(first_changed_id)) {
            System.out.println("6단계 " + "\"" + original_id + "\"" + "->" + "\"" + first_changed_id + "->" + "\"" + new_id + "\"");
        } else {
            System.out.println("6단계 " + "\"" + original_id + "\"" + "->" + new_id);
        }

        return new_id;
    }

    public static String stage7(String new_id) {
        String original_id = new_id;
        boolean isChanged = false;

        if(new_id.length() <= 2) {
            while(new_id.length() < 3) {
                String last_character = new_id.substring(new_id.length() - 1);
                new_id += last_character;
                isChanged = true;
            }
        }

        if(!isChanged) {
            System.out.println("7단계 변화 없습니다.");
            return new_id;
        }

        System.out.println("7단계 " + "\"" + original_id + "\"" + "->" + new_id);

        return new_id;
    }

    public static boolean isEmpty(String str) {
        if(str.equals("") || str == null) {
            return true;
        }
        return false;
    }

}
