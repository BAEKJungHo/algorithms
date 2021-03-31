package programmers.level1.recommendNewId.after;

/**
 * 2021 KAKAO BLIND RECRUITMENT
 * 신규 아이디 추천
 * ==============================================
 * @author BJH
 * @history 작성일            작성자     변경내용
 * @history 2021-03-31         BJH      최초작성
 * ==============================================
 */
public class Solution2 {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
}