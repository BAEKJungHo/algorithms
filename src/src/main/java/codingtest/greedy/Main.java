package codingtest.greedy;

public class Main {

    static int answer = 0;

    public static void main(String[] args) {
        solution(3000, 5000, 23000);
        System.out.println(answer);
    }

    public static int solution(int a, int b, int budget) {
        for (int i = 0; i*a < budget; i++) {
            for (int j = 0; j*b < budget; j++) {
                if((budget-(i*a+j*b))==0)
                    answer++;
            }
        }
        return answer;
    }
}
